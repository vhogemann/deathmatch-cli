package ws.deathmatch.service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate

import ws.deathmatch.xml.CommandEnum;
import ws.deathmatch.xml.DeathmatchRequest;

@Service
class DeathmatchService {
	
	@Value('http://localhost:8080/deathmatch-ws/soap/service')
	private String uri
	
	@Autowired
	private WebServiceTemplate webServiceTemplate

	def sendAndReceive( String command ){
		DeathmatchRequest payload = new DeathmatchRequest()
		payload.command = CommandEnum.values().find { "$it" == command.toUpperCase() }
		return webServiceTemplate.marshalSendAndReceive(uri, payload)
	}
	
}
