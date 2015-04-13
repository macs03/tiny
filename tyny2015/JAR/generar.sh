#!/bin/bash
#
#Generar el lexico "Scanner.java": 

java -jar jFlex.jar -d ../src/compilador lexico.flex

#Generar el sintactico "Parser.java":

java -jar java-cup-11a.jar -expect 100 -destdir ../src/compilador -parser parser -symbols sym -interface sintactico.cup
