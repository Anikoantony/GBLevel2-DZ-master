package DZ2_1_Generic;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit, V extends Fruit> {

    /*
   3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
    */

    ArrayList<T> Box1= new ArrayList<>();
    ArrayList<V> Box2 = new ArrayList<>();
    T fruit1;
    V fruit2;

    public Box(T fruit1, V fruit2) {
        Box1.add(fruit1);
        Box2.add(fruit2);
        this.fruit1=fruit1;
        this.fruit2 = fruit2;
    }

    public ArrayList<T> getBox1() {
        return Box1;
    }

    public ArrayList<V> getBox2() {
        return Box2;
    }
   // g. Не забываем про метод добавления фрукта в коробку.
    public void setFruit1(T fruit1) {
        Box1.add(fruit1);
        this.fruit1 = fruit1;
    }
//g. Не забываем про метод добавления фрукта в коробку.
    public void setFruit2(V fruit2) {
        Box2.add(fruit2);
        this.fruit2 = fruit2;
    }
    // d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    public void getWeightBox()
    {
        System.out.println("\nВес 1-ой коробки: " + Box1.size()*fruit1.getWaight());
        System.out.println("\nВес 2-ой коробки: " + Box2.size()*fruit2.getWaight());
    }

}
