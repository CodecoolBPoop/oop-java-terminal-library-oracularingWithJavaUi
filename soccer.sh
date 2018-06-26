#!/bin/sh
javac com/codecool/termlib/*.java
jar cf termlib.jar com/codecool/termlib/*.class
javac -cp termlib.jar com/codecool/soccer/*.java
java com.codecool.soccer.Soccer
