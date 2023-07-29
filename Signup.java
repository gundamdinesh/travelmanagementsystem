import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;
public class Signup extends JFrame implements ActionListener{
  JButton create,back;
  JTextField tuser, tname, tpass, ans;
  Choice security;
    Signup()
    {
        setBounds(350,200,900,360);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null); // must be used to make work of setBounds
        JPanel p1 = new JPanel();
        p1.setBackground(Color.GRAY);
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

         JLabel user = new JLabel("Username");
         user.setFont(new Font("Tohoma",Font.PLAIN,20));
         user.setBounds(10,20,125,25);
         p1.add(user); 

         tuser = new JTextField();
        tuser.setBounds(10 ,55 ,200 ,30);
        tuser.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tuser);

        JLabel name = new JLabel("Name");
         name.setFont(new Font("Tohoma",Font.PLAIN,20));
        name.setBounds(10,85,125,25);
         p1.add(name); 

        tname = new JTextField();
        tname.setBounds(10 ,115 ,200 ,30);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tname);

         JLabel pass = new JLabel("Password");
         pass.setFont(new Font("Tohoma",Font.PLAIN,20));
        pass.setBounds(10,145,125,25);
         p1.add(pass); 

           tpass = new JTextField();
        tpass.setBounds(10 ,175 ,200 ,30);
        tpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tpass); 

         JLabel sec = new JLabel("Security Question");
         sec.setFont(new Font("Tohoma",Font.PLAIN,15));
        sec.setBounds(10,205,125,25);
         p1.add(sec); 
        
          security = new Choice();
         security.add("enter your lucky number");
         security.add("enter your nick name ");
         security.add("enter your friend name");

         security.setBounds(10, 235, 200, 25);
         p1.add(security);

        ans = new JTextField();
        ans.setBounds(10 ,265 ,200 ,30);
        ans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(ans);

        create = new JButton("Create");
        create.setBounds(250, 260, 100, 50);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(131,120,111));
        create.addActionListener(this);
        p1.add(create);

        back= new JButton("Back");
        back.setBounds(380, 260, 100, 50);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(131,120,111));
        back.addActionListener(this);
        p1.add(back);

  
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/signup.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(600, 70, 200, 200);
        add(l6);


        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource() == create)
      { 
        try 
         {
           String username = tuser.getText();
           String name = tname.getText();
           String pasword = tpass.getText();
           String  question = security.getSelectedItem();
           String answer = ans.getText(); 
           String sql = "insert into account values('"+username+"','"+name+"','"+pasword+"','"+question+"','"+answer+"')";
           Conn cs = new Conn();
           cs.s.executeUpdate(sql);
           JOptionPane.showMessageDialog(null, "inserted sucessfully"); 
         }
         catch(Exception e){
          System.out.println(e); 
         }

      }
      else if(ae.getSource() == back)
      { 
        setVisible(false);
        new Login();

      }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
