package CW2_1_Generic;

public class Main {

    public static void main(String[] args) {
        Gen<String> strGen = new Gen<>("A");
        System.out.println(strGen.getObj());
        System.out.println(strGen.getObj());
        System.out.println(strGen.getObj());
        System.out.println(strGen.getObj());
        System.out.println(strGen.getObj());
        System.out.println(strGen.getObj());
        System.out.println(strGen.getObj());
        System.out.println(strGen.getObj());
        Gen2<String,Integer> gen2 = new Gen2<>("a",1);
        System.out.println(gen2.getObj1()+gen2.getObj2());
        System.out.println(gen2.getObj1()+gen2.getObj2());
    }
}
