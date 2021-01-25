#!/bin/bash

mvn package

docker build -t jumia/task .

docker run -p 8080:8080 jumia/task
