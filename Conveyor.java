package ParcelDistributionCenter;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Conveyor
{
	private int moving;
	private int conveyorX;
	private int rollerP;
	
	public Conveyor()
	{
		this.moving = -1;
		this.conveyorX = 0;
		this.rollerP = 0;
	}
	
	public void move()
	{
		this.setConveyorX(this.getConveyorX() + 1);
		this.setRollerP(this.getRollerP() + 1);
		if (this.getConveyorX() == 20)
		{
			this.setConveyorX(0);
		}
		if (this.getRollerP() == 80)
		{
			this.setRollerP(0);
		}
	}
	
	public int getMoving()
	{
		return this.moving;
	}
	
	public int getConveyorX()
	{
		return this.conveyorX;
	}
	
	public int getRollerP()
	{
		return this.rollerP;
	}
	
	public void setMoving(int moving)
	{
		this.moving = moving;
	}
	
	public void setConveyorX(int conveyorX)
	{
		this.conveyorX = conveyorX;
	}
	
	public void setRollerP(int rollerP)
	{
		this.rollerP = rollerP;
	}
	
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			this.setMoving(this.getMoving() * -1);
		}
	}
}