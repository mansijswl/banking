import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bank extends JFrame implements ActionListener {
    String password;
    JButton depositButton,balanceButton,miniButton,withdrawButton , transferButton,exitButton;
    Bank(String password){
        super("AtoZ BANK");
        this.password = password;


        JLabel label= new JLabel("WELCOME!...");
        label.setFont(new Font("Ralway", Font.BOLD,22));
        label.setBounds(680,20,300,30);
        label.setForeground(Color.white);
        add(label);

        balanceButton = new JButton("VIEW BALANCE");
        balanceButton.setForeground(Color.white);
        balanceButton.setBackground(new Color(0x161031));
        balanceButton.setBounds(600,70,300,40);
        balanceButton.setFont(new Font("Ralway", Font.BOLD,22));
        balanceButton.addActionListener(this);
        add(balanceButton);
        depositButton = new JButton("DEPOSIT");
        depositButton.setForeground(Color.white);
        depositButton.setBackground(new Color(0x161031));
        depositButton.setBounds(600,130,300,40);
        depositButton.setFont(new Font("Ralway", Font.BOLD,22));
        depositButton.addActionListener(this);
        add(depositButton);
        miniButton = new JButton("MINI STATEMENT");
        miniButton.setForeground(Color.white);
        miniButton.setBackground(new Color(0x161031));
        miniButton.setBounds(600,190,300,40);
        miniButton.setFont(new Font("Ralway", Font.BOLD,22));
        miniButton.addActionListener(this);
        add(miniButton);
        withdrawButton = new JButton("WITHDRAWAL");
        withdrawButton.setForeground(Color.white);
        withdrawButton.setBackground(new Color(0x161031));
        withdrawButton.setBounds(600,250,300,40);
        withdrawButton.setFont(new Font("Ralway", Font.BOLD,22));
        withdrawButton.addActionListener(this);
        add(withdrawButton);
        transferButton = new JButton("TRANSFER FUND");
        transferButton.setForeground(Color.white);
        transferButton.setBackground(new Color(0x161031));
        transferButton.setBounds(600,310,300,40);
        transferButton.setFont(new Font("Ralway", Font.BOLD,22));
        transferButton.addActionListener(this);
        add(transferButton);
        exitButton = new JButton("EXIT");
        exitButton.setForeground(Color.white);
        exitButton.setBackground(new Color(0x161031));
        exitButton.setBounds(700,490,100,40);
        exitButton.setFont(new Font("Ralway", Font.BOLD,22));
        exitButton.addActionListener(this);
        add(exitButton);






        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("iconbank/Bank1.png"));
        Image ic = i.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ico = new ImageIcon(ic);
        JLabel icon = new JLabel(ico);
        icon.setBounds(20,10,100,100);
        add(icon);


        ImageIcon b = new ImageIcon(ClassLoader.getSystemResource("iconbank/mainb.png"));
        Image ba = b.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon bac = new ImageIcon(ba);
        JLabel back = new JLabel(bac);
        back.setBounds(0,0,1000,700);
        add(back);

        setSize(1000,700);
        setLocation(250,30);
        getContentPane().setBackground(Color.black);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if(e.getSource()==depositButton){
                new Deposit(password);
                setVisible(false);
            } else if (e.getSource() == withdrawButton) {
                new Withdraw(password);
                setVisible(false);
            } else if(e.getSource()==exitButton){
                System.exit(0);
            } else if (e.getSource() == transferButton) {
                new Transfer(password);
                setVisible(false);
            } else if (e.getSource()==balanceButton) {
                new  Balance(password);
                setVisible(false);
            } else if (e.getSource()==miniButton) {
                new Mini(password);
                setVisible(false);

            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new Bank("");
    }


}
