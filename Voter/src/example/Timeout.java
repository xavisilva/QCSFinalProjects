package example;


import voter.BackgroundBackup;
import voter.PersonalBackup;
import voter.StandardBackup;

import java.util.ArrayList;

public class Timeout  extends VoterState
{
    protected WriteFile fileWriter;
    private BackgroundBackup backgroundBackup;
    private PersonalBackup personalBackup;
    private StandardBackup standardBackup;


    public Timeout(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, BackgroundBackup backgroundBackup)
    {
        System.out.println("Timeout.");
        changeState(v, new Retry(v,method,startTime,results,fileWriter,backgroundBackup));
    }

    public Timeout(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, StandardBackup standardBackup)
    {
        System.out.println("Timeout.");
        changeState(v, new Retry(v,method,startTime,results,fileWriter,standardBackup));
    }

    public Timeout(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, PersonalBackup personalBackup)
    {
        System.out.println("Timeout.");
        changeState(v, new Retry(v,method,startTime,results,fileWriter,personalBackup));
    }

}
