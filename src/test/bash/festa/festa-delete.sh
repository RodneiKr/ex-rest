#!/bin/bash

curl -v -X DELETE http://localhost:8080/festa/$1 \
| json_pp
