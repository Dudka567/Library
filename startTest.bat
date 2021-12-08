set DIR_PROJECT=\Library\src\test\classes
del /s %DIR_BIN%\*.class >NUL
cd \Library\src\test\javaFiles
javac -d \Library\src\test\classes -classpath javac -d \Library\src\test\classes -classpath \Library\src\test\resources\junit-4.13.1.jar *.java
cd \Library\src\main\classes
java -classpath \Library\src\main\classes src.main.javaFiles.Main
