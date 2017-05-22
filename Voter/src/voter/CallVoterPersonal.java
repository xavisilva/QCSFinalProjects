package voter;

import example.Voter;
import example.Voter_I;

/**
 * Created by xaviersilva on 20/05/17.
 */
public class CallVoterPersonal {
    private int personalInsulinValue;

    public CallVoterPersonal(PersonalBackup personalBackup) {
        Voter_I v = (Voter)new Voter(4, personalBackup);
    }

    public int getPersonalInsulinValue() {
        return personalInsulinValue;
    }

    public void setPersonalInsulinValue(int personalInsulinValue) {
        this.personalInsulinValue = personalInsulinValue;
    }
}
