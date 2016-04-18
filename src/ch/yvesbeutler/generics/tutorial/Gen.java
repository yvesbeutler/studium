package ch.yvesbeutler.generics.tutorial;

public class Gen<T extends Object> {

    private T value;
    private T next;
    private T before;

    public T getValue() {
        return value;
    }

}
