package voter;

import java.util.List;

/**
 * Created by xaviersilva on 09/05/17.
 */
public class PersonalBackup {
    protected int carbsInMeal;
    protected int carbsRatio;
    protected int bloodSugarLevel;
    protected int targetBloodSugar;
    protected int physicalAct;
    protected List<Integer> physicalSamples;
    protected List<Integer> bloodSamples;

    public PersonalBackup(int carbsInMeal, int carbsRatio, int bloodSugarLevel, int targetBloodSugar, int physicalAct, List<Integer> physicalSamples, List<Integer> bloodSamples) {
        this.carbsInMeal = carbsInMeal;
        this.carbsRatio = carbsRatio;
        this.bloodSugarLevel = bloodSugarLevel;
        this.targetBloodSugar = targetBloodSugar;
        this.physicalAct = physicalAct;
        this.physicalSamples = physicalSamples;
        this.bloodSamples = bloodSamples;
    }

    public int getCarbsInMeal() {
        return carbsInMeal;
    }

    public void setCarbsInMeal(int carbsInMeal) {
        this.carbsInMeal = carbsInMeal;
    }

    public int getCarbsRatio() {
        return carbsRatio;
    }

    public void setCarbsRatio(int carbsRatio) {
        this.carbsRatio = carbsRatio;
    }

    public int getBloodSugarLevel() {
        return bloodSugarLevel;
    }

    public void setBloodSugarLevel(int bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }

    public int getTargetBloodSugar() {
        return targetBloodSugar;
    }

    public void setTargetBloodSugar(int targetBloodSugar) {
        this.targetBloodSugar = targetBloodSugar;
    }

    public int getPhysicalAct() {
        return physicalAct;
    }

    public void setPhysicalAct(int physicalAct) {
        this.physicalAct = physicalAct;
    }

    public List<Integer> getPhysicalSamples() {
        return physicalSamples;
    }

    public void setPhysicalSamples(List<Integer> physicalSamples) {
        this.physicalSamples = physicalSamples;
    }

    public List<Integer> getBloodSamples() {
        return bloodSamples;
    }

    public void setBloodSamples(List<Integer> bloodSamples) {
        this.bloodSamples = bloodSamples;
    }
}
