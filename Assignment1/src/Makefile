JFLAGS = 
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES := $(patsubst %.java,%.class,$(wildcard assignment1/*.java))

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) assignment1/*.class

format:
	astyle -n -r --style=java *.java
herb:
	astyle -n -r --style=allman --indent=tab *.java

