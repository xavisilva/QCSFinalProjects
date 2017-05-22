package example;

import voter.BackgroundBackup;
import voter.PersonalBackup;

public class Agreement  extends VoterState {

    protected WriteFile fileWriter;
    protected int method;
    protected PersonalBackup personalBackup;

    public Agreement(Voter v, Double result, WriteFile fileWriter)
    {
        System.out.println("Agreement.");
        changeState(v, new End(v, result,fileWriter));
    }

    public Agreement(Voter v, Double result, WriteFile fileWriter, int method)
    {
        System.out.println("Agreement.");
        changeState(v, new End(v, result,fileWriter,method));
    }

    public Agreement(Voter v, Double result, WriteFile fileWriter, int method, PersonalBackup personalBackup)
    {
        System.out.println("Agreement.");
        changeState(v, new End(v, result,fileWriter,method,personalBackup));
    }
}
