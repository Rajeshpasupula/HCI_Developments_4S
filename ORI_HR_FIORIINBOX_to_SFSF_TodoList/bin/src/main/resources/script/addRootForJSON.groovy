import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.json.*

def Message processData(Message message) {
	
	//Body 
	def body = message.getBody(String.class);
	body = body.toString();
	
	def json_to_str = body.substring(1,body.length()-1);
	json_to_str = "{\"Root\":{"+json_to_str+"}}";
	message.setBody(json_to_str);
	
	def messageLog = messageLogFactory.getMessageLog(message);
    if(messageLog != null){
        messageLog.addAttachmentAsString("Logging",json_to_str,"text/xml");	
       } 	
	return message;
}