set DIR_PROJECT=\Library\src\main\classes
del /s %DIR_BIN%\*.class >NUL
cd \Library\src\main\javaFiles
javac -d \Library\src\main\classes *.java
cd \Library\src\main\classes
java -classpath \Library\src\main\classes src.main.javaFiles.Main
