import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup1 extends JFrame implements ActionListener {


    static Random r = new Random();
    static int fno = r.nextInt(1,9999);

    JTextField Name1, Fname1,Add1,City1,State1,Pin1, Date1,Email1;
    JRadioButton r1,r2,m1,m2;
    JButton Next;

    Signup1(){
        super("SIGN UP FORM");






        ImageIcon lo = new ImageIcon(ClassLoader.getSystemResource("iconbank/Bank1.png"));
        Image log = lo.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon logo= new ImageIcon(log);
        JLabel logo1 = new JLabel(logo);
        logo1.setBounds(15,10,80,80);
        add(logo1);

        JLabel FormNum= new JLabel("APPLICATION FORM NO : "+ fno);
        FormNum.setBounds(120,20,520,35);
        FormNum.setFont(new Font("Ralway",Font.BOLD,30));
        add(FormNum);

        JLabel Page1 = new JLabel("Page 1");
        Page1.setFont(new Font("Ralway",Font.BOLD,20));
        Page1.setBounds(320,50,520,50);
        add(Page1);

        JLabel Det1 = new JLabel("Personal Details");
        Det1.setFont(new Font("Ralway",Font.BOLD,20));
        Det1.setBounds(280,80,520,50);
        add(Det1);

        JLabel  Name = new JLabel("Name:");
        Name.setBounds(80, 140, 300,30);
        Name.setFont(new Font("Ralway",Font.BOLD,18));
        add(Name);

        Name1 = new JTextField(15);
        Name1.setBounds(300, 140,300,30);
        Name1.setFont(new Font("Ralway",Font.BOLD,16));
        add(Name1);

        JLabel  FName = new JLabel("Father's Name:");
        FName.setBounds(80, 180, 300,30);
        FName.setFont(new Font("Ralway",Font.BOLD,18));
        add(FName);
        Fname1 = new JTextField(15);
        Fname1.setBounds(300, 180,300,30);
        Fname1.setFont(new Font("Ralway",Font.BOLD,16));
        add(Fname1);


        JLabel  Gen = new JLabel("Gender:");
        Gen.setBounds(80, 220, 300,30);
        Gen.setFont(new Font("Ralway",Font.BOLD,18));
        add(Gen);

        r1 = new JRadioButton("Male");
        r1.setBounds(300,220,100,30);
        r1.setFont(new Font("Ralway",Font.BOLD,14));
        r1.setBackground(new Color(222,250,218));
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setBounds(450,220,100,30);
        r2.setFont(new Font("Ralway",Font.BOLD,14));
        r2.setBackground(new Color(222,250,218));
        add(r2);

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(r1);
        bgroup.add(r2);



        JLabel  DOB = new JLabel("Date of Birth:");
        DOB.setBounds(80, 260, 300,30);
        DOB.setFont(new Font("Ralway",Font.BOLD,18));
        add(DOB);
        Date1 = new JTextField("dd/mm/yy");
        Date1.setBounds(300, 260,300,30);
        Date1.setFont(new Font("Ralway",Font.BOLD,16));
        add(Date1);


        JLabel  Email = new JLabel("Email Address:");
        Email.setBounds(80, 300, 300,30);
        Email.setFont(new Font("Ralway",Font.BOLD,18));
        add(Email);

        Email1 = new JTextField(40);
        Email1.setBounds(300, 300,300,30);
        Email1.setFont(new Font("Ralway",Font.BOLD,16));
        add(Email1);

        JLabel  Married = new JLabel("Marital Status:");
        Married.setBounds(80, 340, 300,30);
        Married.setFont(new Font("Ralway",Font.BOLD,18));
        add(Married);
        m1 = new JRadioButton("Married");
        m1.setBounds(300,340,100,30);
        m1.setFont(new Font("Ralway",Font.BOLD,14));
        m1.setBackground(new Color(222,250,218));
        add(m1);
        m2 = new JRadioButton("Unmarried");
        m2.setBounds(450,340,100,30);
        m2.setFont(new Font("Ralway",Font.BOLD,14));
        m2.setBackground(new Color(222,250,218));
        add(m2);

        ButtonGroup bgroup1 = new ButtonGroup();
        bgroup1.add(m1);
        bgroup1.add(m2);

        JLabel  Add = new JLabel("Address:");
        Add.setBounds(80, 380, 300,30);
        Add.setFont(new Font("Ralway",Font.BOLD,18));
        add(Add);
        Add1 = new JTextField(30);
        Add1.setBounds(300, 380,300,30);
        Add1.setFont(new Font("Ralway",Font.BOLD,16));
        add(Add1);

        JLabel  City = new JLabel("City:");
        City.setBounds(80, 420, 300,30);
        City.setFont(new Font("Ralway",Font.BOLD,18));
        add(City);
        City1 = new JTextField(30);
        City1.setBounds(300, 420,300,30);
        City1.setFont(new Font("Ralway",Font.BOLD,16));
        add(City1);


        JLabel  State = new JLabel("State:");
        State.setBounds(80, 460, 300,30);
        State.setFont(new Font("Ralway",Font.BOLD,18));
        add(State);
        State1 = new JTextField(30);
        State1.setBounds(300, 460,300,30);
        State1.setFont(new Font("Ralway",Font.BOLD,16));
        add(State1);

        JLabel  Pin = new JLabel("Pin Code:");
        Pin.setBounds(80, 500, 300,30);
        Pin.setFont(new Font("Ralway",Font.BOLD,18));
        add(Pin);
        Pin1 = new JTextField(30);
        Pin1.setBounds(300, 500,300,30);
        Pin1.setFont(new Font("Ralway",Font.BOLD,16));
        add(Pin1);

        Next = new JButton("Next");
        Next.setBounds(500,570,100,30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.white);
        Next.addActionListener(this);
        add(Next);




        setLayout(null);
        setSize(660,700);
        setUndecorated(true);
        setLocation(350,30);
        getContentPane().setBackground(new Color(222,250,218));
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {


        try {
            String form = String.valueOf(fno);
            String name = Name1.getText();
            String fname = Fname1.getText();
            String gender = null;
            if (r1.isSelected())
                gender = "Male";
            else if (r2.isSelected())
                gender = "Female";
            String marital = null;
            if (m1.isSelected()) {
                marital = "Married";
            } else if (m2.isSelected()) {
                marital = "Unmarried";
            }
            String add = Add1.getText();
            String pin = Pin1.getText();
            String city = City1.getText();
            String state = State1.getText();
            String email = Email1.getText();
            String dob = Date1.getText();

            if(Name1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }

            else {
                Conn conn11 = new Conn();
                String q = "insert into sign values('" + form + "' ,'" + name + "' ,'" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + add + "','" + city + "','" + state + "','" + pin + "')";
                conn11.statement.executeUpdate(q);
                setVisible(false);
                new Signup2(form);

            }
        }catch (Exception E) {
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new Signup1();

    }


}

