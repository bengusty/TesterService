@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  TesterService startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and TESTER_SERVICE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\demo-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-1.2.6.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-data-rest-1.2.6.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-jersey-1.2.6.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-web-1.2.6.RELEASE.jar;%APP_HOME%\lib\commons-lang3-3.4.jar;%APP_HOME%\lib\apt-maven-plugin-1.1.3.jar;%APP_HOME%\lib\querydsl-core-3.6.7.jar;%APP_HOME%\lib\querydsl-jpa-3.6.7.jar;%APP_HOME%\lib\hibernate-entitymanager-4.3.5.Final.jar;%APP_HOME%\lib\h2-1.4.187.jar;%APP_HOME%\lib\mysql-connector-java-5.1.36.jar;%APP_HOME%\lib\spring-boot-starter-1.2.6.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-aop-1.2.6.RELEASE.jar;%APP_HOME%\lib\spring-core-4.1.7.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-1.2.6.RELEASE.jar;%APP_HOME%\lib\javax.transaction-api-1.2.jar;%APP_HOME%\lib\spring-orm-4.1.7.RELEASE.jar;%APP_HOME%\lib\spring-data-jpa-1.7.3.RELEASE.jar;%APP_HOME%\lib\spring-aspects-4.1.7.RELEASE.jar;%APP_HOME%\lib\jackson-annotations-2.4.6.jar;%APP_HOME%\lib\jackson-databind-2.4.6.jar;%APP_HOME%\lib\spring-tx-4.1.7.RELEASE.jar;%APP_HOME%\lib\spring-data-rest-webmvc-2.2.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-1.2.6.RELEASE.jar;%APP_HOME%\lib\hibernate-validator-5.1.3.Final.jar;%APP_HOME%\lib\spring-web-4.1.7.RELEASE.jar;%APP_HOME%\lib\jersey-server-2.14.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.14.jar;%APP_HOME%\lib\jersey-container-servlet-2.14.jar;%APP_HOME%\lib\jersey-bean-validation-2.14.jar;%APP_HOME%\lib\jersey-spring3-2.14.jar;%APP_HOME%\lib\jersey-media-json-jackson-2.14.jar;%APP_HOME%\lib\spring-webmvc-4.1.7.RELEASE.jar;%APP_HOME%\lib\plexus-build-api-0.0.7.jar;%APP_HOME%\lib\maven-plugin-api-2.2.0.jar;%APP_HOME%\lib\maven-model-2.2.0.jar;%APP_HOME%\lib\maven-project-2.2.0.jar;%APP_HOME%\lib\commons-io-1.3.2.jar;%APP_HOME%\lib\guava-18.0.jar;%APP_HOME%\lib\mysema-commons-lang-0.2.4.jar;%APP_HOME%\lib\bridge-method-annotation-1.13.jar;%APP_HOME%\lib\jboss-logging-3.1.3.GA.jar;%APP_HOME%\lib\jboss-logging-annotations-1.2.0.Beta1.jar;%APP_HOME%\lib\hibernate-core-4.3.5.Final.jar;%APP_HOME%\lib\dom4j-1.6.1.jar;%APP_HOME%\lib\hibernate-commons-annotations-4.0.4.Final.jar;%APP_HOME%\lib\hibernate-jpa-2.1-api-1.0.0.Final.jar;%APP_HOME%\lib\jboss-transaction-api_1.2_spec-1.0.0.Final.jar;%APP_HOME%\lib\javassist-3.18.1-GA.jar;%APP_HOME%\lib\spring-boot-1.2.6.RELEASE.jar;%APP_HOME%\lib\spring-boot-autoconfigure-1.2.6.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-logging-1.2.6.RELEASE.jar;%APP_HOME%\lib\snakeyaml-1.14.jar;%APP_HOME%\lib\spring-aop-4.1.7.RELEASE.jar;%APP_HOME%\lib\aspectjrt-1.8.6.jar;%APP_HOME%\lib\aspectjweaver-1.8.6.jar;%APP_HOME%\lib\spring-jdbc-4.1.7.RELEASE.jar;%APP_HOME%\lib\tomcat-jdbc-8.0.26.jar;%APP_HOME%\lib\spring-beans-4.1.7.RELEASE.jar;%APP_HOME%\lib\spring-data-commons-1.9.3.RELEASE.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.12.jar;%APP_HOME%\lib\jackson-core-2.4.6.jar;%APP_HOME%\lib\spring-data-rest-core-2.2.3.RELEASE.jar;%APP_HOME%\lib\json-patch-1.7.jar;%APP_HOME%\lib\tomcat-embed-core-8.0.26.jar;%APP_HOME%\lib\tomcat-embed-el-8.0.26.jar;%APP_HOME%\lib\tomcat-embed-logging-juli-8.0.26.jar;%APP_HOME%\lib\tomcat-embed-websocket-8.0.26.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\classmate-1.0.0.jar;%APP_HOME%\lib\jersey-common-2.14.jar;%APP_HOME%\lib\jersey-client-2.14.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\hk2-api-2.4.0-b06.jar;%APP_HOME%\lib\javax.inject-2.4.0-b06.jar;%APP_HOME%\lib\hk2-locator-2.4.0-b06.jar;%APP_HOME%\lib\hk2-2.4.0-b06.jar;%APP_HOME%\lib\spring-bridge-2.4.0-b06.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.3.2.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.3.2.jar;%APP_HOME%\lib\maven-settings-2.2.0.jar;%APP_HOME%\lib\maven-profile-2.2.0.jar;%APP_HOME%\lib\maven-artifact-manager-2.2.0.jar;%APP_HOME%\lib\maven-plugin-registry-2.2.0.jar;%APP_HOME%\lib\plexus-interpolation-1.11.jar;%APP_HOME%\lib\maven-artifact-2.2.0.jar;%APP_HOME%\lib\plexus-container-default-1.0-alpha-9-stable-1.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-1.1.0.Final.jar;%APP_HOME%\lib\xml-apis-1.0.b2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.12.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.12.jar;%APP_HOME%\lib\logback-classic-1.1.3.jar;%APP_HOME%\lib\tomcat-juli-8.0.26.jar;%APP_HOME%\lib\spring-hateoas-0.16.0.RELEASE.jar;%APP_HOME%\lib\spring-plugin-core-1.1.0.RELEASE.jar;%APP_HOME%\lib\evo-inflector-1.2.jar;%APP_HOME%\lib\jackson-coreutils-1.6.jar;%APP_HOME%\lib\jersey-guava-2.14.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\hk2-utils-2.4.0-b06.jar;%APP_HOME%\lib\aopalliance-repackaged-2.4.0-b06.jar;%APP_HOME%\lib\config-types-2.4.0-b06.jar;%APP_HOME%\lib\core-2.4.0-b06.jar;%APP_HOME%\lib\hk2-config-2.4.0-b06.jar;%APP_HOME%\lib\hk2-runlevel-2.4.0-b06.jar;%APP_HOME%\lib\class-model-2.4.0-b06.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.3.2.jar;%APP_HOME%\lib\maven-repository-metadata-2.2.0.jar;%APP_HOME%\lib\wagon-provider-api-1.0-beta-6.jar;%APP_HOME%\lib\backport-util-concurrent-3.1.jar;%APP_HOME%\lib\junit-3.8.1.jar;%APP_HOME%\lib\classworlds-1.1-alpha-2.jar;%APP_HOME%\lib\logback-core-1.1.3.jar;%APP_HOME%\lib\objenesis-2.1.jar;%APP_HOME%\lib\msg-simple-1.1.jar;%APP_HOME%\lib\tiger-types-1.4.jar;%APP_HOME%\lib\bean-validator-2.4.0-b06.jar;%APP_HOME%\lib\asm-all-repackaged-2.4.0-b06.jar;%APP_HOME%\lib\btf-1.2.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\slf4j-api-1.7.12.jar;%APP_HOME%\lib\spring-expression-4.1.7.RELEASE.jar;%APP_HOME%\lib\spring-context-4.1.7.RELEASE.jar;%APP_HOME%\lib\plexus-utils-1.5.15.jar;%APP_HOME%\lib\jsr305-2.0.1.jar

@rem Execute TesterService
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %TESTER_SERVICE_OPTS%  -classpath "%CLASSPATH%" demo.TesterServiceApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable TESTER_SERVICE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%TESTER_SERVICE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
