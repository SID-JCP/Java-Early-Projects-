import java.awt.*;

public class ThreadCLass2 implements Runnable{

    Thread thread = new Thread(this);
    VariableClass var;
    int b = 0;


    ThreadCLass2(VariableClass var){
        this.var = var;

    }

    public void start(){
        thread.start();
    }

    @Override
    public void run() {
        while (thread.isAlive()){
            System.out.println("this is mouse pointer by fast thread " + MouseInfo.getPointerInfo().getLocation().distance(100,100));
            ChangeNum();
            b += 2;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public void ChangeNum(){
        var.SetNum(b);
    }
}
