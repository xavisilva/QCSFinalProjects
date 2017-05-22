package voter;

/**
 * Created by xaviersilva on 09/05/17.
 */
public class StandardBackup {
    protected int carbsInMeal;
    protected int carbsRatio;
    protected int bloodSugarLevel;
    protected int targetBloodSugar;
    protected int indSens;

    public StandardBackup(int carbsInMeal, int carbsRatio, int bloodSugarLevel, int targetBloodSugar, int indSens) {
        this.carbsInMeal = carbsInMeal;
        this.carbsRatio = carbsRatio;
        this.bloodSugarLevel = bloodSugarLevel;
        this.targetBloodSugar = targetBloodSugar;
        this.indSens = indSens;
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

    public int getIndSens() {
        return indSens;
    }

    public void setIndSens(int indSens) {
        this.indSens = indSens;
    }
}
