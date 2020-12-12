package SchoolManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminpg extends JFrame implements ActionListener{
	
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;

    adminpg(){
        setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon("admin.jpg");
        Image i2 = i1.getImage();
        Image temp = i2.getScaledInstance(700,500, Image.SCALE_SMOOTH);
		i1 = new ImageIcon(temp);
        l1.setIcon(i1);
        add(l1);

        l2 = new JLabel("Administration");
        l2.setBounds(250,20,200,50);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1=new JButton("Add Student");
        b1.setBounds(50,100,100,40);
        b1.setFont(new Font("serif",Font.BOLD,10));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("update Students");
        b2.setBounds(50,180,100,40);
        b2.setFont(new Font("serif",Font.BOLD,10));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove Student");
        b3.setBounds(50,260,100,40);
        b3.setFont(new Font("serif",Font.BOLD,10));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Student details");
        b4.setBounds(50,340,100,40);
        b4.setFont(new Font("serif",Font.BOLD,10));
        b4.addActionListener(this);
        l1.add(b4);

        b5=new JButton("Add Staff");
        b5.setBounds(530,100,100,40);
        b5.setFont(new Font("serif",Font.BOLD,10));
        b5.addActionListener(this);
        l1.add(b5);


        b6=new JButton("update Staff");
        b6.setBounds(530,180,100,40);
        b6.setFont(new Font("serif",Font.BOLD,10));
        b6.addActionListener(this);
        l1.add(b6);

        b7=new JButton("Remove Staff");
        b7.setBounds(530,260,100,40);
        b7.setFont(new Font("serif",Font.BOLD,10));
        b7.addActionListener(this);
        l1.add(b7);

        b8=new JButton("Staff details");
        b8.setBounds(530,340,100,40);
        b8.setFont(new Font("serif",Font.BOLD,10));
        b8.addActionListener(this);
        l1.add(b8);

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
           new addstudent();
        if(a.getSource()==b2)
            new editstudent();
        if(a.getSource()==b3)
           new removestudent();
        if(a.getSource()==b4)
            new viewstudent();
        if(a.getSource()==b5)
            new addstaff();
        if(a.getSource()==b6)
            new editstaff();
        if(a.getSource()==b7)
            new removestaff();
        if(a.getSource()==b8)
            new viewstaff();
    }
   // public static void main(String[] args)
   //{
   //	new adminpg();
   // }
}