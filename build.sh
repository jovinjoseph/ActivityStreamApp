#!/bin/bash

cd activitystream-backend/AuthenticationService
source ./env-variable.sh
mvn clean package -Dmaven.test.skip=true
sudo docker build -t activity-auth-app .
cd ..
cd circleservice-solution
source ./env-variable.sh
mvn clean package -Dmaven.test.skip=true
sudo docker build -t activity-circle-app .
cd ..
cd messageservice-solution
source ./env-variable.sh
mvn clean package -Dmaven.test.skip=true
sudo docker build -t activity-message-app .
cd ..
cd usercircleservice-solution
source ./env-variable.sh
mvn clean package -Dmaven.test.skip=true
sudo docker build -t activity-usercircle-app .
cd ..
cd userservice-solution
source ./env-variable.sh
mvn clean package -Dmaven.test.skip=true
sudo docker build -t activity-user-app .
cd ..

