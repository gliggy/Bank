#!/usr/bin/bash
cp Index.java template.txt
javac -classpath .:target/dependency/* -d . $(find . -type f -name '*.java')
java -classpath ".:target/dependency/*" Main
#:sqlite-jdbc-3.40.0.0.jar
#cp template.txt Index.java
# for debian: sudo apt install openjdk-17-jdk-headless
# for sqlite: sudo apt install cl-sql-sqlite3 sqlitebrowser
