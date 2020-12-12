package SchoolManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class marks implements ActionListener{
	JFrame f;
    JTextField t,t1,t2,t3;
    JLabel l1,l2,l3,l4;
    JButton b,b1,b2,b3;

    marks(){

    	Font f1 = new Font("serif",Font.BOLD,20); 

		f =new JFrame("Add Marks");
        f.setBackground(Color.green);   
        f.setLayout(null);
        
        l1=new JLabel("Student Id");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.BLUE);
        Font f2 = new Font("serif",Font.BOLD,25); 
        l1.setFont(f2);
        f.add(l1);

        t=new JTextField();
        t.setBounds(250,50,150,30);
        f.add(t);


        b=new JButton("Search");
        b.setBounds(200,100,100,30);
        b.addActionListener(this);
        f.add(b);

        b3=new JButton("back");
        b3.setBounds(360,100,100,30);   
        b3.addActionListener(this);
        f.add(b3);


        l2=new JLabel("Mathematics : "); 
        l2.setBounds(50,150,250,30);
        l2.setForeground(Color.black);
        l2.setFont(f1);
        f.add(l2);

        t1=new JTextField();    
        t1.setBounds(200,150,150,30);
        t1.setForeground(Color.red);
        f.add(t1);

        l3=new JLabel("English : ");
        l3.setBounds(50,200,250,30);
        l3.setForeground(Color.black); 
        l3.setFont(f1);
        f.add(l3);


        t2=new JTextField();
        t2.setBounds(200,200,150,30);
        t2.setForeground(Color.red);
        f.add(t2);



        l4=new JLabel("Science : ");
        l4.setBounds(50,250,250,30);
        l4.setForeground(Color.black);
        l4.setFont(f1);
        f.add(l4);

        t3=new JTextField();
        t3.setBounds(200,250,150,30);
        t3.setForeground(Color.red);
        f.add(t3);

        b1=new JButton("Submit");
        b1.setBounds(120,300,100,30);
        b1.addActionListener(this);
        f.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(300,300,100,30);
        b2.addActionListener(this);
        f.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);

        b1.setVisible(false);
        b2.setVisible(false);

        f.setSize(500,500);
        f.setLocation(500,250);  
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                int m = Integer.parseInt(t1.getText());
                int e = Integer.parseInt(t2.getText());
                int s = Integer.parseInt(t3.getText());
                if(m>100||e>100||s>100)
                    JOptionPane.showMessageDialog(null,"Marks can't be above 100!!");
                else
                {
                    conn con = new conn();
                    String str = "insert into marks values(" + t.getText()+"," + t1.getText() +"," + t3.getText() +"," + t2.getText() +")"; 
                    con.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Student Marks Inserted Successfully");
                    f.setVisible(false);
                }                
            }
            catch(Exception e){
                System.out.println("The error is:"+e);
                JOptionPane.showMessageDialog(null,"Error! Maybe marks already inserted");
            }
        }
        if(ae.getSource()==b3||ae.getSource()==b2){
            f.setVisible(false);
        }
        if(ae.getSource() == b){
            try{
                conn con = new conn();
                String str = "select * from student where id = "+t.getText();
                ResultSet rs = con.s.executeQuery(str);

                if(rs.next()){
                    f.setVisible(true);
             
                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                     t1.setVisible(true);
                    t2.setVisible(true);
                    t3.setVisible(true);

                     b1.setVisible(true);
                      b2.setVisible(true);
                    
                }

                
            }catch(Exception ex){}
        
        }
    }
    public static void main(String [] Args)
    {
    	new marks();
    }
    
}