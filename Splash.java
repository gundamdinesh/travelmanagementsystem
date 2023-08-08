import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Splash()
    {
           //  setSize(1200,600);  //frame size
             setVisible(true);  //frame visibility bydefault will be invisible hence we need to make it visible
           //  setLocation(200, 100);  // to open frame by leaving some distance from x & y axis
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/splash.jpg")); 
            Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
             add(image); 
             Thread t = new Thread(this);
             t.start();

   }
   public void run()
   {
     try{
        Thread.sleep(3000);
        setVisible(false);
        new Login();
     }
     catch(Exception e){};
   }
    public static void main(String[] args) {
          Splash frame = new Splash(); 
          int x=1;
          for(int i=1;i<=500;x+=7,i+=6)
          {
            frame.setLocation(750-(x+i)/2,400-(i/2));
            frame.setSize(x+i,i);
            try{
                Thread.sleep(10);
            }
            catch(Exception e){}
          }
    }
}