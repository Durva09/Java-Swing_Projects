package notepadapp;
import javax.swing.*;

public class NotepadApp extends JFrame 
{
    JMenuBar mbar=new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu edit=new JMenu("Edit");
    JMenu help=new JMenu("Help");
    
    JMenuItem newFile=new JMenuItem("New");
    JMenuItem openFile=new JMenuItem("Open");
    JMenuItem saveFile=new JMenuItem("Save");
    JMenuItem print=new JMenuItem("Print");
    JMenuItem exit=new JMenuItem("Exit");
    
    JMenuItem cut=new JMenuItem("Cut");
    JMenuItem copy=new JMenuItem("Copy");
    JMenuItem paste=new JMenuItem("Paste");
    JMenuItem selectall=new JMenuItem("Select All");
    
    JMenuItem about=new JMenuItem("About");
    
    NotepadApp()
    {
        ImageIcon icon=new ImageIcon(getClass().getResource("notepad.png"));
        setIconImage(icon.getImage());
        setTitle("*Untitled-Notepad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLocation(700,200);
        
        setJMenuBar(mbar);
        mbar.add(file);
        mbar.add(edit);
        mbar.add(help);
        
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        
        help.add(about);
    }
    
    public static void main(String args[])
    {
        NotepadApp notepad=new NotepadApp();
        notepad.setVisible(true);
        
    }
}
