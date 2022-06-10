import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AwtDemo extends Frame implements ActionListener 
{
	MenuBar mbar;
	Menu m1,m2;
	MenuItem item1,item2,item3,item4,item5,item6,item7;
	
	AwtDemo()
	{
		setTitle("AWT_Demo");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(new FlowLayout());
		setResizable(false);
		
		mbar=new MenuBar();
		setMenuBar(mbar);
		
		m1=new Menu("Calculator");
		item1=new MenuItem("Simple Calci");
		item2=new MenuItem("SI Calci");
		item3=new MenuItem("Combo Calci");
		m1.add(item1);
		m1.add(item2);
		m1.add(item3);
		
		mbar.add(m1);
		
		m2=new Menu("Demo Code");
		item4=new MenuItem("CheckboxDemo");
		item5=new MenuItem("RadioButtonDemo");
		item6=new MenuItem("MenuDemo");
		item7=new MenuItem("Exit");
		
		m2.add(item4);
		m2.add(item5);
		m2.add(item6);
		m2.add(item7);
		
		mbar.add(m2);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==item1)
		{
			SimpleCalci calci=new SimpleCalci();
			calci.setVisible(true);
		}
		if(ae.getSource()==item2)
		{
			
		}
		if(ae.getSource()==item3)
		{
			
		}
		if(ae.getSource()==item4)
		{
			
		}
		if(ae.getSource()==item5)
		{
			
		}
		if(ae.getSource()==item6)
		{
			
		}
		if(ae.getSource()==item7)
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		AwtDemo demo=new AwtDemo();
		demo.setVisible(true);
	}
}

