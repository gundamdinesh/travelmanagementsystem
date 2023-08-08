import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Payments extends JFrame implements ActionListener{
 
    JButton back ,pay;
    String username;
    Payments(String username)
    {
        this.username=username;
        setBounds(450,200,780,500);
        setLayout(null);
        setVisible(true);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/paytm.jpeg"));
       Image i2 = i1.getImage().getScaledInstance(780, 500, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(0, 0, 780, 500);
       add(img);

        back = new JButton("Back");
       back.setBounds(500,10,100,30);
       back.setBackground(Color.BLUE);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       img.add(back);

        pay = new JButton("Pay");
       pay.setBounds(630,10,100,30);
       pay.setBackground(Color.BLUE);
       pay.setForeground(Color.WHITE);
       pay.addActionListener(this);
       img.add(pay);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==pay)
        {
            setVisible(false);
             new Paytm(username);
        }
        else
        {
            setVisible(false);
            new Dashboard(username); 
        }
    }
    public static void main(String[] args) {
        new Payments("");
    }
    
}
