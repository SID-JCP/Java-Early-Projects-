public class TestOverride extends Methods{
//    Methods method = new Methods();

    @Override
    public void method() {
        System.out.println("This is modified method 1");
    }

    @Override
    public void play() {
        super.play();
        System.out.println("thread is Running");
    }
}
