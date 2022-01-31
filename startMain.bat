set DIR_PROJECT=src/main/classes
del /s %DIR_BIN%\*.class >NUL
cd src/main/java
javac -d ../classes -sourcepath src *.java
cd..
cd classes
java src.main.java.Main
pause
