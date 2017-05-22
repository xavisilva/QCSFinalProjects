package example;

import voter.BackgroundBackup;
import voter.PersonalBackup;
import voter.StandardBackup;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class HandleRetry extends VoterState
{
    private int method;
    private long startTime;
    protected WriteFile fileWriter;
    private BackgroundBackup backgroundBackup;
    private PersonalBackup personalBackup;
    private StandardBackup standardBackup;

    public HandleRetry(Voter v, ArrayList<Double> results, int method, long startTime,WriteFile fileWriter, BackgroundBackup backgroundBackup)
    {
        super();
        System.out.println("HandleRetry.");
        this.method=method;
        this.startTime = startTime;
        this.backgroundBackup = backgroundBackup;
        this.fileWriter = fileWriter;
        compare(v,results);
    }

    public HandleRetry(Voter v, ArrayList<Double> results, int method, long startTime,WriteFile fileWriter, StandardBackup standardBackup)
    {
        super();
        System.out.println("HandleRetry.");
        this.method=method;
        this.startTime = startTime;
        this.standardBackup = standardBackup;
        this.fileWriter = fileWriter;

        compare(v,results);
    }

    public HandleRetry(Voter v, ArrayList<Double> results, int method, long startTime,WriteFile fileWriter, PersonalBackup personalBackup)
    {
        super();
        System.out.println("HandleRetry.");
        this.method=method;
        this.startTime = startTime;
        this.personalBackup = personalBackup;
        this.fileWriter = fileWriter;

        compare(v,results);
    }

    public HandleRetry(Voter v, ArrayList<Double> results, int method, long startTime)
    {
        super();
        System.out.println("HandleRetry.");
        this.method=method;
        this.startTime = startTime;
        compare(v,results);
    }



    public double compare(Voter v, ArrayList<Double> results)
    {
        if(Collections.frequency(results, -1)>=3)                        // timeouts>=3 -> disagreement by timeout
        {
            changeState(v, new TimeoutAfterRetry(v, -1.0,fileWriter));
            return -1;
        }
        if(abs(results.get((3)) - results.get(4)) <= 1)                          //2 services called in retry equals
        {
            if((abs(results.get(3) - results.get(0))<=1) && (abs(results.get(4) - results.get(0))<=1))                        //agreement-> at least services 0-3-4
            {
                changeState(v, new Agreement(v, min(results.get(0),results.get(3)),fileWriter));
                return min(results.get(0),results.get(3));
            }
            else if(abs(results.get(3) - results.get(1))<=1 && abs(results.get(4) - results.get(1))<=1)                   //agreement-> at least services 1-3-4
            {
                changeState(v, new Agreement(v, min(results.get(1),results.get(3)),fileWriter));
                return min(results.get(1),results.get(3));
            }
            else if(abs(results.get(3) - results.get(2))<=1 && abs(results.get(4) - results.get(2))<=1)                   //agreement-> at least services 2-3-4
            {
                changeState(v, new Agreement(v, min(results.get(2),results.get(3)),fileWriter));
                return min(results.get(2),results.get(3));
            }
            else                                                        //equal values <=2 -> disagreement by values
            {
                changeState(v, new DisagreementAfterRetry(v, -1.0,fileWriter));
                return -1;
            }
        }
        else                                                            //equal values <=2 -> disagreement by values
        {
            changeState(v, new DisagreementAfterRetry(v, -1.0,fileWriter));
            return -1;
        }
    }
}
