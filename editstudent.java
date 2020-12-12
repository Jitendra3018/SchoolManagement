package SchoolManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class editstudent extends JFrame implements ActionListener{
 
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,lab;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t12;
    JButton b,b1,b2;
    String Sid;

    editstudent(){
        setSize(900,650);
        setBackground(Color.white);
        setLayout(null);

        JLabel id = new JLabel("Enter Student Id to edit the data of the student");
        id.setBounds(50,100,500,30);
        id.setFont(new Font("serif",Font.ITALIC,20));
        add(id);
        
        t1 = new JTextField();
        t1.setBounds(500,100,200,30);
        add(t1);
        
        b2 = new JButton("Enter");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(720,100,100,30);
        add(b2);
        b2.addActionListener(this);

        
        id1 = new JLabel("Edit Student Details:");
        id1.setBounds(50,10,500,50);
        id1.setFont(new Font("serif",Font.ITALIC,40));
        id1.setForeground(Color.black);
        add(id1);


        id2 = new JLabel("Name");
        id2.setBounds(50,170,100,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        add(id2);

        t2=new JTextField();
        t2.setBounds(200,170,150,30);
        add(t2);

        id3 = new JLabel("Father's Name");
        id3.setBounds(400,170,200,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        add(id3);

        t3=new JTextField();
        t3.setBounds(600,170,150,30);
        add(t3);

        id4= new JLabel("Age");
        id4.setBounds(50,220,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        add(id4);

        t5=new JTextField();
        t5.setBounds(200,220,150,30);
        add(t5);

        id5= new JLabel("DOB (dd/mm/yyyy)");  
        id5.setBounds(400,220,200,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        add(id5);

        t4=new JTextField();
        t4.setBounds(600,220,150,30);
        add(t4);

        id6= new JLabel("Address");
        id6.setBounds(50,270,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        add(id6);

        t6=new JTextField();
        t6.setBounds(200,270,150,30);
        add(t6);

        id7= new JLabel("Phone");
        id7.setBounds(400,270,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        add(id7);

        t7=new JTextField();
        t7.setBounds(600,270,150,30);
        add(t7);

        id8= new JLabel("Email Id");
        id8.setBounds(50,320,100,30);
        id8.setFont(new Font("serif",Font.BOLD,20));
        add(id8);

        t8=new JTextField();
        t8.setBounds(200,320,150,30);
        add(t8);

        id9= new JLabel("Gender");
        id9.setBounds(400,320,130,30);
        id9.setFont(new Font("serif",Font.BOLD,20));    
        add(id9);

        t9=new JTextField();
        t9.setBounds(600,320,150,30);
        add(t9);

        id10= new JLabel("Class");
        id10.setBounds(50,370,130,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        add(id10);

        t10=new JTextField();
        t10.setBounds(200,370,150,30);
        add(t10);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,520,150,40);
        
        add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,520,150,40);
        
        add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            try{
                conn con = new conn();
                String str = "update student set name='"+t2.getText()+"',father_name='"+t3.getText()+"',age="+t5.getText()+", dob='"+t4.getText()+"',address='"+t6.getText()+"',phone="+t7.getText()+",email='"+t8.getText()+"',gender='"+t9.getText()+"', class="+t10.getText()+" where id='"+t1.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                setVisible(false);
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            setVisible(false);
        }
        if(ae.getSource() == b2){
            try{
                conn con = new conn();
                String str = "select * from student where id = "+t1.getText();
                ResultSet rs = con.s.executeQuery(str);

                if(rs.next()){
                    setVisible(true);
             
                   // t1.setText(rs.getString(1));//id
                    t2.setText(rs.getString(2));//name
                    t3.setText(rs.getString(3));//father's name
                    t5.setText(rs.getString(4));//age
                    t4.setText(rs.getString(5));//dob
                    t6.setText(rs.getString(6));//adddress
                    t7.setText(rs.getString(7));//phone
                    t8.setText(rs.getString(8));//email
                    t9.setText(rs.getString(9));//gender
                    t10.setText(rs.getString(10));//class
                    
                }

                
            }catch(Exception ex){}
        
        }
    }
    public static void main(String[] Args){
    	new editstudent();
    }
}