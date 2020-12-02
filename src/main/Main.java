package main;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class Main extends JFrame implements ActionListener {

    JLabel lblName;
    JTextField txtName;

    JLabel lblBirth;
    JFormattedTextField txtBirth;

    JLabel lblCpf;
    JFormattedTextField txtCpf;

    JLabel lblUserType;
    JComboBox sltUserType;
    final String[] userType = {"Adminstrador", "Geral"};

    JLabel lblSalary;
    JFormattedTextField txtSalary;

    JButton btnSend;
    Container frame;

    public void main(String[] args){
        setSize(500,400);

        setTitle("Tela inicial");

        frame = getContentPane();

        lblName = new JLabel("Nome");
        txtName = new JTextField();
        lblBirth = new JLabel("Nascimento");
        try{
            txtBirth = new JFormattedTextField(new MaskFormatter("##-##-####"));
        } catch(
                ParseException e)
        {
            e.printStackTrace();
        }

        lblCpf = new JLabel("CPF");
        try{
            txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch(
                ParseException e)
        {
            e.printStackTrace();
        }

        lblUserType = new JLabel("Tipo de usuário");
        sltUserType = new JComboBox(userType);

        lblSalary = new JLabel("Salário");
        try{
            txtSalary = new JFormattedTextField(new MaskFormatter("R$: #.###,##"));
        } catch(
                ParseException e)
        {
            e.printStackTrace();
        }

        btnSend = new JButton("Enviar");
        frame.setLayout(null);

        lblName.setBounds(2,2,100,25);
        txtName.setBounds(150,2,200,25);
        lblBirth.setBounds(2,52,100,25);
        txtBirth.setBounds(150,52,200,25);
        lblCpf.setBounds(2,102,100,25);
        txtCpf.setBounds(150,102,200,25);
        lblUserType.setBounds(2,152,100,25);
        sltUserType.setBounds(150,152,200,25);
        lblSalary.setBounds(2,202,100,25);
        txtSalary.setBounds(152,202,200,25);
        btnSend.setBounds(152,252,100,60);

        frame.add(lblName);
        frame.add(txtName);
        frame.add(lblBirth);
        frame.add(txtBirth);
        frame.add(lblCpf);
        frame.add(txtCpf);
        frame.add(lblUserType);
        frame.add(sltUserType);
        frame.add(lblSalary);
        frame.add(txtSalary);
        frame.add(btnSend);

        btnSend.addActionListener(this);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);

        Users user = new Users(txtName.getText(), txtBirth.getText(), txtCpf.getText(), (String) sltUserType.getSelectedItem(), txtSalary.getText());
        try {
            user.SaveUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        user.View();
        System.exit(0);
    }
}
