@echo off
setlocal
set "CLASSPATH=bin"
if not exist bin mkdir bin

echo Compiling dependencies...

:: Compile Character package
for /r src/Character %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

:: Compile Zombie package
for /r src/Zombie %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

:: Compile Plant package
for /r src/Plant %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

:: Compile remaining packages
for /r src/Picture %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

for /r src/PlantFactory %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

for /r src/Subscriber %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

for /r src/Sun %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

for /r src/UI %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

for /r src/ZombieFactory %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

:: Compile Game package last
for /r src/Game %%f in (*.java) do (
    echo Compiling %%f
    javac -d bin -classpath src "%%f"
)

if %errorlevel% neq 0 (
    echo Compilation failed.
    exit /b %errorlevel%
)

echo Creating JAR file...
jar cfm my_project.jar MANIFEST.MF -C bin .

if %errorlevel% neq 0 (
    echo JAR creation failed.
    exit /b %errorlevel%
)

echo JAR creation successful.
endlocal
pause
