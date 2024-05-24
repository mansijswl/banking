import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Balance extends JFrame implements ActionListener {

    String password;
    JTextField textBalance,textB;
    JButton checkBalance, backButton;


    Balance(String password){
        super("Balance Enquiry");

        this.password=password;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("iconbank/Bank1.png"));
        Image ic = i.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ico = new ImageIcon(ic);
        JLabel icon = new JLabel(ico);
        icon.setBounds(20,10,100,100);
        add(icon);
        JLabel label1= new JLabel("YOUR ACCOUNT BALANCE IS RS.");
        label1.setFont(new Font("Arial",Font.BOLD,24));
        label1.setBounds(480 ,190, 500,50);
        label1.setForeground(Color.white);
        add(label1);

        textBalance = new JTextField("**********");
        textBalance.setFont(new Font("Arial",Font.BOLD,24));
        textBalance.setBounds(480 ,255, 400,35);
        add(textBalance);

        checkBalance = new JButton("BALANCE");
        checkBalance.setForeground(Color.white);
        checkBalance.setBackground(new Color(0x161031));
        checkBalance.setBounds(700,400,150,40);
        checkBalance.setFont(new Font("Raleway", Font.BOLD,22));
        checkBalance.addActionListener(this);
        add(checkBalance);

        backButton = new JButton("BACK");
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(0x161031));
        backButton.setFont(new Font("Raleway", Font.BOLD,22));
        backButton.setBounds(700,460,150,40);
        backButton.addActionListener(this);
        add(backButton);







        ImageIcon b = new ImageIcon(ClassLoader.getSystemResource("iconbank/mainb.png"));
        Image ba = b.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon bac = new ImageIcon(ba);
        JLabel back = new JLabel(bac);
        back.setBounds(0,0,1000,700);
        add(back);






        setSize(1000,700);
        setLocation(250,30);
        getContentPane().setBackground(Color.black);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int balance =0;
            Date date = new Date();
            if(e.getSource()==checkBalance){
                    Conn c= new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank1 where password = '"+password+"'");

                    while(resultSet.next()) {
                        if (resultSet.getString("type").equals("DEPOSIT")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        }
                        if (resultSet.getString("type").equals("WITHDRAW")) {
                            balance = balance - Integer.parseInt(resultSet.getString("amount"));
                        }
                        if (resultSet.getString("type").equals("TRANSFER")) {
                            balance = balance - Integer.parseInt(resultSet.getString("amount"));
                        }

                    }
                String bal = ""+ balance;
                textB = new JTextField(bal);
                textB.setFont(new Font("Arial",Font.BOLD,24));
                textB.setBounds(480 ,255, 400,35);
                add(textB);


            } else if (e.getSource()==backButton) {
                new Bank(password);
                setVisible(false);

            }

        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new Balance("");
    }
}
