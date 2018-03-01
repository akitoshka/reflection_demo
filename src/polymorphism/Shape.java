package polymorphism;

public abstract class Shape {
    public void draw(){
        System.out.println(this+".draw()");
    }

    abstract public String toString();
}
