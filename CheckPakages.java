import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CheckPakages extends JFrame {
    CheckPakages()
    {   
        String arr1[] = new String[]{"GOLD PAKAGE","6 Days and 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Soft Drinks Free","Full Day 3 Island Cruise","All Language Speaking Guide","BOOK NOW","SUMMER SPECIAL OFFER","12000/-","icons/icons/package1.jpg"};
        String arr2[] = new String[]{"SILVER PAKAGE","5 Days and 4 Nights","Airport Assistance","Full Day City Tour","Pakage Buffet","Paid Soft Drinks ","Half Day 3 Island Cruise","English Speaking Guide","BOOK NOW","WINTER SPECIAL OFFER","10000/-","icons/icons/package2.jpg"};
        String arr3[] = new String[]{"BRONZE PAKAGE","3 Days and 2 Nights","Airport Assistance","Full Day City Tour","Daily Buffet","Paid Drinks Free","Half Day 3 Island Cruise","English Speaking Guide","BOOK NOW","RAINY SPECIAL OFFER","8000/-","icons/icons/package3.jpg"};


        setBounds(450,200,900,600);
        //setLayout(null); keep it default
        setVisible(true);
        JTabbedPane tab = new JTabbedPane();
         
        JPanel p1=createPakage(arr1);
        tab.addTab("Pakage 1", p1);

         JPanel p2=createPakage(arr2);
        tab.addTab("Pakage 2", p2);

         JPanel p3=createPakage(arr3);
        tab.addTab("Pakage 3", p3);


        add(tab);



    }
    public JPanel createPakage(String arr[])
    { 
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel l1 = new JLabel(arr[0]);
        l1.setBounds(30,20,300,30);
        l1.setFont(new Font("Tohoma", Font.BOLD, 30));
        l1.setForeground(Color.ORANGE);
        p1.add(l1);

        JLabel l2 = new JLabel(arr[1]);
        l2.setBounds(30,80,200,30);
        l2.setFont(new Font("Tohoma", Font.BOLD, 20));
        l2.setForeground(Color.BLUE);
        p1.add(l2);

        JLabel l3 = new JLabel(arr[2]);
        l3.setBounds(30,130,200,30);
        l3.setFont(new Font("Tohoma", Font.BOLD, 20));
        l3.setForeground(Color.BLUE);
        p1.add(l3);

        JLabel l4 = new JLabel(arr[3]);
        l4.setBounds(30,180,200,30);
        l4.setFont(new Font("Tohoma", Font.BOLD, 20));
        l4.setForeground(Color.BLUE);
        p1.add(l4);

         JLabel l5 = new JLabel(arr[4]);
        l5.setBounds(30,230,200,30);
        l5.setFont(new Font("Tohoma", Font.BOLD, 20));
        l5.setForeground(Color.BLUE);
        p1.add(l5);

        JLabel l6 = new JLabel(arr[5]);
        l6.setBounds(30,280,200,30);
        l6.setFont(new Font("Tohoma", Font.BOLD, 20));
        l6.setForeground(Color.BLUE);
        p1.add(l6);

        JLabel l7 = new JLabel(arr[6]);
        l7.setBounds(30,330,300,30);
        l7.setFont(new Font("Tohoma", Font.BOLD, 20));
        l7.setForeground(Color.BLUE);
        p1.add(l7);

        JLabel l8 = new JLabel(arr[7]);
        l8.setBounds(30,380,300,30);
        l8.setFont(new Font("Tohoma", Font.BOLD, 20));
        l8.setForeground(Color.BLUE);
        p1.add(l8);

         JLabel l9 = new JLabel(arr[8]);
        l9.setBounds(100,420,200,30);
        l9.setFont(new Font("Tohoma", Font.BOLD, 25));
        l9.setForeground(Color.BLACK);
        p1.add(l9);

        JLabel l10 = new JLabel(arr[9]);
        l10.setBounds(130,470,500,30);
        l10.setFont(new Font("Tohoma", Font.BOLD, 25));
        l10.setForeground(Color.MAGENTA);
        p1.add(l10);

        JLabel l11 = new JLabel(arr[10]);
        l11.setBounds(600,470,200,30);
        l11.setFont(new Font("Tohoma", Font.BOLD, 35));
        l11.setForeground(Color.RED);
        p1.add(l11);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(arr[11]));
       Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(200, 40, 800, 300);
       p1.add(img);
       
       return p1;
    }  
    public static void main(String[] args) {
        new CheckPakages();
    }
    
}
