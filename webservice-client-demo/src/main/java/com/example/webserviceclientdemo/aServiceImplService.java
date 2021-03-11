
package com.example.webserviceclientdemo;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


@WebServiceClient(name = "Aservice", targetNamespace = "http://com.example.ws/my", wsdlLocation = "http://192.168.1.118:12345/aservice?wsdl")
public class aServiceImplService extends Service {

    private final static URL PERSONIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException PERSONIMPLSERVICE_EXCEPTION;
    private final static QName PERSONIMPLSERVICE_QNAME = new QName("http://com.example.ws/my", "Aservice");
    private final static QName PERSONIMPLSERVICE_QNAME_PORT = new QName("http://com.example.ws/my", "UserPort");
    
    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.1.118:12345/aservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PERSONIMPLSERVICE_WSDL_LOCATION = url;
        PERSONIMPLSERVICE_EXCEPTION = e;
    }

    public aServiceImplService() {
        super(__getWsdlLocation(), PERSONIMPLSERVICE_QNAME);
    }

    @WebEndpoint()
    public Aservice getPersonImplPort() {
        return super.getPort(PERSONIMPLSERVICE_QNAME_PORT, Aservice.class);
    }

    private static URL __getWsdlLocation() {
        if (PERSONIMPLSERVICE_EXCEPTION != null) {
            throw PERSONIMPLSERVICE_EXCEPTION;
        }
        return PERSONIMPLSERVICE_WSDL_LOCATION;
    }

}
