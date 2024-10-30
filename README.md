# Building the WAR file

You will need to have Maven installed to build the WAR file for deployment.

Use the following command to generate the WAR file:

    mvn clean install

The file `upload-demo-rf.war` will be created in the `target` directory, and can be deployed to EAP from there.

# Adding a module for Richfaces

Create a directory at `$EAP_HOME/modules/system/layers/base/org/richfaces/main`

Create the following `module.xml` file

    <module xmlns="urn:jboss:module:1.3" name="org.richfaces">
    
        <resources>
            <resource-root path="atmosphere-runtime-2.2.0.jar"/>
            <resource-root path="commons-beanutils-1.9.4.jar"/>
            <resource-root path="commons-collections-3.2.2.jar"/>
            <resource-root path="commons-digester-2.1.jar"/>
            <resource-root path="commons-logging-1.2.jar"/>
            <resource-root path="cssparser-0.9.14.jar"/>
            <resource-root path="guava-18.0.jar"/>
            <resource-root path="richfaces-api-3.3.4.Final.jar"/>
            <resource-root path="richfaces-impl-jsf2-3.3.4.Final.jar"/>
            <resource-root path="richfaces-ui-3.3.4.Final.jar"/>
            <resource-root path="sac-1.3.jar"/>
        </resources>
    
        <dependencies>
            <module name="com.sun.jsf-impl" />
            <module name="javaee.api" />
            <module name="javax.faces.api" />
        </dependencies>
    </module>

Copy the JAR files listed in `module.xml` to `$EAP_HOME/modules/system/layers/base/org/richfaces/main`

Restart the EAP server and deploy the WAR file.
