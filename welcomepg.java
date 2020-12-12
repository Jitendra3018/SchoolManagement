package SchoolManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class welcomepg extends JFrame implements ItemListener,ActionListener{
	String person;
	JRadioButton r1, r2, r3;
	JPasswordField pass;
	JTextField user;
	public welcomepg()
	{	//font
		Font f = new Font("Serif", Font.BOLD, 50);

		//header
		JPanel heading;
		heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0,0,1200,100);
		JLabel name = new JLabel("DELHI PUBLIC SCHOOL, JODHPUR");
		name.setBounds(200, 50, 400, 80);
		name.setFont(f);
		heading.add(name);
		//login panel
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(500, 400);
		login.setBackground(new Color(0,0,0, 60));
		user = new JTextField("Enter UserID");
		user.setBounds(50,50,400,25);
		login.add(user);
		pass = new JPasswordField("Enter Password");
		pass.setBounds(50,80,400,25);
		login.add(pass);
		//adding radio buttons 
		ButtonGroup bg;
		r1 = new JRadioButton("Admin");
		r2 = new JRadioButton("Faculty");
		r3 = new JRadioButton("Student");

		r1.setBounds(50,110,125,25);
		r2.setBounds(185,110,125,25);
		r3.setBounds(320,110,125,25);

		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.addItemListener(this);

		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);

		login.add(r1);
		login.add(r2);
		login.add(r3);

		//submit button
		JButton submit;
		submit = new JButton("Submit");
		submit.setBounds(190,160, 125, 50);
		login.add(submit);
		submit.addActionListener(this);
		login.setBounds(400,200, 500, 400);
		//frame
		setSize(1200,540);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//background
		ImageIcon bgi = new ImageIcon("school.jpg");
		Image img = bgi.getImage();
		Image temp = img.getScaledInstance(1200,540, Image.SCALE_SMOOTH);
		bgi = new ImageIcon(temp);
		JLabel backgrnd = new JLabel("", bgi, JLabel.CENTER);
		backgrnd.setBounds(0,0,1200,540);
		add(backgrnd);
		backgrnd.add(heading);
		backgrnd.add(login);
		setVisible(true);

		 addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getItemSelectable()==r1)
			person = "loginadmin";
		else if(e.getItemSelectable()==r2)
			person = "loginfaculty";
		else if(e.getItemSelectable()==r3)
			person = "loginstudent";
		System.out.println(person);
	}

	public void actionPerformed(ActionEvent a){
		try{
			conn c1 = new conn();
			String name = user.getText();
			String security = pass.getText();
			String q = "select * from "+person+" where userid= "+name+" and password='"+security+"'";
			

			ResultSet rs = c1.s.executeQuery(q); 

            if(rs.next()){
            	if(person.equals("loginadmin"))
                	new adminpg().setVisible(true);
                else if(person.equals("loginfaculty"))
                	new faculty(name).setVisible(true);
                else
                	new students(name).setVisible(true);
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid login");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
	}

	public static void main(String[] Arga)
	{
		new welcomepg();
	}
}