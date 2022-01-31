set DIR_PROJECT=module/src/main/classes
del /s %DIR_BIN%\*.class >NUL
javac -d module/src/main/classes -sourcepath module module/src/main/java/Main.java
echo D|xcopy module\src\main\resources module\src\main\classes\src\main\resources /e
cd module/src/main/classes
java src.main.java.Main
pause
