package DZ_5_Threads;

public class Calc_thread implements Runnable {
    Mass mass;
    private float[] mas;
 private String name;
 private int index;
    public Calc_thread(float[] mas, String name) {
        this.mas = mas;
        this.name = name;
    }

    public Calc_thread(Mass mass, float[] mas, int index, String name) {
        this.mass = mass;
        this.mas = mas;
        this.name = name;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < mas.length ; i++) {
            mas[i] = (float)(mas[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }


        System.out.println("Завершён подсчет в потоке " + name);
        if (index==0)
        { mass.setA1(mas); } else mass.setA2(mas);
    }
}
