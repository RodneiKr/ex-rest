#!/bin/bash

curl -v -X GET http://localhost:8080/festa \
| json_pp
