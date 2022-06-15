package notepadapp;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;
import javax.swing.*;

public class NotepadApp extends JFrame implements ActionListener
{
    static NotepadApp notepad;
    Text t;
    String fileName=null,fileAddress=null;
    JFileChooser chooser;
    boolean wordWrap=false;
    
    JMenuBar mbar=new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu edit=new JMenu("Edit");
    JMenu help=new JMenu("Help");
    JMenu format=new JMenu("Format");
    
    JMenuItem newFile=new JMenuItem("New");
    JMenuItem newWindow=new JMenuItem("New Window");
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
    
    JMenuItem wrap=new JMenuItem("Word Wrap: OFF");
    JMenu size=new JMenu("Font Size");
    JMenuItem size8=new JMenuItem("8");
    JMenuItem size12=new JMenuItem("12");
    JMenuItem size16=new JMenuItem("16");
    JMenuItem size18=new JMenuItem("18");
    JMenuItem size20=new JMenuItem("20");
    JMenuItem size24=new JMenuItem("24");
    
    JMenu style=new JMenu("Font Style");
    JMenuItem arial=new JMenuItem("Arial");
    JMenuItem comic=new JMenuItem("Comic Sans MS");
    JMenuItem times=new JMenuItem("Times New Roman");
    
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
        mbar.add(format);
        mbar.add(help);
        
        file.add(newFile);
        file.add(newWindow);
        file.add(openFile);
        file.add(saveAsFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        
        format.add(wrap);
        format.add(size);
        format.add(style);
        
        help.add(about);
        
        size.add(size8);
        size.add(size12);
        size.add(size16);
        size.add(size18);
        size.add(size20);
        size.add(size24);
        
        style.add(arial);
        style.add(comic);
        style.add(times);
        
        newFile.addActionListener(this);
        newWindow.addActionListener(this);
        openFile.addActionListener(this);
        saveAsFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        
        wrap.addActionListener(this);
        
        size.addActionListener(this);
        size8.addActionListener(this);
        size12.addActionListener(this);
        size16.addActionListener(this);
        size18.addActionListener(this);
        size20.addActionListener(this);
        size24.addActionListener(this);
        
        style.addActionListener(this);
        arial.addActionListener(this);
        comic.addActionListener(this);
        times.addActionListener(this);
        
        about.addActionListener(this);
        
        JScrollPane scrollpane=new JScrollPane(textarea);
        add(scrollpane);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        
        textarea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,22));
        
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));
        
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,KeyEvent.CTRL_DOWN_MASK));
    }
    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        notepad=new NotepadApp();
        notepad.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newFile)
        {
            notepad.textarea.setText("");
            notepad.setTitle("New");
            fileName=null;
            fileAddress=null;
        }
        else if(e.getSource()==newWindow)
        {
            NotepadApp notepad1=new NotepadApp();
            notepad1.setVisible(true);
        }
        else if(e.getSource()==openFile)
        {
                FileDialog fd = new FileDialog(notepad,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		if(fd.getFile()!=null)
		{
                    fileName=fd.getFile();
                    fileAddress=fd.getDirectory();
                    notepad.setTitle(fileName);
		}
		else
		{
                    notepad.textarea.setText("");
                    notepad.setTitle("New");
                    fileName=null;
                    fileAddress=null;
		}
		
		try
		{
			FileReader fr = new FileReader(fileAddress+fileName);
			BufferedReader br = new BufferedReader(fr);
			
			notepad.textarea.setText("");
			String line = null;
			
			while((line=br.readLine())!=null)
			{
                            notepad.textarea.append(line+"\n");
			}
			br.close();
			fr.close();
		}
		catch(Exception ie)
		{
			//System.out.println("File Not Opened");
			JOptionPane.showMessageDialog(notepad,"File Not Found","Open",JOptionPane.WARNING_MESSAGE );
		}
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
                    notepad.setTitle(fileName);
            }
            catch(Exception ie)
            {
                System.out.println(ie);
            }
        }
        else if(e.getSource()==saveFile)
        {
            if(fileName==null)
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
                                notepad.setTitle(fileName);
                        }
                        catch(Exception ie)
                        {
                            System.out.println(ie);
                        }
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
                            System.out.println(ie);
			}
		}
        }
        else if(e.getSource()==print)
        {
            try {
                textarea.print();
            } catch (PrinterException ex) {
                Logger.getLogger(NotepadApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==exit)
        {
            System.exit(0);
        }
        else if(e.getSource()==cut)
        {
            textarea.cut();
        }
        else if(e.getSource()==copy)
        {
            textarea.copy();
        }
        else if(e.getSource()==paste)
        {
            textarea.paste();
        }
        else if(e.getSource()==selectall)
        {
            textarea.selectAll();
        }
        else if(e.getSource()==about)
        {
            About about=new About();
            about.setVisible(true);
        }
        else if(e.getSource()==wrap)
        {
            if(wordWrap==false)
            { 
                wordWrap=true;
                wrap.setText("Word Wrap : ON");
                notepad.textarea.setLineWrap(true);
                notepad.textarea.setWrapStyleWord(true);
            }
            else if(wordWrap==true)
            {
                wordWrap=false;
                wrap.setText("Word Wrap : OFF");
                notepad.textarea.setLineWrap(false);
                notepad.textarea.setWrapStyleWord(false);
            }
        }
        else if(e.getSource()==arial)
        {
            textarea.setFont(new Font("Arial",Font.PLAIN,(textarea.getFont().getSize())));
        }
        else if(e.getSource()==comic)
        {
            textarea.setFont(new Font("Comic Sans MS",Font.PLAIN,(textarea.getFont().getSize())));
        }
        else if(e.getSource()==times)
        {
            textarea.setFont(new Font("Times New Roman",Font.PLAIN,(textarea.getFont().getSize())));
        }
        else if(e.getSource()==size8)
        {
            textarea.setFont(new Font((textarea.getFont().getName()),Font.PLAIN,8));
        }
        else if(e.getSource()==size12)
        {
            textarea.setFont(new Font((textarea.getFont().getName()),Font.PLAIN,12));
        }
        else if(e.getSource()==size16)
        {
            textarea.setFont(new Font((textarea.getFont().getName()),Font.PLAIN,16));
        }
        else if(e.getSource()==size18)
        {
            textarea.setFont(new Font((textarea.getFont().getName()),Font.PLAIN,18));
        }
        else if(e.getSource()==size20)
        {
            textarea.setFont(new Font((textarea.getFont().getName()),Font.PLAIN,20));
        }
        else if(e.getSource()==size24)
        {
            textarea.setFont(new Font((textarea.getFont().getName()),Font.PLAIN,24));
        }
    }
}
