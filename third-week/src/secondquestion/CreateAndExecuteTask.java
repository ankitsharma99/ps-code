package secondquestion;

import java.util.concurrent.Callable;
// create and execute a task
public class CreateAndExecuteTask implements Callable<Integer> {
    public static void main(String[] args) throws Exception {
        CreateAndExecuteTask createAndExecuteTask = new CreateAndExecuteTask();
        int val = createAndExecuteTask.call();
        System.out.println(val);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Task Running");
        return 10;
    }

}
