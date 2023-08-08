import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener
{  
    JLabel tusr,tid,tphone,tprice;
    JLabel tpak,tac,tfood;
    JLabel tper;
    String username;
    JButton back,bookpakage , checkprice;
    ViewBookedHotel(String username)
    {
         this.username=username;
        setBounds(450,200,780,500);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

       JLabel usr =new JLabel("Username");
       usr.setBounds(20, 30, 200, 20);
       usr.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(usr);

       tusr = new JLabel("from database");
       tusr.setBounds(240, 30, 150, 20);
       tusr.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tusr);

       JLabel pak =new JLabel("Select Hotel");
       pak.setBounds(20, 80, 200, 20);
       pak.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(pak);
       
       tpak = new JLabel("from database");
       tpak.setBounds(240, 80, 230, 20);
       tpak.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tpak);

       JLabel toper =new JLabel("Total Person");
       toper.setBounds(20, 130, 200, 20);
       toper.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(toper);

       tper = new JLabel("from databse");
       tper.setBounds(240, 130, 50, 20);
       tper.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tper);

       JLabel ac =new JLabel("AC/Non-AC");
       ac.setBounds(20, 180, 200, 20);
       ac.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(ac);

       tac = new JLabel("from database");
       tac.setBounds(240, 180, 100, 20);
       tac.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tac);
    
      
       JLabel food =new JLabel("Food Required");
       food.setBounds(20, 230, 200, 23);
       food.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(food);

        tfood =new JLabel("from databse");
        tfood.setBounds(240, 230, 100, 20);
       tfood.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tfood);

       JLabel phone =new JLabel("Phone Number");
       phone.setBounds(20, 292, 200, 23);
       phone.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(phone);

       tphone = new JLabel("from database");
       tphone.setBounds(240, 292, 150, 20);
       tphone.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tphone);

     

       JLabel totalprice =new JLabel("Total Price");
       totalprice.setBounds(20, 350, 200, 23);
       totalprice.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(totalprice);  

       tprice = new JLabel("from database");
       tprice.setBounds(240, 350, 100, 20);
       tprice.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tprice); 

          try{
          Conn cs = new Conn();
          String sql = "select * from bookhotel where username = '"+username+"'";
          ResultSet rs = cs.s.executeQuery(sql);
          while(rs.next())
          {
            tusr.setText(rs.getString("username"));
            tphone.setText(rs.getString("phone"));
            tpak.setText(rs.getString("hotelname"));
            tac.setText(rs.getString("ac_mode"));
             tfood.setText(rs.getString("food_mode"));
             tper.setText(rs.getString("total_per"));
             tprice.setText(rs.getString("total_price"));

          }
          
       }
       catch (Exception e)
       {
        System.out.println(e);
       }

        back = new JButton("Back");
       back.setBounds(50, 400, 150, 30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);

      

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/book.jpg"));
       Image i2 = i1.getImage().getScaledInstance(400, 450, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(390, 50, 300, 350);
       add(img);

       JLabel book = new JLabel("Booked Hotel Details !");
       book.setBounds(400,10,400,40);
       book.setFont(new Font("Tohoma", Font.BOLD,30));
       book.setForeground(Color.ORANGE);
       add(book);

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
        new ViewBookedHotel("");
    }
    
}

