package model;

public class Monom implements Comparable{
    private double coef;
    private int rang;

    public Monom(double coef, int rang)
    {
        this.coef = coef;
        this.rang = rang;
    }

    public Monom()
    {

    }

    public double getcoef()
    {
        return this.coef;
    }

    public int getRang()
    {
        return this.rang;
    }

    public void setcoef(double coef)
    {
        this.coef = coef;
    }

    public void setRang(int rang)
    {
        this.rang = rang;
    }


    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        if(this.rang > ((Monom) o).getRang())
            return -1;
        else if (this.rang < ((Monom) o).getRang())
            return 1;
        return 0;
    }

}
