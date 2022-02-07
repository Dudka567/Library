set DIR_PROJECT=src/main/classes
del /s %DIR_BIN%\*.class >NUL
javac -d src/main/classes/java -sourcepath src/main/java src/main/java/*.java
echo D|xcopy src\main\resources src\main\classes\resources /e
cd src/main/classes/java
java Main
pause
