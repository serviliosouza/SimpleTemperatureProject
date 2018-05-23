# Executes the simulator

# Expects the sensor number as first param

HOST=tcp://127.0.0.1:1883

java -cp '.:lib/org.eclipse.paho.client.mqttv3-1.2.1-20180523.040548-143.jar' appsimulator.MySensor $HOST $1
