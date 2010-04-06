import org.springframework.web.context.support.WebApplicationContextUtils
import org.codehaus.groovy.grails.commons.GrailsApplication;
import groovy.ui.Console
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.hibernate.event.EventListeners

class BootStrap {

  def init = {servletContext ->
    def webAppCtx = WebApplicationContextUtils.getWebApplicationContext(servletContext)
    runConsoleIfNeeded(webAppCtx)
  }
  def destroy = {
  }

  def runConsoleIfNeeded = {webAppCtx ->
    def config = ApplicationHolder.application.config

    if (config?.runConsole) {
      // launch a groovy console
      def grailsApp = webAppCtx.getBean(GrailsApplication.APPLICATION_ID);
      Binding b = new Binding();
      b.setVariable("ctx", webAppCtx);
      def console = new Console(grailsApp.classLoader, b);
      console.run()
    }
  }

} 