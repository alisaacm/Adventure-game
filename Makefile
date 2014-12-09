 1 # Aubrey Isaacman
  2 # alisaacm
  3 # CMPS012B
  4 # 12/8/2014
  5 # Makefile for assignment4
  6
  7 JAVASRC = assignment4.java
  8 SOURCES = ${JAVASRC} Makefile
  9 ALLSOURCES = ${SOURCES}
 10 MAINCLASS = assignment4
 11 CLASSES = ${patsubst $.java, $.class, ${JAVASRC}}
 12
 13 all: ${CLASSES}
 14
 15 %.class: %.java
 16     javac -Xlint $<
 17 clean:
 18     rm -f *.class
 19 test: all
 20 #   java xref -d test.txt
 21
 22 .PHONY: clean all test
