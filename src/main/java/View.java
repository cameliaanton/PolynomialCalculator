import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class View extends JFrame {
    JFrame frame = new JFrame("Calculator");
    private JTextField p_userInputPol1= new JTextField(200);
    private JTextField p_userInputPol2= new JTextField(200);
    private JTextField p_userOutputPol3= new JTextField(200);
    private JLabel p_labelPol1= new JLabel("Polinom1");
    private JLabel p_labelTitlu= new JLabel("Calculator Polinomial");
    private JLabel p_labelPol2= new JLabel("Polinom2");
    private JLabel p_labelPol3= new JLabel("Rezultat");
    private JButton p_plusBtn= new JButton("+");
    private JButton p_minusBtn= new JButton("-");
    private JButton p_inumltireBtn= new JButton("*");
    private JButton p_derivareBtn= new JButton("Derivare P1");
    private JButton p_integrareBtn= new JButton("Integrare P1");
    private JButton p_impartireBtn= new JButton("/");
    private JButton p_clearBtn= new JButton("Clear");
    private Model p_model;
    View(Model model)
    {
        p_model=model;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(20,20,330,350);
        JPanel content = new JPanel();
        Font font= p_labelTitlu.getFont();
        p_labelTitlu.setBounds(60,20,50,15);
        p_labelTitlu.setSize(240,70);
        p_labelTitlu.setFont(font.deriveFont(20.0f));

        p_labelPol1.setBounds(30,70,50,15);
        p_labelPol1.setSize(170,30);
        p_userInputPol1.setBounds(100,70,50,15);
        p_userInputPol1.setSize(190,30);

        p_labelPol2.setBounds(30,110,50,15);
        p_labelPol2.setSize(170,30);
        p_userInputPol2.setBounds(100,110,50,15);
        p_userInputPol2.setSize(190,30);

        p_labelPol3.setBounds(30,150,50,15);
        p_labelPol3.setSize(170,30);
        p_userOutputPol3.setBounds(100,150,50,15);
        p_userOutputPol3.setSize(190,30);

        p_plusBtn.setBounds(30,190,20,15);
        p_plusBtn.setSize(50,30);

        p_minusBtn.setBounds(100 ,190, 20, 15);
        p_minusBtn.setSize(50,30);

        p_inumltireBtn.setBounds(170,190,20,15);
        p_inumltireBtn.setSize(50,30);

        p_impartireBtn.setBounds(240,190,20,15);
        p_impartireBtn.setSize(50,30);

        p_derivareBtn.setBounds(30,230,100,15);
        p_derivareBtn.setSize(120,30);

        p_integrareBtn.setBounds(170,230,100,15);
        p_integrareBtn.setSize(120,30);

        p_clearBtn.setBounds(30,270,20,15);
        p_clearBtn.setSize(260,30);

        frame.add(p_labelTitlu);
        frame.add(p_clearBtn);
        frame.add((p_integrareBtn));
        frame.add(p_derivareBtn);
        frame.add(p_impartireBtn);
        frame.add(p_inumltireBtn);
        frame.add(p_minusBtn);
        frame.add(p_plusBtn);
        frame.add(p_labelPol3);
        frame.add(p_labelPol1);
        frame.add(p_labelPol2);
        frame.add(p_userInputPol2);
        frame.add(p_userInputPol1);
        frame.add(p_userOutputPol3);
        frame.add(content);
    }
    String getUserInputPolinom1() {
        return p_userInputPol1.getText();
    }
    String getUserInputPolinom2() {
        return p_userInputPol2.getText();
    }
    void setRezultat(String newRezultat)
    {
        p_userOutputPol3.setText(newRezultat);
    }
    void reset() {
        p_userInputPol1.setText(p_model.INITIAL_VALUE);
        p_userInputPol2.setText(p_model.INITIAL_VALUE);
        p_userOutputPol3.setText(p_model.INITIAL_VALUE);

    }
    void addAdunareListener(ActionListener add)
    {
        p_plusBtn.addActionListener(add);
    }
    void addScadereListener(ActionListener add)
    {
        p_minusBtn.addActionListener(add);
    }
    void addInmultireListener(ActionListener add)
    {
        p_inumltireBtn.addActionListener(add);
    }
    void addImpartireListener(ActionListener add)
    {
        p_impartireBtn.addActionListener(add);
    }
    void addDerivareListener(ActionListener add)
    {
        p_derivareBtn.addActionListener(add);
    }
    void addIntegrareListener(ActionListener add)
    {
        p_integrareBtn.addActionListener(add);
    }
    void addClearListener(ActionListener add)
    {
        p_clearBtn.addActionListener(add);
    }
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
}
