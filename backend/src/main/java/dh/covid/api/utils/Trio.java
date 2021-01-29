package dh.covid.api.utils;

public class Trio<T, U, V> {
    public final T t;
    public final U u;
    public final V v;

    public Trio(T t, U u, V v) {
        this.t= t;
        this.u= u;
        this.v = v;
    }
}