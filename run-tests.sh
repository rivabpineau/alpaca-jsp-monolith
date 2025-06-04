#!/bin/sh
set -e
mkdir -p bin
find src -name '*.java' | grep -E 'dao|model' > compile_sources.txt
javac -d bin @compile_sources.txt
find test -name '*.java' > test_sources.txt
javac -d bin -cp /usr/share/java/junit4.jar:bin @test_sources.txt
java -cp /usr/share/java/junit4.jar:bin org.junit.runner.JUnitCore UserDAOTest TourDAOTest BookingDAOTest
