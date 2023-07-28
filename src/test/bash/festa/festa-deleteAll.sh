#!/bin/bash

curl -v -X DELETE http://localhost:8080/festa/ALL \
| json_pp
