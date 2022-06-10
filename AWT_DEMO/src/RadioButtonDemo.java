import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends Dialog implements ItemListener, ActionListener
{
	Checkbox c1,c2,c3;
	CheckboxGroup cbg;
	TextArea result;
	Label lbl;
	Button b1;
	
	RadioButtonDemo()
	{
		super(new Frame(),"Radiobutton");
		setSize(400,300);
		setLayout(new FlowLayout());
		
		cbg=new CheckboxGroup();
		lbl=new Label("Select area of interest :");
		c1=new Checkbox("software",cbg,false);
		c2=new Checkbox("Hardware",cbg,false);
		c3=new Checkbox("Networking",cbg,false);
		
		result=new TextArea(10,50);
		b1=new Button("Close");
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
		String s="Area of interest :";
		if(c1.getState()==true)
		{
			s=s+"\n Software = "+c1.getState();
		}
		if(c2.getState()==true)
		{
			s=s+"\n Hardware = "+c2.getState();
		}
		if(c3.getState()==true)
		{
			s=s+"\n Networking = "+c3.getState();
		}
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
		RadioButtonDemo rbd=new RadioButtonDemo();
		rbd.setVisible(true);
		rbd.setLocation(200,200);
	}
}
