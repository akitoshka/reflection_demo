package polymorphism;

public class Square extends Shape{

    private String txt="asda";


    @Override
    public String toString() {
        return "Square";
    }


    public void doSmth(){
        System.out.println("do smth");
    }

    private void doSmthHidden(){
        System.out.println("do smth");
    }

    public void printF(String pref, Integer count){
        for (int i = 0; i < count; i++) {
            System.out.println(pref + txt);
        }
    }
}
