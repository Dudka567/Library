set DIR_PROJECT=C:\\Library\src\main\javaFiles
del /s %DIR_BIN%\*.class >NUL
cd C:\\Library\src\main\javaFiles
javac -d C:\\Library\src\main\classes -classpath junit-4.13.1.jar *.java
cd C:\\Library\src\main\classes
java -classpath C:\\Library\src\main\classes res.main.javaFiles.Main
