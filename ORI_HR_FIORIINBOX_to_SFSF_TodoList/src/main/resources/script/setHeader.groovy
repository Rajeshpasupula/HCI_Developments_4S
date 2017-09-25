import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.util.XmlSlurper;

def Message processData(Message message) {
	
	//Body 
	def body = message.getBody(String.class);
	
	def Xmldata = new XmlSlurper().parseText(body);
	def access_token = Xmldata.access_token.text();
	def token_type = Xmldata.token_type.text();
	
	
	def messageLog = messageLogFactory.getMessageLog(message);
	if(messageLog!=null)
	{
	  messageLog.setStringProperty("access_token", access_token);
	  messageLog.setStringProperty("token_type", token_type);
	 }	
			
	message.setBody("");		
	//Headers 
	message.setHeader("Authorization", "Bearer "+access_token);
			
	return message;
}