package example;


import voter.BackgroundBackup;
import voter.PersonalBackup;
import voter.StandardBackup;

public class Voter implements Voter_I
{
    private VoterState vs;

    public Voter(int method, BackgroundBackup backgroundBackup)
    {

        this.vs = new Start(this,method, backgroundBackup);
    }

    public Voter(int method, PersonalBackup personalBackup)
    {
        this.vs = new Start(this,method, personalBackup);
    }

    public Voter(int method, PersonalBackup personalBackup, int result)
    {
        this.vs = new Start(this,method, personalBackup,result);
    }

    public Voter(int method, StandardBackup standardBackup)
    {
        this.vs = new Start(this,method, standardBackup);
    }

    public Voter(int method){
        this.vs = new Start(this,method);
    }

    public void changeState(VoterState vs)
    {
        this.vs = vs;
    }

    public void callServices(){}
    public int compare(){return 0;}
}
