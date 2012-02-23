Frameworks used:
1. Play 1.2.4
2. Twitter bootstrap for UI

How to start project
1. Download Play framework 1.2.4
2. In the root directory of the project run 'play run', then access the application http://localhost:9000 and for the admin application use http://localhost:9000/admin
    Running under IntelliJ: You can run the 'Server' run configuration inside intellij

Info on DB;
   This project uses H2 DB and will be created on the fly, when you run the project for the first time and also some sample data are loaded using /conf/initial-data.yml and this is triggered from the class Bootstrap.java
