package example;



public interface VoterState_I
{
    public void callServices(Voter v, int method);
    public int compare(Voter v);
    public void changeState(Voter v, VoterState vs);
}
