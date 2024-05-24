import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {


    private final String Form;
    JRadioButton a1,a2,a3,a4;
    JCheckBox s1,s2, s3, s4, s5;
    JButton buttonS,buttonC;
    Signup3(String form){

        this.Form = form;

        ImageIcon l= new ImageIcon(ClassLoader.getSystemResource("iconbank/Bank1.png"));
        Image lo = l.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon log = new ImageIcon(lo);
        JLabel logo = new JLabel(log);
        logo.setBounds(70,10,80,80);
        add(logo);



        JLabel label1= new JLabel("FORM NO. :"+ form);
        label1.setBounds(500,20,300,30);
        label1.setFont(new Font("Ralway",Font.BOLD,15));
        add(label1);




        JLabel Page3 = new JLabel("Page 3");
        Page3.setFont(new Font("Ralway",Font.BOLD,20));
        Page3.setBounds(320,30,520,50);
        add(Page3);

        JLabel Det1 = new JLabel("Account Details");
        Det1.setFont(new Font("Ralway",Font.BOLD,20));
        Det1.setBounds(280,50,520,50);
        add(Det1);

        JLabel Atype = new JLabel("Account Type: ");
        Atype.setFont(new Font("Ralway",Font.BOLD,18));
        Atype.setBounds(80,160,200,30);
        add(Atype);

        a1= new JRadioButton("Saving Account");
        a1.setFont(new Font("Ralway",Font.BOLD,15));
        a1.setBounds(300,160,300,25);
        a1.setBackground(new Color(147, 219, 170));
        add(a1);
        a2= new JRadioButton("Fixed Deposit Account");
        a2.setFont(new Font("Ralway",Font.BOLD,15));
        a2.setBounds(300,185,300,25);
        a2.setBackground(new Color(147, 219, 170));
        add(a2);
        a3= new JRadioButton("Current Account");
        a3.setFont(new Font("Ralway",Font.BOLD,15));
        a3.setBounds(300,210,300,25);
        a3.setBackground(new Color(147, 219, 170));
        add(a3);
        a4= new JRadioButton("Recurring Deposit Account");
        a4.setFont(new Font("Ralway",Font.BOLD,15));
        a4.setBounds(300,235,300,25);
        a4.setBackground(new Color(147, 219, 170));
        add(a4);


        ButtonGroup b1 = new ButtonGroup();
        b1.add(a1);
        b1.add(a2);
        b1.add(a3);
        b1.add(a4);

        JLabel login = new JLabel("Login ID: ");
        login.setFont(new Font("Ralway",Font.BOLD,18));
        login.setBounds(80,280,200,30);
        add(login);
        JLabel login1 = new JLabel("(Your 8 digit login ID)");
        login1.setFont(new Font("Ralway",Font.BOLD,10));
        login1.setBounds(80,305,200,15);
        add(login1);

        JLabel log1 = new JLabel("XXXX-XXXX");
        log1.setFont(new Font("Ralway",Font.BOLD,18));
        log1.setBounds(300,280,200,30);
        add(log1);
        JLabel l1 = new JLabel("(It would appear on Cheque book/Statement)");
        l1.setFont(new Font("Ralway",Font.BOLD,10));
        l1.setBounds(300,305,200,15);
        add(l1);






        JLabel pass = new JLabel("Password:");
        pass.setFont(new Font("Ralway",Font.BOLD,18));
        pass.setBounds(80,330,200,30);
        add(pass);
        JLabel pass1 = new JLabel("(Your 4 digit password)");
        pass1.setFont(new Font("Ralway",Font.BOLD,10));
        pass1.setBounds(80,355,200,15);
        add(pass1);
        JLabel pass0 = new JLabel("XXXX");
        pass0.setFont(new Font("Ralway",Font.BOLD,18));
        pass0.setBounds(300,330,200,30);
        add(pass0);
        JLabel  service = new JLabel("Services Required:");
        service.setFont(new Font("Ralway",Font.BOLD,18));
        service.setBounds(80,390,200,30);
        add(service);

        s1 = new JCheckBox("ATM CARD");
        s1.setFont(new Font("Ralway",Font.BOLD,16));
        s1.setBounds(80,420,150,35);
        s1.setBackground(new Color(147, 219, 170));
        add(s1);
        s2 = new JCheckBox("Mobile Banking");
        s2.setFont(new Font("Ralway",Font.BOLD,16));
        s2.setBounds(300,420,150,35);
        s2.setBackground(new Color(147, 219, 170));
        add(s2);
        s3 = new JCheckBox("Cheque Book");
        s3.setFont(new Font("Ralway",Font.BOLD,16));
        s3.setBounds(80,460,150,35);
        s3.setBackground(new Color(147, 219, 170));
        add(s3);
        s4 = new JCheckBox("Email Alert");
        s4.setFont(new Font("Ralway",Font.BOLD,16));
        s4.setBounds(300,460,150,35);
        s4.setBackground(new Color(147, 219, 170));
        add(s4);
        s5 = new JCheckBox("Internet Banking");
        s5.setFont(new Font("Ralway",Font.BOLD,16));
        s5.setBounds(80,500,150,35);
        s5.setBackground(new Color(147, 219, 170));
        add(s5);
        JCheckBox declare = new JCheckBox("I hereby declare that all information that above entered are correct in best of my knowledge. ",true);
        declare.setFont(new Font("Ralway",Font.BOLD,10));
        declare.setBounds(80,550,500,15);
        declare.setBackground(new Color(147, 219, 170));
        add(declare);

        buttonS = new JButton("Submit");
        buttonS.setFont(new Font("Ralway",Font.BOLD,14));
        buttonS.setBounds(200,600,100,30);
        buttonS.setBackground(Color.black);
        buttonS.setForeground(Color.white);
        buttonS.addActionListener(this);
        add(buttonS);

        buttonC = new JButton("Cancel");
        buttonC.setFont(new Font("Ralway",Font.BOLD,14));
        buttonC.setBounds(400,600,100,30);
        buttonC.setBackground(Color.black);
        buttonC.setForeground(Color.white);
        buttonC.addActionListener(this);
        add(buttonC);





        setSize(660,700);
        getContentPane().setBackground(new Color(147, 219, 170));
        setLocation(350,50);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String Atyp= null;
        if(a1.isSelected()){
            Atyp= "Saving Account";
        }else if(a2.isSelected()){
            Atyp= "Fixed Deposit Account";
        }else if(a3.isSelected()){
            Atyp= "Current Account";
        }else if(a4.isSelected()){
            Atyp= "Recurring Deposit Account";
        }
        String ser = "";
        if(s1.isSelected()){
            ser+=  "ATM";
        }if(s2.isSelected()){
            ser+="MOB banking";
        }if(s3.isSelected()){
            ser+="Cheque";
        }if(s4.isSelected()){
            ser+="Email";
        }if(s5.isSelected()){
            ser+="Internet";
        }

        Random random = new Random();
        int logi = random.nextInt(10000000,99999999);
        int passo = random.nextInt(1000,9999);
        String login= ""+logi;
        String password= ""+passo;

        try{
            if(e.getSource()==buttonS){
                Conn con1= new Conn();
                String q="insert into sign3 values('"+Form+"','"+Atyp+"','"+login+"', '"+password+"', '"+ser+"')";
                String q2 = "insert into log values('"+Form+"','"+login+"', '"+password+"')";

                con1.statement.executeUpdate(q);
                con1.statement.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "LogIn ID: "+login+"\n Password: " +password);
                new Deposit(password);
                setVisible(false);


            } else if (e.getSource()==buttonC) {
                new Login();
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }



    }



    public static void main(String[] args) {
        new Signup3("");
    }


}

