package CW_2_Exceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 5;
            int c = 0;


            String fname = "1.txt";
            try {
                readFile(fname);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                System.out.println(factorial(-5));
            } catch (FactorialException e) {
                System.out.println(e.n);
                System.out.println(e.mess);
                e.printStackTrace();
            }


            try {
                int[] arr = {1, 2};
                // System.out.println("ошибка" + b/c);
                arr[65] = 6;
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("Плохо!Й");
                throw new RuntimeException("Сами вызвали");
            }

        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("другая ошибка");
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("Еще что-то");
        }

        // System.out.println("Приветики");
        System.out.println(sqrt(-6));


    }

    private static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException(" <0" + x);
        }
        return Math.sqrt(x);

    }

    private static int factorial(int n)
    {
        if (n<0)
        {
            throw new FactorialException (n, "Аргумент не должен быть отрицательным");
        }
        int f=1;
        for (int i=1;i<=n;i++)
        {
            f*=i;
        }
        return f;
    }

    private static void readFile(String filename) throws IOException {
        FileInputStream in = new FileInputStream(filename);
        int x;
        while ((x = in.read()) != -1) {
            System.out.print((char) x);
        }


    }
}
