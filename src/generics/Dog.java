package generics;

public class Dog<T extends Animal> extends Animal implements Activity<T> {

    @Override
    public void sound(T obj) {
        System.out.println("Bhaw Bhaw");
    }
}
