package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xaviersilva on 08/05/17.
 */
public class WriteFile {
    protected String filename;
    protected BufferedWriter out;
    protected int nVersions;
    protected ArrayList<Integer> voterValues;
    protected int majorityResult;


    public WriteFile(String filename) {
        this.filename = filename;
    }

    public int getnVersions() {
        return nVersions;
    }

    public void setnVersions(int nVersions) {
        this.nVersions = nVersions;
    }

    public ArrayList<Integer> getVoterValues() {
        return voterValues;
    }

    public void setVoterValues(ArrayList<Integer> voterValues) {
        this.voterValues = voterValues;
    }

    public int getMajorityResult() {
        return majorityResult;
    }

    public void setMajorityResult(int majorityResult) {
        this.majorityResult = majorityResult;
    }

    public void writeFile() throws IOException {
        try {
            out = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.write(this.getnVersions() + "\n");

        for(int i : this.getVoterValues()){
            out.write(i + "\n");
        }

        out.write(this.getMajorityResult() + "\n");

        out.close();
    }

}
