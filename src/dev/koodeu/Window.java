package dev.koodeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;



public class Window extends JFrame implements ActionListener, FoodCost{

    JMenuBar barMenuBar;
    JMenu menuFile, menuAbout;
    JMenuItem mOpen, mSave, mExit, mAbout;
    JLabel lFoodBagCost, lFoodBagSize, lSandBagCost, lSandBagSize, lDailyFoodDose, lSandExchangeRate, lMonthlyFoodCost,
    lMonthlySandCost, lTotalCost;
    JTextField tFoodBagCost, tFoodBagSize, tSandBagCost, tSandBagSize, tDailyFoodDose;
    JComboBox comboSandExchangeRate;
    JButton bTotalCost;
    double foodCost, monthlyFoodCost, bagSize, sandBagSize, sandBagCost, sandCost, totalCost;
    int dailyFoodDose, sandExchangeRate;
    ImageIcon catIcon, catIcon2;

    Window(){
        setTitle("Miaukulator v.1.02");
        setSize(500, 400);
        getRootPane().setDefaultButton(bTotalCost);
        setLayout(null);


        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);

        barMenuBar = new JMenuBar();
        setJMenuBar(barMenuBar);
        menuFile = new JMenu("Plik");
        menuAbout = new JMenu("O programie");
        barMenuBar.add(menuFile);
        barMenuBar.add(menuAbout);
        mOpen = new JMenuItem("Otwórz", 'O');
        mOpen.addActionListener(this);
        mOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        mSave = new JMenuItem("Zapisz", 'Z');
        mSave.addActionListener(this);
        mSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        mExit = new JMenuItem("Wyjdź", 'W');
        mExit.addActionListener(this);
        mExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        menuFile.add(mOpen);
        menuFile.add(mSave);
        menuFile.add(mExit);

        mAbout = new JMenuItem("O Miaukulatorze", 'M');
        mAbout.addActionListener(this);
        mAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        menuAbout.add(mAbout);

        lFoodBagCost = new JLabel("Cena paczki suchej karmy: ");
        lFoodBagCost.setBounds(30, 20, 160, 20);
        add(lFoodBagCost);
        tFoodBagCost = new JTextField();
        tFoodBagCost.setBounds(190, 20, 50, 20);
        tFoodBagCost.setToolTipText("Wpisz cenę paczki karmy w złotówkach.");
        add(tFoodBagCost);

        lFoodBagSize = new JLabel("Wielkość paczki w kg:");
        lFoodBagSize.setBounds(260, 20, 130, 20);
        add(lFoodBagSize);
        tFoodBagSize = new JTextField();
        tFoodBagSize.setBounds(430, 20, 30,20);
        add(tFoodBagSize);

        lSandBagCost = new JLabel("Cena paczki żwirku:");
        lSandBagCost.setBounds(30, 60, 150, 20);
        add(lSandBagCost);
        tSandBagCost = new JTextField();
        tSandBagCost.setBounds(190, 60,50, 20);
        add(tSandBagCost);

        lSandBagSize = new JLabel("Wielkość paczki żwirku w kg: ");
        lSandBagSize.setBounds(260, 60, 170, 20);
        add(lSandBagSize);
        tSandBagSize = new JTextField();
        tSandBagSize.setBounds(430, 60, 30, 20);
        add(tSandBagSize);

        lDailyFoodDose = new JLabel("Dzienne spożycie karmy w gramach: ");
        lDailyFoodDose.setBounds(30, 120, 220, 20);
        add(lDailyFoodDose);
        tDailyFoodDose = new JTextField();
        tDailyFoodDose.setBounds(245,120,30,20);
        add(tDailyFoodDose);

        lSandExchangeRate = new JLabel("Ilość wymian żwirku w miesiącu: ");
        lSandExchangeRate.setBounds(30, 150, 250, 20);
        add(lSandExchangeRate);
        comboSandExchangeRate = new JComboBox();
        comboSandExchangeRate.setBounds(245, 150, 50, 20);
        comboSandExchangeRate.addItem(1);
        comboSandExchangeRate.addItem(2);
        comboSandExchangeRate.addItem(3);
        comboSandExchangeRate.addItem(4);
        comboSandExchangeRate.addItem(5);
        comboSandExchangeRate.addItem(6);
        comboSandExchangeRate.addItem(7);
        comboSandExchangeRate.addItem(8);
        add(comboSandExchangeRate);


