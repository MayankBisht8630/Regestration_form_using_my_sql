import com.sun.security.auth.module.JndiLoginModule;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calsi_main extends JFrame implements ActionListener , MouseMotionListener
{
    Double num1 , num2 , answer;
    int calculation;
    JFrame frame = new JFrame("CALCULATOR");
    JLabel label = new JLabel();
    JTextField tf = new JTextField();
    JLabel label1 = new JLabel();

    JRadioButton onjr = new JRadioButton("On"); // jradio is used to select one option from multiple options in java used in filling forms objectives
    JRadioButton offjr = new JRadioButton("Off");

    JButton b0 = new JButton("0");
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b10 = new JButton("=");
    JButton b11 = new JButton(".");
    JButton b14 = new JButton("*");
    JButton b15 = new JButton("/");
    JButton b16 = new JButton("+");
    JButton b17 = new JButton("-");
    JButton b18 = new JButton("CLR");

    JPopupMenu pm = new JPopupMenu("menu");

    public void application() //application ak gui hai
    {

        frame.setSize(305,510);
        frame.getContentPane(); // it s the layer used to hold the objects (object are added to content pain of the container)
        frame.setLayout(null); /* we do this because JPannel has inbuild flowlayout manager used to place the objects (widgets) into container
                                  if we do set layout to null so we can set the objects(widgits) according to us */
        frame.setLocationRelativeTo(null); // isse jub hum run kerange to humesha hamara output center meh rehayagas
        frame.getContentPane().setBackground(Color.DARK_GRAY); // getcontent pain karke he background set hoga
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //to close the window

    }

    public void close()
    {
        WindowEvent closewindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closewindow);
    }

    public void componenets()
    {
        label.setBounds(250,0,50,50);
        label.setForeground(Color.white);
        frame.add(label);

        tf.setBounds(10,40,270,40);
        tf.setFont(new Font("Arial",Font.BOLD,18));
        tf.setEditable(false);
        tf.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(tf);

        label1.setBounds(10,170,200,40);
        label1.setFont(new Font("Arial",Font.BOLD,12));
        label1.setForeground(Color.orange);
        frame.add(label1);


        onjr.setBounds(10,95,60,40);
        onjr.setSelected(true);
        onjr.setFont(new Font("Arial",Font.BOLD,14));
        onjr.setBackground(Color.DARK_GRAY);
        onjr.setForeground(Color.GREEN);
        frame.add(onjr);

        offjr.setBounds(10, 120, 60, 40);
        offjr.setSelected(false);
        offjr.setFont(new Font("Arial", Font.BOLD, 14));
        offjr.setBackground(Color.DARK_GRAY);
        offjr.setForeground(Color.GREEN);
        frame.add(offjr);

        ButtonGroup bg = new ButtonGroup();
        bg.add(onjr);
        bg.add(offjr);

        b7.setBounds(10, 230, 60, 40);
        b7.setFont(new Font("Arial", Font.BOLD, 20));
        b7.setForeground(Color.blue);
        frame.add(b7);

        b8.setBounds(80, 230, 60, 40);
        b8.setFont(new Font("Arial", Font.BOLD, 20));
        b8.setForeground(Color.blue);
        frame.add(b8);

        b9.setBounds(150, 230, 60, 40);
        b9.setFont(new Font("Arial", Font.BOLD, 20));
        b9.setForeground(Color.blue);
        frame.add(b9);

        b4.setBounds(10, 290, 60, 40);
        b4.setFont(new Font("Arial", Font.BOLD, 20));
        b4.setForeground(Color.blue);
        frame.add(b4);

        b5.setBounds(80, 290, 60, 40);
        b5.setFont(new Font("Arial", Font.BOLD, 20));
        b5.setForeground(Color.blue);
        frame.add(b5);

        b6.setBounds(150, 290, 60, 40);
        b6.setFont(new Font("Arial", Font.BOLD, 20));
        b6.setForeground(Color.blue);
        frame.add(b6);

        b1.setBounds(10, 350, 60, 40);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setForeground(Color.blue);
        frame.add(b1);

        b2.setBounds(80, 350, 60, 40);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setForeground(Color.blue);
        frame.add(b2);

        b3.setBounds(150, 350, 60, 40);
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.setForeground(Color.blue);
        frame.add(b3);

        b11.setBounds(150, 410, 60, 40);
        b11.setFont(new Font("Arial", Font.BOLD, 20));
        b11.setForeground(Color.blue);
        frame.add(b11);

        b0.setBounds(10, 410, 130, 40);
        b0.setFont(new Font("Arial", Font.BOLD, 20));
        b0.setForeground(Color.blue);
        frame.add(b0);

        b10.setBounds(220, 410, 60, 40);
        b10.setFont(new Font("Arial", Font.BOLD, 20));
        b10.setBackground(Color.CYAN);
        frame.add(b10);

        b15.setBounds(220, 350, 60, 40);
        b15.setFont(new Font("Arial", Font.BOLD, 20));
        b15.setBackground(Color.MAGENTA);
        frame.add(b15);

        b14.setBounds(220, 230, 60, 40);
        b14.setFont(new Font("Arial", Font.BOLD, 20));
        b14.setBackground(Color.MAGENTA);
        frame.add(b14);

        b17.setBounds(220, 170, 60, 40);
        b17.setFont(new Font("Arial", Font.BOLD, 20));
        b17.setBackground(Color.MAGENTA);
        frame.add(b17);

        b16.setBounds(220, 290, 60, 40);
        b16.setFont(new Font("Arial", Font.BOLD, 20));
        b16.setBackground(Color.MAGENTA);
        frame.add(b16);

        b18.setBounds(150, 110, 130, 40);
        b18.setFont(new Font("Arial", Font.BOLD, 12));
        b18.setBackground(Color.YELLOW);
        b18.setForeground(Color.BLUE);
        frame.add(b18);

        onjr.addActionListener(this);
        offjr.addActionListener(this);
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);

        b10.addMouseListener(new MouseAdapter()  /* using mouse adapter instead of mouse listner because using mouse
                                               listner we have to override all the mouse listner methods
                                                but using mouse adapter we can use ony those method that we want*/
        {

            @Override
            public void mouseEntered(MouseEvent e)
            {
                b10.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                b10.setBackground(Color.CYAN);
            }
        });

        b18.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent e)
            {
                b18.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                b18.setBackground(Color.YELLOW);
            }
        });

        b14.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent e)
            {
                b14.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                b14.setBackground(Color.MAGENTA);
            }
        });

        b15.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent e)
            {
                b15.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                b15.setBackground(Color.MAGENTA);
            }
        });

        b16.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent e)
            {
                b16.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                b16.setBackground(Color.MAGENTA);
            }
        });

        b17.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent e)
            {
                b17.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                b17.setBackground(Color.MAGENTA);
            }
        });

        frame.addMouseMotionListener(this);  // adding pop up listner
        JMenuItem mi1 = new JMenuItem("Copy");
        JMenuItem mi2 = new JMenuItem("Paste");
        JMenuItem mi3 = new JMenuItem("Select All");
        pm.add(mi1);
        pm.add(mi2);
        pm.add(mi3);
        tf.add(pm);
        tf.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                pm.show(frame,e.getX(),e.getY());
            }
        });

        mi1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tf.cut();
            }
        });

        mi2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tf.copy();
            }
        });

        mi3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tf.selectAll();
            }
        });



    }
     Calsi_main()
     {

        application();
        componenets();
     }


    public static void main(String[] args)
    {
        Calsi_main cal = new Calsi_main();
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object ob = e.getSource();

        if(ob == onjr)
        {
            enable();
        }

        else if(ob == offjr)
        {
            disable();
        }

        else if(ob == b18)
        {
            frame.hide();
            page page = new page();
            JLabel emoji;
            ImageIcon img = new ImageIcon("smili1-removebg-preview.png");
            emoji = new JLabel("" , img , JLabel.CENTER);
            emoji.setBounds(110,10,70,70);
            page.add(emoji);

            page.getContentPane().setBackground(Color.pink);
            page.setLocationRelativeTo(null);
            JLabel wel_label = new JLabel("Are You Sure You Want To Clear" , JLabel.CENTER);
            wel_label.setForeground(Color.blue);
            JButton yes = new JButton("Yes");
            JButton no = new JButton("No");
            yes.setBounds(70,120,60,20);
            yes.setBackground(Color.lightGray);
            yes.setForeground(Color.MAGENTA);
            no.setBounds(150,120,60,20);
            no.setBackground(Color.lightGray);
            no.setForeground(Color.MAGENTA);
            page.add(yes);
            page.add(no);
            page.getContentPane().add(wel_label);
            page.setVisible(true);

            yes.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseExited(MouseEvent e)
                {
                    yes.setBackground(Color.lightGray);
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    yes.setBackground(Color.RED);
                }
            });

            yes.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    frame.dispose();
                    page.dispose();
                    Calsi_main cm = new Calsi_main();
                    tf.setText("");
                    label.setText("");
                }
            });

            no.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseExited(MouseEvent e)
                {
                    no.setBackground(Color.lightGray);
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    no.setBackground(Color.RED);
                }});
            no.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    page.dispose();
                    frame.setVisible(true);
                }
            });

        }

        else if(ob == b0)
        {
          if(tf.getText().equals("0"))
          {
              return;
          }
          else
          {
              tf.setText(tf.getText()+"0");
          }
        }

        else if(ob == b1)
        {
            tf.setText(tf.getText()+"1");
        }

        else if(ob == b2)
        {
            tf.setText(tf.getText()+"2");
        }

        else if(ob == b3)
        {
            tf.setText(tf.getText()+"3");
        }

        else if(ob == b4)
        {
            tf.setText(tf.getText()+"4");
        }

        else if(ob == b5)
        {
            tf.setText(tf.getText()+"5");
        }

        else if(ob == b6)
        {
            tf.setText(tf.getText()+"6");
        }

        else if(ob == b7)
        {
            tf.setText(tf.getText()+"7");
        }

        else if(ob == b8)
        {
            tf.setText(tf.getText()+"8");
        }

        else if(ob == b9)
        {
            tf.setText(tf.getText()+"9");
        }

        else if(ob == b11)
        {
            if(tf.getText().contains("."))
            {
                return;
            }
            else
            {
                tf.setText(tf.getText() + ".");
            }
        }

        else if(ob == b16)
        {
            String str =  new String ();
            str = tf.getText();
            num1 = Double.parseDouble(tf.getText());
            calculation = 1;
            tf.setText("");
            label.setText(str + "+");
        }

        else if(ob == b17)
        {
            String str =  new String ();
            str = tf.getText();
            num1 = Double.parseDouble(tf.getText());
            calculation = 2;
            tf.setText("");
            label.setText(str + "-");
        }

        else if(ob == b14)
        {
            String str =  new String ();
            str = tf.getText();
            num1 = Double.parseDouble(tf.getText());
            calculation = 3;
            tf.setText("");
            label.setText(str + "*");
        }

        else if(ob == b15)
        {
                String str = new String();
                str = tf.getText();
                num1 = Double.parseDouble(tf.getText());
                calculation = 4;
                tf.setText("");
                label.setText(str + "/");
        }

        else if(ob == b10)
        {
            num2 = Double.parseDouble(tf.getText());
            switch (calculation)
            {
                case 1:
                    answer = num1 + num2;
                    break;
                case 2 :
                    answer = num1 - num2;
                    break;
                case 3 :
                    answer = num1 * num2;
                    break;
                case 4 :
                    answer = num1 / num2;
                    break;
            }
            tf.setText(Double.toString(answer));
            label.setText("");
            num1 = answer;
        }
    }
    public void enable()
    {
        onjr.setEnabled(false);
        offjr.setEnabled(true);
        b0.setEnabled(true);
        tf.setEnabled(true);
        label.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b10.setEnabled(true);
        b11.setEnabled(true);
        b14.setEnabled(true);
        b15.setEnabled(true);
        b16.setEnabled(true);
        b17.setEnabled(true);
        b18.setEnabled(true);
        label1.setVisible(true);
    }
    public void disable()
    {
        onjr.setEnabled(true);
        offjr.setEnabled(false);
        b0.setEnabled(false);
        tf.setEnabled(false);
        label.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        b10.setEnabled(false);
        b11.setEnabled(false);
        b14.setEnabled(false);
        b15.setEnabled(false);
        b16.setEnabled(false);
        b17.setEnabled(false);
        b18.setEnabled(false);
        label1.setVisible(false);
    }


    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        label1.setText("Mouse position is x : "+x+" y : "+y);
    }
}


class page extends JFrame
{
    page()
    {
        getToolkit().beep();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmation Page");
        setSize(305, 220);

    }
}
