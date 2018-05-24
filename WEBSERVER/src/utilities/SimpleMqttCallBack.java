package utilities;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SimpleMqttCallBack implements MqttCallback {

  public void connectionLost(Throwable throwable) {
    System.out.println("Connection to MQTT broker lost!");
  }

  public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
    String topic = s;
    String message = new String(mqttMessage.getPayload());
    System.out.println("Message received - Topic"+ topic + " Message: "+ message);
    
    // Putting the new value to temperature cache
    Temperature.putCurrentTemperature(topic, message);
  }

  public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
  
  }
}
