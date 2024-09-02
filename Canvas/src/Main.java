import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;

public class Main {
    public static void main(String[] args){
        SubClass threadedClass = new SubClass();
        SUbClass2 threadedClass2 = new SUbClass2();
        threadedClass.startThread();
        threadedClass2.startThread();

    }

}

class SubClass implements Runnable{

    Thread thread1;

    SubClass(){
        thread1 = new Thread(this);
    }

    public void startThread(){
        thread1.start();
    }

    @Override
    public void run() {
        while (thread1 != null){
            System.out.println("Thread not stopped yet");

            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class SUbClass2 implements Runnable {

    Thread thread2;


    SUbClass2(){
        thread2 = new Thread(this);
    }

    public void startThread(){
        thread2.start();
    }

    @Override
    public void run() {
        while (thread2.isAlive()){
            System.out.println("thread 2 worked also");

            try {
                thread2.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    
}
