import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SICalci extends Frame implements ActionListener
{
	Label l1,l2,l3,l4;
	TextField t1,t2,t3,t4;
	Button b1,b2,b3;
	
	SICalci()
	{
		l1=new Label("Principal Amount : ");
		l2=new Label("Rate Of Interest : ");
		l3=new Label("Time Duration : ");
		l4=new Label("Simple Interest : ");
		
		t1=new TextField(11);
		t2=new TextField(11);
		t3=new TextField(11);
		t4=new TextField(11);
		
		b1=new Button("Calculate");
		b2=new Button("Reset");
		b3=new Button("Close");
		b3.setBackground(Color.red);
		b3.setForeground(Color.white);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b1);
		add(b2);
		add(b3);
		
		setSize(300,200);
		setLayout(new FlowLayout());
		setTitle("SI_Calculator");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
    }
	
	public void actionPerformed(ActionEvent ae)
	{
		float p=0,r=0,t=0,si=0;
		try
		{
			p=Float.parseFloat(t1.getText());
		}
		catch(NumberFormatException e)
		{
			t1.setText("Invalid input");
		}
		try
		{
			r=Float.parseFloat(t2.getText());
		}
		catch(NumberFormatException e)
		{
			t2.setText("Invalid input");
		}
		try
		{
			t=Float.parseFloat(t3.getText());
		}
		catch(NumberFormatException e)
		{
			t3.setText("Invalid input");
		}
		
		if(ae.getSource()==b1)
		{
			si=p*r*t;
			t4.setText(String.valueOf(si));
		}
		if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
		}
		if(ae.getSource()==b3)
		{
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		SICalci clc=new SICalci();
		clc.setVisible(true);
		clc.setLocation(300, 300);
	}
}
