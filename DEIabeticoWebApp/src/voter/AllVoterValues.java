package voter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xaviersilva on 03/05/17.
 */
public class AllVoterValues {
    public static int numberOfVersions;
    public static ArrayList<String> voterValues = new ArrayList<>();
    public static String majorityResult;

    public AllVoterValues(int numberOfVersions, ArrayList<String> voterValues, String majorityResult) {
        this.numberOfVersions = numberOfVersions;
        this.voterValues = voterValues;
        this.majorityResult = majorityResult;
        readFile();
    }

    public AllVoterValues(){
        readFile();
    }

    public static ArrayList<String> getVoterValues() {
        return voterValues;
    }

    public void setVoterValues(ArrayList<String> voterValues) {
        this.voterValues = voterValues;
    }
    public static int getNumberOfVersions() {
        return numberOfVersions;
    }

    public static void setNumberOfVersions(int numberOfVersions) {
        AllVoterValues.numberOfVersions = numberOfVersions;
    }

    public static String getMajorityResult() {
        return majorityResult;
    }

    public static void setMajorityResult(String majorityResult) {
        AllVoterValues.majorityResult = majorityResult;
    }


    public static void readFile(){

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/xaviersilva/Desktop/out.txt"));
            String nVersions;
            String voterValue;
            String majorityRes;

            nVersions = reader.readLine();
            numberOfVersions = Integer.parseInt(nVersions);
            System.out.println(nVersions);

            for(int i=0 ; i<Integer.parseInt(nVersions) ; i++){
                voterValue = reader.readLine();
                if(voterValue.compareTo("-1") == 0){
                    voterValues.add("Timeout");
                }
                else{
                    voterValues.add(voterValue);
                }

            }

            majorityRes = reader.readLine();

            majorityResult = majorityRes;

            if(majorityResult.compareTo("-1") == 0){
                majorityResult = "It was not possible to calculate the insulin dose. Please try again.";
            }
            else{
                majorityResult = "Your insulin dose is: " + majorityRes;
            }

            reader.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", "/Users/xaviersilva/Desktop/out.txt");
            e.printStackTrace();
        }
    }

    public static void clear(){
        voterValues.clear();
    }
}
