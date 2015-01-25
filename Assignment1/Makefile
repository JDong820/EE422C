JFLAGS = -cp src/
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES := $(patsubst %.java,%.class,$(wildcard src/*/*.java))

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) src/*/*.class

format:
	astyle -n -r --style=java *.java
herb:
	astyle -n -r --style=allman --indent=tab *.java
