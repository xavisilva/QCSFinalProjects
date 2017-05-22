package example;


import voter.BackgroundBackup;
import voter.PersonalBackup;
import voter.StandardBackup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class Start extends VoterState {

    private static final int servicesUsed=3;
    private static final String[] services = {"http://10.17.1.12:8080/services/Insulina?wsdl", "http://10.17.1.12:8080/services/Insulina?wsdl", "http://10.17.1.13:8080/InsulinDoseCalculator_WebService_QCS/services/InsulinDoseCalculator?wsdl", "http://10.17.1.13:8080/InsulinDoseCalculator_WebService_QCS/services/InsulinDoseCalculator?wsdl", "http://10.17.1.12:8080/services/Insulina?wsdl"};
    private int method;
    private long startTime;
    WriteFile fileWriter = new WriteFile("/Users/xaviersilva/Desktop/out.txt");
    private BackgroundBackup backgroundBackup;
    private PersonalBackup personalBackup;
    private StandardBackup standardBackup;
    private int personalResult;

    public Start(Voter v, int method){
        super();
        System.out.println("Start.");
        this.method = method;
        this.startTime = System.nanoTime();
        fileWriter.setnVersions(servicesUsed);
        callServices(v,method);
    }


    public Start(Voter v,int method,BackgroundBackup backgroundBackup)
    {
        super();
        System.out.println("Start.");
        this.backgroundBackup = backgroundBackup;
        this.method = method;
        this.startTime = System.nanoTime();
        fileWriter.setnVersions(servicesUsed);
        callServices(v,method);
    }

    public Start(Voter v, int method, PersonalBackup personalBackup)
    {
        super();
        System.out.println("Start.");
        this.personalBackup = personalBackup;
        this.method = method;
        this.startTime = System.nanoTime();
        fileWriter.setnVersions(servicesUsed);
        callServices(v,method);
    }

    public Start(Voter v, int method, StandardBackup standardBackup)
    {
        super();
        System.out.println("Start.");
        this.standardBackup = standardBackup;
        this.method = method;
        this.startTime = System.nanoTime();
        fileWriter.setnVersions(servicesUsed);
        callServices(v,method);
    }

    public Start(Voter v, int method, PersonalBackup personalBackup, int result)
    {
        super();
        System.out.println("Start.");
        this.personalBackup = personalBackup;
        this.method = method;
        this.startTime = System.nanoTime();
        this.personalResult = result;
        fileWriter.setnVersions(servicesUsed);
        callServices(v,method);
    }


    @Override
    public void callServices(Voter v,int method)
    {
        ExecutorService executor = Executors.newFixedThreadPool(servicesUsed);
        Set<Future<Double>> futures = new HashSet<>();
        Future<Double> f;
        ArrayList<Double> results = new ArrayList<>();
        for (int i=0; i < servicesUsed; i++)
        {
            if(method==1)
            {
                f = executor.submit(new ServiceCall(services[i],method,this.backgroundBackup.getWeight()));
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
                f = executor.submit(new ServiceCall(services[i],method,this.personalBackup.getCarbsInMeal(), this.personalBackup.getCarbsRatio(),
                        this.personalBackup.getBloodSugarLevel(), this.personalBackup.getTargetBloodSugar(), this.personalBackup.getPhysicalAct(),
                        this.personalBackup.getPhysicalSamples(), this.personalBackup.getBloodSamples()));
                futures.add(f);

            }
            else if(method == 4){
                f = executor.submit(new ServiceCall(services[i],method,this.personalBackup.getCarbsInMeal(), this.personalBackup.getCarbsRatio(),
                        this.personalBackup.getBloodSugarLevel(), this.personalBackup.getTargetBloodSugar(), this.personalBackup.getPhysicalAct(),
                        this.personalBackup.getPhysicalSamples(), this.personalBackup.getBloodSamples(), this.personalResult));
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


        if(method == 1){
            changeState(v, new Handle(v, results, method, startTime, fileWriter, backgroundBackup));
        }
        else if(method == 2){
            changeState(v, new Handle(v, results, method, startTime, fileWriter, standardBackup));
        }
        else if(method == 3){
            changeState(v, new Handle(v, results, method, startTime, fileWriter, personalBackup));
        }
        else if(method == 4){
            changeState(v, new Handle(v, results, method, startTime, fileWriter, personalBackup));
        }

    }
}
