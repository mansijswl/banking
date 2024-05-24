import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame  implements ActionListener {

    String password;
    JTextField textDeposit;
    JButton depositButton, backButton;

    Deposit(String password){


        super("Deposit Money");

        this.password = password;

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("iconbank/Bank1.png"));
        Image ic = i.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ico = new ImageIcon(ic);
        JLabel icon = new JLabel(ico);
        icon.setBounds(20,10,100,100);
        add(icon);
        JLabel label1= new JLabel("Enter Amount You Want To Deposit.");
        label1.setFont(new Font("Arial",Font.BOLD,24));
        label1.setBounds(480 ,190, 500,50);
        label1.setForeground(Color.white);
        add(label1);

        textDeposit = new JTextField(10);
        textDeposit.setFont(new Font("Arial",Font.BOLD,24));
        textDeposit.setBounds(480 ,255, 400,35);
        add(textDeposit);

        depositButton = new JButton("DEPOSIT");
        depositButton.setForeground(Color.white);
        depositButton.setBackground(new Color(0x161031));
        depositButton.setBounds(700,400,150,40);
        depositButton.setFont(new Font("Raleway", Font.BOLD,22));
        depositButton.addActionListener(this);
        add(depositButton);

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
        setUndecorated(true);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String amount = textDeposit.getText();
            Date date = new Date();
            if(e.getSource()==depositButton){
                if(textDeposit.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount");
                }else {
                    Conn c= new Conn();
                    String q= "insert into bank1 values('"+ password+"','"+date +"','DEPOSIT','"+amount+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Rs."+amount+" Deposited Successfully");
                    new Bank(password);
                    setVisible(false);
                }

            }
            else if(e.getSource()==backButton){
                new Bank(password);
                setVisible(false);
            }



        }catch (Exception E){
            E.printStackTrace();
        }


    }




    public static void main(String[] args) {
        new Deposit("");

    }
}
