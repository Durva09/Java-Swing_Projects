import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxDemo extends Dialog implements ItemListener , ActionListener
{
	Checkbox c1,c2,c3;
	TextArea result;
	Label lbl;
	Button b1;
	
	public CheckboxDemo()
	{
		super(new Frame(),"CheckboxDemo");
		setSize(400,200);
		setLayout(new FlowLayout());
		
		lbl=new Label("Select area of interest : ");
		c1=new Checkbox("Software");
		c2=new Checkbox("Hardware");
		c3=new Checkbox("Networking");
		
		result=new TextArea(5,15);
		b1=new Button("close");
		b1.setBackground(Color.red);
		b1.setForeground(Color.white);
		
		add(lbl);
		add(c1);
		add(c2);
		add(c3);
		add(result);
		add(b1);
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		
		b1.addActionListener(this);
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		String s="Area of interest : ";
		s=s+"\nSoftware : "+c1.getState();
		s=s+"\nHardware : "+c2.getState();
		s=s+"\nNetworking : "+c3.getState();
		
		result.setText(s);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			setVisible(false);
			dispose();
		}
	}
	public static void main(String args[])
	{
		CheckboxDemo cd=new CheckboxDemo();
		cd.setVisible(true);
		cd.setLocation(300, 300);
	}
}
