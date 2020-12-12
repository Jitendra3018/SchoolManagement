package SchoolManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class addstaff extends JFrame implements ActionListener{

    JLabel l1,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JButton b,b1,b2,b3;
    JComboBox c1,c2,c3;
    public addstaff()
    {
        setBackground(Color.white);
        setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,900,600);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon("bg.jpg");
        Image i3 = img.getImage().getScaledInstance(900, 600,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l1.setIcon(icc3);

        id1 = new JLabel("New Staff's Details");
        id1.setBounds(220,30,500,50);
        id1.setFont(new Font("serif",Font.ITALIC,50));
        id1.setForeground(Color.black);
        l1.add(id1);
        add(l1);

 
        id2 = new JLabel("Name");
        id2.setBounds(60,150,100,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id2);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        l1.add(t1);

        id3 = new JLabel("Age");
        id3.setBounds(400,150,200,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id3);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        l1.add(t2);

        id4= new JLabel("Address");
        id4.setBounds(60,200,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id4);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        l1.add(t3);

        id5= new JLabel("DOB (dd/mm/yyyy)");  
        id5.setBounds(400,200,200,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id5);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        l1.add(t4);

        id6= new JLabel("Phone");
        id6.setBounds(60,250,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id6);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        l1.add(t5);

        id7= new JLabel("Salary");
        id7.setBounds(400,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id7);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        l1.add(t6);

        id8= new JLabel("Email Id");
        id8.setBounds(60,300,100,30);
        id8.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id8);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        l1.add(t7);

        id9= new JLabel("Gender");
        id9.setBounds(400,300,130,30);
        id9.setFont(new Font("serif",Font.BOLD,20));    
        l1.add(id9);
        String sex[] = {"Female", "Male","Others"};
        c2 = new JComboBox(sex);
        c2.setBackground(Color.WHITE);
        c2.setBounds(600,300,150,30);
        l1.add(c2);

        id10= new JLabel("Qualification");
        id10.setBounds(60,350,150,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id10);

        t9=new JTextField();   
        t9.setBounds(200,350,150,30);
        l1.add(t9);


        lab=new JLabel("Department");
        lab.setBounds(400,350,150,30);
	    lab.setFont(new Font("serif",Font.BOLD,20));
        l1.add(lab);
            
        String standard[] = {"administration","faculty","others"};
        c1 = new JComboBox(standard);
        c1.setBackground(Color.WHITE);
        c1.setBounds(600,350,150,30);
        l1.add(c1);
        
        lab1 = new JLabel("Subject");
        lab1.setBounds(60,400,150,30);
        lab1.setFont(new Font("serif",Font.BOLD,20));
        l1.add(lab1);
            
        String subject[] = {"mathematics","english","science", "none"};
        c3 = new JComboBox(subject);
        c3.setBackground(Color.WHITE);
        c3.setBounds(200,400,150,30);
        l1.add(c3);
        
        id11= new JLabel("Staff_ID");
        id11.setBounds(400,400,100,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        l1.add(id11);

        t10=new JTextField();
        t10.setBounds(600,400,150,30);
        l1.add(t10);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,500,150,40);
        
        l1.add(b);


        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,500,150,40);
        
        l1.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        setVisible(true);
        setSize(900,600);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        String ff = t6.getText();
        String g = t7.getText();
        String h = (String)c2.getSelectedItem();
        String i = t9.getText();
        String j = (String)c1.getSelectedItem();
        String k = (String)c3.getSelectedItem();
        String ll = t10.getText();
        if(ae.getSource() == b){
            try{
                String login="";
                conn cc = new conn();
                String q = "insert into staff values("+ll+",'"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"')";
                cc.s.executeUpdate(q);
                String str;
                if(j.equals("administration"))
                    login="loginadmin ";
                else if(j.equals("faculty"))
                {
                    login="loginfaculty ";
                    q = "insert into sub" + " values(" + ll + ", '" + k + "')";
                    cc.s.executeUpdate(q);
                }   
                if(j.equals("administration")||j.equals("faculty"))
                {
                    str = "insert into "+ login + "values(" + ll + ",'abc')";
                    cc.s.executeUpdate(str);
                }
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                setVisible(false);
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
                JOptionPane.showMessageDialog(null,"Error! Maybe Duplicating Id");
            }
        }else if(ae.getSource() == b1){
            setVisible(false);
        }
    }
    public static void main(String[] Args){
        new addstaff();
    }
}
