package DZ_2_Exception;

public class MyArraySizeException extends IllegalArgumentException{
    int n;
    String mess;

    public MyArraySizeException(int n, String mess) {
      //  super(message, cause);
        this.n = n;
        this.mess = mess;
    }
}
