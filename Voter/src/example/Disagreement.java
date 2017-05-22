package example;


import voter.BackgroundBackup;
import voter.PersonalBackup;
import voter.StandardBackup;

import java.util.ArrayList;

public class Disagreement  extends VoterState
{
    protected WriteFile fileWriter;
    private BackgroundBackup backgroundBackup;
    private PersonalBackup personalBackup;
    private StandardBackup standardBackup;


    public Disagreement(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, BackgroundBackup backgroundBackup)
    {
        System.out.println("Disagreement.");
        changeState(v, new Retry(v,method,startTime,results,fileWriter, backgroundBackup));
    }

    public Disagreement(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, StandardBackup standardBackupp)
    {
        System.out.println("Disagreement.");
        changeState(v, new Retry(v,method,startTime,results,fileWriter, standardBackupp));
    }

    public Disagreement(Voter v, int method, long startTime, ArrayList<Double> results, WriteFile fileWriter, PersonalBackup personalBackup)
    {
        System.out.println("Disagreement.");
        changeState(v, new Retry(v,method,startTime,results,fileWriter, personalBackup));
    }

}
