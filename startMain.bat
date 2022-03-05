cd src/main
call mvn clean package
echo D|xcopy resources target\resources /e
cd target/classes
java Main
pause
