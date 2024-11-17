@echo off


REM Java와 애플리케이션 설정
set "JAVA_HOME=java home path"
set "MAVEN_HOME=maven home path"
set "MAVEN_REPOSITORY=maven repository path"
set "APP_HOME=app home path"

REM 로그 파일 설정
set "LOGFILE=%APP_HOME%\\application.log"

REM set "APP_JAR=springboot-app.jar"
REM set "JAVA_OPTS=-Xms256m -Xmx1024m -Dspring.profiles.active=prod"

echo JAVA_HOME=%JAVA_HOME%
echo APP_HOME=%APP_HOME%
REM echo APP_JAR=%APP_JAR%
REM echo JAVA_OPTS=%JAVA_OPTS%

REM 현재 날짜와 시간을 로그에 기록
echo %date% %time% : Starting application >> %LOGFILE%

REM Java와 Maven이 설치되어 있는지 확인
if not exist "%JAVA_HOME%\bin\java.exe" (
    echo Error: Java is not installed or JAVA_HOME is incorrect. >> %LOGFILE%
    exit /b 1
)
if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
    echo Error: Maven is not installed or MAVEN_HOME is incorrect. >> %LOGFILE%
    exit /b 1
)

REM Maven Clean Install 실행
echo Running Maven Clean Install...
call %MAVEN_HOME%\bin\mvn.cmd clean install -f %APP_HOME%\pom.xml -Dmaven.repo.local=%MAVEN_REPOSITORY%  >> %LOGFILE% 2>&1

if %ERRORLEVEL% neq 0 (
    echo Maven build failed with error code %ERRORLEVEL% >> %LOGFILE%
    exit /b 1
)

echo END
