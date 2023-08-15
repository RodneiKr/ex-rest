#!/bin/bash
if [[ -z $1 ]] && [[ -z $2 ]] && [[ -z $3 ]]
then
	echo ''
	echo '-----------------------------------------------'
	echo '  syntax: '$(basename $0)' id [orcamento] [valor]'
	echo '-----------------------------------------------'
	echo ''
	exit 1
fi
id=$1
orcamento=$2
if [ -z $orcamento ]
then
	orcamento=100
fi
valor=$3
if [ -z $valor ]
then
	valor=10
fi
ymd=$(date +%Y-%m-%d)
hms=$(date +%H:%M:%S)

curl -v -X PUT http://jar:8080/festa/$id \
-H 'Content-Type:application/json' \
-d '{"autor":"eu","motivo":"final de ano '$hms'","data":"'$ymd'","orcamento":"'$orcamento'","servicos":[{"nome": "bar man", "descricao": "bebidas", "valor": "'$valor'"}]}' \
| json_pp
