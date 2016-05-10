package ch.yvesbeutler.generics;

/**
 * Just a simple example to demonstrate how generics work.
 *
 * @author yvesbeutler
 * @since 11.03.2016
 */
public class GenericSample {

    public static void main(String[] args) {

        // create string instance
        SimpleGeneric<String> gen1 = new SimpleGeneric<>("Hello World");
        gen1.print();

        // create integer instance
        SimpleGeneric<Integer> gen2 = new SimpleGeneric<>(42);
        gen2.print();

        // create instance with itself
        SimpleGeneric<SimpleGeneric> gen3 = new SimpleGeneric<>(new SimpleGeneric(false));
        gen3.print();
    }
}

class SimpleGeneric<T> {

    private T type = null;

    public SimpleGeneric(T param) {
        type = param;
    }

    public T getType() {
        return type;
    }

    public void print() {
        System.out.println("Type is " + type.getClass().getName());
    }
}