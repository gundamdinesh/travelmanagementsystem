import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class ViewCustomer extends JFrame implements ActionListener{
    JLabel tusr,tid,tname,tgen,tcon,tmob,tadd,temail;
    JButton back;
    String username;
    ViewCustomer(String username)
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

       JLabel id =new JLabel("Id");
       id.setBounds(20, 80, 100, 20);
       id.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(id);

       tid = new JLabel("from database");
       tid.setBounds(200, 80, 150, 20);
       tid.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tid);

       JLabel name =new JLabel("Name");
       name.setBounds(20, 130, 100, 20);
       name.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(name);

       tname = new JLabel("from database");
       tname.setBounds(200, 130, 150, 20);
       tname.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tname);

       JLabel gender =new JLabel("Gender");
       gender.setBounds(20, 180, 100, 20);
       gender.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(gender);

       tgen = new JLabel("from database");
       tgen.setBounds(200, 180, 150, 20);
       tgen.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tgen);
       

       JLabel country =new JLabel("Country");
       country.setBounds(350, 30, 100, 23);
       country.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(country);

       tcon = new JLabel("from database");
       tcon.setBounds(530, 30, 150, 20);
       tcon.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tcon);


        JLabel mobile =new JLabel("Mobile No");
       mobile.setBounds(350, 80, 100, 23);
       mobile.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(mobile);

       tmob = new JLabel("from database");
       tmob.setBounds(530, 80, 150, 20);
       tmob.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tmob);
       

        JLabel address =new JLabel("Address");
       address.setBounds(350, 130, 100, 23);
       address.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(address);

       tadd = new JLabel("from database");
       tadd.setBounds(530, 130, 150, 20);
       tadd.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tadd);
       

        JLabel email =new JLabel("E-Mail");
       email.setBounds(350, 180, 100, 23);
       email.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(email);

       temail = new JLabel("from database");
       temail.setBounds(530, 180, 200, 20);
       temail.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(temail);

       back = new JButton("Back");
       back.setBounds(310, 230, 100, 25);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/viewall.jpg"));
       Image i2 = i1.getImage().getScaledInstance(750, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(0, 260, 750, 300);
       add(img);

       try{
          Conn cs = new Conn();
          String sql = "select * from customers where username = '"+username+"'";
          ResultSet rs = cs.s.executeQuery(sql);
          while(rs.next())
          {
            tusr.setText(rs.getString("username"));
            tid.setText(rs.getString("id"));
            tname.setText(rs.getString("name"));
            tgen.setText(rs.getString("gender"));
            tcon.setText(rs.getString("country"));
            tmob.setText(rs.getString("mobile"));
            tadd.setText(rs.getString("address"));
            temail.setText(rs.getString("email"));
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
        new ViewCustomer("");
    }
}
