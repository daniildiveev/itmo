javac -d classes/ ../src/common/exceptions/*
javac -cp ".:../src" -d classes/ ../src/common/validator/*
javac -cp ".:../src" -d classes/ ../src/common/entities/*
javac -cp ".:../src" -d classes/ ../src/common/handler/*

jar cfm lab5_common.jar MANIFEST.MF -C classes/ .

mkdir ../../client/app/libs/ 2>/dev/null
mkdir ../../server/app/libs/ 2>/dev/null
cp lab5_common.jar ../../client/app/libs/
cp lab5_common.jar ../../server/app/libs/