@ECHO off

ECHO.
ECHO :::::::::::::::::::: set environment variables :::::::::::::::::::::::::::
ECHO :: By:      Machiel de Jager, 20-02-2016          (dd-MM-yyyy)          ::
ECHO :: Version: 2.0                                                         ::
ECHO ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

set PROJECT=file_exchange

rem Project
set PROJECT_HOME=D:\dev\projects\file_exchange
set WS=%PROJECT_HOME%
set POM=%WS%\pom.xml
rem set POM_DAR=

rem Maven
set M2_HOME=D:\dev\maven\apache-maven-3.3.9
set M2=%M2_HOME%\bin
rem set ACTIVE_MAVEN_PROFILE=xba_ont

rem Java
set JAVA_HOME=D:\dev\java\jdk
set JAVA=%JAVA_HOME%\bin

set PATH=%JAVA_HOME%;%JAVA%;%M2%;%M2_HOME%;%windir%;C:\Windows\system32;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;%PATH%