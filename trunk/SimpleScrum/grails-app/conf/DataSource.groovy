dataSource {
  pooled = true
  driverClassName = "org.hsqldb.jdbcDriver"
  username = "sa"
  password = ""
}
hibernate {
  cache.use_second_level_cache = true
  cache.use_query_cache = true
  cache.provider_class = 'com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
  development {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop','update'
      url = "jdbc:hsqldb:file:db/devDB"
    }
    runConsole = false //When true launches Grails console alongside the application. U'll be able to query and modify data live.
  }
  custom {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop','update'
      url = "jdbc:hsqldb:file:db/customDB"
    }
    runConsole = true //When true launches Grails console alongside the application. U'll be able to query and modify data live.
  }
  test {
    dataSource {
      dbCreate = "update"
      url = "jdbc:hsqldb:mem:testDb"
    }
  }
  production {
    dataSource {
      dbCreate = "update"
      url = "jdbc:hsqldb:file:prodDb;shutdown=true"
    }
  }
}