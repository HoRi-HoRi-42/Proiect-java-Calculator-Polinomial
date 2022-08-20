package controller;


import model.Polinom;
import view.Interface;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Polinom p = new Polinom("5+2x^2-5x+6");
        System.out.println(p);

        Interface interf = new Interface();
    }
//x^3+x^5-3x-9
//-2x^5+3x^2-2
}
