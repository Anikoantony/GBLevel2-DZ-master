package DZ_1_Interface;

public class Cat implements SuperJumpRun {

    @Override
    public void jump2() {

    }

    @Override
    public void run(String name) {
        System.out.println("Кот по имени " + name + " бежит.");

    }
}
