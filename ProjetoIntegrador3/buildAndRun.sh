#!/bin/sh
mvn clean package && docker build -t com.systempro/JSFtentativa .
docker rm -f JSFtentativa || true && docker run -d -p 9080:9080 -p 9443:9443 --name JSFtentativa com.systempro/JSFtentativa