package DZ2_1_Generic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Work <T> {

    private T[] mas=null;

    public T[] getMas() {
        return mas;
    }

    public ArrayList<T> getMasAsList()
    {
        ArrayList<T> Al = null;
        return Al;

    }

    public Work(T... mas) {
        this.mas = mas;
    }
    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public T[] masCh (int a, int b)
    {
        T[] masChange = this.mas;
        T c= masChange[a];
        masChange[a]=masChange[b];
        masChange[b]=c;
        intoArrayList(masChange);
        this.mas = masChange;
        return masChange;

    }

    public void showEl()
    {
        intoArrayList(this.mas);
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    private void intoArrayList(T... m)
    {
        for (T s:Arrays.asList(m)
        ) { System.out.print (s + "; ");  };
    }
}
