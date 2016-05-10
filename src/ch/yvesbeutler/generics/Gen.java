package ch.yvesbeutler.generics;

/**
 * @author yvesbeutler
 * This simple class shows the functionallity of generics with animals.
 */
public class Gen<T> {

    private T value;

    public void print() {
        if (value != null) {
            System.out.println("Type: " + value.getClass().getSimpleName());
        } else {
            System.out.println("Type: null");
        }
    }

    public Gen() {}

    public Gen(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
