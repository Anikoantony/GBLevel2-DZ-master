package DZ_2_Exception;

public class MyFormatException extends NumberFormatException {

    public MyFormatException(int i, int j, String simv, String mess) {
        this.i = i;
        this.j = j;
        this.simv = simv;
        this.mess = mess;
    }

    int i;
    int j;
    String simv;
    String mess;



}
