package DZ_5_Threads;

/*
1) Создают одномерный длинный массив, например:

static final int size = 10000000;
static final int h = size / 2;
        float[] arr = new float[size];

        2) Заполняют этот массив единицами;
        3) Засекают время выполнения: long a = System.currentTimeMillis();
        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        5) Проверяется время окончания метода System.currentTimeMillis();
        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);

        Отличие первого метода от второго:
        Первый просто бежит по массиву и вычисляет значения.
        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

        Пример деления одного массива на два:

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Пример обратной склейки:

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        Примечание:
        System.arraycopy() – копирует данные из одного массива в другой:
        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
        По замерам времени:
        Для первого метода надо считать время только на цикл расчета:

        for (int i = 0; i < size; i++) {
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
*/
public class Main {

    public static void main(String[] args) {

        Mass mas = new Mass(10000000);

       // расчет по 1-му заданию и заполнение массива единицами и расклейка массива на 2:
        mas.mass_add();

        // расчет по 2-му задаиню
        long start = System.currentTimeMillis();
        long time = 0;

         mas.razkleika();

        // старт 1-ого и 2-ого потока через новый Runnable класс:

       /* Thread t1 = new Thread(new Calc_thread(mas, mas.getA1(), 0,"Поток 1"));
        Thread t2 = new Thread(new Calc_thread(mas, mas.getA2(), 1, "Поток 2"));
        t1.start();
        t2.start();
        // завершение работы в 2-х потоках
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        float[] a1 = mas.getA1();
        float[] a2 = mas.getA2();
        Thread t1 = new Thread(()->{
                       for (int i = 0; i < a1.length ; i++) {
               a1[i] = (float)(i * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }});

        Thread t2 = new Thread(()->{
                       int h=mas.getH();
            for (int i = 0; i < a2.length ; i++) {
                a2[i] = (float)((h+i) * Math.sin(0.2f + (h+i) / 5) * Math.cos(0.2f + (h+i) / 5) * Math.cos(0.4f + (h+i) / 2));
            }});

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("Значение до склейки в 1-ом массиве: " + a1[1]);
            System.out.println("Значение до склейки в 2-ом массиве: " + a2[1]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            mas.skleika(a1,a2);
        }

     /*   System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);*/

        time = System.currentTimeMillis() - start;
        System.out.println("Время заполнения массива новыми значениями в потоках " + time);
        mas.getRndZnack();

    }
}
