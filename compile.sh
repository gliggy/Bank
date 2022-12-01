#!/usr/bin/bash
#cp Index.java template.txt
function substitute_BLOCK_with_FILEcontents {
  local BLOCK_StartRegexp="${1}"
  local BLOCK_EndRegexp="${2}"
  local FILE="${3}"
  sed -e "/${BLOCK_EndRegexp}/a ___tmpMark___" -e "/${BLOCK_StartRegexp}/,/${BLOCK_EndRegexp}/d" | sed -e "/___tmpMark___/r ${FILE}" -e '/___tmpMark___/d'
}


javac -classpath .:target/dependency/* -d . $(find . -type f -name '*.java')
java -classpath ".:target/dependency/*" Main
cat template.txt | substitute_BLOCK_with_FILEcontents '^START' '^END' accounts.txt > Index.java
#:sqlite-jdbc-3.40.0.0.jar
#cp template.txt Index.java
# for debian: sudo apt install openjdk-17-jdk-headless
# for sqlite: sudo apt install cl-sql-sqlite3 sqlitebrowser
