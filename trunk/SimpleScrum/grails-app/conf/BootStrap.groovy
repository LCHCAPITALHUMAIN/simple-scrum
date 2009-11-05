import org.springframework.web.context.support.WebApplicationContextUtils
import com.simplescrum.AuditLogListener
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.hibernate.event.EventListeners

class BootStrap {

  def init = {servletContext ->
    def webAppCtx = WebApplicationContextUtils.getWebApplicationContext(servletContext)
    doWithApplicationContext(webAppCtx)
  }
  def destroy = {
  }

  def doWithApplicationContext = {webAppCtx ->

    def sessionFactory  = webAppCtx.getBean('sessionFactory')
    EventListeners eventListeners = sessionFactory.eventListeners

    def listener = new AuditLogListener()
    def config = ApplicationHolder.application.config.auditLog
    if (config?.verbose) {
      listener.verbose = (config?.verbose) ? true : false
    }
    if (config?.actor) {
      listener.actorKey = (config?.actor) ?: config?.user
    }
    if (config?.username) {
      listener.sessionAttribute = (config?.username) ?: null
    }

    // use preDelete so we can see what is going to be destroyed
    // hook to the postInsert to grab the ID of the object
    // hook to postUpdate to use the old and new state hooks
    ['preDelete', 'postInsert', 'postUpdate',].each({
      addEventTypeListener(eventListeners, listener, it)
    })
  }

  // Brazenly lifted from HibernateEventsGrailsPlugin by Kevin Burke
  def addEventTypeListener(listeners, listener, type) {
    def typeProperty = "${type}EventListeners"
    def typeListeners = listeners."${typeProperty}"
    def expandedTypeListeners = new Object[typeListeners.length + 1]
    System.arraycopy(typeListeners, 0, expandedTypeListeners, 0, typeListeners.length)
    expandedTypeListeners[-1] = listener
    listeners."${typeProperty}" = expandedTypeListeners
  }

} 