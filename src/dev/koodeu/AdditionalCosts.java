package dev.koodeu;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionalCosts extends JFrame implements ActionListener {


    private JLabel lAdditionalCosts;
    private JTextField tAdditionalCosts1, tAdditionalCosts2, tAdditionalCosts3, tAdditionalCosts4;
    private  JButton bSumbit;
    private  double additionalCosts1, additionalCosts2, additionalCosts3, additionalCosts4;
    public double totalAdditionalCosts;

    AdditionalCosts(){

        setSize(250, 250);
        setTitle("Dodatkowe koszty");
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
        tAdditionalCosts4 = new JTextField();
        tAdditionalCosts4.setBounds(150, 120, 50,20);
        add(tAdditionalCosts4);

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


                    if(tAdditionalCosts1.getText().contains(",") || tAdditionalCosts2.getText().contains(",") ||
                            tAdditionalCosts2.getText().contains(",")|| tAdditionalCosts2.getText().contains(",")){

                        tAdditionalCosts1.setText(tAdditionalCosts1.getText().replace(",","."));
                        tAdditionalCosts2.setText(tAdditionalCosts2.getText().replace(",","."));
                        tAdditionalCosts3.setText(tAdditionalCosts3.getText().replace(",","."));
                        tAdditionalCosts4.setText(tAdditionalCosts4.getText().replace(",","."));

                    }


                     if (tAdditionalCosts1.getText().isEmpty() ) {
                        tAdditionalCosts1.setText("0");
                    }

                    if (tAdditionalCosts2.getText().isEmpty() ) {
                        tAdditionalCosts2.setText("0");
                    }

                    if (tAdditionalCosts3.getText().isEmpty() ) {
                        tAdditionalCosts3.setText("0");
                    }

                    if (tAdditionalCosts4.getText().isEmpty() ) {
                        tAdditionalCosts4.setText("0");
                    }


                additionalCosts1 = Double.parseDouble(tAdditionalCosts1.getText());
                additionalCosts2 = Double.parseDouble(tAdditionalCosts2.getText());
                additionalCosts3 = Double.parseDouble(tAdditionalCosts3.getText());
                additionalCosts4 = Double.parseDouble(tAdditionalCosts4.getText());
                totalAdditionalCosts = additionalCosts1+additionalCosts2+additionalCosts3+additionalCosts4;
                setVisible(false);
            }
        }

    }

