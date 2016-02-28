//*********************************************************************************************//
//  CSE 131 LAB 10   LAB_SECTION: Tuesday 11:30-13:00
//  Name: MINGFEI CHEN    WUSTL Key: chenmingfei
//  Student ID: 438830

//  Class: Car
//  To restart the game: for player 1, press 1,  for player 2, press 2
//  Additional features: 
//      1. Require the player to cross the stream (jumping accross logs, turtles, etc.) as well as the street to reach the goal
//      2. Allow multiple players, either by letting them take turns or having them race towards the goal
//      3. Include a title screen and game over screen, with animations that you've created 
//*********************************************************************************************//

package lab10;

import java.awt.Color;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;

public class Car implements Drawable {


	double xx=0.5;
	double yy=0.5;
	double length;
	double width;
	double speed=0.05;
	Color color;

	public Car(double x, double y, double length, double width,double speed, Color color)
	{
		this.xx = x;
		this.yy = y;
		this.length = length;
		this.width = width;
		this.speed = speed;
		this.color = color;

	}


	@Override
	/**
	 * Draw the rectangles to represent the cars
	 */
	public void drawHit() {



		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);

		xx = xx + speed;        // move the cars

		if ( xx >= 1) {    // if reach the edge, show in the left side again
			xx=0;

		}
		else if ( xx <= 0) {   
			xx=0;
		}

		StdDraw.setPenColor(this.color);
		StdDraw.filledRectangle(xx, yy, length,width);


	}


}


