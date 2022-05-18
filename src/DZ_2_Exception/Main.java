package DZ_2_Exception;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
*/

public class Main {
    public static void main(String[] args) {

        String[][] ccc = {{"5","2","1","2"},{"5","2","3","2"},{"5","1","1","2"}};
        String[][] aaa = {{"5","2","1","2"},{"5","2","3","2"},{"5","1","1"},{"1","2","1","8"}};
        String[][] bbb = {{"5","2","1","2"},{"5","2","3","2"},{"5","1","gfdgd","2"},{"1","2","1","8"}};

        try
        {
            newMassChekSize (bbb);
        }
        catch (MyArraySizeException e )
        {
            e.printStackTrace();
            System.out.print(e.mess);
            System.out.print(e.n);
        }

        try {
            preobrazNewMass(bbb);
        } catch (MyFormatException e) {
            e.printStackTrace();
            System.out.println(e.mess);
          //  System.out.println(e.i);
        }

        // newMass (bbb);
        // newMass (ccc);

    }
// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

    public static void newMassChekSize (String[][] mass) throws RuntimeException
    {
        if (mass.length !=4)  {
            throw new MyArraySizeException(mass.length, "Неверная размерность, т.к. строк не 4 а: ");
           // System.out.println("Неверная размерность 1!");
        }

        for (int i=0; i<4; i++)
        { if (mass [i].length!=4)
        { throw new MyArraySizeException(mass[i].length, "Неверная размерность, т.к. в одной из строк столбцов всего: ");
        // System.out.println("Неверная размерность 2!");
        }
        }
    }

// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

    public static int preobrazNewMass (String[][] mass) throws RuntimeException
    {
        int sum=0;

        for (int i=0; i<4; i++)
        {
            for (int j=0; j<4; j++)
           {

               if (chekInteger(mass[i][j])==false)
               {
                   throw new MyFormatException(i,j,mass[i][j],"Нельзя преобразовать значение " + mass[i][j] + " в строке " + (int)(i+1) + " и в столбце " + (int)(j+1));
               }
                sum+=(Integer.parseInt(mass[i][j])) ;

               }

               System.out.println(sum);
            }


        return sum;
    }

    public static boolean chekInteger(String s)
    {
        //boolean bul=true;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    };


}