        lMonthlyFoodCost = new JLabel("Miesięczny koszt karmy: ");
        lMonthlyFoodCost.setBounds(30, 240, 200, 20);
        add(lMonthlyFoodCost);

        lMonthlySandCost = new JLabel("Miesięczny koszt żwirku: ");
        lMonthlySandCost.setBounds(30, 260, 200, 20);
        add(lMonthlySandCost);


        bTotalCost = new JButton("Oblicz");
        bTotalCost.setBounds(170,200, 150, 20);
        bTotalCost.addActionListener(this);
        getRootPane().setDefaultButton(bTotalCost);
        add(bTotalCost);



        lTotalCost = new JLabel("Całkowity miesięczny koszt: ");
        lTotalCost.setBounds(30, 285, 250, 20);
        add(lTotalCost);


    }


    @Override
    public double foodCost(double foodBagCost, double foodBagSize, int dialyDose) {
        return foodBagCost/foodBagSize/1000 * dialyDose*(30.5);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == mExit) {
            dispose();
        }

        else if (source == mAbout) {
        catIcon = new ImageIcon("src/dev/koodeu/images/cat.png");
        JOptionPane.showMessageDialog(null, "\nTo jest pierwsza wersja Miaukulatora, który liczy miesięczny koszt utrzymania kociambra :-)" +
                        " \n\n                                     KociRights Krystian Limiera\n",
                "O Miaukulatorze", JOptionPane.INFORMATION_MESSAGE, catIcon);
        }

        else if (source == bTotalCost) {



            if (tFoodBagCost.getText().contains(",") ){
                tFoodBagCost.setText(tFoodBagCost.getText().replace(",","."));
            }
            foodCost = Double.parseDouble(tFoodBagCost.getText());

            if (tFoodBagSize.getText().contains(",")){
                tFoodBagSize.setText(tFoodBagSize.getText().replace(",","."));
            }
            bagSize = Double.parseDouble(tFoodBagSize.getText());
            dailyFoodDose = Integer.parseInt(tDailyFoodDose.getText());
            monthlyFoodCost = Math.round((foodCost / bagSize / 1000 * dailyFoodDose * 30.5) * 100) / 100.0;
            lMonthlyFoodCost.setText("Miesięczny koszt karmy: " + (String.valueOf(monthlyFoodCost)) + "zł");

            if(tSandBagSize.getText().contains(",")){
                tSandBagSize.setText(tSandBagSize.getText().replace(",","."));
            }
            sandBagSize = Double.parseDouble(tSandBagSize.getText());

            if (tSandBagCost.getText().contains(",")){
                tSandBagCost.setText(tSandBagCost.getText().replace(",",".") );
            }
            sandBagCost = Double.parseDouble(tSandBagCost.getText());
            sandExchangeRate = Integer.parseInt(comboSandExchangeRate.getSelectedItem().toString());
            sandCost = Math.round((sandBagCost / sandBagSize * (sandExchangeRate * 1.5)) * 100) / 100.00;
            lMonthlySandCost.setText("Miesięczny koszt żwirku: " + (String.valueOf(sandCost)) + "zł");

            totalCost = Math.round((monthlyFoodCost + sandCost) *100)/100.00;
            lTotalCost.setText(String.valueOf("Całkowity miesięczny koszt: " + totalCost + "zł"));

            catIcon2 = new ImageIcon("src/dev/koodeu/images/kitty.png");
            JOptionPane.showMessageDialog(null, "Miesięczny koszt utrzymania Twojego kota to: " + totalCost + " zł", "Info o kosztach", JOptionPane.INFORMATION_MESSAGE, catIcon2);

        }

        else if (source==mSave){

            JFileChooser fileChooser = new JFileChooser();
                if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                        try {
                            PrintWriter printWriter = new PrintWriter(file);
                            Scanner scanner = new Scanner(lTotalCost.getText());
                                while (scanner.hasNext()){
                                    printWriter.println("Oj dużo.... dużo..... " + "\n" + scanner.nextLine() + "\n");
                                }
                                printWriter.close();
                        }

                        catch (FileNotFoundException e1){
                            e1.printStackTrace();
                        }

                }
        }

    }
}
