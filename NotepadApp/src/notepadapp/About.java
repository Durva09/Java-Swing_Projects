package notepadapp;
import javax.swing.*;

public class About extends JFrame
{
    About()
    {
        setTitle("About Notepad");
        setSize(500,500);
        setLocation(700,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("notepad.png"));
        setIconImage(icon.getImage());
        
        JLabel iconlabel=new JLabel(new ImageIcon(getClass().getResource("notepad.png")));
        add(iconlabel);
        
    }
    public static void main(String args[])
    {
        About abt=new About();
        abt.setVisible(true);
    }
}
