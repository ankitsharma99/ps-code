package fifthquestion;

public class SpringBufferThread extends Thread{
    private StringBuffer sBuff;
    private String str;
    SpringBufferThread (StringBuffer sBuff, String str) {
        this.sBuff = sBuff;
        this.str = str;
    }

    @Override
    public void run() {
        sBuff.append(str);
    }
}
