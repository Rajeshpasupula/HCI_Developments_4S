import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.util.XmlSlurper;

def Message processData(Message message) {
	
	//Body 
	def body = message.getBody();
	def map =  message.getProperties();
	
	def Xmldata = new XmlSlurper().parseText(body);
	int expires_in = Xmldata.expires_in.text() as int;	
	// Check if expires_in is less than 60
	if (expires_in > 60 )
	{
		message.setProperty("valid", "true");
	}
	else
	{
	   message.setProperty("valid", "false");
	}  
		return message;
}

