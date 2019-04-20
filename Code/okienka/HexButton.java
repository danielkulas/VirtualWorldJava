package okienka;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class HexButton extends JButton
{
	public int n = 6;
	public int x[]= new int[n];
	public int y[]= new int[n];
	public double angle = 2*Math.PI/n;
	public Polygon polygon;
	
	public HexButton()
	{
		super();
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
	    if (getModel().isArmed()) 
	        g.setColor(Color.lightGray);
	    else 
	        g.setColor(getBackground());
	    
	    int x0 = getSize().width/2;
	    int y0 = getSize().height/2;
	    for(int i=0; i<n; i++) 
	    {
	        double v = i*angle;
	        x[i] = x0 + (int)Math.round((getWidth()/2)*Math.cos(v));
	        y[i] = y0 + (int)Math.round((getHeight()/2)*Math.sin(v));
	    }
	    g.fillPolygon(x, y, n);
	    super.paintComponent(g);
	}
	 
	@Override
	public void paintBorder(Graphics g)
	{
	    g.setColor(getForeground());
	    int x0 = getSize().width/2;
	    int y0 = getSize().height/2;
	    for(int i=0; i<n; i++)
	    {
	        double v = i*angle;
	        x[i] = x0 + (int)Math.round((getWidth()/2)*Math.cos(v));
	        y[i] = y0 + (int)Math.round((getHeight()/2)*Math.sin(v));
	    }
	    g.drawPolygon(x, y, n);
	}
	 
	@Override
	public boolean contains(int x1, int y1)
	{
	    if (polygon == null || !polygon.getBounds().equals(getBounds())) 
	    {
	        int x0 = getSize().width/2;
	        int y0 = getSize().height/2;
	        for(int i=0; i<n; i++) 
	        {
	            double v = i*angle;
	            x[i] = x0 + (int)Math.round((getWidth()/2)*Math.cos(v));
	            y[i] = y0 + (int)Math.round((getHeight()/2)*Math.sin(v));
	        }
	        polygon = new Polygon(x,y,n);
	    }
	    return polygon.contains(x1, y1);
	}
}