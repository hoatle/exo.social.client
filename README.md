# eXo Social Client Java Library

http://exoplatform.org/company/en/platform/exo-extended-services/exo-social


## How to develop

* Project dependencies:
    + json_simple-1.1 (compiled): http://code.google.com/p/json-simple/
    + httpclient-4.0 (compile):   http://hc.apache.org/httpcomponents-client-ga/
    + junit-4.8.2 (test)

* mvn dependency:tree
  <pre>

    org.exoplatform.social:exo.social.client:jar:1.0.0-alpha2-SNAPSHOT
    +- com.googlecode:json_simple:jar:1.1:compile
    +- org.apache.httpcomponents:httpclient:jar:4.0:compile
    |  +- org.apache.httpcomponents:httpcore:jar:4.0.1:compile
    |  +- commons-logging:commons-logging:jar:1.1.1:compile
    |  \- commons-codec:commons-codec:jar:1.3:compile
    +- org.testng:testng:jar:6.1.1:test
    |  +- junit:junit:jar:3.8.1:test
    |  +- org.beanshell:bsh:jar:2.0b4:test
    |  +- com.beust:jcommander:jar:1.12:test
    |  \- org.yaml:snakeyaml:jar:1.6:test
    \- org.hamcrest:hamcrest-core:jar:1.2.1:test

  </pre>

This library must work with http client 4.0 and above (4.0.1, 4.0.2, 4.0.3, 4.1, 4.1.1).

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

By default it will use the latest release with Rest APIs (1.2.0-GA).
You can change the version by adding the following parameter in the command line (to use version 1.3.0-SNAPSHOT for example) :

    -Dsocial.server.version=1.3.0-SNAPSHOT

### Integration tests with a social server already deployed

Or you can run integration tests against a social server already deployed on your network. By default it will try to use deployed on http://127.0.0.1:8080/. This solution is quickest to execute but requires an initial setup of a social server. To launch tests on an existing server launch the following command :

    mvn clean install -Prun-its -Dit.cargo.skip=true

You can redefine the host and port of the server to use by adding the following options in the command line

    -Dsocial.server.host=myHost -Dsocial.server.port=8888

### Project resources

* Issues management: https://jira.exoplatform.org/browse/SCL
* Jenkins continuous integration build: https://ci.exoplatform.org/job/social-client-master-ci/
* Jenkins integration tests build: https://ci.exoplatform.org/job/social-client-master-it/
* Sonar report: https://sonar.exoplatform.org/dashboard/index/81870
* Fisheye: https://fisheye.exoplatform.org/changelog/social-client
* Ohloh report: https://www.ohloh.net/p/exo-social-client/
* Artifact deployment: http://repository.exoplatform.org/content/groups/public/org/exoplatform/social/exo.social.client/

## How to use this library

Sample code:

    // Context information
    SocialClientContext.setProtocol("http"); //by default it is set as "http"
    SocialClientContext.setHost("platform35.demo.exoplatform.org");
    SocialClientContext.setPort(80);
    SocialClientContext.setPortalContainerName("portal");
    SocialClientContext.setRestContextName("rest");
    SocialClientContext.setRestVersion("v1-alpha1");
    SocialClientContext.setUsername("demo");
    SocialClientContext.setPassword("gtn");

    ClientServiceFactory clientServiceFactory = ClientServiceFactoryHelper.getClientServiceFactory();

    //it's all for Client to work, now just get the Service to use
    ActivityService activityService = clientServiceFactory.createActivityService();;

    IdentityService identityService = clientServiceFactory.createIdentityService();
    //...

    ActivityService activityService = client.getActivityService();
    RestActivity restActivity = (RestActivity) activityService.get("123456789");