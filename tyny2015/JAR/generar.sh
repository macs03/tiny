#!/bin/bash
#
#Generar el lexico "Scanner.java": 

java -jar jFlex.jar -d ../src/compilador lexico.flex

#Generar el sintactico "Parser.java":


