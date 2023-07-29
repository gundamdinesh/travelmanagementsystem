import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tusename,tname,tsecurity,tans,tpass;
    JButton search,retrive,back;
    ForgetPassword()
    {
      setBounds(350,200,850,380);
      setVisible(true);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/forgotpassword.jpg"));
      Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(580,70,200,200);
      add(image);
      JPanel p1 = new JPanel();
      p1.setLayout(null);
      p1.setBounds(10, 30, 500,300 );
      add(p1);

      JLabel usrname = new JLabel("UserName");
      usrname.setBounds(25, 20, 100, 30);
      usrname.setFont(new Font("Tohoma",Font.BOLD ,15));
      p1.add(usrname);
    
      tusename = new JTextField();
      tusename.setBounds(125, 20, 200, 30);
      tusename.setBorder(null);
      p1.add(tusename); 

      search = new JButton("Search");
      search.setBounds(340, 20, 100 , 30);
      search.setBackground(Color.GRAY);
      search.setForeground(Color.WHITE);
      search.addActionListener(this);
      p1.add(search);
      
     


      JLabel name = new JLabel("Name");
      name.setBounds(25, 55, 100, 30);
      name.setFont(new Font("Tohoma",Font.BOLD ,15));
      p1.add(name);
    
      tname = new JTextField();
      tname.setBounds(125, 55, 200, 30);
      tname.setBorder(null);
      p1.add(tname);  


      JLabel security = new JLabel("Security");
      security.setBounds(25, 90, 100, 30);
      security.setFont(new Font("Tohoma",Font.BOLD ,15));
      p1.add(security);
    
      tsecurity = new JTextField();
      tsecurity.setBounds(125, 90, 200, 30);
      tsecurity.setBorder(null);
      p1.add(tsecurity);  


      JLabel ans = new JLabel("Answer");
      ans.setBounds(25, 130, 100, 30);
      ans.setFont(new Font("Tohoma",Font.BOLD ,15));
      p1.add(ans);
    
      tans = new JTextField();
      tans.setBounds(125, 130, 200, 30);
      tans.setBorder(null);
      p1.add(tans);  
      
      retrive = new JButton("retrieve");
      retrive.setBounds(340, 130, 100 , 30);
      retrive.setBackground(Color.GRAY);
      retrive.setForeground(Color.WHITE);
      retrive.addActionListener(this);
      p1.add(retrive);


      JLabel pass = new JLabel("Password");
      pass.setBounds(25, 170, 100, 30);
      pass.setFont(new Font("Tohoma",Font.BOLD ,15));
      p1.add(pass);
    
      tpass = new JTextField();
      tpass.setBounds(125, 170, 200, 30);
      tpass.setBorder(null);
      p1.add(tpass);  
      
      back = new JButton("Back");
      back.setBounds(200, 250, 100 , 30);
      back.setBackground(Color.GRAY);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);
      p1.add(back);


    }
   
    public void actionPerformed(ActionEvent ae)
    {
      try{
       Conn cs = new Conn();
       if(ae.getSource()== search)
       {
           
            String sql = "select * from account where username='"+tusename.getText()+"'";
            ResultSet rs = cs.s.executeQuery(sql);
            while(rs.next())
            {
               tname.setText(rs.getString("name"));
               tsecurity.setText(rs.getString("question"));
            }

       }
       else if(ae.getSource()== retrive)
       {
          String s = tans.getText();
          String sql = "select * from account where username='"+tusename.getText()+"' and answer='"+tans.getText()+"'";
          ResultSet rs = cs.s.executeQuery(sql);
           while(rs.next())
            {
                tpass.setText(rs.getString("pass"));
            }
         
       }
       else if(ae.getSource()==back)
       {     
            setVisible(false);
             new Login();
       }
        }  
          catch(Exception e)
          {
            
          }
    }
     public static void main(String[] args) {
        new ForgetPassword();
    }
}
