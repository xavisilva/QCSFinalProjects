package example;


public class DisagreementAfterRetry  extends VoterState
{
    protected WriteFile fileWriter;

    public DisagreementAfterRetry(Voter v, Double result, WriteFile fileWriter)
    {
        System.out.println("DisagreementAfterRetry.");
        changeState(v, new End(v,result,fileWriter));
    }
}
