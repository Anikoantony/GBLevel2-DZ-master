package DZ_1_Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
 Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
*/

    public static void main(String[] args) {
        //launch(args);

        Cat cat = new Cat();
        Man man = new Man();
        Robot robot = new Robot();

        Wall wall=new Wall();
        RunRoad runRoad = new RunRoad();
        Prepatstvie[] prepatstvies = {wall, runRoad};
        SuperJumpRun[] superJumpRuns = {cat, man, robot};
        for (SuperJumpRun superJumpRun : superJumpRuns) {
            for (Prepatstvie prepatstvy : prepatstvies) {
                prepatstvy.prepatstvie(superJumpRun);
            }
          }

        for (int i=1;i<=10; i++)
        {
            System.out.println("Hello World!");
            System.out.println("Hello World!");
        }

    }
}
