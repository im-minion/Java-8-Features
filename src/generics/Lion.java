package generics;

public class Lion<T extends Animal> extends Animal implements Activity<T> {

    @Override
    public void sound(T obj) {
        System.out.println("Roar");
    }
}
