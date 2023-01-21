javac -d classes/ ../src/ru/ifmo/se/lab3/enums/*
javac -d classes/ ../src/ru/ifmo/se/lab3/exceptions/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/*.java
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/objects/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/characters/*

jar cmf MANIFEST.MF lab3.jar -C classes/ .

java -jar lab3.jar