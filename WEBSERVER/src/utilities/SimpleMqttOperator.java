package utilities;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public abstract class SimpleMqttOperator {
	
	private static final int qos = 2;
	private static final String broker = "tcp://127.0.0.1:1883";
	
	
	public static void sendMqttMessage(String topic, String content) {
		String clientId     = "webserver";
		MemoryPersistence persistence = new MemoryPersistence();
		try {
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			sampleClient.connect(connOpts);
			MqttMessage message = new MqttMessage(content.getBytes());
			message.setQos(qos);
			sampleClient.publish(topic, message);
			sampleClient.disconnect();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a new MQTT client and generates a listener to wait messages related to the topic.
	 * 
	 * @param topic The interested topic.
	 */
	public static void createParallelListenerForTopic(String topic) {
		
		try {
			MqttClient client=new MqttClient("tcp://127.0.0.1:1883", MqttClient.generateClientId());
			client.setCallback(new SimpleMqttCallBack());
			client.connect();
			client.subscribe(topic);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
