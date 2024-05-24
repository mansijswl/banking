import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String password;

    JButton exitButton;
    Mini(String password){

        this.password=password;


        JLabel l1 = new JLabel("MINI STATEMENT");
        l1.setBounds(130,15,200,30);
        l1.setFont(new Font("System",Font.BOLD,17));
        add(l1);

        JLabel l2 = new JLabel();
        l2.setBounds(20,90,200,30);
        l2.setFont(new Font("System",Font.BOLD,15));
        add(l2);

        try {
            Conn c= new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from log where password = '"+password+"'");
            while (resultSet.next()){

                l2.setText("Login ID: XXXX"+resultSet.getString("Login").substring(4));
            }
        }catch (Exception E){
            E.printStackTrace();
        }


        JLabel l3 = new JLabel();
        l3.setBounds(20,120,400,300);
        l3.setFont(new Font("System",Font.BOLD,12));
        add(l3);


        JLabel l4 = new JLabel();
        l4.setBounds(20,450,400,20);
        l4.setFont(new Font("System",Font.BOLD,15));
        add(l4);
        try {
            int balance =0;
            Conn c= new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank1 where password = '"+password+"'");

            while(resultSet.next()) {

                if (resultSet.getString("type").equals("DEPOSIT")) {
                    l3.setText(l3.getText()+"<html> "+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><html>");

                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
                if (resultSet.getString("type").equals("WITHDRAW")) {
                    l3.setText(l3.getText()+"<html> "+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><html>");

                    balance = balance - Integer.parseInt(resultSet.getString("amount"));
                }
                if (resultSet.getString("type").equals("TRANSFER")) {
                    l3.setText(l3.getText()+"<html> "+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><html>");

                    balance = balance - Integer.parseInt(resultSet.getString("amount"));
                }

            }
            l4.setText("Your Total Balance is: "+ balance);


        }catch (Exception E){
            E.printStackTrace();
        }








        exitButton = new JButton("Exit");
        exitButton.setBounds(20,550,100,20);
        exitButton.setFont(new Font("System",Font.BOLD,15));
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.white);
        exitButton.addActionListener(this);
        add(exitButton);



        setSize(400,650);
        setLocation(250,30);
        setUndecorated(true);
        getContentPane().setBackground(new Color(238, 213, 239));
        setLayout(null);
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if(e.getSource()==exitButton){
                new Bank(password);
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Mini("");
    }
}
