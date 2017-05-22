package example;

public abstract class VoterState implements VoterState_I
{
    public void callServices(Voter v, int method){}
    public int compare(Voter v){return 0;}
    public void changeState(Voter v, VoterState vs)
    {
        v.changeState(vs);
    }
}
