package com.marknjunge.soapclient.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import universities.wsdl.*;

public class UniversityClient extends WebServiceGatewaySupport {
    public GetUniversityResponse getUniversityByName(String name) {
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(name);

        return (GetUniversityResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost/ws", request);
    }

    public GetAllUniversitiesResponse getAllUniversities() {
        GetAllUniversitiesRequest request = new GetAllUniversitiesRequest();

        return (GetAllUniversitiesResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost/ws", request);
    }

    public GetAllUniversitiesResponse getAllUniversitiesAtLocation(String location) {
        GetAllUniversitiesAtLocationRequest request = new GetAllUniversitiesAtLocationRequest();
        request.setLocation(location);

        return (GetAllUniversitiesResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost/ws", request);
    }
}
