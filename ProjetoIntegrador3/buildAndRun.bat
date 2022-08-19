@echo off
call mvn clean package
call docker build -t com.systempro/JSFtentativa .
call docker rm -f JSFtentativa
call docker run -d -p 9080:9080 -p 9443:9443 --name JSFtentativa com.systempro/JSFtentativa