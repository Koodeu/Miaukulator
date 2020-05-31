package dev.koodeu;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionalCosts extends JFrame implements ActionListener {


    JLabel lAdditionalCosts;
    JTextField tAdditionalCosts1, tAdditionalCosts2, tAdditionalCosts3, tAdditionalCosts4;
    JButton bSumbit;

    AdditionalCosts(){

        setSize(250, 250);
        setTitle("Dodatkowe koszty");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width/2+this.getSize().width, dimension.height/2-this.getSize().height/2);

        lAdditionalCosts = new JLabel("Dodatkowe wydatki: ");
        lAdditionalCosts.setBounds(20,30, 120, 20);
        add(lAdditionalCosts);
        tAdditionalCosts1 = new JTextField();
        tAdditionalCosts1.setBounds(150, 30, 50,20);
        add(tAdditionalCosts1);

        lAdditionalCosts = new JLabel("Dodatkowe wydatki: ");
        lAdditionalCosts.setBounds(20,60, 120, 20);
        add(lAdditionalCosts);
        tAdditionalCosts2 = new JTextField();
        tAdditionalCosts2.setBounds(150, 60, 50,20);
        add(tAdditionalCosts2);

        lAdditionalCosts = new JLabel("Dodatkowe wydatki: ");
        lAdditionalCosts.setBounds(20,90, 120, 20);
        add(lAdditionalCosts);
        tAdditionalCosts3 = new JTextField();
        tAdditionalCosts3.setBounds(150, 90, 50,20);
        add(tAdditionalCosts3);

        lAdditionalCosts = new JLabel("Dodatkowe wydatki: ");
        lAdditionalCosts.setBounds(20,120, 120, 20);
        add(lAdditionalCosts);
        tAdditionalCosts3 = new JTextField();
        tAdditionalCosts3.setBounds(150, 120, 50,20);
        add(tAdditionalCosts3);

        bSumbit = new JButton("Dodaj");
        bSumbit.setBounds(130, 165, 70, 20);
        getRootPane().setDefaultButton(bSumbit);
        bSumbit.addActionListener(this);
        add(bSumbit);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
            if(source == bSumbit){
                setVisible(false);
            }
        }

    }

