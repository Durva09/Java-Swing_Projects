import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;

public class SimpleCalci extends Frame implements ActionListener
{
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1,b2,b3,b4,b5,b6;
	SimpleCalci()
	{
		l1=new Label("Number1 : ");
		l2=new Label("Number2 : ");
		l3=new Label("Result  : ");
		
		t1=new TextField(11);
		t2=new TextField(11);
		t3=new TextField(11);
		
		b1=new Button("ADD");
		b2=new Button("MULTIPLY");
		b3=new Button("SUBTRACT");
		b4=new Button("Division");
		b5=new Button ("CLOSE");
		b6=new Button("RESET");
		b5.setBackground(Color.red);
		b5.setForeground(Color.white);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b6);
		add(b5);
		
		setSize(210,250);
		setLayout(new FlowLayout());
		setTitle("Calculator");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		float a=0,b=0;
		float c=0;
		try
		{
			a=Float.parseFloat(t1.getText());
		}
		catch(NumberFormatException e)
		{
			t1.setText("Invalid input");
		}
		try
		{
			b=Float.parseFloat(t2.getText());
		}
		catch(NumberFormatException e)
		{
			t2.setText("Invalid input");
		}
		
		if(ae.getSource()==b1)
		{
			c=a+b;
			t3.setText(String.valueOf(c));
		}
		if(ae.getSource()==b2)
		{
			c=a*b;
			t3.setText(String.valueOf(c));
		}
		if(ae.getSource()==b3)
		{
			c=a-b;
			t3.setText(String.valueOf(c));
		}
		if(ae.getSource()==b4)
		{
			c=a/b;
			t3.setText(String.valueOf(c));
		}
		if(ae.getSource()==b5)
		{
			System.exit(0);
		}
		if(ae.getSource()==b6)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
	}
	public static void main(String args[])
	{
		SimpleCalci clc=new SimpleCalci();
		clc.setVisible(true);
		clc.setLocation(300,300);
	}
}
