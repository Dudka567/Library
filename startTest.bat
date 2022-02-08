set DIR_PROJECT=src/test/classes
del /s %DIR_BIN%\*.class >NUL
javac -d src/test/classes/java -classpath src\test\resources\junit-4.13.1.jar -sourcepath src/main/java src/test/java/LibraryTest.java
echo D|xcopy src\test\resources src\test\classes\resources /e
cd src/test/classes/java
java -classpath ..\resources\junit-4.13.1.jar; LibraryTest
pause
