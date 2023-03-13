import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Registration_form extends JFrame
{
    JFrame j = new JFrame("Registration Form");
    JLabel l1,l2,l3,l4,l5,label;
    JButton b1,b2;
    JTextField t1,t2,t3,t4;
    JPasswordField jp;

    Registration_form()
    {
        j.getContentPane();
        j.setSize(305,510);
        j.setLocationRelativeTo(null);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Registration Form");
        label.setBounds(60,15,220,60);
        label.setFont(new Font("Arial",Font.BOLD,20));

        l1 = new JLabel("Name");
        l1.setBounds(20,80,120,30);
        l1.setForeground(Color.GREEN);

        l2 = new JLabel("Email");
        l2.setBounds(20,120,120,30);
        l2.setForeground(Color.GREEN);

        l3 = new JLabel("Phone no .");
        l3.setBounds(20,160,120,30);
        l3.setForeground(Color.GREEN);

        l4 = new JLabel("Password");
        l4.setBounds(20,200,120,30);
        l4.setForeground(Color.GREEN);

        l5 = new JLabel("Confirm password");
        l5.setBounds(20,240,120,30);
        l5.setForeground(Color.GREEN);

        t1 = new JTextField();
        t1.setBounds(150,80,120,30);

        t2 = new JTextField();
        t2.setBounds(150,120,120,30);

        t3 = new JTextField();
        t3.setBounds(150,160,120,30);

        t4 = new JTextField();
        t4.setBounds(150,200,120,30);

        jp = new JPasswordField();
        jp.setBounds(150,240,120,30);

        b1 = new JButton("Creat");
        b1.setBounds(35,300,80,30);
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               registeuser();

            }
        });

        b2 = new JButton("Cancel");
        b2.setBounds(170,300,80,30);

        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                j.dispose();
            }
        });

        j.add(label);
        j.add(l1);
        j.add(l2);
        j.add(l3);
        j.add(l4);
        j.add(l5);
        j.add(t1);
        j.add(t2);
        j.add(t3);
        j.add(t4);
        j.add(jp);
        j.add(b1);
        j.add(b2);
        j.setVisible(true);
    }

    private void registeuser()
    {
        String Name = t1.getText();
        String Email = t2.getText();
        String Phone_no = t3.getText();
        String Password = t4.getText();
        String confirm_Password = jp.getText();

        if (Name.isEmpty() || Email.isEmpty() || Phone_no.isEmpty() || Password.isEmpty())
        {
            JOptionPane.showMessageDialog(this ,
            "Please Enter all Field","Try Again",
            JOptionPane.ERROR_MESSAGE);

            return;
        }

        if(!Password.equals(confirm_Password))
        {
            JOptionPane.showMessageDialog(this , "Confirm Password Did Not Match" ,
                    "Try Again",JOptionPane.ERROR_MESSAGE);

            return;
        }

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayank_login", "root", "Mayank@12");
            String query = "INSERT INTO registration values('" + Name + "','" + Email + "','" + Phone_no + "','" +
                    Password +"')";

            Statement sta = connection.createStatement();
            int x = sta.executeUpdate(query);
            if (x == 0) {
                JOptionPane.showMessageDialog(b1, "This is already exist");
            } else {
                JOptionPane.showMessageDialog(b1,"Welcome,Your account is successfully created");

                Login_Mysql lms = new Login_Mysql();
            }
            connection.close();
            j.dispose();
        }
        catch (Exception f)
        {
            f.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Registration_form rf = new Registration_form();
    }
}
