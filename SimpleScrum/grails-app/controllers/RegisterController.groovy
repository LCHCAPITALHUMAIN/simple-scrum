import com.simplescrum.model.User
import com.simplescrum.model.AccessRole

import org.springframework.security.providers.UsernamePasswordAuthenticationToken as AuthToken
import org.springframework.security.context.SecurityContextHolder as SCH

/**
 * Registration controller.
 */
class RegisterController {

  def authenticateService
  def daoAuthenticationProvider
  def emailerService

  static Map allowedMethods = [save: 'POST', update: 'POST']

  /**
   * User Registration Top page.
   */
  def index = {

    // skip if already logged in
    if (authenticateService.isLoggedIn()) {
      redirect action: show
      return
    }

    if (session.id) {
      def person = new User()
      person.properties = params
      return [person: person]
    }

    redirect uri: '/'
  }

  /**
   * User Information page for current user.
   */
  def show = {

    // get user id from session's domain class.
    def user = authenticateService.userDomain()
    if (user) {
      render view: 'show', model: [person: User.get(user.id)]
    }
    else {
      redirect action: index
    }
  }

  /**
   * Edit page for current user.
   */
  def edit = {

    def person
    def user = authenticateService.userDomain()
    if (user) {
      person = User.get(user.id)
    }

    if (!person) {
      flash.message = "[Illegal Access] User not found with id ${params.id}"
      redirect action: index
      return
    }

    [person: person]
  }

  /**
   * update action for current user's edit page
   */
  def update = {

    def person
    def user = authenticateService.userDomain()
    if (user) {
      person = User.get(user.id)
    }
    else {
      redirect action: index
      return
    }

    if (!person) {
      flash.message = "[Illegal Access] User not found with id ${params.id}"
      redirect action: index, id: params.id
      return
    }

    // if user want to change password. leave password field blank, password will not change.
    if (params.password && params.password.length() > 0
            && params.repassword && params.repassword.length() > 0) {
      if (params.password == params.repassword) {
        person.password = authenticateService.encodePassword(params.password)
      }
      else {
        person.password = ''
        flash.message = 'The passwords you entered do not match.'
        render view: 'edit', model: [person: person]
        return
      }
    }

    person.userRealName = params.userRealName
    person.email = params.email
    if (params.emailShow) {
      person.emailShow = true
    }
    else {
      person.emailShow = false
    }

    if (person.save()) {
      redirect action: show, id: person.id
    }
    else {
      render view: 'edit', model: [person: person]
    }
  }

  /**
   * Person save action.
   */
  def save = {

    // skip if already logged in
    if (authenticateService.isLoggedIn()) {
      redirect action: show
      return
    }

    def person = new User()
    person.properties = params

    def config = authenticateService.securityConfig
    def defaultRole = config.security.defaultRole

    def role = AccessRole.findByAuthority(defaultRole)
    if (!role) {
      role = new AccessRole(authority: defaultRole, description: 'Default Access Role')
      if (!role.save()) {
        person.password = ''
        flash.message = 'Default Role not found.'
        render view: 'index', model: [person: person]
        return
      }
    }


    if (params.captcha.toUpperCase() != session.captcha) {
      person.password = ''
      flash.message = 'Access code did not match.'
      render view: 'index', model: [person: person]
      return
    }

    if (params.password != params.repassword) {
      person.password = ''
      flash.message = 'The passwords you entered do not match.'
      render view: 'index', model: [person: person]
      return
    }

    def pass = authenticateService.encodePassword(params.password)
    person.password = pass
    person.enabled = true
    person.emailShow = true
    
    if (person.save()) {
      role.addToPeople(person)
      if (config.security.useMail) {
        String emailContent = """You have signed up for an account at:

 ${request.scheme}://${request.serverName}:${request.serverPort}${request.contextPath}

 Here are the details of your account:
 -------------------------------------
 LoginName: ${person.login}
 Email: ${person.email}
 Full Name: ${person.userRealName}
 Password: ${params.password}
"""

        def email = [
                to: [person.email], // 'to' expects a List, NOT a single email address
                subject: "[${request.contextPath}] Account Signed Up",
                text: emailContent // 'text' is the email body
        ]
        emailerService.sendEmails([email])
      }

      person.save(flush: true)

      def auth = new AuthToken(person.login, params.password)
      def authtoken = daoAuthenticationProvider.authenticate(auth)
      SCH.context.authentication = authtoken
      redirect uri: '/'
    }
    else {
      person.password = ''
      render view: 'index', model: [person: person]
    }
  }
}
