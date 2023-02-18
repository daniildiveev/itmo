rm -rf classes/ lab4.jar 2>/dev/null

javac -d classes/ ../src/ru/ifmo/se/lab4/exceptions/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab4/entities/*

jar -cvfm lab4.jar MANIFEST.MF -C classes/ .
java -jar lab4.jar