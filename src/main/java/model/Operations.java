package model;

public class Operations {

    public static Polinom aduna(Polinom p1, Polinom p2)
    {
        Polinom pol_rez = new Polinom();//creem un nou polinom
        for (Monom m1: p1.P)//pentru fiecare monom din polinom
        {
            for (Monom m2: p2.P)
                if (m1.getRang() == m2.getRang())//daca rangurile sunt egale
                {
                    Monom a = new Monom();//creem un nou monom
                    a.setcoef(m1.getcoef() + m2.getcoef() );//ii setam coeficientul ca si adunarea celor 2 monoame
                    a.setRang(m1.getRang());//rangul este =, deci nu conteaza al caruia il luam
                    pol_rez.addMonom(a);//adaugam in p
                }
        }
        for(Monom m1: p1.P)//pt fiecare monom din polinomul 1
        {
            int check = 1;//verificam daca cumva nu sunt monoame in polinomul 1 pe care le-am lasat afara
            for(Monom r: pol_rez.P)//pentru fiecare monom din polinom
            {
                if(r.getRang()== m1.getRang())
                    check = 0;//daca se regaseste, nu il adaugam
            }
            if(check == 1)// daca nu
            {
                pol_rez.addMonom(m1);//daca cumva este un termen la o putere negasita in polinomul pol_rez il adaugam
            }
        }
        for(Monom m1: p2.P)//pt fiecare monom din polinomul 2
        {
            int check = 1;//verificam daca cumva nu sunt monoame in polinomul 2 pe care le-am lasat afara
            for(Monom rez: pol_rez.P)//pentru fiecare monom din polinom
            {
                if(m1.getRang() == rez.getRang())
                    check = 0;//daca se regaseste, nu il adaugam
            }
            if(check == 1)
            {
                pol_rez.addMonom(m1);//daca cumva este un termen la o putere negasita in polinomul pol_rez il adaugam
            }
        }
        return pol_rez;
    }

    public static Polinom scade(Polinom p1, Polinom p2)
    {
        Polinom pol_rez = new Polinom();//creem un nou polinom
        for (Monom m1: p1.P)//pentru fiecare monom din polinom
        {
            for (Monom m2: p2.P)
                if (m1.getRang() == m2.getRang())//daca rangurile sunt egale
                {
                    Monom a = new Monom();//creem un nou monom
                    if (m1.getcoef() != m2.getcoef() )//daca coieficientii nu sunt egali
                    {
                        a.setcoef(m1.getcoef() - m2.getcoef() );//scadem din coeficientul monomului din primul polinom pe al doilea
                        a.setRang(m1.getRang());//rangul este =, deci nu conteaza al caruia il luam
                        pol_rez.addMonom(a);//adaugam in polinomul pol_rez
                    }
                    else {
                        a.setcoef(m1.getcoef() - m2.getcoef() );//scadem din coeficientul monomului din primul polinom pe al doilea
                        a.setRang(m1.getRang());//rangul este =, deci nu conteaza al caruia il luam
                        pol_rez.addMonom(a);//adaugam in polinomul pol_rez

                    }
                }
        }
        for(Monom m1: p1.P)//pt fiecare monom din polinomul 2
        {
            int check = 1;//verificam daca cumva nu sunt monoame in polinomul 2 pe care le-am lasat afara
            for(Monom rez: pol_rez.P)//mergem cu un monom prin polinomul pol_reza
            {
                if(m1.getRang() == rez.getRang())//daca se regaseste, nu il adaugam
                    check = 0;//daca se regaseste, nu il adaugam
            }
            if(check == 1)//daca mai sunt monoame se adauga in pol_rez
            {
                pol_rez.addMonom(m1);
            }
        }
        for(Monom m1: p2.P)//pt fiecare monom din polinomul 2
        {
            int check = 1;//verificam daca cumva nu sunt monoame in polinomul 2 pe care le-am lasat afara
            for(Monom rez: pol_rez.P)//mergem cu un monom prin polinomul pol_reza
            {
                if(m1.getRang() == rez.getRang())//daca se regaseste, nu il adaugam
                    check = 0;//daca se regaseste, nu il adaugam
            }
            if(check == 1)//daca mai sunt monoame se adauga in pol_rez
            {
                m1.setcoef(-m1.getcoef());//cum asta este al doilea poinom (cel de dupa -) trebuie sa vina cu semn schimbat
                pol_rez.addMonom(m1);//il adaugam in pol_rez
            }
        }
        return pol_rez;
    }

    public static Polinom inmulteste(Polinom p1, Polinom p2)
    {
        Polinom pol_rez = new Polinom();//creem un nou polinom
        for (Monom m1:p1.P)//ne plimbam pentru fiecare monom din primul polinom
        {
            for(Monom m2:p2.P)//ne plimbam pentru fiecare monom din al doilea polinom
            {
                Monom a = new Monom();//creem un nou monom
                a.setcoef(m1.getcoef() * m2.getcoef());//inmultim coeficientii
                a.setRang(m1.getRang() + m2.getRang());//si rangurile dintre cele doua monoame din polinoame

                pol_rez.addMonom(a);//adaugam in pol_rez monomul a
            }
        }
        for (Monom m1: pol_rez.P)
        {
            for (Monom m2: pol_rez.P)
            {
                if (m1.getRang() == m2.getRang())//au aceasi putere
                {
                    if (m1 != m2)//daca difera numerele
                    {
                        m1.setcoef(m1.getcoef() + m2.getcoef());//adunam coeficientii
                        m2.setcoef(0);//si nu mai avem necvoie de coeficientul monomului din polinoumul 2
                    }
                }
            }
        }
        return pol_rez;
    }

    public static Polinom derivare(Polinom p)
    {
        Polinom pol_rez = new Polinom();//creeam un nou polinom

        for (Monom m: p.P)//pentru fiecare monom din polinom
        {
            if (m.getRang() >= 1)//daca ragul este mai mare decat 1
            {
                Monom aux = new Monom();//monom ajutator
                aux.setcoef(m.getcoef() * m.getRang());//coeficentul este pol_rezul inmultirii dintre rang si vechiul coieficient
                aux.setRang(m.getRang() - 1);//rangul se scadde in urma derivarii
                pol_rez.addMonom(aux);//adaugam
            }
            if (m.getRang() == 0){//daca avem elementul liber (rangul lui x este 0)
                Monom aux = new Monom();//monom aux
                aux.setcoef(0);//setam coeficientul 0
                pol_rez.addMonom(aux);// si adaugam monomul in pol_rez
            }
        }
        return pol_rez;//returnam pol_rezul
    }

    public static Polinom integrare(Polinom p)
    {
        Polinom pol_rez = new Polinom();//creeam un nou polinom rezultat

        for (Monom m: p.P)//pentru filecare monom din polinom
        {
            Monom aux = new Monom();
            aux.setcoef(m.getcoef() / (m.getRang() + 1));//impartim coeficientul la puterea incrementata
            aux.setRang(m.getRang() + 1);//crestem puterea
            pol_rez.addMonom(aux);//adaugam in rezultat
        }
        return pol_rez;
    }
}
