package appsimulator;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.TimeUnit;

public abstract class MySensor {
	
	private static MemoryPersistence persistence;
	private static MqttClient sampleClient;
	private static MqttConnectOptions connOpts;
	
	private static final int qos = 2;
	
	private static void mqqtConnect(String broker) throws Exception {
		persistence = new MemoryPersistence();
		sampleClient = new MqttClient(broker, MqttClient.generateClientId(), persistence);
		connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		sampleClient.connect(connOpts);
	}
	
	private static void mqqtDisconnect() throws Exception {
		sampleClient.disconnect();
	}
	
	private static void mqqtSendMessage(String topic, String message) throws Exception {
		MqttMessage m = new MqttMessage(message.getBytes());
		m.setQos(qos);
		sampleClient.publish(topic, m);
	}
	
	/**
	 * Main simulator thread. Expects the MQTT host and the sensor number.
	 */
	public static void main(String[] args) {
		
		System.out.println("Host: " + args[0]);
		System.out.println("Inicializando simulador para " + args[1] + " sensores");
		try {
			mqqtConnect("tcp://127.0.0.1:1883");
			mqqtSendMessage("arroz", "feijao");
			mqqtDisconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
}
