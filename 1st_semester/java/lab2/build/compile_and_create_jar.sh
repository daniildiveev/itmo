javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab2/*.java
javac -d classes/ ../src/ru/ifmo/se/lab2/objects/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab2/characters/*
javac -d classes/ ../src/ru/ifmo/se/lab2/enums/*

cd classes 
java ru.ifmo.se.lab2.Main
cd .. 
