package example;


import voter.BackgroundBackup;
import voter.PersonalBackup;

import java.io.IOException;

public class End extends VoterState
{
    private int result;
    protected WriteFile fileWriter;
    private int method;

    public End(Voter v, Double result, WriteFile fileWriter)
    {
        System.out.println("End.");
        this.fileWriter = fileWriter;
        this.result = result.intValue();


        if(result != null){
            this.fileWriter.setMajorityResult(this.result);
        }
        else{
            this.fileWriter.setMajorityResult(-1);
        }

        try {
            fileWriter.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendResult(this.result);
    }

    public End(Voter v, Double result, WriteFile fileWriter, int method)
    {
        System.out.println("End.");
        this.fileWriter = fileWriter;
        this.result = result.intValue();


        if(result != null){
            this.fileWriter.setMajorityResult(this.result);
        }
        else{
            this.fileWriter.setMajorityResult(-1);
        }

        try {
            fileWriter.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendResult(this.result);
    }

    public End(Voter v, Double result, WriteFile fileWriter, int method, PersonalBackup personalBackup)
    {
        System.out.println("End.");
        this.fileWriter = fileWriter;
        this.result = result.intValue();


        if(result != null){
            this.fileWriter.setMajorityResult(this.result);
        }
        else{
            this.fileWriter.setMajorityResult(-1);
        }

        try {
            fileWriter.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendResult(this.result);

        // Se o metodo calculado foi o cálculo pessoal da insulina, chama de seguida o mealtime
        if(method == 3){
            Voter_I voter = (Voter)new Voter(4, personalBackup,this.fileWriter.getMajorityResult());
        }


    }

    public int sendResult(int result)
    {
        return result;
    }
}
