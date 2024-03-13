import java.awt.event.*;
public class Controller {
    private Model p_model;
    private View p_view;
    Controller(Model model,View view)
    {
        p_model=model;
        p_view=view;
        view.addAdunareListener(new AdunareListener());
        view.addScadereListener(new ScadereListener());
        view.addInmultireListener(new InmultireListener());
        view.addImpartireListener(new ImpartireListener());
        view.addDerivareListener(new DerivareListener());
        view.addIntegrareListener(new IntegrareListener());
        view.addClearListener(new ClearListener());
    }
    class AdunareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
               Polinom p1 = new Polinom(p_view.getUserInputPolinom1());
               Polinom p2 = new Polinom (p_view.getUserInputPolinom2());
               p_model.adunareBy(p1,p2);
               p_view.setRezultat(p_model.getValue());

            } catch (BadInputExeption nfex) {
                p_view.showError("Bad input");
            }
        }
    }//end inner class AdunareListener
    class ScadereListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Polinom p1 = new Polinom(p_view.getUserInputPolinom1());
                Polinom p2 = new Polinom (p_view.getUserInputPolinom2());
                p_model.scadereBy(p1,p2);
                p_view.setRezultat(p_model.getValue());

            } catch (BadInputExeption nfex) {
                p_view.showError("Bad input");

            }
        }
    }//end inner class ScadereListener
    class InmultireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Polinom p1 = new Polinom(p_view.getUserInputPolinom1());
                Polinom p2 = new Polinom(p_view.getUserInputPolinom2());
                p_model.inmultireBy(p1, p2);
                p_view.setRezultat(p_model.getValue());
            } catch (BadInputExeption nfex) {
                p_view.showError("Bad input");
            } catch (ImpartireException nfex) {
                p_view.showError("Polinomul 2 are gradul mai mare decat primul");
            }
        }
    }//end inner class InmultireListener
    class ImpartireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Polinom p1 = new Polinom(p_view.getUserInputPolinom1());
                Polinom p2 = new Polinom (p_view.getUserInputPolinom2());
                if(p_view.getUserInputPolinom2().equals("0"))
                    p_view.showError("Bad Input");
                else
                    p_model.impartireBy(p1,p2);
                p_view.setRezultat(p_model.getValue());

            } catch (BadInputExeption nfex) {
                p_view.showError("Bad input");
            }
            catch (ImpartireException nfex)
            {
                p_view.setRezultat(p_model.getValue());
                p_view.showError("EROARE!! Polinomul2 are gradul mai mare decat Polinomul1");
            }
        }
    }//end inner class ImpartireListener
    class DerivareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Polinom p1 = new Polinom(p_view.getUserInputPolinom1());
                p_model.derivareBy(p1);
                p_view.setRezultat(p_model.getValue());

            } catch (BadInputExeption nfex) {
                p_view.showError("Bad input");
            }
        }
    }//end inner class DerivareListener
    class IntegrareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Polinom p1 = new Polinom(p_view.getUserInputPolinom1());
                p_model.integrareBy(p1);
                p_view.setRezultat(p_model.getValue());

            } catch (BadInputExeption nfex) {
                p_view.showError("Bad input");
            }
        }
    }//end inner class IntegrareListener
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            p_model.reset();
            p_view.reset();
        }
    }// end inner class ClearListener
}
