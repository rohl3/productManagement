package com.classes;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Form extends JFrame{
    Prodotto p;
    ArrayList<Prodotto> list = new ArrayList<>();
    private JLabel codeLabel;
    private JTextField codeTxt;
    private JLabel categoryLabel;
    private JTextField categoryTxt;
    private JLabel descLabel;
    private JTextField descTxt;
    private JLabel priceLabel;
    private JTextField priceTxt;
    private JLabel quantityLabel;
    private JTextField quantityTxt;
    private JButton okBtn;
    private JButton viewAllBtn;
    private JButton viewHighBtn;
    private JTextArea outputTxtArea;
    private JPanel Form;
    private JLabel infoLabel;
    private JButton clearBtn;
    private JButton openFileBtn;
    private JButton clearFileBtn;

    public Form() {
        setContentPane(Form);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        okButton();
        viewAllButton();
        viewHighButton();
        clearButton();
        fileOpener();
        fileClear();
    }

    public void okButton(){
        okBtn.addActionListener(e -> {
            try {
                p = new Prodotto(codeTxt.getText(), descTxt.getText(), categoryTxt.getText(),Double.parseDouble(priceTxt.getText()), Integer.parseInt(quantityTxt.getText()));
                list.add(p);
                FileWriter writer = new FileWriter("Data.txt" , true);
                writer.write(p.toString());
                writer.write(System.lineSeparator());
                writer.write(System.lineSeparator());
                writer.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane,ex.getMessage());
            }
        });
    }

    public void viewAllButton(){
        viewAllBtn.addActionListener(e -> {
            outputTxtArea.setText("");
            list.forEach(x -> outputTxtArea.append(x.toString()+'\n'));
        });
    }

    public void viewHighButton(){
        viewHighBtn.addActionListener(e -> {
            outputTxtArea.setText("");
            list.sort(Prodotto.costSorter);
            list.forEach(p -> outputTxtArea.append(p.toString()+'\n'));
        });
    }

    public void clearButton(){
        clearBtn.addActionListener(e -> {
            outputTxtArea.setText("");
            list.clear();
        });
    }

    public void fileOpener(){
        openFileBtn.addActionListener(e -> {
            try {
                Desktop.getDesktop().open(new java.io.File("Data.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public void fileClear(){
        clearFileBtn.addActionListener(e -> {
            try {
                FileWriter writer = new FileWriter("Data.txt");
                writer.flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
