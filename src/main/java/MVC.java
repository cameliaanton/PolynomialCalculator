import java.util.*;

public class MVC {
    public static void main(String [] args)
    {
        Model model = new Model();
        View view = new View(model);
        Controller corntroller = new Controller(model,view);
    }
}
