package ParcelDistributionCenter;

import java.awt.*;

public class Parcel
{
	private String color;
	private int length;
	private int height;
	private int width;
	private int x;
	private int y;
	
	public Parcel(int x)
	{
		int colorCode = randomize(0, 2);
		if (colorCode == 0)
		{
			this.color = "blue";
		}
		else if (colorCode == 1)
		{
			this.color = "green";
		}
		else if (colorCode == 2)
		{
			this.color = "yellow";
		}
		this.length = randomize(20, 50);
		this.height = randomize(20, 50);
		this.width = randomize(10, 50);
		
		this.x = x;
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (this.getColor().equals("blue"))
		{
			g2d.setColor(Color.BLUE);
		}
		else if (this.getColor().equals("green"))
		{
			g2d.setColor(Color.GREEN);
		}
		else if (this.getColor().equals("yellow"))
		{
			g2d.setColor(Color.YELLOW);
		}
		
		if (this.getX() < 510 - this.getLength() / 2)
		{
			g2d.fillRect(this.getX(), this.getY(), this.getLength(), this.getHeight());
			int[] Xs1 = {this.getX(), this.getX() + this.getWidth(), this.getX() + this.getLength() + this.getWidth(), this.getX() + this.getLength()};
			int[] Ys1 = {this.getY(), this.getY() - this.getWidth(), this.getY() - this.getWidth(), this.getY()};
			g2d.fillPolygon(Xs1, Ys1, 4);
			int[] Xs2 = {this.getX() + this.getLength(), this.getX() + this.getLength() + this.getWidth(), this.getX() + this.getLength() + this.getWidth(), this.getX() + this.getLength()};
			int[] Ys2 = {this.getY(), this.getY() - this.getWidth(), this.getY() + this.getHeight() - this.getWidth(), this.getY() + this.getHeight()};
			g2d.fillPolygon(Xs2, Ys2, 4);
			
			g2d.setColor(Color.BLACK);
			g2d.drawRect(this.getX(), this.getY(), this.getLength(), this.getHeight());
			g2d.drawPolygon(Xs1, Ys1, 4);
			g2d.drawPolygon(Xs2, Ys2, 4);
		}
		
		else if (this.getX() >= 510 - this.getLength() / 2 && this.getX() <= 515)
		{
			g2d.fillRect(this.getX(), this.getY(), this.getLength(), this.getHeight());
			int[] Xs1 = {this.getX(), this.getX() + this.getWidth() / 4, this.getX() + this.getLength() - this.getWidth() / 4, this.getX() + this.getLength()};
			int[] Ys1 = {this.getY(), this.getY() - this.getWidth(), this.getY() - this.getWidth(), this.getY()};
			g2d.fillPolygon(Xs1, Ys1, 4);
			
			g2d.setColor(Color.BLACK);
			g2d.drawRect(this.getX(), this.getY(), this.getLength(), this.getHeight());
			g2d.drawPolygon(Xs1, Ys1, 4);
		}
		
		else
		{
			g2d.fillRect(this.getX(), this.getY(), this.getLength(), this.getHeight());
			int[] Xs1 = {this.getX(), this.getX() - this.getWidth(), this.getX() + this.getLength() - this.getWidth(), this.getX() + this.getLength()};
			int[] Ys1 = {this.getY(), this.getY() - this.getWidth(), this.getY() - this.getWidth(), this.getY()};
			g2d.fillPolygon(Xs1, Ys1, 4);
			int[] Xs2 = {this.getX(), this.getX(), this.getX() - this.getWidth(), this.getX() - this.getWidth()};
			int[] Ys2 = {this.getY(), this.getY() + this.getHeight(), this.getY() + this.getHeight() - this.getWidth(), this.getY() - this.getWidth()};
			g2d.fillPolygon(Xs2, Ys2, 4);
			
			g2d.setColor(Color.BLACK);
			g2d.drawRect(this.getX(), this.getY(), this.getLength(), this.getHeight());
			g2d.drawPolygon(Xs1, Ys1, 4);
			g2d.drawPolygon(Xs2, Ys2, 4);
		}
		
	}
	
	public void move()
	{
		if (this.getColor().equals("blue") && this.getX() > 510 - this.getLength() / 2)
		{
			this.setY(280 + this.getWidth() / 2 - this.getHeight());
		}
		else if (this.getColor().equals("yellow") && this.getX() == 510 - this.getLength() / 2 && this.getY() < 595 + this.getWidth() / 2 - this.getHeight())
		{
			this.setY(this.getY() + 1);
		}
		if (this.getColor().equals("yellow") == false || this.getX() != 510 - this.getLength() / 2 || this.getY() == 595 + this.getWidth() / 2 - this.getHeight())
		{
			this.setX(this.getX() + 1);
		}
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int randomize(int min, int max)
	{
		return (int)(Math.random() * (max - min + 1) + min);
	}
}