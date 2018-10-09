import javax.swing.*;
import java.awt.*;

public class IDCardFrame extends JFrame {


    GridBagConstraints gbc = new GridBagConstraints();

    IDCardFrame(String title){

        setPreferredSize(new Dimension(500, 300));
        Color backcolor = new Color(245, 249, 122);
        getContentPane().setBackground(backcolor);

        setLayout(new GridBagLayout());
        GridBagConstraints layoutConst = null;


        gbc.insets = new Insets(1, 1, 1, 1);

        JLabel idPic = new JLabel();
        Image img = new ImageIcon(this.getClass().getResource("/danny.jpg")).getImage();
        idPic.setIcon(new ImageIcon(img));
        gbc.gridx = 3;
        gbc.gridy = 2;
        //gbc.gridheight = 1;
        add(idPic,gbc);

        JLabel Pic = new JLabel();
        Image myimg = new ImageIcon(this.getClass().getResource("/approve.jpg")).getImage();
        Pic.setIcon(new ImageIcon(myimg));
        gbc.gridx = 0;
        gbc.gridy = 2;
        //gbc.gridheight = 1;
        add(Pic,gbc);


        //Set frame's title
        setTitle(title);

        //Create labels
        JLabel name = new JLabel("Name: Danny Devito");
        gbc.gridx = 0;
        gbc.gridy = 0;
        name.setFont(new Font("Serif", Font.ITALIC, 16));
        gbc.insets = new Insets(1, 1, 1, -5);
        add(name, gbc);


        JLabel address = new JLabel("123 Cool St");
        gbc.gridx = 5;
        gbc.gridy = 3;
        address.setFont(new Font("Serif", Font.PLAIN, 14));
        //gbc.gridwidth = 20;
        add(address, gbc);

        JLabel weight = new JLabel("Weight: 180 lbs");
        gbc.gridx = 5;
        gbc.gridy = 5;
        weight.setFont(new Font("Serif", Font.PLAIN, 14));
        add(weight, gbc);

        JLabel myheight = new JLabel("Height: 6' 2\"");
        gbc.gridx = 5;
        gbc.gridy = 4;
        myheight.setFont(new Font("Serif", Font.PLAIN, 14));
        add(myheight, gbc);

        JLabel eyecolor = new JLabel("Eyes: Brown");
        gbc.gridx = 5;
        gbc.gridy = 6;
        eyecolor.setFont(new Font("Serif", Font.PLAIN, 14));
        add(eyecolor, gbc);

        JLabel quote = new JLabel("Danny Devito really means 'Daniel of life' and I think that's beautiful");
        gbc.gridx = 3;
        gbc.gridy = 7;
        quote.setFont(new Font("Serif", Font.PLAIN, 10));
        add(quote, gbc);

        JLabel programmer = new JLabel("Java Programmer");
        gbc.gridx = 3;
        gbc.gridy = 8;
        Color labelColor = new Color(103, 103, 205);
        programmer.setForeground(labelColor);
        programmer.setFont(new Font("Serif", Font.BOLD, 18));
        add(programmer, gbc);



        //Set size to be 5:3 ratio

        setLocationRelativeTo(null);
        setResizable(false);



    }

    public static void main(String []args){
        IDCardFrame myID = new IDCardFrame("My ID Card");

        myID.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myID.pack();
        myID.setVisible(true);

    }
}
