package example;


public class TimeoutAfterRetry  extends VoterState
{
    protected WriteFile fileWriter;

    public TimeoutAfterRetry(Voter v, Double result, WriteFile fileWriter)
    {
        System.out.println("TimeoutAfterRetry.");
        changeState(v, new End(v,result,fileWriter));
    }
}
