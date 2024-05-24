import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    String  Form;


    JButton next;
    JTextField textPan, textAadhar;
    JRadioButton Sr_yes, Sr_no, r1,r2;
    JComboBox comboReli, comboCat, comboIncome,comboQuali,comboOccu;
    Signup2(String form){
        super("Application Form");

        ImageIcon l= new ImageIcon(ClassLoader.getSystemResource("iconbank/Bank1.png"));
        Image lo = l.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon log = new ImageIcon(lo);
        JLabel logo = new JLabel(log);
        logo.setBounds(70,10,80,80);
        add(logo);
        this.Form= form;


        JLabel label1= new JLabel("FORM NO. :"+ form);
        label1.setBounds(500,20,300,30);
        label1.setFont(new Font("Ralway",Font.BOLD,15));
        add(label1);




        JLabel Page2 = new JLabel("Page 2");
        Page2.setFont(new Font("Ralway",Font.BOLD,20));
        Page2.setBounds(320,30,520,50);
        add(Page2);

        JLabel Det1 = new JLabel("Additional Details");
        Det1.setFont(new Font("Ralway",Font.BOLD,20));
        Det1.setBounds(280,50,520,50);
        add(Det1);

        JLabel Religion = new JLabel("Religion");
        Religion.setBounds(90,120,200,30);
        Religion.setFont(new Font("Ralway",Font.BOLD,18));
        add(Religion);

        String [] religion ={"Hindu","Muslim","Sikh","Christian","Other"};
        comboReli = new JComboBox(religion);
        comboReli.setBackground(new Color(100,250,218));
        comboReli.setFont(new Font("Ralway",Font.BOLD,16));
        comboReli.setBounds(300,120,300,30);
        add(comboReli);



        JLabel category = new JLabel("Category");
        category.setBounds(90,160,200,30);
        category.setFont(new Font("Ralway",Font.BOLD,18));
        add(category);

        String [] cat ={"General","OBC","ST","SC","Other"};
        comboCat = new JComboBox(cat);
        comboCat.setBackground(new Color(100,250,218));
        comboCat.setFont(new Font("Ralway",Font.BOLD,16));
        comboCat.setBounds(300,160,300,30);
        add(comboCat);

        JLabel Income = new JLabel("Income");
        Income.setBounds(90,200,200,30);
        Income.setFont(new Font("Ralway",Font.BOLD,18));
        add(Income);

        String [] in ={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10lakh","above 10lakh"};
        comboIncome = new JComboBox(in);
        comboIncome.setBackground(new Color(100,250,218));
        comboIncome.setFont(new Font("Ralway",Font.BOLD,16));
        comboIncome.setBounds(300,200,300,30);
        add(comboIncome);

        JLabel Edu = new JLabel("Education Qualification");
        Edu.setBounds(90,240,200,30);
        Edu.setFont(new Font("Ralway",Font.BOLD,17));
        add(Edu);
        String [] edu ={"Not-Graduate","Graduate","Post Graduate","Doctorate","other"};
        comboQuali = new JComboBox(edu);
        comboQuali.setBackground(new Color(100,250,218));
        comboQuali.setFont(new Font("Ralway",Font.BOLD,16));
        comboQuali.setBounds(300,240,300,30);
        add(comboQuali);




        JLabel Occupation = new JLabel("Occupation");
        Occupation.setBounds(90,280,200,30);
        Occupation.setFont(new Font("Ralway",Font.BOLD,18));
        add(Occupation);
        String [] job ={"Salaried","self-Employed","Business","Student","Retired","Other"};
        comboOccu = new JComboBox(job);
        comboOccu.setBackground(new Color(100,250,218));
        comboOccu.setFont(new Font("Ralway",Font.BOLD,16));
        comboOccu.setBounds(300,280,300,30);
        add(comboOccu);



        JLabel Pan = new JLabel("Pan Number");
        Pan.setBounds(90,320,200,30);
        Pan.setFont(new Font("Ralway",Font.BOLD,18));
        add(Pan);

        textPan = new JTextField();
        textPan.setFont(new Font("Ralway",Font.BOLD,16));
        textPan.setBounds(300,320,300,30);
        add(textPan);

        JLabel Aadhar = new JLabel("Aadhar Number");
        Aadhar.setBounds(90,360,200,30);
        Aadhar.setFont(new Font("Ralway",Font.BOLD,18));
        add(Aadhar);
        textAadhar = new JTextField();
        textAadhar.setBounds(300,360,300,30);
        textAadhar.setFont(new Font("Ralway",Font.BOLD,18));
        add(textAadhar);


        JLabel Senior = new JLabel("Senior Citizen");
        Senior.setBounds(90,400,200,30);
        Senior.setFont(new Font("Ralway",Font.BOLD,18));
        add(Senior);

        Sr_yes= new JRadioButton("Yes");
        Sr_yes.setFont(new Font("Ralway",Font.BOLD,15));
        Sr_yes.setBounds(300,400,100,30);
        Sr_yes.setBackground(new Color(100,250,218));
        add(Sr_yes);
        Sr_no= new JRadioButton("No");
        Sr_no.setFont(new Font("Ralway",Font.BOLD,15));
        Sr_no.setBounds(450,400,100,30);
        Sr_no.setBackground(new Color(100,250,218));
        add(Sr_no);

        ButtonGroup b = new ButtonGroup();
        b.add(Sr_yes);
        b.add(Sr_no);



        JLabel Exist = new JLabel("Existing Account");
        Exist.setBounds(90,440,200,30);
        Exist.setFont(new Font("Ralway",Font.BOLD,18));
        add(Exist);
        r1= new JRadioButton("Yes");
        r1.setFont(new Font("Ralway",Font.BOLD,15));
        r1.setBounds(300,440,100,30);
        r1.setBackground(new Color(100,250,218));
        add(r1);
        r2= new JRadioButton("No");
        r2.setFont(new Font("Ralway",Font.BOLD,15));
        r2.setBounds(450,440,100,30);
        r2.setBackground(new Color(100,250,218));
        add(r2);

        ButtonGroup b1 = new ButtonGroup();
        b1.add(r1);
        b1.add(r2);



        next = new JButton("Next");
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBounds(500,600, 100,30);
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.addActionListener(this);
        add(next);

        setSize(660,700);
        setLocation(350,30);
        getContentPane().setBackground(new Color(100,250,218));
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String reli = (String)comboReli.getSelectedItem();
            String cate= (String)comboCat.getSelectedItem();
            String inc = (String)comboIncome.getSelectedItem();
            String educa= (String)comboQuali.getSelectedItem();
            String occup= (String)comboOccu.getSelectedItem();
            String panno= textPan.getText();
            String adhar= textAadhar.getText();
            String fno = Form;
            String senior= null;
            if(Sr_yes.isSelected()){
                senior ="Yes";
            } else if (Sr_no.isSelected()) {
                senior="No";
            }
            String exUser= null;
            if(r1.isSelected()){
                senior ="Yes";
            } else if (r2.isSelected()) {
                senior="No";
            }



            if(textPan.getText().isEmpty()||textAadhar.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"fill all necessary detail");
            }else{
                Conn con= new Conn();
                String q1="insert into sign2 values(' " +fno+ " ' , ' " +reli+ " ' , ' " +cate+ "', '"+inc+"', '"+educa+"','"+occup+"', '"+panno+"','"+adhar+"','"+senior+"', '"+exUser+"')";
                con.statement.executeUpdate(q1);
                new Signup3(fno);
                setVisible(false);


            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }



    public static void main(String[] args) {
        new Signup2("");
    }
}