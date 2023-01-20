javac -d classes/ ../src/ru/ifmo/se/lab3/enums/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/*.java
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/objects/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/characters/*

jar cvmf MANIFEST.MF lab3.jar -C classes/ .