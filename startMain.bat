set DIR_PROJECT=C:\\Library\src\main\classes
del /s %DIR_BIN%\*.class >NUL
cd C:\\Library\src\main\javaFiles
javac -d C:\\Library\src\main\classes *.java
cd C:\\Library\src\main\classes
java -classpath C:\\Library\src\main\classes src.main.javaFiles.Main
