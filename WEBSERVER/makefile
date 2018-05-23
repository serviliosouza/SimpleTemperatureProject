# Tomcat Configuration
TOMCAT=apache-tomcat-9.0.8

# Directories
SRCDIR     = $(CURDIR)/src
TOMCATDIR  = $(CURDIR)/$(TOMCAT)
CONTEXTDIR = $(TOMCATDIR)/webapps/ROOT
CLASSDIR   = $(CONTEXTDIR)/WEB-INF/classes
JARDIR     = $(CONTEXTDIR)/WEB-INF/lib

# Class Path
CLASSPATH=$(TOMCATDIR)/lib/servlet-api.jar

# Toolchain Configuration
JAVAC = javac
JFLAGS = -d $(CLASSDIR) -cp $(CLASSPATH)

# Source Files
SRC= $(wildcard src/*.java)
	 
# Class Files
CLASS = $(SRC:.java=.class)

all: debug

# Builds
build:
	mkdir -p $(CLASSDIR)
	$(JAVAC) $(JFLAGS) $(SRC)

release: build
	cd $(CONTEXTDIR)                       && \
	zip -r $(CURDIR)/Projeto *            && \
	git checkout *

debug: build
	cd $(CONTEXTDIR)                       && \
	zip -r $(CURDIR)/Projeto *            && \
	git checkout *

# Cleans Compilation Files
clean:
	rm -rf $(CLASSDIR)/*
	rm -rf $(CLASS)
	rm -f Projeto.zip