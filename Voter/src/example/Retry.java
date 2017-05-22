package example;

import voter.BackgroundBackup;
import voter.PersonalBackup;
import voter.StandardBackup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Retry extends VoterState {

    private static final int servicesUsed=5;
    private static final String[] services = {"http://10.17.1.12:8080/services/Insulina?wsdl", "http://10.17.1.12:8080/services/Insulina?wsdl", "http://10.17.1.13:8080/InsulinDoseCalculator_WebService_QCS/services/InsulinDoseCalculator?wsdl", "http://10.17.1.13:8080/InsulinDoseCalculator_WebService_QCS/services/InsulinDoseCalculator?wsdl", "http://10.17.1.12:8080/services/Insulina?wsdl"};
    private int method;
    private long startTime;
    private ArrayList<Double> results;
    protected WriteFile fileWriter;
    private BackgroundBackup backgroundBackup;
    private PersonalBackup personalBackup;
    private StandardBackup standardBackup;

    public Retry(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, StandardBackup standardBackup)
    {
        super();
        System.out.println("Retry.");
        this.method = method;
        this.startTime = startTime;
        this.results=results;
        this.standardBackup = standardBackup;
        this.fileWriter = fileWriter;
        this.fileWriter.setnVersions(servicesUsed);
        if(((System.nanoTime()-startTime)/1000000000)>=4)           //the final response shall be no more than 4 seconds.
            changeState(v, new End(v, -1.0,fileWriter));
        callServices(v,method);
    }

    public Retry(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, PersonalBackup personalBackup)
    {
        super();
        System.out.println("Retry.");
        this.method = method;
        this.startTime = startTime;
        this.results=results;
        this.personalBackup = personalBackup;
        this.fileWriter = fileWriter;
        this.fileWriter.setnVersions(servicesUsed);
        if(((System.nanoTime()-startTime)/1000000000)>=4)           //the final response shall be no more than 4 seconds.
            changeState(v, new End(v, -1.0,fileWriter));
        callServices(v,method);
    }

    public Retry(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, BackgroundBackup backgroundBackup)
    {
        super();
        System.out.println("Retry.");
        this.method = method;
        this.startTime = startTime;
        this.results=results;
        this.backgroundBackup = backgroundBackup;
        this.fileWriter = fileWriter;
        this.fileWriter.setnVersions(servicesUsed);
        if(((System.nanoTime()-startTime)/1000000000)>=4)           //the final response shall be no more than 4 seconds.
            changeState(v, new End(v, -1.0,fileWriter));
        callServices(v,method);
    }


    public Retry(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter)
    {
        super();
        System.out.println("Retry.");
        this.method = method;
        this.startTime = startTime;
        this.results=results;
        if(((System.nanoTime()-startTime)/1000000000)>=4)           //the final response shall be no more than 4 seconds.
            changeState(v, new End(v, -1.0,fileWriter));
        callServices(v,method);
    }


    @Override
    public void callServices(Voter v, int method)
    {
        ExecutorService executor = Executors.newFixedThreadPool(servicesUsed);
        Set<Future<Double>> futures = new HashSet<>();
        Future<Double> f;
        for (int i=3; i < servicesUsed; i++)
        {
            if(method==1)
            {
                f = executor.submit(new ServiceCall(services[i],method,backgroundBackup.getWeight()));
                futures.add(f);
            }
            else if(method==2)
            {
                f = executor.submit(new ServiceCall(services[i],method,this.standardBackup.getCarbsInMeal(), this.standardBackup.getCarbsRatio(),
                        this.standardBackup.getBloodSugarLevel(), this.standardBackup.getTargetBloodSugar(), this.standardBackup.getIndSens()));
                futures.add(f);
            }
            else if(method == 3)
            {
                f = executor.submit(new ServiceCall(services[i],method,this.personalBackup.getPhysicalAct(),
                        this.personalBackup.getPhysicalSamples(), this.personalBackup.getBloodSamples()));
                futures.add(f);
            }
        }
        for (Future<Double> future : futures)
        {
            try
            {
                results.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        //Conversão para inteiros
        ArrayList<Integer> intResults = new ArrayList<>();
        for(Double d : results){
            intResults.add(d.intValue());
        }

        fileWriter.setVoterValues(intResults);

        if((System.nanoTime()-startTime)/1000000000>=4)                      //the final response shall be no more than 4 seconds.
        {
            changeState(v, new End(v, -1.0,fileWriter));
        }
        else
        {
            if(method == 1){
                changeState(v,new HandleRetry(v,results,method,startTime, fileWriter, this.backgroundBackup));
            }
            else if(method == 2){
                changeState(v,new HandleRetry(v,results,method,startTime, fileWriter, this.standardBackup));
            }
            else if(method == 3){
                changeState(v,new HandleRetry(v,results,method,startTime, fileWriter, this.personalBackup));
            }

        }
    }
}
