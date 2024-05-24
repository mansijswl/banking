import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    String password;
    JTextField textWithdraw;
    JButton withdrawButton, backButton;

    Withdraw(String password){


        super("Withdraw Money");

        this.password = password;

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("iconbank/Bank1.png"));
        Image ic = i.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ico = new ImageIcon(ic);
        JLabel icon = new JLabel(ico);
        icon.setBounds(20,10,100,100);
        add(icon);
        JLabel label1= new JLabel("Enter Amount You Want To Withdraw.");
        label1.setFont(new Font("Arial",Font.BOLD,24));
        label1.setBounds(480 ,190, 500,50);
        label1.setForeground(Color.white);
        add(label1);

        textWithdraw = new JTextField();
        textWithdraw.setFont(new Font("Arial",Font.BOLD,24));
        textWithdraw.setBounds(480 ,255, 400,35);
        add(textWithdraw);

        JLabel label2= new JLabel("Maximum Limit is 10,000.");
        label2.setFont(new Font("Arial",Font.BOLD,24));
        label2.setBounds(480 ,150, 500,30);
        label2.setForeground(Color.white);
        add(label2);


        withdrawButton = new JButton("Withdraw");
        withdrawButton.setForeground(Color.white);
        withdrawButton.setBackground(new Color(0x161031));
        withdrawButton.setBounds(700,400,150,40);
        withdrawButton.setFont(new Font("Raleway", Font.BOLD,22));
        withdrawButton.addActionListener(this);
        add(withdrawButton);

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
        setUndecorated(true);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String wAmount = textWithdraw.getText();
            Date date = new Date();
            int balance =0;
            if(e.getSource()==withdrawButton){
                if(textWithdraw.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Enter the Amount");
                }else{
                    Conn c= new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank1 where password='"+password+"'");
                    while (resultSet.next()){
                        if(resultSet.getString("type").equals("DEPOSIT")){
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        }else{
                            balance -=  Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if(Integer.parseInt(wAmount)>10000){
                        JOptionPane.showMessageDialog(null,"Limit Exceed");
                    }

                    else if(balance<Integer.parseInt(wAmount)){
                        JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE");
                    }
                    else {
                        String q = "insert into bank1 values('" + password + "','" + date + "','WITHDRAW','" + wAmount + "')";
                        c.statement.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Rs." + wAmount + " Withdrawal Successfully" );
                        new Bank(password);
                        setVisible(false);
                    }

                }

            }else if (e.getSource()==backButton){
                new  Bank(password);
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }


    }





    public static void main(String[] args) {
        new Withdraw("");

    }
}
