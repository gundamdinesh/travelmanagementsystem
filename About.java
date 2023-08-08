import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener{
    String username;
    JButton back;
    About(String username)
    {
        this.username=username;
       String s = " About Projects          \n  "
        + "\nThe objective of the Travel and Tourism Management System"
        + "project is to develop a system that automates the processes "
        + "and activities of a travel and the purpose is to design a "
        + "system using which one can perform all operations related to "
        + "traveling.\n\n"
        + "This application will help in accessing the information related "
        + "to the travel to the particular destination with great ease. "
        + "The users can track the information related to their tours with "
        + "great ease through this application. The travel agency information "
        + "can also be obtained through this application.\n\n"
        + "Advantages of Project:"
        + "\nï‚·Gives accurate information"
        + "\nï‚·Simplifies the manual work"
        + "\nï‚·It minimizes the documentation related work"
        + "\nï‚·Provides up to date information"
        + "\nï‚·Friendly Environment by providing warning messages."
        + "\nï‚·travelers details can be provided"
        + "\nï‚·booking confirmation notification"
        ;

        setBounds(500,200,800,500);
        setVisible(true);
        setLayout(null);
        TextArea t = new TextArea(s);
        t.setBounds(100,100,600,300);
        t.setFont(new Font("Tohoma",Font.BOLD,15));
        t.setEditable(false);
        add(t);
        JLabel lb =new JLabel("About");
        lb.setFont(new Font("Tohoma",Font.BOLD,30));
        lb.setBounds(350,20,100,30);
        lb.setForeground(Color.RED);
        add(lb);

        back = new JButton("Back");
       back.setBounds(350, 420, 100, 30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Dashboard(username);
        }
    }
    public static void main(String[] args) {
        new About("");
    }
}
