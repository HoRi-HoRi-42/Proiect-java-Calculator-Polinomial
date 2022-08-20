package model;

import java.util.ArrayList;
import java.util.Collections;

public class Polinom {
    String polinom;
    ArrayList<Monom> P= new ArrayList<Monom>();

    public Polinom(String polinom)
    {
        this.polinom = polinom;
        this.P = crearePolinom(polinom);
    }

    public Polinom()
    {

    }

    public ArrayList<Monom> crearePolinom(String P)
    {
        ArrayList<Monom> a = new ArrayList<Monom>();

        P = P.replace("-", " -");
        String[] s = P.split("\\+|\\ ");

        for (String s1: s)
        {
            System.out.println(s1);
            if (!s1.equals(""))
            {
                Monom m = new Monom();
                if (!s1.contains("^"))
                {
                    if (!s1.contains("x"))
                    {
                        if(s1.equals(""))
                        {
                            s1 = "1";
                        }
                        else if (s1.equals("-"))
                        {
                            s1 = "-1";
                        }
                        m.setcoef(Double.parseDouble(s1));
                        m.setRang(0);
                    }
                    else
                    {
                        s1 = s1.replace("x", "");
                        if(s1.equals(""))
                        {
                            s1 = "1";
                        }
                        else if (s1.equals("-"))
                        {
                            s1 = "-1";
                        }
                        m.setcoef(Double.parseDouble(s1));
                        m.setRang(1);
                    }
                    a.add(m);
                }
                else
                {
                    String[] cr = s1.split("x\\^");

                    if(cr[0].isEmpty())
                    {
                        m.setcoef(1);
                    }
                    else if(cr[0].equals("-"))
                    {
                        m.setcoef(-1);
                    }
                    else
                    {
                        m.setcoef(Double.parseDouble(cr[0]));
                    }
                    if (cr.length != 2 && !cr[0].isEmpty())
                    {
                        m.setRang(0);
                    }
                    else
                    {
                        m.setRang(Integer.parseInt(cr[1]));
                    }
                    a.add(m);
                }
            }
        }
        return a;
    }

    public void addMonom(Monom m)
    {
        P.add(m);
    }

    public String toString()
    {
        String rezultat = "";
        Collections.sort(P);
        for (Monom m: this.P)
        {
            if(m.getcoef() > 0)
            {
                rezultat += "+" + m.getcoef() + "x^" + m.getRang();
            }
            else if(m.getcoef() < 0)
            {
                rezultat += m.getcoef() + "x^" + m.getRang();
            }
            else if (m.getcoef() == 0)
            {
                rezultat += "+" +0;
            }
        }
        return rezultat;
    }
}