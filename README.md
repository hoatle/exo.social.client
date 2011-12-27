# eXo Social Client Java Library

http://exoplatform.org/company/en/platform/exo-extended-services/exo-social


## How to develop

* Project dependencies:
    + json_simple-1.1           (compile)   :     http://code.google.com/p/json-simple/
    + httpclient-4.0            (compile)   :     http://hc.apache.org/httpcomponents-client-ga/
    + slf4j-api-1.6.1           (compile)   :     http://www.slf4j.org
    + testng-6.1.1              (test)      :     http://testng.org/doc/index.html
    + logback-classic-0.9.28    (test)      :     http://logback.qos.ch/
    + org.hamcrest-core-1.2.1   (test)      :     http://code.google.com/p/hamcrest/

* mvn dependency:tree
  <pre>
     org.exoplatform.social:exo.social.client:jar:1.0.0-alpha3
     +- com.googlecode:json_simple:jar:1.1:compile
     +- org.apache.httpcomponents:httpclient:jar:4.0:compile
     |  +- org.apache.httpcomponents:httpcore:jar:4.0.1:compile
     |  +- commons-logging:commons-logging:jar:1.1.1:compile
     |  \- commons-codec:commons-codec:jar:1.3:compile
     +- org.slf4j:slf4j-api:jar:1.6.1:compile
     +- org.testng:testng:jar:6.1.1:test
     |  +- junit:junit:jar:3.8.1:test
     |  +- org.beanshell:bsh:jar:2.0b4:test
     |  +- com.beust:jcommander:jar:1.12:test
     |  \- org.yaml:snakeyaml:jar:1.6:test
     +- ch.qos.logback:logback-classic:jar:0.9.28:test
     |  \- ch.qos.logback:logback-core:jar:0.9.28:test
     \- org.hamcrest:hamcrest-core:jar:1.2.1:test
  </pre>

This library is tested with http client 4.0 and above (4.0.1, 4.0.2, 4.0.3, 4.1, 4.1.1).

### Prepare your environment

Use [Apache Maven][maven] version 2.2.1 minimum. Version 3.x is recommended.

`json-simple` library isn't available in [maven central repository][central]

Either install it manually in your local repository by executing the following command from the root directory of the project :

    mvn install:install-file -Dfile=lib/json_simple-1.1.jar -DgroupId=com.googlecode -DartifactId=json_simple -Dversion=1.1 -Dpackaging=jar

Or add the eXo platform repository in your maven settings (`${HOME}/.m2/settings.xml`) like this :

    <settings>
      ....
      <profiles>
        <profile>
          <id>exo-public</id>
          <repositories>
            <repository>
              <id>exo-public</id>
              <url>http://repository.exoplatform.org/public</url>
            </repository>
          </repositories>
        </profile>
        ....
      </profiles>
      ....
      <activeProfiles>
        <activeProfile>exo-public</activeProfile>
        ....
      </activeProfiles>
      ....
    </settings>

[maven]: http://maven.apache.org "Apache Maven"
[central]: http://repo1.maven.org "Maven Central Repository"

### Default build

Use this command to build project:

    mvn clean install

By default, it will run only unit tests.

To run integration tests you have two choices.

### Integration tests with an automated deployment of the social server

Either you launch the automated build which will deploy for you an exo-social server to run integration tests. It is the recommended solution as it doesn't require any specific setup but it is slow if you are developing as it will start and stop the server each time (and unpack it each time you're doing a clean build). To launch the build with integration tests just launch :

    mvn clean install -Prun-its

By default it will use the latest release with Rest APIs (as defined by social.server.version property on pom.xml).
You can change the version by adding the following parameter in the command line (to use version 1.3.0-SNAPSHOT for example) :

    -Dsocial.server.version=1.3.0-SNAPSHOT

### Integration tests with a social server already deployed

Or you can run integration tests against a social server already deployed on your network. This solution is quickest to execute but requires an initial setup of a social server. You need to define the host and port of the server to use. To launch tests on an existing server launch the following command :

    mvn clean install -Prun-its -Dit.cargo.skip=true -Dsocial.server.host=myHost -Dsocial.server.http.port=8888


### Project resources

* Issues management: https://jira.exoplatform.org/browse/SCL
* Jenkins continuous integration build: https://ci.exoplatform.org/job/social-client-master-ci/
* Jenkins integration tests build: https://ci.exoplatform.org/job/social-client-master-it/
* Sonar report: https://sonar.exoplatform.org/dashboard/index/81870
* Fisheye: https://fisheye.exoplatform.org/changelog/social-client
* Ohloh report: https://www.ohloh.net/p/exo-social-client/
* Artifact deployment: http://repository.exoplatform.org/content/groups/public/org/exoplatform/social/exo.social.client/

### Logging
This library uses SLF4J for logging. You are free to use your own logging framework such as Log4j, Android Logging, Apache commons logging…, simply  add the slf4j binding corresponding to your logging framework. (For more information, please refer to: http://www​.slf4j.org​/manual.ht​ml#binding)

## How to use this library

Sample code:

    // Context information
    SocialClientContext.setProtocol("http"); //by default it is set as "http"
    SocialClientContext.setHost("platform35.demo.exoplatform.org");
    SocialClientContext.setPort(80);
    SocialClientContext.setPortalContainerName("portal");
    SocialClientContext.setRestContextName("rest");
    SocialClientContext.setRestVersion("v1-alpha3");
    SocialClientContext.setUsername("demo");
    SocialClientContext.setPassword("gtn");

    ClientServiceFactory clientServiceFactory = ClientServiceFactoryHelper.getClientServiceFactory();

    //it's all for Client to work, now just get the Service to use
    ActivityService activityService = clientServiceFactory.createActivityService();;

    IdentityService identityService = clientServiceFactory.createIdentityService();
    //...

    ActivityService activityService = client.getActivityService();
    RestActivity restActivity = (RestActivity) activityService.get("123456789");
