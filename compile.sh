#!/usr/bin/bash
javac -classpath .:target/dependency/* -d . $(find . -type f -name '*.java')
java -classpath .:target/dependency/* Main
# for debian: sudo apt install openjdk-17-jdk-headless
