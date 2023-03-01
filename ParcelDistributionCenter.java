package ParcelDistributionCenter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ParcelDistributionCenter extends JPanel
{
	BufferedImage background;
	Scanner scanner;
	private Parcel parcelList[];
	private Conveyor[] conveyorList;
	
	public ParcelDistributionCenter()
	{
		this.background = null;
		this.scanner = new Scanner();
		this.parcelList = new Parcel[20];
		this.conveyorList = new Conveyor[5];
		
		for (int i = 0; i < 20; i++)
		{
			this.parcelList[i] = new Parcel(i * -500);
			this.parcelList[i].setY(430 + this.parcelList[i].getWidth() / 2 - this.parcelList[i].getHeight());
		}
		
		for (int i = 0; i < 5; i++)
		{
			this.conveyorList[i] = new Conveyor();
		}
		
		conveyorList[0].setMoving(1);
		
		try
		{
			//Replace path with the path to "background.jpg" on your local. Uncomment line 42.
			//this.background = ImageIO.read(new File("C:\\Users\\shelb\\eclipse-workspace\\Parcel Distribution Center\\src\\ParcelDistributionCenter\\background.jpg"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e){
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				conveyorList[0].keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e){
			}
		});
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(this.background, 0, 0, 1020, 640, null);
		
		this.scanner.paint(g, true);
		
		//background
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 400, 410, 75);
		g2d.fillRect(610, 250, 410, 75);
		g2d.fillRect(610, 400, 410, 75);
		g2d.fillRect(480, 490, 60, 90);
		g2d.fillRect(540, 565, 480, 73);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 460, 410, 10);
		g2d.fillRect(610, 310, 410, 10);
		g2d.fillRect(610, 460, 410, 10);
		g2d.fillRect(540, 625, 480, 10);
		
		//rollers
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 405, 410, 50);
		g2d.fillRect(610, 255, 410, 50);
		g2d.fillRect(610, 405, 410, 50);
		g2d.fillRect(485, 490, 50, 90);
		g2d.fillRect(540, 570, 480, 50);
		
		//main conveyor
		for (int i = 0; i < 510; i = i + 20)
		{
			g2d.setColor(Color.BLACK);
			g2d.drawLine(conveyorList[0].getConveyorX() + i - 50, 455, conveyorList[0].getConveyorX() + i, 405);
			g2d.setColor(Color.GRAY);
			g2d.fillOval(i, 460, 10, 10);
			if (conveyorList[0].getRollerP() < 40)
			{
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawLine(i + 1, 465, i + 9, 465);
				g2d.setColor(Color.DARK_GRAY);
				g2d.drawLine(i + 5, 461, i + 5, 469);
			}
			else
			{
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawLine(i + 5, 461, i + 5, 469);
				g2d.setColor(Color.DARK_GRAY);
				g2d.drawLine(i + 1, 465, i + 9, 465);
			}
		}
		
		//blue conveyor
		for (int i = 510; i < 1070; i = i + 20)
		{
			boolean checker = false;
			for (Parcel p: parcelList)
			{
				if (p.getColor().equals("blue") && p.getX() + p.getLength() > 710 && p.getX() - p.getWidth() < 1020)
				{
					checker = true;
				}
			}
			if (checker == false)
			{
				conveyorList[1].setMoving(-1);
			}
			else
			{
				conveyorList[1].setMoving(1);
			}
			g2d.setColor(Color.BLACK);
			g2d.drawLine(conveyorList[1].getConveyorX() + i, 305, conveyorList[1].getConveyorX() + i - 50, 255);
			g2d.setColor(Color.GRAY);
			g2d.fillOval(i, 310, 10, 10);
			if (conveyorList[1].getRollerP() < 40)
			{
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawLine(i + 1, 315, i + 9, 315);
				g2d.setColor(Color.DARK_GRAY);
				g2d.drawLine(i + 5, 311, i + 5, 319);
			}
			else
			{
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawLine(i + 5, 311, i + 5, 319);
				g2d.setColor(Color.DARK_GRAY);
				g2d.drawLine(i + 1, 315, i + 9, 315);
			}
		}
		
		//green conveyor
		for (int i = 510; i < 1070; i = i + 20)
		{
			boolean checker = false;
			for (Parcel p: parcelList)
			{
				if (p.getColor().equals("green") && p.getX() + p.getLength() > 710 && p.getX() - p.getWidth() < 1020)
				{
					checker = true;
				}
			}
			if (checker == false)
			{
				conveyorList[2].setMoving(-1);
			}
			else
			{
				conveyorList[2].setMoving(1);
			}
			g2d.setColor(Color.BLACK);
			g2d.drawLine(conveyorList[2].getConveyorX() + i, 455, conveyorList[2].getConveyorX() + i - 50, 405);
			g2d.setColor(Color.GRAY);
			g2d.fillOval(i, 460, 10, 10);
			if (conveyorList[2].getRollerP() < 40)
			{
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawLine(i + 1, 465, i + 9, 465);
				g2d.setColor(Color.DARK_GRAY);
				g2d.drawLine(i + 5, 461, i + 5, 469);
			}
			else
			{
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawLine(i + 5, 461, i + 5, 469);
				g2d.setColor(Color.DARK_GRAY);
				g2d.drawLine(i + 1, 465, i + 9, 465);
			}
		}

		//yellow conveyor down
		for (int i = 490; i < 580; i = i + 20)
		{
			boolean checker = false;
			for (Parcel p: parcelList)
			{
				if (p.getColor().equals("yellow") && p.getY() + p.getHeight() > 490 && p.getY() - p.getWidth() < 520)
				{
					checker = true;
				}
			}
			if (checker == false)
			{
				conveyorList[3].setMoving(-1);
			}
			else
			{
				conveyorList[3].setMoving(1);
			}
			g2d.setColor(Color.BLACK);
			g2d.drawLine(485, conveyorList[3].getConveyorX() + i, 535, conveyorList[3].getConveyorX() + i);
		}
		
		//yellow conveyor right
		for (int i = 510; i < 1070; i = i + 20)
		{
			boolean checker = false;
			for (Parcel p: parcelList)
			{
				if (p.getColor().equals("yellow") && p.getX() + p.getLength() > 565 && p.getX() - p.getWidth() < 1020)
				{
					checker = true;
				}
			}
			if (checker == false)
			{
				conveyorList[4].setMoving(-1);
			}
			else
			{
				conveyorList[4].setMoving(1);
			}
			g2d.setColor(Color.BLACK);
			g2d.drawLine(conveyorList[4].getConveyorX() + i, 620, conveyorList[4].getConveyorX() + i - 50, 570);
			g2d.setColor(Color.GRAY);
			g2d.fillOval(i, 625, 10, 10);
			if (conveyorList[4].getRollerP() < 40)
			{
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawLine(i + 1, 630, i + 9, 630);
				g2d.setColor(Color.DARK_GRAY);
				g2d.drawLine(i + 5, 626, i + 5, 634);
			}
			else
			{
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawLine(i + 5, 626, i + 5, 634);
				g2d.setColor(Color.DARK_GRAY);
				g2d.drawLine(i + 1, 630, i + 9, 630);
			}
		}
		
		for (Parcel p: parcelList)
		{
			p.paint(g);
		}
		
		this.scanner.paint(g, parcelList);
		
		//bottom box to change direction
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(455, 570, 110, 68);
		g2d.setColor(Color.GRAY);
		int[] Xs2 = {465, 555, 565, 455}; 
		int[] Ys2 = {520, 520, 570, 570};
		g2d.fillPolygon(Xs2, Ys2, 4);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(455, 570, 110, 68);
		g2d.drawPolygon(Xs2, Ys2, 4);
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame ("Amazon");
		ParcelDistributionCenter c = new ParcelDistributionCenter();
		frame.add(c);
		frame.setSize(1020, 640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true)
		{
			c.move();
			c.repaint();
			Thread.sleep(10);
		}
	}
	
	public void move()
	{
		for (Parcel p: parcelList)
		{
			if (p.getX() - p.getWidth() > 410 || conveyorList[0].getMoving() == 1)
			{
				p.move();
			}
		}
		
		for (Conveyor c: conveyorList)
		{
			if (c.getMoving() == 1)
			{
				c.move();
			}
		}
	}
	
	public Parcel[] getParcelList()
	{
		return parcelList;
	}
}
