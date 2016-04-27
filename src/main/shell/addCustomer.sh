#!/bin/sh

curl -H "Content-Type: application/json" -X POST -d $1 http://localhost:8080/jaxrs-example/customers
echo '\n'