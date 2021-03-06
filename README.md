
Apache Ivy Database Dependencies Plugin (dbdep for Ivy)

A custom Apache Ivy Ant Task to store dependencies on a database

Apache Ivy Database Dependencies Ant Task can be used to store in a easy way all the dependencies of all of your Ant projects in a database.

The goal is simplifying software development monitoring for business intelligence purpose.

The implementation is based on Spring Framework for transactions and queries.

How to install Apache Ivy Database Dependencies Plugin (dbdep for Ivy)
This page is dedicated to show how to install Apache Ivy Database Dependencies Plugin.

Database creation
Download and execute with a SQL client a script to create dbdep database, for MySQL you can execute setup_db.sql (you can find it in the plugin package distribution too).

Ant classpath
Add to your Ant classpath all the dependencies included in dbdep with-dependencies package, here you can see version and scope for each dependency:

com.sourcesense:ivy-dbdep-ant-task:jar:0.2
[INFO] +- junit:junit:jar:3.8.1:test
[INFO] +- org.springframework:spring:jar:2.5.6:compile
[INFO] |  \- commons-logging:commons-logging:jar:1.1.1:compile
[INFO] +- commons-dbcp:commons-dbcp:jar:1.2.2:compile
[INFO] |  \- commons-pool:commons-pool:jar:1.3:compile
[INFO] +- commons-digester:commons-digester:jar:1.8:compile
[INFO] |  \- commons-beanutils:commons-beanutils:jar:1.7.0:compile
[INFO] +- log4j:log4j:jar:1.2.15:compile
[INFO] |  +- javax.mail:mail:jar:1.4:compile
[INFO] |  |  \- javax.activation:activation:jar:1.1:compile
[INFO] |  +- javax.jms:jms:jar:1.1:compile
[INFO] |  +- com.sun.jdmk:jmxtools:jar:1.2.1:compile
[INFO] |  \- com.sun.jmx:jmxri:jar:1.2.1:compile
[INFO] \- org.apache.ant:ant:jar:1.7.1:compile
[INFO]    \- org.apache.ant:ant-launcher:jar:1.7.1:compile
For more informations about dependencies you can visit Project's Website.

Configure your own Apache Ivy project
To enable dbdep plugin you must add this snippet on your Apache Ant file (build.xml):

<!-- ================================= 
      target: Apache Ivy DbDep Plugin             
     ================================= -->
        <taskdef name="ApacheIvyDbDepAntTask" classname="com.sourcesense.ant.dbdep.task.IvyDbDepTask" />
        <target name="ApacheIvyDbDep">
                <ApacheIvyDbDepAntTask 
                        databaseDriverClassName="driver.classname.package.dbms" 
                        databaseUrl="jdbc:dbms://ip:port/dbdep" 
                        databaseUsername="dbdep" 
                        databasePassword="dbdep" 
                        ivyFilePath="ivy.xml" 
                        environment="YOUR ENVIRONMENT NAME" 
                        project="YOUR PROJECT NAME">
                </ApacheIvyDbDepAntTask>
        </target>
