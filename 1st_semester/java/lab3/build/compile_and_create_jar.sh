rm -rf classes/ lab3.jar 2>/dev/null

javac -d classes/ ../src/ru/ifmo/se/lab3/enums/*
javac -d classes/ ../src/ru/ifmo/se/lab3/exceptions/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/objects/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/characters/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab3/*.java

jar cmf MANIFEST.MF lab3.jar -C classes/ .

java -jar lab3.jar