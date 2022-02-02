set DIR_PROJECT=module/src/test/classes
del /s %DIR_BIN%\*.class >NUL
cd src/test/javaFiles
javac -d module/src/test/classes -classpath module\src\test\resources\junit-4.13.1.jar -sourcepath module module/src/test/java/LibraryTest.java
echo D|xcopy module\src\test\resources module\src\test\classes\src\test\resources /e
cd module/src/test/classes
java -classpath module\src\test\resources\junit-4.13.1.jar; src.test.java.LibraryTest
pause
