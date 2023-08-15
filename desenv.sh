#!/bin/bash

if [ ${HOME} == "/home/developer" ]
then
        echo "------------------------------------------------------------------------------"
        echo "--- por gentileza nao executar '$(basename $0)' dentro do container do IntelliJ ---"
        echo "--- executar no sistema operacional local                                  ---"
        echo "------------------------------------------------------------------------------"
        exit 1
fi

mvn clean install -DskipTests
exit_code=$?
if [ $exit_code != 0 ]
then
        echo ">>>>>>>>>>>>>>>>>>> ERROR: $exit_code <<<<<<<<<<<<<<<<<<<<<<<<<"
        exit $exit_code
fi

docker compose up --build -d

