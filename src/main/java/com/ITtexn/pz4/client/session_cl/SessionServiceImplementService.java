
package com.ITtexn.pz4.client.session_cl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SessionServiceImplementService", targetNamespace = "http://session.service.pz4.ITtexn.com/", wsdlLocation = "http://localhost:7777/session?wsdl")
public class SessionServiceImplementService
    extends Service
{

    private final static URL SESSIONSERVICEIMPLEMENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SESSIONSERVICEIMPLEMENTSERVICE_EXCEPTION;
    private final static QName SESSIONSERVICEIMPLEMENTSERVICE_QNAME = new QName("http://session.service.pz4.ITtexn.com/", "SessionServiceImplementService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:7777/session?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SESSIONSERVICEIMPLEMENTSERVICE_WSDL_LOCATION = url;
        SESSIONSERVICEIMPLEMENTSERVICE_EXCEPTION = e;
    }

    public SessionServiceImplementService() {
        super(__getWsdlLocation(), SESSIONSERVICEIMPLEMENTSERVICE_QNAME);
    }

    public SessionServiceImplementService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SESSIONSERVICEIMPLEMENTSERVICE_QNAME, features);
    }

    public SessionServiceImplementService(URL wsdlLocation) {
        super(wsdlLocation, SESSIONSERVICEIMPLEMENTSERVICE_QNAME);
    }

    public SessionServiceImplementService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SESSIONSERVICEIMPLEMENTSERVICE_QNAME, features);
    }

    public SessionServiceImplementService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SessionServiceImplementService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SessionService
     */
    @WebEndpoint(name = "SessionServiceImplementPort")
    public SessionService getSessionServiceImplementPort() {
        return super.getPort(new QName("http://session.service.pz4.ITtexn.com/", "SessionServiceImplementPort"), SessionService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SessionService
     */
    @WebEndpoint(name = "SessionServiceImplementPort")
    public SessionService getSessionServiceImplementPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://session.service.pz4.ITtexn.com/", "SessionServiceImplementPort"), SessionService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SESSIONSERVICEIMPLEMENTSERVICE_EXCEPTION!= null) {
            throw SESSIONSERVICEIMPLEMENTSERVICE_EXCEPTION;
        }
        return SESSIONSERVICEIMPLEMENTSERVICE_WSDL_LOCATION;
    }

}
