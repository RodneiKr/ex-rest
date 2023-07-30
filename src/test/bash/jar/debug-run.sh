#!/bin/bash
java  -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005  -jar  /home/rodnei/workspace/ex-rest/target/ex-rest-0.0.1-SNAPSHOT.jar  >  /tmp/$(basename $0).log
