package example;

import com.sun.xml.ws.client.BindingProviderProperties;
import mypackage.Insulina;
import mypackage.InsulinaService;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;


public class ServiceCall implements Callable<Double>
{
    private String wsdl;
    private int bodyWeight;
    private int method;
    private int carbohydrateAmount;
    private int carbohydrateToInsulinRatio;
    private int preMealBloodSugar;
    private int targetBloodSugar;
    private int personalSensitivity;
    private int physicalActivityLevel;
    private List<Integer> physicalActivitySamples;
    private List<Integer> bloodSugarDropSamples;
    private int personalResult;

    public ServiceCall(String wsdl,int method,int bodyWeight)
    {
        this.wsdl = wsdl;
        this.method = method;
        this.bodyWeight = bodyWeight;
    }

    public ServiceCall(String wsdl, int method,int carbohydrateAmount, int carbohydrateToInsulinRatio, int preMealBloodSugar, int targetBloodSugar, int personalSensitivity)
    {
        this.wsdl = wsdl;
        this.method = method;
        this.carbohydrateAmount = carbohydrateAmount;
        this.carbohydrateToInsulinRatio = carbohydrateToInsulinRatio;
        this.preMealBloodSugar = preMealBloodSugar;
        this.targetBloodSugar = targetBloodSugar;
        this.personalSensitivity = personalSensitivity;
    }

    public ServiceCall(String wsdl, int method,int physicalActivityLevel, List<Integer> physicalActivitySamples, List<Integer> bloodSugarDropSamples)
    {
        this.wsdl = wsdl;
        this.method = method;
        this.physicalActivityLevel = physicalActivityLevel;
        this.physicalActivitySamples = physicalActivitySamples;
        this.bloodSugarDropSamples = bloodSugarDropSamples;
    }

    public ServiceCall(String wsdl, int method,int carbohydrateAmount, int carbohydrateToInsulinRatio, int preMealBloodSugar, int targetBloodSugar,
                       int physicalActivityLevel, List<Integer> physicalActivitySamples, List<Integer> bloodSugarDropSamples){
        this.wsdl = wsdl;
        this.method = method;
        this.carbohydrateAmount = carbohydrateAmount;
        this.carbohydrateToInsulinRatio = carbohydrateToInsulinRatio;
        this.preMealBloodSugar = preMealBloodSugar;
        this.targetBloodSugar = targetBloodSugar;
        this.physicalActivityLevel = physicalActivityLevel;
        this.physicalActivitySamples = physicalActivitySamples;
        this.bloodSugarDropSamples = bloodSugarDropSamples;
    }

    public ServiceCall(String wsdl, int method,int carbohydrateAmount, int carbohydrateToInsulinRatio, int preMealBloodSugar, int targetBloodSugar,
                       int physicalActivityLevel, List<Integer> physicalActivitySamples, List<Integer> bloodSugarDropSamples, int personalResult){
        this.wsdl = wsdl;
        this.method = method;
        this.carbohydrateAmount = carbohydrateAmount;
        this.carbohydrateToInsulinRatio = carbohydrateToInsulinRatio;
        this.preMealBloodSugar = preMealBloodSugar;
        this.targetBloodSugar = targetBloodSugar;
        this.physicalActivityLevel = physicalActivityLevel;
        this.physicalActivitySamples = physicalActivitySamples;
        this.bloodSugarDropSamples = bloodSugarDropSamples;
        this.personalResult = personalResult;
    }



    @Override
    public Double call() throws Exception
    {
        //Parse the url string
        String[] tokens = wsdl.split("/");
        String[] moreTokens = null;

        if(tokens.length == 6){
            moreTokens = tokens[5].split("\\?");
        }
        if(tokens.length == 5){
            moreTokens = tokens[4].split("\\?");
        }


        String serviceName = moreTokens[0] + "Service";
        String nameSpaceURL = "";

        if(serviceName.compareTo("InsulinaService") == 0) {
            nameSpaceURL = "http://example/";
        }
        else{
            nameSpaceURL = "http://server/";
        }
        Insulina service = (Insulina) new InsulinaService(new URL(wsdl), new QName(nameSpaceURL, serviceName), moreTokens[0]).getInsulinaPort();
        ((BindingProvider)service).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT,1500);             //the final response shall be no more than 4 seconds.

        try
        {
            if(method==1)
                return (double)service.backgroundInsulinDose(bodyWeight);
            else if(method==2)
                return (double)service.mealtimeInsulinDose(carbohydrateAmount, carbohydrateToInsulinRatio, preMealBloodSugar, targetBloodSugar, personalSensitivity);
            else if(method==3){
                return (double)service.personalSensitivityToInsulin(physicalActivityLevel, physicalActivitySamples, bloodSugarDropSamples);
            }
            else if(method==4){
                return (double)service.mealtimeInsulinDose(carbohydrateAmount, carbohydrateToInsulinRatio, preMealBloodSugar, targetBloodSugar, this.personalResult);
            }



        }catch (WebServiceException wse)
        {
            return -1.0;
        }
        return -1.0;
    }
}