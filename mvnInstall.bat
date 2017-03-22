@echo off

rem -- Lipsion
:menu
echo   ________________________________________________________________
echo  ^|                                                                ^|
echo  ^|                     Maven  -  control                          ^|
echo  ^|                                                                ^|
echo  ^|  0 - mvn clean install -U       1 - mvn install		^|
echo  ^|  2 - tomcat                     3 - kill tomcat                ^|
echo  ^|________________________________________________________________^|

:input
set /p input=-^> chose: 

if "%input%"== "0" goto cleanInstall
if "%input%"== "1" goto install
if "%input%"== "2" goto tomcat
if "%input%"== "3" goto killTomcat
goto end

:cleanInstall
TaskList|Findstr /i "java.exe">Nul
If ErrorLevel 1 (
  mvn clean install -U && %CATALINA_HOME%\bin\startup.bat && pause && call mvnInstall.bat
) Else (
  %CATALINA_HOME%\bin\shutdown.bat && mvn clean install -U && %CATALINA_HOME%\bin\startup.bat && pause && call mvnInstall.bat
)

:install
cd est-web-master && mvn install && pause && cd.. && call mvnInstall.bat

:tomcat
%CATALINA_HOME%\bin\startup.bat && pause && call mvnInstall.bat

:killTomcat
%CATALINA_HOME%\bin\shutdown.bat && pause && call mvnInstall.bat