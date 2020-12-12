package SchoolManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class viewstudent implements ActionListener
{

    JFrame f;
    JTextField t;
    JLabel l2;
    JButton b,b2;

    viewstudent(){
        f=new JFrame("View");
        f.setBackground(Color.green);
        f.setLayout(null);

        l2=new JLabel("Student Id");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.BLUE);
        Font F1 = new Font("serif",Font.BOLD,30);
        l2.setFont(F1); 
        f.add(l2);
        
        t=new JTextField();
        t.setBounds(240,60,220,30);
        f.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        f.add(b);

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        f.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            f.setVisible(false);
        }
        if(ae.getSource()==b){
            new student_data(t.getText());
        }

    }
    public static void main(String[] args){
        new viewstudent();
    }
}