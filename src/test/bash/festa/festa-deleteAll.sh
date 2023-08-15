#!/bin/bash

curl -v -X DELETE http://jar:8080/festa/ALL \
| json_pp
