set DIR_PROJECT=src/test/classes
del /s %DIR_BIN%\*.class >NUL
cd src/test/javaFiles
javac -d ../classes -classpath ..\resources\junit-4.13.1.jar;..\..\..\ *.java
cd..
cd classes
java -classpath ..\resources\junit-4.13.1.jar; src.test.javaFiles.LibraryTest
pause
