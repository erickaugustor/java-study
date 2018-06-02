package study.abstractClass;

public class Parrot extends Bird {

    public Parrot(String name){
        super(name);
    }

//    @Override
//    public void fly() {
//        System.out.println("Flying");
//    }

    @Override
    public void eat() {
        System.out.println("Eating");
    }

    @Override
    public void breathe() {
        System.out.println("Flitting from branch to branch");
    }
}
