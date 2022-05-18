package CW_2_Exceptions;

public class FactorialException extends IllegalArgumentException {
    int n;
    String mess;

    public FactorialException(int n, String mess) {
        this.n = n;
        this.mess = mess;
    }
}
