set DIR_PROJECT=C:\\Library\src\test\classes
del /s %DIR_BIN%\*.class >NUL
cd C:\\Library\src\test\javaFiles
javac -d C:\\Library\src\test\classes -classpath javac -d C:\\Library\src\test\classes -classpath C:\\Library\src\test\resources\junit-4.13.1.jar *.java
cd C:\\Library\src\main\classes
java -classpath C:\\Library\src\main\classes src.main.javaFiles.Main
