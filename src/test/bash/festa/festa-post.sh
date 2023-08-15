#!/bin/bash
ymd=$(date +%Y-%m-%d)
hms=$(date +%H:%M:%S)

curl -v -X POST http://jar:8080/festa \
-H 'Content-Type:application/json' \
-d '{"autor":"eu","motivo":"final de ano '$hms'","data":"'$ymd'","orcamento":"10","servicos":[{"nome": "bar man", "descricao": "bebidas", "valor": "10"}]}' \
| json_pp
