package view;

import model.Operations;
import model.Polinom;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Interface extends JFrame
{
    JFrame frame = new JFrame ("Operatii cu polinoame");
    private Polinom p1 = null, p2 = null;
    JTextField txtbox1 = new JTextField();
    JTextField txtbox2 = new JTextField();
    JTextField txtbox3 = new JTextField();

    public Interface()
    {
        GUI();
        frame.setVisible(true);
    }

    private void GUI()
    {
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int height = screenSize.height * 2 / 3;
//        int width = screenSize.width * 2 / 3;
//        frame.setPreferredSize(new Dimension(width, height));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        JLabel label1 = new JLabel("Introduceti primul polinom: ");
        JLabel label2 = new JLabel("Introduceti al doilea polinom: ");
        JLabel label3 = new JLabel("Alegeti operatia dorita: ");
        label3.setFont(new Font("Times New Roman ", Font.BOLD, 24));
        JLabel label4 = new JLabel("Rezultat este: ");

        txtbox1.setColumns(45);
        txtbox1.setEditable(true);

        txtbox2.setColumns(45);
        txtbox2.setEditable(true);

        txtbox3.setColumns(45);
        txtbox3.setEditable(false);

        JButton b1 = new JButton("ADUNARE");
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polinom rezultat = Operations.aduna(p1, p2);
                txtbox3.setText(rezultat.toString());
            }
        });

        JButton b2 = new JButton("SCADERE {p1 - p2}");
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polinom rezultat = Operations.scade(p1, p2);
                txtbox3.setText(rezultat.toString());
            }
        });
        JButton b3 = new JButton("INMULTIRE");
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polinom rezultat = Operations.inmulteste(p1, p2);
                txtbox3.setText(rezultat.toString());
            }
        });
        JButton b4 = new JButton("IMPARTIRE {1 / 2}");
        JButton b5 = new JButton("DERIVARE {p 1}");
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polinom rezultat = Operations.derivare(p1);
                txtbox3.setText(rezultat.toString());
            }
        });
        JButton b6 = new JButton("INTEGRARE {p 1}");
        b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polinom rezultat = Operations.integrare(p1);
                txtbox3.setText(rezultat.toString());
            }
        });
        JButton b7 = new JButton("DERIVARE {p 2}");
        b7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polinom rezultat = Operations.derivare(p2);
                txtbox3.setText(rezultat.toString());
            }
        });
        JButton b8 = new JButton("INTEGRARE {p 2}");
        b8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polinom rezultat = Operations.integrare(p2);
                txtbox3.setText(rezultat.toString());
            }
        });
        JButton b9 = new JButton("MEMORARE");
        b9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                p1 = new Polinom(txtbox1.getText());
                System.out.println(p1);
                p2 = new Polinom(txtbox2.getText());
                System.out.println(p2);
            }
        });


        panel1.add(label1);
        panel1.add(txtbox1);
        panel1.add(label2);
        panel1.add(txtbox2);
        panel1.add(b9);
        panel1.setLayout(new FlowLayout());

        panel4.add(label3);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        panel2.add(b4);
        panel2.add(b5);
        panel2.add(b6);
        panel2.add(b7);
        panel2.add(b8);
        panel2.setLayout(new GridLayout(2,3));

        panel3.add(label4);
        panel3.add(txtbox3);

        panel.add(panel1);
        panel.add(panel4);
        panel.add(panel2);
        panel.add(panel3);
        panel.setLayout(new BoxLayout (panel, BoxLayout.Y_AXIS));


        frame.setContentPane(panel);
        frame.setVisible(true);

    }


}
