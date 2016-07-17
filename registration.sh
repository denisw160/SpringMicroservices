#!/bin/sh

# Settings for Service
SERVICE=registration
JAR=$SERVICE.jar
PID=$SERVICE.pid
LOG=$SERVICE.log

# Setup Environment
JAVA=java

case $1 in
    start)
        echo "Starting $SERVICE ..."
        if [ ! -f $PID ]; then
            nohup $JAVA -jar $PATH >> $LOG &
            echo $! > $PID
            echo "$SERVICE started."
        else
            echo "$SERVICE is already running."
        fi
    ;;
    stop)
        if [ -f $PID ]; then
            P=$(cat $PID);
            echo "$SERVICE stopping ..."
            kill $P;
            echo "$SERVICE stopped."
            rm $PID
        else
            echo "$SERVICE is not running."
        fi
    ;;
    restart)
        if [ -f $PID ]; then
            P=$(cat $PID);
            echo "$SERVICE stopping ...";
            kill $P;
            echo "$SERVICE stopped.";
            rm $PID
            echo "$SERVICE starting ..."
            nohup $JAVA -jar $PATH >> $LOG &
            echo $! > $PID
            echo "$SERVICE started."
        else
            echo "$SERVICE is not running."
        fi
    ;;
esac