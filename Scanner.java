package ParcelDistributionCenter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Scanner
{
	BufferedImage plane;
	BufferedImage truck;
	BufferedImage question;
	
	public Scanner()
	{
		this.plane = null;
		this.truck = null;
		this.question = null;
		
		try
		{
			this.plane = ImageIO.read(new File("C:\\Users\\lewisv\\eclipse-workspace\\Parcel Distribution Center\\src\\ParcelDistributionCenter\\plane.jpg"));
			this.truck = ImageIO.read(new File("C:\\Users\\lewisv\\eclipse-workspace\\Parcel Distribution Center\\src\\ParcelDistributionCenter\\truck.png"));
			this.question = ImageIO.read(new File("C:\\Users\\lewisv\\eclipse-workspace\\Parcel Distribution Center\\src\\ParcelDistributionCenter\\question.jpg"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g, Parcel[] parcelList)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//scanner body
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(410, 190, 200, 300);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(310, 360, 100, 120);
		g2d.fillRect(610, 360, 100, 120);
		g2d.fillRect(610, 210, 100, 120);
		g2d.setColor(Color.GRAY);
		int[] Xs1 = {360, 410, 410, 310}; 
		int[] Ys1 = {350, 350, 360, 360};
		g2d.fillPolygon(Xs1, Ys1, 4);
		int[] Xs2 = {610, 660, 710, 610}; 
		int[] Ys2 = {350, 350, 360, 360};
		g2d.fillPolygon(Xs2, Ys2, 4);
		int[] Xs3 = {610, 710, 660, 610}; 
		int[] Ys3 = {330, 330, 340, 340};
		g2d.fillPolygon(Xs3, Ys3, 4);
		
		g2d.setColor(Color.BLACK);
		g2d.drawRect(410, 190, 200, 300);
		g2d.drawRect(310, 360, 100, 120);
		g2d.drawRect(610, 360, 100, 120);
		g2d.drawRect(610, 210, 100, 120);
		g2d.drawPolygon(Xs1, Ys1, 4);
		g2d.drawPolygon(Xs2, Ys2, 4);
		g2d.drawPolygon(Xs3, Ys3, 4);
		
		//scanner light off
		g2d.setColor(Color.RED.darker().darker());
		g2d.fillOval(570, 210, 20, 20);
		
		//scanner light on
		for (Parcel p: parcelList)
		{
			if (p.getX() + p.getLength() > 310)
			{
				if (p.getX() < 710 && p.getY() - p.getWidth() < 490)
				{
					g2d.setColor(Color.RED);
					g2d.fillOval(570, 210, 20, 20);
				}
				if (p.getColor().equals("blue"))
				{
					g2d.setColor(Color.BLUE.darker());
					g2d.fillRoundRect(0, 500, 140, 140, 20, 20);
					g2d.setColor(Color.BLUE);
					g2d.fillRoundRect(10, 510, 120, 120, 20, 20);
					g.drawImage(this.plane, 20, 520, 100, 100, null);
				}
				else if (p.getColor().equals("green"))
				{
					g2d.setColor(Color.GREEN.darker());
					g2d.fillRoundRect(0, 500, 140, 140, 20, 20);
					g2d.setColor(Color.GREEN);
					g2d.fillRoundRect(10, 510, 120, 120, 20, 20);
					g.drawImage(this.truck, 20, 520, 100, 100, null);
				}
				else if (p.getColor().equals("yellow"))
				{
					g2d.setColor(Color.YELLOW.darker());
					g2d.fillRoundRect(0, 500, 140, 140, 20, 20);
					g2d.setColor(Color.YELLOW);
					g2d.fillRoundRect(10, 510, 120, 120, 20, 20);
					g.drawImage(this.question, 20, 520, 100, 100, null);
				}
			}
		}
	}
	
	public void paint(Graphics g, boolean b)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.BLUE);
		g2d.fillOval(410, 530, 60, 40);
		g2d.fillOval(550, 530, 60, 40);
		g2d.setColor(Color.BLACK);
		g2d.drawOval(410, 530, 60, 40);
		g2d.drawOval(550, 530, 60, 40);
		
		g2d.setColor(Color.BLUE);
		g2d.fillOval(420, 540, 40, 20);
		g2d.setColor(Color.BLACK);
		g2d.drawOval(420, 540, 40, 20);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(420, 490, 40, 60);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(420, 490, 40, 60);
		g2d.setColor(Color.BLUE);
		g2d.drawLine(420, 550, 460, 550);
		
		g2d.setColor(Color.BLUE);
		g2d.fillOval(560, 540, 40, 20);
		g2d.setColor(Color.BLACK);
		g2d.drawOval(560, 540, 40, 20);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(560, 490, 40, 60);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(560, 490, 40, 60);
		g2d.setColor(Color.BLUE);
		g2d.drawLine(560, 550, 600, 550);
	}
}