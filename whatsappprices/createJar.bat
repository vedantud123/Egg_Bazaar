@echo off
cd C:\Users\Vinay server 3\eclipse-workspace\PoultryMavenProject
timeout 5
IF EXIST "C:\Users\Vinay server 3\eclipse-workspace\PoultryMavenProject\testing.jar" del "C:\Users\Vinay server 3\eclipse-workspace\PoultryMavenProject\testing.jar" /s /f /q
timeout 5
call mvn compile 
echo Exit Code = %ERRORLEVEL%
if not "%ERRORLEVEL%" == "0" exit /b

call mvn test-compile
echo Exit Code = %ERRORLEVEL%
if not "%ERRORLEVEL%" == "0" exit /b

call mvn test
echo Exit Code = %ERRORLEVEL%
if not "%ERRORLEVEL%" == "0" exit /b

call mvn install

cd C:\Users\Vinay server 3\eclipse-workspace\PoultryMavenProject

cd C:\Users\Vinay server 3\eclipse-workspace\PoultryMavenProject\target
ren PoultryMavenProject.whatsapp-0.0.1-SNAPSHOT-jar-with-dependencies.jar testing.jar
MOVE /Y "C:\Users\Vinay server 3\eclipse-workspace\PoultryMavenProject\target\testing.jar" "C:\Users\Vinay server 3\eclipse-workspace\PoultryMavenProject"

cd C:\Users\Vinay server 3\eclipse-workspace\PoultryMavenProject
java -jar testing.jar
cmd.exe
pause

 