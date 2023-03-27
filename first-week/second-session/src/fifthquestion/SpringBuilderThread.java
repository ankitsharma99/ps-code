package fifthquestion;

public class SpringBuilderThread extends Thread{
    private StringBuilder sBuild;
    private String str;
    SpringBuilderThread (StringBuilder sBuild, String str) {
        this.sBuild = sBuild;
        this.str = str;
    }

    @Override
    public void run () {
        sBuild.append(str);
    }
}
