public class Model {
    private Polinom pRez= new Polinom();
    private Operatii op= new Operatii();
    static final String INITIAL_VALUE="";
    Model()
    {
        reset();
    }
    public void reset()
    {
        pRez.reset();
    }
    public void adunareBy(Polinom p1,Polinom p2)
    {
        pRez= op.adunaPolinoame(p1,p2);
    }
    public void scadereBy(Polinom p1,Polinom p2)
    {
        pRez= op.scadePolinoame(p1,p2);
    }
    public void inmultireBy(Polinom p1,Polinom p2) throws ImpartireException { pRez=op.inmultestePolinoame(p1,p2);}
    public void impartireBy(Polinom p1,Polinom p2) throws ImpartireException {
        pRez = op.impartePolinoame(p1, p2);
    }
    public void derivareBy(Polinom p1)
    {
        pRez=op.derivarePolinoame(p1);
    }
    public void integrareBy(Polinom p1)
    {
        pRez=op.integrarePolinoame(p1);
    }
    public String getValue()
    {
        return pRez.toString();
    }
}
