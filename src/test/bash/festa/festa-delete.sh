#!/bin/bash

curl -v -X DELETE http://jar:8080/festa/$1 \
| json_pp
