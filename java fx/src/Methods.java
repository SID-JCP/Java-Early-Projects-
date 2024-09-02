import java.util.Arrays;

public class Methods extends Thread {

    Methods(){
        super();
    }
    public void method(){
        System.out.println("This is method 1");
    }

    public void method2(){
        System.out.println("This is method 2");
    }

    public void play(){
        this.start();
    }

}
