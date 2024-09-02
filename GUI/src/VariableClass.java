public class VariableClass {

    public static int num;
    public static int num2;
    int MousePointer = 0;



    VariableClass(){
        num = 0;
        num2 = 1;
    }

    public int getMousePointer() {
        return MousePointer;
    }

    public void setMousePointer(int mousePointer) {
        MousePointer = mousePointer;
    }

    public int getNum(){
        return num;
    }

    public int getNum2(){
        return num2;
    }


    public void SetNum(int a){
        num = a;
    }

    public void SetNum2(int a){
        num2 = a;
    }
}
