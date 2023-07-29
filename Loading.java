import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Loading  extends JFrame implements Runnable{
 JProgressBar bar;
 Thread t;
 String username;
    public void run()
    {
        try{
           for(int i=1;i<=101;i++)
           {
            
             if(i<=100) 
             {
                bar.setValue(i);
             }
             else
             {
                setVisible(false);
             }
             Thread.sleep(100);
           }

           new Dashboard(username);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    Loading( String username)
    {
       this.username=username;
      setLayout(null);
      setBounds(500,200,650,400);
      setVisible(true);
      getContentPane().setBackground(Color.WHITE);
      

      JLabel text = new JLabel("Travel and Tourism Application");
      text.setBounds(70,20,500,30);
      text.setForeground(Color.ORANGE);
      text.setFont(new Font("Tohoma ",Font.BOLD , 30));
      add(text); 

       bar = new JProgressBar();
      bar.setBounds(150, 70, 300, 30);
      bar.setStringPainted(true); // to get 0% on bar
      add(bar);

      JLabel wait = new JLabel("Please wait Loading...");
      wait.setBounds(230,110,300,20);
      wait.setFont(new Font("Tohoma",Font.BOLD,15));
      wait.setForeground(Color.RED);
      add(wait); 

      JLabel name = new JLabel("Welcome,"+username);
      name.setBounds(210,250 ,300,50);
       name.setFont(new Font("Tohoma",Font.BOLD,25));
      name.setForeground(Color.BLUE);
      add(name); 
      
      t = new Thread(this);
      t.start();


    }
    
    public static void main(String[] args) {
        new Loading("");
    }
    
}
