//*********************************************************************************************//
//  CSE 131 LAB 10   LAB_SECTION: Tuesday 11:30-13:00
//  Name: MINGFEI CHEN    WUSTL Key: chenmingfei
//  Student ID: 438830

//  Class: Goal
//  To restart the game: for player 1, press 1,  for player 2, press 2
//  Additional features: 
//      1. Require the player to cross the stream (jumping accross logs, turtles, etc.) as well as the street to reach the goal
//      2. Allow multiple players, either by letting them take turns or having them race towards the goal
//      3. Include a title screen and game over screen, with animations that you've created 
//*********************************************************************************************//

package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Goal implements Drawable {


	double xx=0.5;
	double yy=0.5;
	double length;
	double width;

	double distance = 0.3;
	boolean invaded = false;



	public Goal(double x, double y, double length, double width)
	{
		this.xx = x;
		this.yy = y;
		this.length = length;
		this.width = width;


	}



	@Override
	/**
	 * Draw the rectangles to represent the goals
	 */
	public void drawHit() {

		if(this.invaded) StdDraw.setPenColor(Color.BLACK);     // if the goal is invaded by a frog, show in black
		else StdDraw.setPenColor(Color.yellow);                // if the goal is empty, show in yellow
		StdDraw.filledRectangle(xx, yy, length,width);


	}


}


