#!/bin/bash

function log() {
  p1=$@
  echo $p1 >> ${fileLog}
  echo $p1
}

function   docker_container() {
  log " "
  log "=== 01. docker container"
  for f in $(docker container ls | awk '{print $1"_"$2}')
  do
    if [[ $f == *ex-rest* ]]
    then
      log $f
      docker container stop ${f:0:12}
      docker container rm   ${f:0:12}
    fi
  done
  docker container prune -f
}

function   docker_image() {
  log " "
  log "=== 02. docker image"
  for f in $(docker image ls | awk '{print $3"_"$1}')
  do
    if [[ $f == *ex-rest* ]]
    then
      log $f
      docker image rm -f ${f:0:12}
    fi
  done
  docker image prune -f
}

function   docker_network() {
  log " "
  log "=== 03. docker network"
  for f in $(docker network ls | awk '{print $1"_"$2}')
  do
    if [[ $f == *ex-rest* ]]
    then
      log $f
      docker network rm ${f:0:12}
    fi
  done
  docker network prune -f
}

function mvn_clean_install() {
  log " "
  log "=== 04. mvn clean install -DskipTests"
  mvn clean install -DskipTests
}

function docker_compose() {
  log " "
  log "=== 05. docker compose up -d"
  docker compose up -d
}

ini=$(date +%Y-%m-%d_%H:%M:%S)
bashBasename=$(basename $0)
fileLog="/tmp/${bashBasename}.log"

echo " " > ${fileLog}
log "${bashBasename} - Inicio"
log " "
log ${fileLog}

docker_container
docker_image
docker_network
mvn_clean_install
docker_compose

log " "
log "${bashBasename} - Fim"
log " "
log "Ini: ${ini}"
log "Fim: $(date +%Y-%m-%d_%H:%M:%S)"
log " "

less ${fileLog}
