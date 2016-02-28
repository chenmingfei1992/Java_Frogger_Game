//*********************************************************************************************//
//  CSE 131 LAB 10   LAB_SECTION: Tuesday 11:30-13:00
//  Name: MINGFEI CHEN    WUSTL Key: chenmingfei
//  Student ID: 438830

//  Class: Frog
//  To restart the game: for player 1, press 1,  for player 2, press 2
//  Additional features: 
//      1. Require the player to cross the stream (jumping accross logs, turtles, etc.) as well as the street to reach the goal
//      2. Allow multiple players, either by letting them take turns or having them race towards the goal
//      3. Include a title screen and game over screen, with animations that you've created 
//*********************************************************************************************//

package lab10;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import sedgewick.StdDraw;

public class Frog {

	double x=0.5;       // instance variables
	double y=0.5;
	double length;
	double width;
	double speed=0.05;
	double r=0.05;
	double lives;
	double score = 0;
	Color color;
	double moveItselfSpeed;
	
	
	public Frog(double x, double y, double length, double width,double speed, double lives, Color c)
	{
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		this.speed = speed;
		this.lives = lives;
		this.color = c;
	}

	
	/**
	 * no return, move the frog according the key pressed
	 * @param playerNum
	 */
	public void Move(int playerNum) {
		this.drawFrog();
		
	
		if (ArcadeKeys.isKeyPressed(playerNum, ArcadeKeys.KEY_LEFT)) 
		{
			x = x-speed;
			drawFrog();
		}
		if (ArcadeKeys.isKeyPressed(playerNum, ArcadeKeys.KEY_RIGHT)) 
		{
			x = x+speed;
			drawFrog();
		}	
		if (ArcadeKeys.isKeyPressed(playerNum, ArcadeKeys.KEY_UP))
		{
			y = y+speed;
			drawFrog();
		}


		if (ArcadeKeys.isKeyPressed(playerNum, ArcadeKeys.KEY_DOWN)) 
		{
			y = y-speed;
			drawFrog();
		}

		
		
		
	
	}
	

	/**
	 * use StdDraw to draw a rectangle to represent the frog
	 */
	public void drawFrog()
	{   

		StdDraw.setPenColor(this.color);
		StdDraw.filledRectangle(x, y, length,width);

		
	}

	/**
	 * Check whether the frog collide one of the cars in car List
	 * @param carList
	 * @return
	 */
	public boolean HitCar(LinkedList<Car> carList)
	{
		
		boolean HitCar = false;
		for(int i=0;i<carList.size();i++)
		{    
			boolean collideOnce = ((Math.abs(this.x-carList.get(i).xx))<(this.length+carList.get(i).length))&&((Math.abs(this.y-carList.get(i).yy))<(this.width+carList.get(i).width));
			HitCar = HitCar || collideOnce;
		}
		
		return HitCar;
	}
	
	/**
	 * Check whether the frog enter in one of the goals in goal List
	 * @param goalList
	 * @return
	 */
	public boolean HitGoal(LinkedList<Goal> goalList )
	{
		boolean HitGoal = false;
		for(int i=0;i<goalList.size();i++)
		{
			boolean enterOnce = (((this.x+this.length)<(goalList.get(i).xx+goalList.get(i).length))&&((this.x-this.length)>(goalList.get(i).xx-goalList.get(i).length)))&&(((this.y+this.width)<(goalList.get(i).yy+goalList.get(i).width))&&((this.y-this.width)>(goalList.get(i).yy-goalList.get(i).width)));
			if(enterOnce) goalList.get(i).invaded = true;
			HitGoal = HitGoal || enterOnce;
		}
	  return HitGoal;
	}
	
	/**
	 * Check whether the frog is on one log of the loglist
	 * @param logList
	 * @return
	 */
	public boolean isOnLog(LinkedList<Car> logList )
	{
		boolean isOnLog = false;
		for(int i=0;i<logList.size();i++)
		{
			boolean enterOnce = (this.x>=(logList.get(i).xx - logList.get(i).length))&& (this.x<=(logList.get(i).xx + logList.get(i).length))&&(this.y>=(logList.get(i).yy - logList.get(i).width-this.width))&&(this.y<=(logList.get(i).yy + logList.get(i).width + this.width));
			if(enterOnce) this.moveItselfSpeed = logList.get(i).speed;
			isOnLog = isOnLog || enterOnce;
		}
		return isOnLog;
	  
	}
	
	/**
	 * move the frog by itself when no key is pressed
	 */
	public void moveItself()
	{   if(x>=1) x=0;
		
		this.x = this.x+moveItselfSpeed;
		this.drawFrog();
	}
	
	
	
	/**
	 * If collide with car or stream, move the frog to initial position
	 * no return
	 * @param init_x
	 * @param init_y
	 */
	  public void Die(double init_x, double init_y)
	    {
		  
				
				this.x = init_x;
				this.y= init_y;
				this.lives --;    // if die, cut one life
			
	    }
	  
	  
	  /**
	   * If enter into one of the goals, move the frog to initial position
	   * @param init_x
	   * @param init_y
	   */
	  public void Win(double init_x, double init_y)
	  {

		  this.x = init_x;
		  this.y= init_y;
		  this.score += 100;    // if win once, add 100 scores
  
	  }
	
}
