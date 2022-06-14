package notepadapp;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.text.Text;
import javax.swing.*;

public class NotepadApp extends JFrame implements ActionListener
{
    static NotepadApp notepad;
    Text t;
    String fileName=null,fileAddress=null;
    JFileChooser chooser;
    
    JMenuBar mbar=new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu edit=new JMenu("Edit");
    JMenu help=new JMenu("Help");
    
    JMenuItem newFile=new JMenuItem("New");
    JMenuItem openFile=new JMenuItem("Open");
    JMenuItem saveFile=new JMenuItem("Save");
    JMenuItem saveAsFile=new JMenuItem("Save As");
    JMenuItem print=new JMenuItem("Print");
    JMenuItem exit=new JMenuItem("Exit");
    
    JMenuItem cut=new JMenuItem("Cut");
    JMenuItem copy=new JMenuItem("Copy");
    JMenuItem paste=new JMenuItem("Paste");
    JMenuItem selectall=new JMenuItem("Select All");
    
    JMenuItem about=new JMenuItem("About");
    JTextArea textarea=new JTextArea();
    
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
        file.add(saveAsFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        
        help.add(about);
        
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveAsFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        
        about.addActionListener(this);
        
        JScrollPane scrollpane=new JScrollPane(textarea);
        add(scrollpane);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        textarea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,22));
        textarea.setLineWrap(true);
    }
    
    public static void main(String args[])
    {
        notepad=new NotepadApp();
        notepad.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()=="newFile")
        {
            
        }
        else if(e.getSource()=="openFile")
        {
            
        }
        else if(e.getSource()==saveAsFile)
        {
            FileDialog fd = new FileDialog(notepad,"Save As",FileDialog.SAVE);
            fd.setVisible(true);

            if(fd.getFile()!=null)
            {
                    fileName = fd.getFile();
                    fileAddress = fd.getDirectory();
            }

            try
            { 
                    BufferedWriter br = new BufferedWriter(new FileWriter(fileAddress+fileName));
                    br.write(notepad.textarea.getText());
                    br.close();
            }
            catch(Exception ie)
            {

            }
        }
        else if(e.getSource()==saveFile)
        {
            if(fileName==null)
		{
			
		}
		else
		{
			try
			{
				
                            BufferedWriter br = new BufferedWriter(new FileWriter(fileAddress+fileName));
                            br.write(notepad.textarea.getText());
                            br.close();
                            notepad.setTitle(fileName);
			}
			catch(IOException ie)
			{
				
			}
		}
        }
        else if(e.getSource()=="print")
        {
            
        }
        else if(e.getSource()==exit)
        {
            System.exit(0);
        }
        else if(e.getSource()=="cut")
        {
            
        }
        else if(e.getSource()=="copy")
        {
            
        }
        else if(e.getSource()=="paste")
        {
            
        }
        else if(e.getSource()=="selectall")
        {
            
        }
        else if(e.getSource()=="about")
        {
            
        }
    }
}
