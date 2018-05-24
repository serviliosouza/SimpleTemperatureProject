package utilities;

import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.paho.client.mqttv3.MqttClient;

public abstract class Temperature {
	
	private static ConcurrentHashMap<String, String> tp = new ConcurrentHashMap<String, String>();
	
	private static MqttClient client = null;
	
	public static String getCurrentTemperature(String sensor) throws Exception {
		
		if (client == null) {
			makeListener("tcp://127.0.0.1:1883");
		}
		
		client.subscribe(sensor);
		
		String result = tp.get(sensor);
		
		if (result == null)
			result = "no value";
			
		return (result);
	}
	
	public static void putCurrentTemperature(String sensor, String value) {
		tp.put(sensor, value);
	}
	
	private static void makeListener(String server) throws Exception {
		client = new MqttClient(server, MqttClient.generateClientId());
		client.setCallback(new SimpleMqttCallBack());
		client.connect();
	}
	
}
