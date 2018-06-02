package study.abstractClass;

public abstract class Bird extends Animal implements CanFly{
    public Bird(String name){
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flapping its wings");
    }
}
