#!/bin/bash

curl -v -X GET http://jar:8080/festa \
| json_pp
