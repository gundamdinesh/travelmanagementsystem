import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class AddCustomer extends JFrame implements ActionListener 
{  
    JButton add,back;
    JLabel tusr,tname;
    JComboBox select;
     JRadioButton radiom,radiof;
     JTextField cn,pn,ad,email;
     String username;
    AddCustomer(String username)
    {
        this.username=username;
       setBounds(450,200,850,550);
       setLayout(null);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);

       JLabel usr =new JLabel("Username");
       usr.setBounds(20, 30, 100, 20);
       usr.setFont(new Font("Tohoma", Font.BOLD, 15));
       add(usr);

       tusr = new JLabel("from database");
       tusr.setBounds(200, 30, 150, 20);
       add(tusr);

       JLabel id =new JLabel("Id");
       id.setBounds(20, 80, 100, 20);
       id.setFont(new Font("Tohoma", Font.BOLD, 15));
       add(id);

        select = new JComboBox(new String[]{"Passport","Aadhar Card","Pan Card","Voter Id"});
       select.setBounds(200, 80, 200, 20);
       select.setBackground(Color.WHITE);
       add(select);

       JLabel name =new JLabel("Name");
       name.setBounds(20, 130, 100, 20);
       name.setFont(new Font("Tohoma", Font.BOLD, 15));
       add(name);

       tname = new JLabel("from database");
       tname.setBounds(200, 130, 150, 20);
       add(tname);

       JLabel gender =new JLabel("Gender");
       gender.setBounds(20, 180, 100, 20);
       gender.setFont(new Font("Tohoma", Font.BOLD, 15));
       add(gender); 

        radiom = new JRadioButton("Male");
       radiom.setBounds(200, 180, 100, 20);
       radiom.setBackground(Color.WHITE);
       add(radiom);

        radiof = new JRadioButton("Female");
       radiof.setBounds(320, 180, 100, 20);
       radiof.setBackground(Color.WHITE);
       add(radiof);

       ButtonGroup radio = new ButtonGroup();
       radio.add(radiom);
       radio.add(radiof);

       JLabel country =new JLabel("Country");
       country.setBounds(20, 230, 100, 20);
       country.setFont(new Font("Tohoma", Font.BOLD, 15));
       add(country);

        cn = new JTextField();
       cn.setBounds(200, 230, 100, 20);
       add(cn);


        JLabel number =new JLabel("Mobile No");
       number.setBounds(20, 280, 100, 20);
       number.setFont(new Font("Tohoma", Font.BOLD, 15));
       add(number);

        pn = new JTextField();
       pn.setBounds(200, 280, 100, 20);
       add(pn);
       


       JLabel Address =new JLabel("Address");
       Address.setBounds(20, 330, 200, 20);
       Address.setFont(new Font("Tohoma", Font.BOLD, 15));
       add(Address);

        ad = new JTextField();
       ad.setBounds(200, 330, 100, 20);
       add(ad);

        JLabel emailid =new JLabel("Email Id");
       emailid.setBounds(20, 380, 100, 20);
       emailid.setFont(new Font("Tohoma", Font.BOLD, 15));
       add(emailid);

        email = new JTextField();
       email.setBounds(200, 380, 200, 20);
       add(email);


       add = new JButton("Add");
       add.setBounds(250, 430, 100, 35);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add.addActionListener(this);
       add(add);

       back = new JButton("Back");
       back.setBounds(400, 430, 100, 35);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/newcustomer.jpg"));
       Image i2 = i1.getImage().getScaledInstance(520, 600, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(510, 10, 320, 500);
       add(img);
    
       try{
         Conn cs = new Conn();
         String sql = "select * from account where username='"+username+"'";
         ResultSet rs = cs.s.executeQuery(sql);
         while(rs.next())
         {
           tusr.setText(rs.getString("username"));
           tname.setText(rs.getString("name"));
         }
       }
       catch(Exception e)
       {
        System.out.println(e);
       }
       
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            String username =tusr.getText();
            String id = (String) select.getSelectedItem();
            String name = tname.getText();
            String gender = null;
            if(radiof.isSelected())
            {
                gender="Female";
            }
            else
            {
                gender="Male";
            }
            String country = cn.getText();
            String Mobile = pn.getText();
            String Address = ad.getText();
            String Email = email.getText();
            
            String sql = "insert into customers values('"+username+"','"+id+"','"+name+"','"+gender+"','"+country+"','"+Mobile+"','"+Address+"','"+Email+"')";
            try{
                Conn cs = new Conn();
                cs.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"added details sucessfully");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
        else{
            setVisible(false);
            new Dashboard(username);
        }
    }
    public static void main(String[] args) {
        new AddCustomer("");
    }
}