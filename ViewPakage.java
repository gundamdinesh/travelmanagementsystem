import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class ViewPakage extends JFrame implements ActionListener{
    JLabel tusr,temail,tprice,tpak,tpn,tper;
    JButton back;
    String username;
    ViewPakage(String username)
    { 
        this.username=username;
        setBounds(450,200,780,500);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

       JLabel usr =new JLabel("Username");
       usr.setBounds(20, 30, 100, 20);
       usr.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(usr);

       tusr = new JLabel("from database");
       tusr.setBounds(200, 30, 150, 20);
       tusr.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tusr);

       JLabel pakage =new JLabel("Pakage");
       pakage.setBounds(20, 80, 100, 23);
       pakage.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(pakage);

       tpak = new JLabel("from database");
       tpak.setBounds(200, 80, 150, 20);
       tpak.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tpak);

       JLabel toper =new JLabel("Total Persons");
       toper.setBounds(20, 130, 200, 20);
       toper.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(toper);

       tper = new JLabel("from database");
       tper.setBounds(200, 130, 150, 20);
       tper.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tper);

       JLabel email =new JLabel("Email");
       email.setBounds(20, 180, 100, 20);
       email.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(email);

       temail = new JLabel("from database");
       temail.setBounds(200, 180, 200, 20);
       temail.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(temail);
       

       JLabel phone =new JLabel("Phone No");
       phone.setBounds(20, 230, 100, 23);
       phone.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(phone);

       tpn = new JLabel("from database");
       tpn.setBounds(200, 230, 150, 20);
       tpn.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tpn);


       JLabel price =new JLabel("Total Price");
       price.setBounds(20, 280, 150, 23);
       price.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(price);

       tprice = new JLabel("from database");
       tprice.setBounds(200, 280, 150, 20);
       tprice.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tprice);
       


       back = new JButton("Back");
       back.setBounds(90, 350, 100, 30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/bookedDetails.jpg"));
       Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(180, 30, 750, 300);
       add(img);
  
       try{
          Conn cs = new Conn();
          String sql = "select * from bookpakage where username = '"+username+"'";
          ResultSet rs = cs.s.executeQuery(sql);
          while(rs.next())
          {
            tusr.setText(rs.getString("username"));
            tpak.setText(rs.getString("pakage"));
            tper.setText(rs.getString("total_person"));
            temail.setText(rs.getString("email"));
            tpn.setText(rs.getString("phone"));
            tprice.setText(rs.getString("total_price"));
          
          }
          
       }
       catch (Exception e)
       {
        System.out.println(e);
       }
       


    }

    public void actionPerformed(ActionEvent ae)
    { 
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Dashboard(username);
        }

    }
    public static void main(String[] args) {
        new ViewPakage("");
    }
}

