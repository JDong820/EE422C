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

bitbucket:
	$(RM) -r ~/git/bitbucket/Assignment3/src; \
	    cp -r src ~/git/bitbucket/Assignment3/src; \

format:
	astyle -n -r --style=java *.java
herb:
	astyle -n -r --style=allman --indent=tab *.java

javadoc:
	javadoc -d ./html -sourcepath ./src assignment3
