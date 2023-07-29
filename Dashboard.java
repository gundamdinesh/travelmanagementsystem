import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton b1,b3;
    Dashboard(String username)
    { 
        this.username=username;
       setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen
       setVisible(true);
       setLayout(null);

       JPanel p1 = new JPanel();
       p1.setLayout(null);
       p1.setBackground(Color.GRAY);
       p1.setBounds(0, 0, 1600, 60);
       add(p1);

       ImageIcon i =new ImageIcon(ClassLoader.getSystemResource("icons/icons/dashboard.png"));
       Image i2 = i.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
       ImageIcon i3  = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(5,0,70,70);
       p1.add(image);

       JLabel dash = new JLabel("Dashboard");
       dash.setFont(new Font("Tohoma", Font.BOLD, 35));
       dash.setBounds(90,20,500, 30);
       p1.add(dash); 

       JPanel p2 = new JPanel();
       p2.setLayout(null);
       p2.setBackground(Color.GRAY);
       p2.setBounds(0,60,350,1600);
       add(p2);

        b1 = new JButton("Add Personal Details");
       b1.setBounds(30, 30, 300, 30);
       b1.setBackground(Color.WHITE);
       b1.setForeground(Color.GRAY);
       b1.addActionListener(this);
       p2.add(b1);

       JButton b2 = new JButton("Update Personal Details");
       b2.setBounds(30, 70, 300, 30);
       b2.setBackground(Color.WHITE);
       b2.setForeground(Color.GRAY);
       p2.add(b2);

        b3 = new JButton("View Details");
       b3.setBounds(30, 110, 300, 30);
       b3.setBackground(Color.WHITE);
       b3.setForeground(Color.GRAY);
       b3.addActionListener(this);
       p2.add(b3);

       JButton b4 = new JButton("Delete Personal Details");
       b4.setBounds(30, 150, 300, 30);
       b4.setBackground(Color.WHITE);
       b4.setForeground(Color.GRAY);
       p2.add(b4);

       JButton b5 = new JButton("Check Pakage");
       b5.setBounds(30, 190, 300, 30);
       b5.setBackground(Color.WHITE);
       b5.setForeground(Color.GRAY);
       p2.add(b5);

       JButton b6 = new JButton("Book Pakage");
       b6.setBounds(30, 230, 300, 30);
       b6.setBackground(Color.WHITE);
       b6.setForeground(Color.GRAY);
       p2.add(b6);

       JButton b7 = new JButton("View Pakage");
       b7.setBounds(30, 270, 300, 30);
       b7.setBackground(Color.WHITE);
       b7.setForeground(Color.GRAY);
       p2.add(b7);

       JButton b8 = new JButton("View Hotels");
       b8.setBounds(30, 310, 300, 30);
       b8.setBackground(Color.WHITE);
       b8.setForeground(Color.GRAY);
       p2.add(b8);

       JButton b9 = new JButton("Book Hotel");
       b9.setBounds(30, 350, 300, 30);
       b9.setBackground(Color.WHITE);
       b9.setForeground(Color.GRAY);
       p2.add(b9);

       JButton b10 = new JButton("View Booked Hotel");
       b10.setBounds(30, 390, 300, 30);
       b10.setBackground(Color.WHITE);
       b10.setForeground(Color.GRAY);
       p2.add(b10);

       JButton b11 = new JButton("Destinations");
       b11.setBounds(30, 430, 300, 30);
       b11.setBackground(Color.WHITE);
       b11.setForeground(Color.GRAY);
       p2.add(b11);

       JButton b12 = new JButton("Payments");
       b12.setBounds(30, 470, 300, 30);
       b12.setBackground(Color.WHITE);
       b12.setForeground(Color.GRAY);
       p2.add(b12);

       JButton b13 = new JButton("Calculator");
       b13.setBounds(30, 510, 300, 30);
       b13.setBackground(Color.WHITE);
       b13.setForeground(Color.GRAY);
       p2.add(b13);

       JButton b14 = new JButton("Notepad");
       b14.setBounds(30, 550, 300, 30);
       b14.setBackground(Color.WHITE);
       b14.setForeground(Color.GRAY);
       p2.add(b14);

       JButton b15 = new JButton("About");
       b15.setBounds(30, 590, 300, 30);
       b15.setBackground(Color.WHITE);
       b15.setForeground(Color.GRAY);
       p2.add(b15); 

       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/icons/home.jpg"));
       Image i4 = i1.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
       ImageIcon i5  = new ImageIcon(i4);
       JLabel img = new JLabel(i5);
       img.setBounds(0,0,1650,1000);
       add(img); 

       JLabel text = new JLabel("Travel and Tourism Management System");
       text.setBounds(550, 70, 800, 50);
       text.setFont(new Font("Tohoma",Font.BOLD,40));
       img.add(text);


  

     

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new AddCustomer(username);
        }
        else if(ae.getSource()==b3)
        {
            new ViewCustomer(username);
        }
    }
     public static void main(String[] args)
    {
        
        new Dashboard("");
    }
    
}
