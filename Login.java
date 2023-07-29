import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements ActionListener{
    JButton forgetpassword,signup,login;
    JTextField tpass,tuser;
    Login()
    {
        setSize(800,400);
        setLocation(300,300); 
        setVisible(true);
        setLayout(null); //must be null to not use swing laylouts
        getContentPane().setBackground(Color.WHITE);
        JPanel p1 = new JPanel(); 
        p1.setLayout(null);

        p1.setBackground(new Color(131,120,111));
        p1.setBounds(0, 0, 300, 400);//layout size
       
        add(p1);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel( i3);
        image.setBounds(50, 70, 200, 200);
        p1.add(image);
       
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds( 300,0,500,400);
        add(p2); 

        JLabel user = new JLabel("Username");
        user.setBounds(30, 0, 100, 55);
        user.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(user); 

         tuser = new JTextField();
        tuser.setBounds(30 ,50 ,300 ,50);
        tuser.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tuser);
    
        JLabel pass = new JLabel("Password");
        pass.setBounds(30, 100, 100, 55);
        pass.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(pass); 

         tpass = new JTextField();
        tpass.setBounds(30 ,150 ,300 ,50);
        tpass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tpass);
        

        login = new JButton("Login");
        login.setBounds(40, 220, 100, 50);
        login.setBackground(new Color(131,120,111));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(150, 220, 100, 50);
        signup.setBackground(new Color(131,120,111));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        p2.add(signup);

        forgetpassword = new JButton("forget");
        forgetpassword.setBounds(90, 280, 100, 30);
        forgetpassword.setBackground(new Color(131,120,111));
        forgetpassword.setForeground(Color.WHITE);
         forgetpassword.addActionListener(this);
        p2.add(forgetpassword);
        
    } 
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login)
        {
            try{
                 String username = tuser.getText();
                 String password = tpass.getText();

                 String sql = "select * from account where username='"+username+"' and pass='"+password+"'";

                 Conn cs = new Conn();
                 ResultSet rs =cs.s.executeQuery(sql);
                 if(rs.next())
                 {
                    setVisible(false);
                    new Loading(tuser.getText());
                 }
                 else
                 {
                    JOptionPane.showMessageDialog(null,"please enter correct login credentials");
                 }

            }
            catch(Exception e){}
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new Signup();
        }
        else
        {
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}

