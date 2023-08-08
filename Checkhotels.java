import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Checkhotels extends JFrame implements ActionListener
 {
    String s[] = new String[]{"icons/icons/hotel1.jpg","icons/icons/hotel2.jpg","icons/icons/hotel3.jpg","icons/icons/hotel4.jpg","icons/icons/hotel5.jpg","icons/icons/hotel6.jpg","icons/icons/hotel7.jpg","icons/icons/hotel8.jpg","icons/icons/hotel9.jpg","icons/icons/hotel10.jpg"};
    String str[] = new String[]{"The Hotel Nayab","The Hotel Saadab","The Hotel Nimrah","The Hotel Nilofour","The Hotel Paradise","The Hotel Alpha","The Hotel Pista House","The Hotel Joint","The Hotel salimar","The Hotel Charminar"};
     int i=0;
     JButton b1;
     ImageIcon i1;
     JLabel i4;
     JLabel lbl;
    Checkhotels()
    {
    setBounds(500,200,800,400);
    setLayout(null);
    setVisible(true);

     i1 = new ImageIcon((s[i]));
    Image i2 = i1.getImage().getScaledInstance(800,400,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
     i4 = new JLabel(i3);
    i4.setBounds(0, 0, 800, 400);
    add(i4);
 
    JPanel p = new JPanel();
    p.setLayout(null);
    p.setBounds(450, 300, 400, 30);
    i4.add(p);
    
    lbl = new JLabel(str[i]);
    lbl.setBounds(0, 0, 400, 30);
    lbl.setFont(new Font("Tohoma",Font.BOLD,30));
    lbl.setForeground(Color.BLACK);
    p.add(lbl);

     b1 = new JButton("<<");
    b1.setBounds(500, 20, 100, 30);
    b1.addActionListener(this);
    i4.add(b1);

    JButton b2 = new JButton(">>");
    b2.setBounds(610, 20, 100, 30);
    b2.addActionListener(this);
    i4.add(b2); 

   

   }
   

   public void actionPerformed(ActionEvent ae)
   {
    
     if(ae.getSource()== b1)
     {
        if(i==0)
        {
          //i4.setIcon(new ImageIcon(s[i]));
            JOptionPane.showMessageDialog(null, "This is First Image");
        }
      
         else
        {
            i--;
          i4.setIcon(new ImageIcon(s[i]));
          lbl.setText(str[i]);
          
        }
      
     }
     else{
        if(i==s.length-1)
        {
            JOptionPane.showMessageDialog(null, "This is Last Image");
        }
        else if(i<=s.length)
        {
            i++;
            i4.setIcon(new ImageIcon(s[i]));
            lbl.setText(str[i]);
            
        }
     }
   
   }
   
 
 public static void main(String[] args)
 {

    new Checkhotels();
 }

 }


