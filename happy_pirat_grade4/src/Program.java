import controller.Controller;
import model.Registry;
import view.Console;
import view.IView;

public class Program {
    public static void main(String[] a_args) {

        Controller m = new Controller();
        Registry d = new Registry();
        String a = "";
        IView v = new Console();

        m.Show(v, d, a);

    }
}