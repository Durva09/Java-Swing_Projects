import java.awt.*;
import java.awt.event.*;

public class ComboCalci extends Dialog implements ItemListener
{
	Label l1,l2,l3,l4;
	TextField t1,t2,t3;
	Choice operation;
	
	ComboCalci()
	{
		super(new Frame(),"combo");
		setSize(400,200);
		setLayout(new FlowLayout());
		
		l1=new Label("Number1 : ");
		l2=new Label("Number2 : ");
		l3=new Label("Result  : ");
		l4=new Label("Operation : ");
		
		t1=new TextField(11);
		t2=new TextField(11);
		t3=new TextField(11);
		
		operation=new Choice();
		operation.add("add");
		operation.add("sub");
		operation.add("div");
		operation.add("multi");
		operation.add("reset");
		operation.add("close");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(operation);
		
		operation.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent ie)
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
		
		String option=operation.getSelectedItem();
		if(option.equals("add"))
		{
			c=a+b;
			t3.setText(String.valueOf(c));
		}
		if(option.equals("sub"))
		{
			c=a-b;
			t3.setText(String.valueOf(c));
		}
		if(option.equals("multi"))
		{
			c=a*b;
			t3.setText(String.valueOf(c));
		}
		if(option.equals("div"))
		{
			c=a/b;
			t3.setText(String.valueOf(c));
		}
		if(option.equals("reset"))
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		if(option.equals("close"))
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		ComboCalci cbc=new ComboCalci();
		cbc.setVisible(true);
		cbc.setLocation(200, 200);
	}
}
