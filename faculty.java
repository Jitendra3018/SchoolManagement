package SchoolManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class faculty extends JFrame implements ActionListener{
	
    JLabel l1,l2;
    JButton b1,b2,b3,b4;
    String Staff_id;
    faculty(String id){
    	setBackground(Color.white);
        setLayout(null);
        Staff_id=id;

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon("teacher.png");
        Image i2 = i1.getImage();
        Image temp = i2.getScaledInstance(700,500, Image.SCALE_SMOOTH);
		i1 = new ImageIcon(temp);
        l1.setIcon(i1);
        add(l1);


        l2 = new JLabel("Faculty");
        l2.setBounds(70,100,200,90);
        l2.setFont(new Font("serif",Font.BOLD,60));
        l2.setForeground(Color.black);
        l1.add(l2);

         b1=new JButton("Enter marks");
        b1.setBounds(70,275,200,30);
        b1.setFont(new Font("serif",Font.BOLD,20));
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Student details");
        b2.setBounds(70,320,200,30);
        b2.setFont(new Font("serif",Font.BOLD,20));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("edit marks");
        b3.setBounds(70,365,200,30);
        b3.setFont(new Font("serif",Font.BOLD,20));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("your details");
        b4.setBounds(70,410,200,30);
        b4.setFont(new Font("serif",Font.BOLD,20));
        b4.addActionListener(this);
        l1.add(b4);

        setVisible(true);
        setSize(700,500);
        setLocation(450,200);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                setVisible(false);
                new welcomepg();
            }
        });

        
     }
     public void actionPerformed(ActionEvent a){
        if(a.getSource()==b1)
           new marks();
        if(a.getSource()==b2)
            new viewstudent();
        if(a.getSource()==b3)
           new editmarks();
       if(a.getSource()==b4)
            new staff_data(Staff_id);
    }
    
   // public static void main(String[] args)
  // {
  // 	  new faculty();
  // }
}