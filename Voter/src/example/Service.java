package example;


public class Service
{
    private int index;
    private String wsdl;
    private boolean timeout;
    private boolean disagree;

    public Service(int index, String wsdl, boolean timeout, boolean disagree) {
        this.index = index;
        this.wsdl = wsdl;
        this.timeout = timeout;
        this.disagree = disagree;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public boolean isTimeout() {
        return timeout;
    }

    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }

    public boolean isDisagree() {
        return disagree;
    }

    public void setDisagree(boolean disagree) {
        this.disagree = disagree;
    }
}
