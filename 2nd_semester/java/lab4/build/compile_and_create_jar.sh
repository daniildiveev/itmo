rm -rf classes/ lab4.jar 2>/dev/null

javac -d classes/ ../src/ru/ifmo/se/lab4/handler/*
javac -d classes/ ../src/ru/ifmo/se/lab4/exceptions/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab4/entities/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab4/commands/*
javac -cp ".:../src" -d classes/ ../src/ru/ifmo/se/lab4/*.java

jar -cvfm lab4.jar MANIFEST.MF -C classes/ .