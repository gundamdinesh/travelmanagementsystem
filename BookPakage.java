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

public class BookPakage extends JFrame implements ActionListener
{  
    JLabel tusr,tid,tphone,temail,tprice;
    Choice tpak;
    JTextField tper;
    String username;
    JButton back,bookpakage , checkprice;
    BookPakage(String username)
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

       JLabel pak =new JLabel("Select Pakage");
       pak.setBounds(20, 80, 200, 20);
       pak.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(pak);

       tpak = new Choice();
       tpak.add("GOLD PAKAGE");
       tpak.add("SILVER PAKAGE");
       tpak.add("BRONZE PAKAGE");
       tpak.setBounds(240, 80, 230, 20);
       tpak.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tpak);

       JLabel toper =new JLabel("Total Person");
       toper.setBounds(20, 130, 200, 20);
       toper.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(toper);

       tper = new JTextField("1");
       tper.setBounds(240, 130, 50, 20);
       tper.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tper);

       JLabel email =new JLabel("Email Id");
       email.setBounds(20, 180, 100, 20);
       email.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(email);

       temail = new JLabel("from database");
       temail.setBounds(240, 180, 200, 20);
       temail.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(temail);
       

       JLabel phone =new JLabel("Phone No");
       phone.setBounds(20, 230, 200, 23);
       phone.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(phone);

       tphone = new JLabel("from database");
       tphone.setBounds(240, 230, 150, 20);
       tphone.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tphone);

       JLabel totalprice =new JLabel("Total Price");
       totalprice.setBounds(20, 292, 200, 23);
       totalprice.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(totalprice);

       tprice = new JLabel("0");
       tprice.setBounds(240, 292, 150, 20);
       tprice.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tprice);

          try{
          Conn cs = new Conn();
          String sql = "select * from customers where username = '"+username+"'";
          ResultSet rs = cs.s.executeQuery(sql);
          while(rs.next())
          {
            tusr.setText(rs.getString("username"));
            tphone.setText(rs.getString("mobile"));
            temail.setText(rs.getString("email"));
          }
          
       }
       catch (Exception e)
       {
        System.out.println(e);
       }
      
       checkprice = new JButton("Check price");
       checkprice.setBounds(20, 350, 150, 30);
       checkprice.setBackground(Color.BLACK);
       checkprice.setForeground(Color.WHITE);
       checkprice.addActionListener(this);
       add(checkprice);

       bookpakage = new JButton("Book Pakage");
       bookpakage.setBounds(200, 350, 150, 30);
       bookpakage.setBackground(Color.BLACK);
       bookpakage.setForeground(Color.WHITE);
       bookpakage.addActionListener(this);
       add(bookpakage);

       back = new JButton("Back");
       back.setBounds(380, 350, 150, 30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/bookpackage.jpg"));
       Image i2 = i1.getImage().getScaledInstance(350, 150, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(440, 10, 300, 370);
       add(img);

       JLabel book = new JLabel("BOOK PAKAGE !");
       book.setBounds(440,10,300,40);
       book.setFont(new Font("Tohoma", Font.BOLD,30));
       book.setForeground(Color.ORANGE);
       add(book);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==checkprice)
        {
             String str = tpak.getSelectedItem();
             int c=0;
             if(str=="GOLD PAKAGE")
             {
                 c=18000;
             }
             else if(str =="SILVER PAKAGE")
             {
                 c=12000;
             }
             else 
             {
                 c=8000;
             }
             int p = Integer.parseInt(tper.getText());
             c=p*c;

             tprice.setText("Rs"+c);
        }
        else if(ae.getSource()==bookpakage)
        {  
             String str = tpak.getSelectedItem();
             int c=0;
             if(str=="GOLD PAKAGE")
             {
                 c=18000;
             }
             else if(str =="SILVER PAKAGE")
             {
                 c=12000;
             }
             else 
             {
                 c=8000;
             }
             int p = Integer.parseInt(tper.getText());
             c=p*c;

             tprice.setText("Rs"+c);
             
              try{
          Conn cs = new Conn();
          String sql = "insert into bookpakage values('"+username+"','"+tpak.getSelectedItem()+"','"+tper.getText()+"','"+temail.getText()+"','"+tphone.getText()+"','"+c+"')";
           cs.s.executeUpdate(sql);
          JOptionPane.showMessageDialog(null,"Booked Sucessfully");
          }
          catch (Exception e)
          {
          System.out.println(e);
         }

        }
        else
        {
             
             setVisible(false);
             new Dashboard(username);
        }
    }

    public static void main(String[] args) {
        new BookPakage("");
    }
    
}
