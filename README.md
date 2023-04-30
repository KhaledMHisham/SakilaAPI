# SakilaAPI
Overview:



* This API provides access to Sakila Sample Database MYSQL, allowing users to retrieve information about films actors and other data stored in the database, for more info check this link.
* The API is available with both SOAP and REST interfaces, giving developers the flexibility to choose the protocol that best fits their needs.

Getting Started



* Dependencies:
    * JAVA:
        * You can find Java17 [here](https://www.oracle.com/eg/java/technologies/downloads/#java17).
        * **JAVA_HOME**: **path/to/java**
        * Add **path/to/java/bin** to **PATH**
        * Run Command: **java -version**
    * MYSQL Database v8.0.32:
        * You can find the database server  [here](https://dev.mysql.com/downloads/installer/).
        * Make sure you choose to install the Sakila Sample database while installing.
    * Apache Tomcat 10.1.7:
        * You can find the apache tomcat server [here](https://tomcat.apache.org/download-10.cgi).
        * Download the Windows Zip file then extract it.
        * Unpack then add the following Environment Variables:
            * **CATALINA_HOME** : **path/to/tomcat**
            * Add **path/to/tomcat/bin** to **PATH**
            * Run command: **catalina start** to start the server
    * Apache Maven :
        * You can find Apache Maven [here](https://maven.apache.org/download.cgi).
        * Download the Binary Zip Archive.
        * Unpack then add the following Environment Variables:
            * Add **path/to/maven/bin** to **PATH**
            * Run Command: **mvn -version**
* Go to the project file in the same directory as the pom.xml file and run the following command: **mvn package tomcat7:redeploy**
* Docs:
   * REST: https://documenter.getpostman.com/view/15451357/2s93eSZvRc
   * SOAP: https://documenter.getpostman.com/view/15451357/2s93eSZvRe
