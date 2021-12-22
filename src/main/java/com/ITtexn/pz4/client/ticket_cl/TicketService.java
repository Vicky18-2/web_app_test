
package com.ITtexn.pz4.client.ticket_cl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TicketService", targetNamespace = "http://ticket.service.pz4.ITtexn.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TicketService {


    /**
     * 
     * @return
     *     returns java.util.List<com.ITtexn.pz4.ticket_cl.Ticket>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllTickets", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.GetAllTickets")
    @ResponseWrapper(localName = "getAllTicketsResponse", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.GetAllTicketsResponse")
    @Action(input = "http://ticket.service.pz4.ITtexn.com/TicketService/getAllTicketsRequest", output = "http://ticket.service.pz4.ITtexn.com/TicketService/getAllTicketsResponse")
    public List<Ticket> getAllTickets();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     */
    @WebMethod
    @RequestWrapper(localName = "insertTicket", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.InsertTicket")
    @ResponseWrapper(localName = "insertTicketResponse", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.InsertTicketResponse")
    @Action(input = "http://ticket.service.pz4.ITtexn.com/TicketService/insertTicketRequest", output = "http://ticket.service.pz4.ITtexn.com/TicketService/insertTicketResponse")
    public void insertTicket(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Session arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        Film arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        Hall arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        int arg5,
        @WebParam(name = "arg6", targetNamespace = "")
        int arg6,
        @WebParam(name = "arg7", targetNamespace = "")
        boolean arg7);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     */
    @WebMethod
    @RequestWrapper(localName = "updateTicket", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.UpdateTicket")
    @ResponseWrapper(localName = "updateTicketResponse", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.UpdateTicketResponse")
    @Action(input = "http://ticket.service.pz4.ITtexn.com/TicketService/updateTicketRequest", output = "http://ticket.service.pz4.ITtexn.com/TicketService/updateTicketResponse")
    public void updateTicket(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Session arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        Film arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        Hall arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        int arg5,
        @WebParam(name = "arg6", targetNamespace = "")
        int arg6,
        @WebParam(name = "arg7", targetNamespace = "")
        boolean arg7);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "deleteTicket", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.DeleteTicket")
    @ResponseWrapper(localName = "deleteTicketResponse", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.DeleteTicketResponse")
    @Action(input = "http://ticket.service.pz4.ITtexn.com/TicketService/deleteTicketRequest", output = "http://ticket.service.pz4.ITtexn.com/TicketService/deleteTicketResponse")
    public void deleteTicket(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "countTicket", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.CountTicket")
    @ResponseWrapper(localName = "countTicketResponse", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.CountTicketResponse")
    @Action(input = "http://ticket.service.pz4.ITtexn.com/TicketService/countTicketRequest", output = "http://ticket.service.pz4.ITtexn.com/TicketService/countTicketResponse")
    public int countTicket();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.ITtexn.pz4.ticket_cl.Ticket
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTicket", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.GetTicket")
    @ResponseWrapper(localName = "getTicketResponse", targetNamespace = "http://ticket.service.pz4.ITtexn.com/", className = "com.ITtexn.pz4.ticket_cl.GetTicketResponse")
    @Action(input = "http://ticket.service.pz4.ITtexn.com/TicketService/getTicketRequest", output = "http://ticket.service.pz4.ITtexn.com/TicketService/getTicketResponse")
    public Ticket getTicket(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
