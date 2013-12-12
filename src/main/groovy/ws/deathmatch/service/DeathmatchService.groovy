package ws.deathmatch.service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate

import ws.deathmatch.xml.CommandEnum;
import ws.deathmatch.xml.DeathmatchRequest;
import ws.deathmatch.xml.DeathmatchResponse;

@Service
class DeathmatchService {
	
	@Value('http://172.20.19.161:8080/deathmatch-ws/soap/service')
	private String uri
	
	@Autowired
	private WebServiceTemplate webServiceTemplate

	public DeathmatchResponse sendAndReceive( String command ){
		DeathmatchRequest payload = new DeathmatchRequest()
		payload.command = CommandEnum.values().find { "$it" == command.toUpperCase() }
		return webServiceTemplate.marshalSendAndReceive(uri, payload)
	}
	
}
