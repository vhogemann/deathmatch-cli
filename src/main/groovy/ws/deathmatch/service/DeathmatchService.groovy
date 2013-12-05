package ws.deathmatch.service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
class DeathmatchService {
	
	@Value('${deathmatch.soap.uri}')
	private String uri
	
	@Autowired
	private WebServiceTemplate webServiceTemplate

	def sendAndReceive(def payload ){
		return webServiceTemplate.marshalSendAndReceive(uri, payload)
	}
	
}
