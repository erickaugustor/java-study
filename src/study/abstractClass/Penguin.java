package study.abstractClass;

public class Penguin extends Bird {
    public Penguin(String name){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Eating");
    }

    @Override
    public void breathe() {
        System.out.println("Breating");
    }

    @Override
    public void fly(){
        super.fly();
        System.out.println("I'm not very good at that!");
    }
}
