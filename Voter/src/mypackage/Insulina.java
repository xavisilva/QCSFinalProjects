
package mypackage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Insulina", targetNamespace = "http://example/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Insulina {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "backgroundInsulinDose", targetNamespace = "http://example/", className = "mypackage.BackgroundInsulinDose")
    @ResponseWrapper(localName = "backgroundInsulinDoseResponse", targetNamespace = "http://example/", className = "mypackage.BackgroundInsulinDoseResponse")
    @Action(input = "http://example/Insulina/backgroundInsulinDoseRequest", output = "http://example/Insulina/backgroundInsulinDoseResponse")
    public int backgroundInsulinDose(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "mealtimeInsulinDose", targetNamespace = "http://example/", className = "mypackage.MealtimeInsulinDose")
    @ResponseWrapper(localName = "mealtimeInsulinDoseResponse", targetNamespace = "http://example/", className = "mypackage.MealtimeInsulinDoseResponse")
    @Action(input = "http://example/Insulina/mealtimeInsulinDoseRequest", output = "http://example/Insulina/mealtimeInsulinDoseResponse")
    public int mealtimeInsulinDose(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4);

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "personalSensitivityToInsulin", targetNamespace = "http://example/", className = "mypackage.PersonalSensitivityToInsulin")
    @ResponseWrapper(localName = "personalSensitivityToInsulinResponse", targetNamespace = "http://example/", className = "mypackage.PersonalSensitivityToInsulinResponse")
    @Action(input = "http://example/Insulina/personalSensitivityToInsulinRequest", output = "http://example/Insulina/personalSensitivityToInsulinResponse")
    public int personalSensitivityToInsulin(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
                List<Integer> arg1,
        @WebParam(name = "arg2", targetNamespace = "")
                List<Integer> arg2);

}
