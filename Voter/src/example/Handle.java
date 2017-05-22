package example;

import voter.BackgroundBackup;
import voter.PersonalBackup;
import voter.StandardBackup;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Handle extends VoterState
{
    private int method;
    private long startTime;
    protected WriteFile fileWriter;
    private BackgroundBackup backgroundBackup;
    private PersonalBackup personalBackup;
    private StandardBackup standardBackup;

    public Handle(Voter v, ArrayList<Double> results, int method, long startTime, WriteFile fileWriter, BackgroundBackup backgroundBackup)
    {
        super();
        System.out.println("Handle.");
        this.fileWriter = fileWriter;
        this.method=method;
        this.startTime = startTime;
        this.backgroundBackup = backgroundBackup;
        compare(v,results);
    }

    public Handle(Voter v, ArrayList<Double> results, int method, long startTime, WriteFile fileWriter, StandardBackup standardBackup)
    {
        super();
        System.out.println("Handle.");
        this.fileWriter = fileWriter;
        this.method=method;
        this.startTime = startTime;
        this.standardBackup = standardBackup;
        compare(v,results);
    }

    public Handle(Voter v, ArrayList<Double> results, int method, long startTime, WriteFile fileWriter, PersonalBackup personalBackup)
    {
        super();
        System.out.println("Handle.");
        this.fileWriter = fileWriter;
        this.method=method;
        this.startTime = startTime;
        this.personalBackup = personalBackup;
        compare(v,results);
    }


    public double compare(Voter v, ArrayList<Double> results)
    {
        if(Collections.frequency(results, -1)==3)                                                                      // timeouts==3 -> no possible calculation, end
        {
            changeState(v, new End(v, -1.0,fileWriter));
            return -1;
        }

        if(Collections.frequency(results, -1)==2)                                                                       // timeouts>=2 -> disagreement by timeout
        {
            if(method == 1){
                changeState(v, new Timeout(v,method,startTime,results,fileWriter, backgroundBackup));
                return -1;
            }
            else if(method == 2){
                changeState(v, new Timeout(v,method,startTime,results,fileWriter, standardBackup));
                return -1;
            }
            else if(method == 3){
                changeState(v, new Timeout(v,method,startTime,results,fileWriter, personalBackup));
                return -1;
            }

        }

        if((abs(results.get(0)-results.get(1))<=1))                          //agreement-> at least service 0 + service 1 or service 2
        {
            if(method == 3){
                changeState(v, new Agreement(v, min(results.get(0),results.get(1)),fileWriter,method,personalBackup));
                return min(results.get(0),results.get(1));
            }
            else{
                changeState(v, new Agreement(v, min(results.get(0),results.get(1)),fileWriter,method));
                return min(results.get(0),results.get(1));
            }

        }
        else if((abs(results.get(0)-results.get(2))<=1)){
            if(method == 3){
                changeState(v, new Agreement(v, min(results.get(0),results.get(2)),fileWriter,method,personalBackup));
                return min(results.get(0),results.get(2));
            }
            else{
                changeState(v, new Agreement(v, min(results.get(0),results.get(2)),fileWriter,method));
                return min(results.get(0),results.get(2));
            }
        }
        else if((abs(results.get(1)-results.get(2))<=1))                                                                //agreeement->at least service 1 + service 2
        {
            if(method == 3){
                changeState(v, new Agreement(v, min(results.get(1),results.get(2)),fileWriter,method,personalBackup));
                return min(results.get(1),results.get(2));
            }
            else{
                changeState(v, new Agreement(v, min(results.get(1),results.get(2)),fileWriter,method));
                return min(results.get(1),results.get(2));
            }
        }
        else                                                                                                             //equal values <=1 -> disagreement by values
        {
            if(method == 1){
                changeState(v, new Disagreement(v,method,startTime,results,fileWriter, backgroundBackup));
                return -1;
            }
            else if(method == 2){
                changeState(v, new Disagreement(v,method,startTime,results,fileWriter, standardBackup));
                return -1;
            }
            else if(method == 3){
                changeState(v, new Disagreement(v,method,startTime,results,fileWriter, personalBackup));
                return -1;
            }

        }
        return -1;
    }
}
