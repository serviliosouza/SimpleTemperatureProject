all: debug

build:
	javac -cp ".:lib/org.eclipse.paho.client.mqttv3-1.2.1-20180523.040548-143.jar" appsimulator/MySensor.java

release: build
	cd ..                && \
	zip -r SENSOR_SIMULATOR *

debug: build
	cd ..                && \
	zip -r SENSOR_SIMULATOR *

clean:
	rm -rf $(CLASS)
	rm -f SENSOR_SIMULATOR.zip
