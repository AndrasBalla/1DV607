import controller.Controller;
import model.Registry;
import view.Console;

public class Program {
    public static void main(String[] a_args) {

        Controller m = new Controller();
        Console v = new Console();
        Registry d = new Registry();

        m.Show(v, d);

    }
}