@echo off
setlocal
set "CLASSPATH=bin"
if not exist bin mkdir bin

echo Creating file list...
del filelist.txt

:: Compile Character package
for /r src/Character %%f in (*.java) do (
    echo %%f >> filelist.txt
)

:: Compile Zombie package
for /r src/Zombie %%f in (*.java) do (
    echo %%f >> filelist.txt
)

:: Compile Plant package
for /r src/Plant %%f in (*.java) do (
    echo %%f >> filelist.txt
)

:: Compile remaining packages
for /r src/Picture %%f in (*.java) do (
    echo %%f >> filelist.txt
)

for /r src/PlantFactory %%f in (*.java) do (
    echo %%f >> filelist.txt
)

for /r src/Subscriber %%f in (*.java) do (
    echo %%f >> filelist.txt
)

for /r src/Sun %%f in (*.java) do (
    echo %%f >> filelist.txt
)

for /r src/UI %%f in (*.java) do (
    echo %%f >> filelist.txt
)

for /r src/ZombieFactory %%f in (*.java) do (
    echo %%f >> filelist.txt
)

:: Compile Game package last
for /r src/Game %%f in (*.java) do (
    echo %%f >> filelist.txt
)

echo Compiling Java files...
javac -d bin -classpath src @filelist.txt

if %errorlevel% neq 0 (
    echo Compilation failed.
    exit /b %errorlevel%
)

echo Creating JAR file...
jar cfm MichaelvsLalapan.jar MANIFEST.MF -C bin .

echo Running the application...
java -cp bin Game.WelcomingFrame

if %errorlevel% neq 0 (
    echo JAR creation failed.
    exit /b %errorlevel%
)

echo JAR creation successful.
endlocal
pause
