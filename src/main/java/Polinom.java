import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom  {
    HashMap<Integer, Double> map = new HashMap<Integer, Double>();
    Polinom() {}
    Polinom(String pol) throws BadInputExeption {

        this.despartePolinom(pol);
    }
    public Polinom reset()
    {
        return new Polinom();
    }
    // 2x^3+3
    public int getDegree() {
        int maxx=-1;
        for(Integer key: this.map.keySet())
        {
            if(maxx<key && map.get(key)!=0)
            {
                maxx=key;
            }
        }
        return maxx;
    }
    public static boolean validarePolinom(String polinom){
        if(polinom==null || polinom.isEmpty())
            return false;
        if(!polinom.matches("[0-9x+\\-^\\s.]+"))
            return false;
        return true;
    }
    void despartePolinom(String pol) throws BadInputExeption {
        if(validarePolinom(pol)==false) {throw new BadInputExeption("Bad Input");}
        if (!pol.contains("x")) { double c = Double.parseDouble(pol); adaugaMonom(c, 0); return;}
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(pol);
        while (matcher.find()) {
            String grup =matcher.group(1);
            Pattern intPattern = Pattern.compile("[+-]?\\d+(\\.\\d+)?");
            Matcher intMatcher = intPattern.matcher(grup);
            int p=0; // schimba in integer
            Double c=0.0;
            Integer e=0;
            String s=grup;
            while (intMatcher.find()) {
                if(p==0) {
                    if(s.charAt(0)=='x') {
                        e=Integer.parseInt(intMatcher.group());
                        c=1.0;
                    }
                    else if(s.charAt(1)=='x'&& (s.charAt(0)=='+' || s.charAt(0)=='-')) {
                        e=Integer.parseInt(intMatcher.group());
                        if(s.charAt(0)=='+')
                            c=1.0;
                        else c=-1.0;
                    }
                    else { c = (double) Double.parseDouble(intMatcher.group());
                        p=1;}}
                else{e = Integer.parseInt(intMatcher.group());}}
            adaugaMonom(c,e);
        }
    }
    void adaugaMonom(double c,int e)
    {
        if(map.containsKey(e))
            map.put(e,map.get(e)+c);
        else map.put(e,c);
    }
   // @Override
    public String toString1() {
        String ret = "";
        for (int i :map.keySet()) {
            if(map.get(i)!=0.0)
            {
                if(map.get(i)>0) {
                    if (i == 0)
                        ret += "+" + map.get(i) + " ";
                    else if (i == 1) ret += "+" + map.get(i) + "x ";
                    else ret += "+" + map.get(i) + "x^" + i + " ";
                }
                else
                {
                    if(i==0)
                        ret += +map.get(i)+" ";
                    else if (i==1)  ret += +map.get(i)+"x ";
                    else ret += +map.get(i)+"x^"+i+" ";
                }

            }
        }
        return ret;
    }
    public String toString() {
        String ret = " ";
        List<Map.Entry<Integer,Double>> listaAfisare= new ArrayList<>(this.map.entrySet());
        Collections.sort(listaAfisare, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getKey().compareTo(o1.getKey());}
        });
        for(Map.Entry<Integer,Double>i: listaAfisare) {
            if (i.getValue() > 0) {
                if (i.getKey() == 1.0) ret += "+" + String.format("%.2f", i.getValue()) + "x ";
                else if (i.getKey() == 0) ret += "+" + String.format("%.2f", i.getValue()) + " ";
               // if(i.getValue()==1 && i.getKey()!=0) ret += "+x^ "+i.getKey();
                else ret += "+" + String.format("%.2f", i.getValue()) + "x^" + i.getKey() + " ";
            }
            else {
                if (i.getValue() != 0) {
                    if (i.getKey() == 0) ret += String.format("%.2f", i.getValue()) + " ";
                    else ret += String.format("%.2f", i.getValue()) + "x^" + i.getKey() + " ";
                }
            }
        }
        if(ret.equals(" ")) ret="0";
        return ret;
    }
}

