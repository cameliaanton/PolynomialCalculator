import jdk.dynalink.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    Operatii op = new Operatii();
    @org.junit.Test
    public void TestAdunareOk() throws BadInputExeption {
        Polinom p= new Polinom("x^4+3x^5");
        Polinom p1= new Polinom("x^3-2x^2+9");
        Polinom rezultat= op.adunaPolinoame(p1,p);
        Polinom rezultatAsteptat= new Polinom("3x^5+x^4+x^3-2x^2+9");
        //System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestAdunareNotOk() throws BadInputExeption {
        Polinom p= new Polinom("x^4+3x^5");
        Polinom p1= new Polinom("x^3-2x^2+9");
        Polinom rezultat= op.adunaPolinoame(p1,p);
        Polinom rezultatAsteptat= new Polinom("3x^5+x^4+x^3-2x^2+4");
       // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestScadereOk() throws BadInputExeption {
        Polinom p= new Polinom("x^4+3x^5");
        Polinom p1= new Polinom("+5x^5-x^4+x^3-2x^2+9");
        Polinom rezultat= op.scadePolinoame(p1,p);
        Polinom rezultatAsteptat= new Polinom("2.00x^5 -2.00x^4 +1.00x^3 -2.00x^2 +9.00");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestScadereNotOk() throws BadInputExeption {
        Polinom p= new Polinom("x^4+3x^5");
        Polinom p1= new Polinom("+5x^5-x^4+x^3-2x^2+9");
        Polinom rezultat= op.scadePolinoame(p1,p);
        Polinom rezultatAsteptat= new Polinom("5.20x^5 +2.00x^4 +1.00x^3 -2.00x^2 +9.00");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestInmultireOk() throws BadInputExeption {
        Polinom p= new Polinom("x^4+3x^5");
        Polinom p1= new Polinom("+5x^5-x^4+x^3-2x^2-x^2+2");
        Polinom rezultat= op.inmultestePolinoame(p1,p);
        Polinom rezultatAsteptat= new Polinom("15.00x^10 +2.00x^9 +2.00x^8 -8.00x^7 -3.00x^6 +6.00x^5 +2.00x^4");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestInmultireNotOk() throws BadInputExeption {
        Polinom p= new Polinom("x^4+3x^5");
        Polinom p1= new Polinom("+5x^5-x^4+x^3-2x^2-x^2+2");
        Polinom rezultat= op.inmultestePolinoame(p1,p);
        Polinom rezultatAsteptat= new Polinom("5.20x^5 +2.00x^4 +1.00x^3 -2.00x^2 +9.00");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestImpartireOk() throws BadInputExeption {
        Polinom p= new Polinom("x^3-2x^2+6x^1-5");
        Polinom p1= new Polinom("x^2-1");
        Polinom rezultat= op.impartePolinoame(p1,p);
        Polinom rezultatAsteptat= new Polinom("x^1-2");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestImpartireNotOk() throws BadInputExeption {
        Polinom p= new Polinom("x^3-2x^2+6x^1-5");
        Polinom p1= new Polinom("x^2-5-x^5");
        Polinom rezultat= op.impartePolinoame(p1,p);
        Polinom rezultatAsteptat= new Polinom("x^1-2");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestDerivareOk() throws BadInputExeption {
        Polinom p= new Polinom("x^3-2x^2+6x^1-5");
        Polinom rezultat= op.derivarePolinoame(p);
        Polinom rezultatAsteptat= new Polinom("+3.00x^2 -4.00x^1 +6.00 ");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestDerivareNotOk() throws BadInputExeption {
        Polinom p= new Polinom("x^3-2x^2+6x^1-5");
        Polinom rezultat= op.derivarePolinoame(p);
        Polinom rezultatAsteptat= new Polinom("x^1-2");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestIntegrareOk() throws BadInputExeption {
        Polinom p= new Polinom("x^3-2x^2+6x^1-5");
        Polinom rezultat= op.integrarePolinoame(p);
        Polinom rezultatAsteptat= new Polinom("0.25x^4 -0.67x^3 +3.00x^2 -5.00x^1  ");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }
    @org.junit.Test
    public void TestIntegrareNotOk() throws BadInputExeption {
        Polinom p= new Polinom("x^3-2x^2+6x^1-5");
        Polinom rezultat= op.integrarePolinoame(p);
        Polinom rezultatAsteptat= new Polinom("2.25x^4 -0.67x^3 +3.50x^2 -1.00x^1 ");
        // System.out.println(rezultat.toString()+'\n'+rezultatAsteptat.toString());
        assertEquals(rezultat.toString(),rezultatAsteptat.toString());
    }

}
