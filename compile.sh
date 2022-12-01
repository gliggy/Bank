#!/usr/bin/bash
javac -classpath .:target/dependency/* -d . $(find . -type f -name '*.java')
java -classpath ".:target/dependency/*:sqlite-jdbc-3.40.0.0.jar" Main
# for debian: sudo apt install openjdk-17-jdk-headless
# for sqlite: sudo apt install cl-sql-sqlite3 sqlitebrowser
