package DZ_1_Interface;
//@FunctionalInterface
public interface Jumpable {
    default void jump()
    {
        System.out.println("Прыгает");
    };
    default void jump2()
    {
        System.out.println("Прыгает");
    };
}
