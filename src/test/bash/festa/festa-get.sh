#!/bin/bash

curl -v -X GET http://jar:8080/festa/$1 \
| json_pp
