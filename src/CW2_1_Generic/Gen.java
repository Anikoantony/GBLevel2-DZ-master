package CW2_1_Generic;

public class Gen<T> {
  private T obj;

    public T getObj() {
        return obj;
    }

    public Gen(T obj) {
        this.obj = obj;

    }
}
