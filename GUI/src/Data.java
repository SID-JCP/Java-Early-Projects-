import javafx.stage.Stage;

public class Data implements Runnable {

    Thread thread = new Thread(this);
    VariableClass var;

    int a = 0;

    Data(VariableClass variableClass)
    {
        this.var = variableClass;
    }


    public void start(){
        thread.start();
    }

    @Override
    public void run() {
        while (thread.isAlive()){



            System.out.println("this is mouse pointer by slow thread: " );
            ChangeNum(a);
            a++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void ChangeNum(int number){
        var.SetNum2(number);
    }


}

