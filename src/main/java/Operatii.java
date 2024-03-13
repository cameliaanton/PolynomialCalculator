import java.util.Set;

public class Operatii {
    Operatii() {

    }
    Polinom adunaPolinoame(Polinom p1,Polinom p2)
    {
        Polinom rez = new Polinom();
        rez.map.putAll(p1.map);
        //System.out.println(rez.toString());
        for(int i: p2.map.keySet())
        {
            if(rez.map.containsKey(i))
                rez.map.put(i,rez.map.get(i)+p2.map.get(i));
            else rez.map.put(i,p2.map.get(i));
        }
        return rez;
    }
    Polinom scadePolinoame(Polinom p,Polinom p2)
    {
        Polinom rez = new Polinom();
        rez.map.putAll(p.map);
        for(int i: p2.map.keySet())
        {
            if(rez.map.containsKey(i))
                rez.map.put(i,rez.map.get(i)-p2.map.get(i));
            else rez.map.put(i,-p2.map.get(i));
        }
        return rez;
    }
    public boolean verificareImpartire(Polinom p,Polinom p2)
    {
        if(p.getDegree()<p2.getDegree())
            return false;
        return true;
    }
    Polinom inmultestePolinoame(Polinom p,Polinom p2)  {
        Polinom rez= new Polinom();
        int e=0;
        double c=0.0;
        for(int i: p2.map.keySet())
        {
            if(p2.map.get(i)!=0)
            {
                for(int j:p.map.keySet())
                {
                    if(p.map.get(j)!=0)
                    {
                        e=i+j;
                        c=p2.map.get(i)*p.map.get(j);
                        if(rez.map.containsKey(e))
                            rez.map.put(e,rez.map.get(e)+c);
                        else rez.map.put(e,c);
                    }
                }
            }
        }
        return rez;
    }
    Polinom impartePolinoame(Polinom p1,Polinom p2)  { // p1/p2
        if(verificareImpartire(p1,p2)==false)
            return this.impartePolinoame(p2,p1);
            //throw new ImpartireException("Polinomul 2 are grad mai mare decat primul");
        Polinom quotient= new Polinom();
        Polinom remainder= new Polinom();
        remainder.map.putAll(p1.map);
        while(remainder.getDegree()>=p2.getDegree())
        {
            Integer degree= remainder.getDegree()-p2.getDegree();
            Double coeficient=remainder.map.get(remainder.getDegree())/p2.map.get(p2.getDegree());
            quotient.adaugaMonom(coeficient,degree);
            for(Integer i: p2.map.keySet()) {
             //   System.out.println(i + " " + remainder.toString());
                Double intermediate = p2.map.get(i) * coeficient;
                if (remainder.map.containsKey(degree + i))
                    intermediate = remainder.map.get(degree + i) - intermediate;
                else intermediate = -intermediate;
                remainder.map.put(degree + i, intermediate);
               // System.out.println(i + " " + remainder.toString());
            }
            if (remainder.getDegree() < p2.getDegree()) {
                break;
            }
        }
        return quotient;
    }
    Polinom derivarePolinoame(Polinom p)
    {
        // (aX^n)'= (a*n)X^(n-1)
        Polinom rez= new Polinom();
        for(int i: p.map.keySet())
        {
            int e=i; //exponent
            Double c=p.map.get(i); //coeficient
            c=c*e;
            e=e-1;
            if(rez.map.containsKey(e))
                rez.map.put(e,rez.map.get(e)+c);
            else rez.map.put(e,c);
        }
        return rez;
    }
    Polinom integrarePolinoame(Polinom p)
    {
        // (aX^n)'= (a*n)X^(n-1)
        Polinom rez= new Polinom();
        for(int i: p.map.keySet())
        {
            int e=i; //exponent
            Double c=p.map.get(i); //coeficient
            c=c/(e+1);
            e=e+1;
            if(rez.map.containsKey(e))
                rez.map.put(e,rez.map.get(e)+c);
            else rez.map.put(e,c);
        }
        return rez;
    }
}

