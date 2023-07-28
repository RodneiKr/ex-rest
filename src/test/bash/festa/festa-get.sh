#!/bin/bash

curl -v -X GET http://localhost:8080/festa/$1 \
| json_pp
