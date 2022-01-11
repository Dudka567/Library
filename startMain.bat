set DIR_PROJECT=src/main/classes
del /s %DIR_BIN%\*.class >NUL
cd src/main/javaFiles
javac -d ../classes *.java
cd..
cd classes
java src.main.javaFiles.Main
