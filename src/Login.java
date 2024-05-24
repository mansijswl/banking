import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.awt.Font.BOLD;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2,label3;
    JTextField login;
    JPasswordField password;

    JButton clear, sign_in,sign_up;
    Login(){
        super("Bank Management System");

        label1 = new JLabel("WELCOME to AtoZ BANK");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Ralway",Font.BOLD,36));
        label1.setBounds(350,80,450,55);
        add(label1);


        label2 = new JLabel("Login ID: ");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Ralway",Font.BOLD,26));
        label2.setBounds(380,150,450,35);
        add(label2);

        login =new JTextField(15);
        login.setBounds(550,150,250,35);
        login.setFont(new Font("Arial", BOLD,18));
        add(login);

        label3 = new JLabel("Password : ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("",Font.BOLD,26));
        label3.setBounds(380,190,450,35);
        add(label3);

        password = new JPasswordField(15);
        password.setBounds(550,190,250,35);
        password.setFont(new Font("Arial", BOLD,18));
        add(password);

        sign_in = new JButton("SIGN IN");
        sign_in.setBounds(550, 240,120,35);
        sign_in.setFont(new Font("Arial",Font.ITALIC,14));
        sign_in.setForeground(Color.white);
        sign_in.setBackground(Color.black);
        sign_in.addActionListener(this);
        add(sign_in);
        clear = new JButton("CLEAR");
        clear.setBounds(680,240,120,35);
        clear.setFont(new Font("Arial",Font.ITALIC,14));
        clear.setForeground(Color.white);
        clear.setBackground(Color.black);
        clear.addActionListener(this);
        add(clear);

        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(610,290,140,35);
        sign_up.setFont(new Font("Arial",Font.ITALIC,14));
        sign_up.setForeground(Color.white);
        sign_up.setBackground(Color.black);
        sign_up.addActionListener(this);
        add(sign_up);







        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("iconbank/bg.png"));
        Image bg1 = bg.getImage().getScaledInstance(850,450,Image.SCALE_DEFAULT);
        ImageIcon back= new ImageIcon(bg1);
        JLabel bImage = new JLabel(back);
        bImage.setBounds(0,0,850,450);
        add(bImage);

        setLayout(null);
        setSize(850,450);
        setLocation(400,200);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==sign_in){
                Conn c = new Conn();
                String log = login.getText();
                String pass = password.getText();
                String q = "select * from log where Login = '"+log+"'and password = '"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new Bank(pass);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect 'Login ID' or 'Password'");
                }

            } else if (e.getSource()==sign_up) {
                new Signup1();
                setVisible(false);

            } else if (e.getSource()==clear) {
                login.setText("");
                password.setText("");

            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}

