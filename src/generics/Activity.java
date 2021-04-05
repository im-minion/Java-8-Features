package generics;

public interface Activity<T extends Animal> {
    void sound(T obj);
}
