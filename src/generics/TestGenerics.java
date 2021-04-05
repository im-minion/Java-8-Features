package generics;

public class TestGenerics {
    public static void main(String[] args) {
        Dog<Animal> dog = new Dog<>();
        dog.sound(dog);

        Activity<Dog<Animal>> activity = new Dog<>();
        activity.sound(new Dog<>());

        Lion<Animal> lion = new Lion<>();
        lion.sound(new Lion<>());

        Activity<Lion<Animal>> activity2 = new Lion<>();
        activity2.sound(new Lion<>());
    }
}
