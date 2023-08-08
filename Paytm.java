import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Paytm  extends JFrame implements ActionListener{
    JButton pay;
    String username;
    Paytm(String username)
    {
      setBounds(500, 200, 800, 600);

      JEditorPane pane = new JEditorPane();
      pane.setEditable(false);
      try{
           pane.setPage("https://paytm.com/rent-payment");
      }
      catch(Exception e)
      {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load , Error 404 </html>");
      }
      JScrollPane sp = new JScrollPane(pane);
      getContentPane().add(sp);

      setVisible(true);

       pay = new JButton("Back");
       pay.setBounds(630,10,100,30);
       pay.setBackground(Color.BLUE);
       pay.setForeground(Color.WHITE);
       pay.addActionListener(this);
       pane.add(pay);

    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==pay)
        {
            setVisible(false);
            new Payments(username);
        }
    }
    public static void main(String[] args) {
        new Paytm("");
    }
}
