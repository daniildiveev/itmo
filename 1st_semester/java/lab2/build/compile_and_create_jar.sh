javac -d classes/ ../src/ru/ifmo/se/lab2/enums/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab2/*.java
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab2/objects/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab2/characters/*

jar cvmf MANIFEST.MF lab2.jar -C classes/ .