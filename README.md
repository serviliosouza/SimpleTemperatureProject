# SimpleTemperatureProject

A simple temperature project based on internet of things.

# Steps for testing

Assumed you are on a Ubuntu distro, run the following commands:

sudo apt-add-repository ppa:mosquitto-dev/mosquitto-ppa

sudo apt-get update

sudo apt-get install mysql-server openjdk-8-jdk git mosquitto mosquitto-clients

mosquitto -d

git clone "https://github.com/serviliosouza/SimpleTemperatureProject.git"

cd ./SimpleTemperatureProject/SENSOR_SIMULATOR

make build

bash exec.sh 3
- It will be running on the terminal, please open another terminal window to continue

cd ../SimpleTemperatureProject/WEBSERVER

make build

bash scripts/run.sh

- After commands, go to browser and access "localhost:8080/temperatura"





