import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Transfer extends JFrame implements ActionListener {
    String password;
    JTextField textTransfer, textAccount;
    JButton transferButton, backButton;

    Transfer(String password) {

        this.password = password;

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("iconbank/Bank1.png"));
        Image ic = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ico = new ImageIcon(ic);
        JLabel icon = new JLabel(ico);
        icon.setBounds(20, 10, 100, 100);
        add(icon);

        JLabel label2 = new JLabel("Enter Beneficiary Account no..");
        label2.setFont(new Font("Arial", Font.BOLD, 24));
        label2.setBounds(480, 100, 500, 50);
        label2.setForeground(Color.white);
        add(label2);
        textAccount = new JTextField();
        textAccount.setFont(new Font("Arial", Font.BOLD, 24));
        textAccount.setBounds(480, 145, 400, 35);
        add(textAccount);

        JLabel label1 = new JLabel("Enter Amount You Want To Transfer.");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setBounds(480, 190, 500, 50);
        label1.setForeground(Color.white);
        add(label1);

        textTransfer = new JTextField();
        textTransfer.setFont(new Font("Arial", Font.BOLD, 24));
        textTransfer.setBounds(480, 255, 400, 35);
        add(textTransfer);


        transferButton = new JButton("Transfer");
        transferButton.setForeground(Color.white);
        transferButton.setBackground(new Color(0x161031));
        transferButton.setBounds(700, 400, 150, 40);
        transferButton.setFont(new Font("Raleway", Font.BOLD, 22));
        transferButton.addActionListener(this);
        add(transferButton);

        backButton = new JButton("BACK");
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(0x161031));
        backButton.setFont(new Font("Raleway", Font.BOLD, 22));
        backButton.setBounds(700, 460, 150, 40);
        backButton.addActionListener(this);
        add(backButton);


        ImageIcon b = new ImageIcon(ClassLoader.getSystemResource("iconbank/mainb.png"));
        Image ba = b.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon bac = new ImageIcon(ba);
        JLabel back = new JLabel(bac);
        back.setBounds(0, 0, 1000, 700);
        add(back);


        setSize(1000, 700);
        setLocation(250, 30);
        getContentPane().setBackground(Color.black);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String wAmount = textTransfer.getText();
            Date date = new Date();
            int balance = 0;
            if (e.getSource() == transferButton) {
                if (textAccount.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Account no.");
                }else if (textTransfer.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Amount");
                } else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank1 where password='" + password + "'");
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("DEPOSIT")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(wAmount)) {
                        JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
                    } else {
                        String q = "insert into bank1 values('" + password + "','" + date + "','TRANSFER','" + wAmount + "')";
                        c.statement.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Rs." + wAmount + " Transfered Successfully");
                        new Bank(password);
                        setVisible(false);
                    }

                }

            } else if (e.getSource() == backButton) {
                new Bank(password);
                setVisible(false);
            }


        } catch (Exception E) {
            E.printStackTrace();
        }

    }




    public static void main(String[] args) {
        new Transfer("");
    }
}
