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

public class BookHotel extends JFrame implements ActionListener
{  
    JLabel tusr,tid,tphone,tprice;
    Choice tpak,tac,tfood;
    JTextField tper;
    String username;
    JButton back,bookpakage , checkprice;
    BookHotel(String username)
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
       String str[] = new String[]{"The Hotel Nayab","The Hotel Saadab","The Hotel Nimrah","The Hotel Nilofour","The Hotel Paradise","The Hotel Alpha","The Hotel Pista House","The Hotel Joint","The Hotel salimar","The Hotel Charminar"};
       tpak = new Choice();
       for(int i=0;i<str.length;i++)
       {
         tpak.add(str[i]);
       }
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

       JLabel ac =new JLabel("AC/Non-AC");
       ac.setBounds(20, 180, 200, 20);
       ac.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(ac);

       tac = new Choice();
       tac.add("Yes");
       tac.add("No");
       tac.setBounds(240, 180, 100, 20);
       tac.setFont(new Font("Tohoma", Font.PLAIN, 15));
       add(tac);
    
      
       JLabel food =new JLabel("Food Required");
       food.setBounds(20, 230, 200, 23);
       food.setFont(new Font("Tohoma", Font.BOLD, 20));
       add(food);

        tfood =new Choice();
        tfood.add("Yes");
        tfood.add("No");
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

       tprice = new JLabel("0");
       tprice.setBounds(240, 350, 100, 20);
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
          }
          
       }
       catch (Exception e)
       {
        System.out.println(e);
       }
      
       checkprice = new JButton("Check price");
       checkprice.setBounds(20, 400, 150, 30);
       checkprice.setBackground(Color.BLACK);
       checkprice.setForeground(Color.WHITE);
       checkprice.addActionListener(this);
       add(checkprice);

       bookpakage = new JButton("Book Hotel");
       bookpakage.setBounds(200, 400, 150, 30);
       bookpakage.setBackground(Color.BLACK);
       bookpakage.setForeground(Color.WHITE);
       bookpakage.addActionListener(this);
       add(bookpakage);

       back = new JButton("Back");
       back.setBounds(380, 400, 150, 30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/book.jpg"));
       Image i2 = i1.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(370, 20, 370, 400);
       add(img);

       JLabel book = new JLabel("BOOK Hotel !");
       book.setBounds(440,10,300,40);
       book.setFont(new Font("Tohoma", Font.BOLD,30));
       book.setForeground(Color.ORANGE);
       add(book);

    }

    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==checkprice)
        {   

              int c=0;
             String str = tpak.getSelectedItem();
            
             int ac=0;
             int percost=0;
             int foodcost=0;
            String sql ="select * from hotels where name = '"+tpak.getSelectedItem()+"'";
            
            try{
                Conn cs = new Conn();
                ResultSet rs = cs.s.executeQuery(sql);
                while(rs.next())
                {
                    ac=Integer.parseInt(rs.getString("accost"));
                    percost=Integer.parseInt(rs.getString("percost"));
                    foodcost=Integer.parseInt(rs.getString("foodcost"));

                }
   
            }
            catch(Exception e){}
            c=c+Integer.parseInt(tper.getText())*percost;
            if(tac.getSelectedItem()=="Yes")
            {
                c=c+ac;
            }
            if(tfood.getSelectedItem()=="Yes")
            {
                 c=c+Integer.parseInt(tper.getText())*foodcost;
            }
             tprice.setText("Rs"+c);
        }
        else if(ae.getSource()==bookpakage)
        {  
             //for direct book click
            int c=0;
             String str = tpak.getSelectedItem();
            
             int ac=0;
             int percost=0;
             int foodcost=0;
            String sql1 ="select * from hotels where name = '"+tpak.getSelectedItem()+"'";
            
            try{
                Conn cs = new Conn();
                ResultSet rs = cs.s.executeQuery(sql1);
                while(rs.next())
                {
                    ac=Integer.parseInt(rs.getString("accost"));
                    percost=Integer.parseInt(rs.getString("percost"));
                    foodcost=Integer.parseInt(rs.getString("foodcost"));

                }
   
            }
            catch(Exception e){}
            c=c+Integer.parseInt(tper.getText())*percost;
            if(tac.getSelectedItem()=="Yes")
            {
                c=c+ac;
            }
            if(tfood.getSelectedItem()=="Yes")
            {
                 c=c+Integer.parseInt(tper.getText())*foodcost;
            }
             tprice.setText("Rs"+c);




             
              try{
          Conn cs = new Conn();
          String sql = "insert into bookhotel values('"+username+"','"+tpak.getSelectedItem()+"','"+tper.getText()+"','"+tac.getSelectedItem()+"','"+tfood.getSelectedItem()+"','"+tphone.getText()+"','"+c+"')";
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
        new BookHotel("");
    }
    
}
