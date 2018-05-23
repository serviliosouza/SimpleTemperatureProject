TOMCAT=apache-tomcat-9.0.8

export CATALINA_HOME=$PWD/$TOMCAT

mkdir -p $CATALINA_HOME/logs

$CATALINA_HOME/bin/startup.sh

