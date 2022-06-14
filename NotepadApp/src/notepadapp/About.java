package notepadapp;
import java.awt.Font;
import javax.swing.*;

public class About extends JFrame
{
    About()
    {
        setTitle("About Notepad");
        setSize(1200,800);
        setLocation(100,100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("notepad.png"));
        setIconImage(icon.getImage());
        
        JLabel iconlabel=new JLabel(new ImageIcon(getClass().getResource("notepad.png")));
        iconlabel.setBounds(300,220,250,230);
        add(iconlabel);
        JLabel textlabel=new JLabel("<html>Welcome to Notepad <br> Notepad is a simple text editor for Microsoft Windows and a basic text editing program which enables computer users to create documents <br> All rights reserved@2022<html>");
        textlabel.setBounds(600,150,400,400);
        textlabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        add(textlabel);
        JLabel extra=new JLabel("<html><html>");
        extra.setBounds(300,100,250,230);
        add(extra);
        
    }   
    public static void main(String args[])
    {
        About abt=new About();
        abt.setVisible(true);
    }
}
