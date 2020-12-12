package SchoolManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class students extends JFrame implements ActionListener{
	
    String sid;
    JLabel l1,l2;
    JButton b1,b2,b3,b4;

    students(String id){
    	setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon("studentimg.png");
        Image i2 = i1.getImage();
        Image temp = i2.getScaledInstance(700,500, Image.SCALE_SMOOTH);
		i1 = new ImageIcon(temp);
        l1.setIcon(i1);
        add(l1);

        sid = id;

        l2 = new JLabel("Student");
        l2.setBounds(70,30,200,90);
        l2.setFont(new Font("serif",Font.BOLD,60));
        l2.setForeground(Color.black);
        l1.add(l2);

         b1=new JButton("View Details");
        b1.setBounds(70,130,200,30);
        b1.setFont(new Font("serif",Font.BOLD,20));
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("View Marks");
        b2.setBounds(70,180,200,30);
        b2.setFont(new Font("serif",Font.BOLD,20));
        b2.addActionListener(this);
        l1.add(b2);

        
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
     public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            new student_data(sid);
        }
        else if(ae.getSource() == b2){
            new viewmarks(sid);
        }
    }

  /*    public static void main(String[] args)
   {
   	  new students();
   }*/
}