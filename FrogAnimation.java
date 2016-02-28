//*********************************************************************************************//
//  CSE 131 LAB 10   LAB_SECTION: Tuesday 11:30-13:00
//  Name: MINGFEI CHEN    WUSTL Key: chenmingfei
//  Student ID: 438830

//  Class: FrogAnimation
//  To restart the game: for player 1, press 1,  for player 2, press 2
//  Additional features: 
//      1. Require the player to cross the stream (jumping accross logs, turtles, etc.) as well as the street to reach the goal
//      2. Allow multiple players, either by letting them take turns or having them race towards the goal
//      3. Include a title screen and game over screen, with animations that you've created 
//*********************************************************************************************//


package lab10;


import java.awt.Color;

import sedgewick.StdDraw;

public class FrogAnimation {

	public static void main(String[] args) {

		animation(1);


	}


	public static void animation(double L)
	{
		animationPart_1(1, 100);
		animationPart_2(1,Color.RED, Color.yellow);
	}

	/**
	 * The first part of the animation, rotating the stars
	 * @param L
	 * @param rounds
	 */
	public static void animationPart_1(double L, int rounds)
	{
		StdDraw.setXscale(0,L);
		StdDraw.setYscale(0,L);
		int numOfStar = 12;
		double[] t = new double[numOfStar];
		for(int i=0;i<numOfStar;i++)
		{
			t[i] = 2*Math.PI*(double)i/numOfStar;
		}
		double center_x  = L/2;  double center_y  = L/2; double thelta = 0.2; double R = L/3; double delta = 0.6;

		while( rounds>=0)
		{  rounds--;
		if(rounds>=0)  StdDraw.clear();	 


		for(int i=0;i<12;i++)
		{
			t[i] = t[i] + delta;
			thelta = t[i];
			double x = center_x + R*Math.sin(thelta); 
			double y = center_y + R*Math.cos(thelta); 

			paintStar(x,y,L/20,Color.RED);
		}


		}


	}


	/**
	 * draw stars
	 * @param start_x
	 * @param start_y
	 * @param R
	 * @param color
	 */
	public static void paintStar(double start_x, double start_y, double R, Color color)

	{


		double r=(R*Math.sin(Math.PI/10)/Math.sin(3*Math.PI/10));



		int angle =3;

		double[] x=new double[10]; 
		double[] y=new double[10];



		for(int i=0;i<10;i++){ 
			if(i%2==0){ 
				x[i]=start_x+(double)(R*Math.cos(Math.PI*angle/10+(i-1)*Math.PI/5)); 
				y[i]=start_y+(double)(R*Math.sin(Math.PI*angle/10+(i-1)*Math.PI/5)); 
			} 
			else{ 
				x[i]=start_x+(double)(r*Math.cos(Math.PI*angle/10+(i-1)*Math.PI/5)); 
				y[i]=start_y+(double)(r*Math.sin(Math.PI*angle/10+(i-1)*Math.PI/5)); 
			} 
		}
		StdDraw.setPenColor(color);
		StdDraw.filledPolygon(x,y);


	}


	/**
	 * 2nd part of the animation, the text "FROGGER" fly into the screen
	 * @param L
	 * @param textColor
	 * @param frogColor
	 */
	public static void animationPart_2(double L, Color textColor, Color frogColor)
	{
		//StdDraw.clear();


		double[] startX = new double[7];
		double[] startY = new double[7];
		double[] stopX  = new double[7];
		double[] stopY  = new double[7];
		for(int i=0;i<7;i++)
		{

			startX[i] = L;
			startY[i] = (L/5)*2 ;

			stopX[i] = L/6 + (L/9)*i;;
			stopY[i] = (L/5)*2 ;

		}
		String[] str = {"F","r","o","g","g","e","r"};


		double step = L/100;

		for(int i=0;i<7;i++)
		{    
			while(startX[i]>=stopX[i])
			{
				startX[i] = startX[i] - step;
				StdDraw.clear();
				for(int k=0;k<i;k++)
				{   animationPart_1(1,0);
				StdDraw.setPenColor(frogColor);
				StdDraw.filledRectangle(stopX[k],(L/3)*2,  L/25, L/40);
				StdDraw.setPenColor(textColor);
				StdDraw.text(stopX[k],(L/3)*2,str[k]);


				}
				animationPart_1(1,0);
				StdDraw.setPenColor(frogColor);
				StdDraw.filledRectangle(startX[i],startY[i],  L/25, L/40);
				StdDraw.setPenColor(textColor);
				StdDraw.text(startX[i],startY[i],str[i]);
				StdDraw.show(10);

			}  

			while(startY[i]<=(L/3)*2)
			{
				startY[i] = startY[i] + step;
				StdDraw.clear();
				for(int k=0;k<i;k++)
				{   animationPart_1(1,0);
				StdDraw.setPenColor(frogColor);
				StdDraw.filledRectangle(stopX[k],(L/3)*2,  L/25, L/40);
				StdDraw.setPenColor(textColor);
				StdDraw.text(stopX[k],(L/3)*2,str[k]);


				}
				animationPart_1(1,0);
				StdDraw.setPenColor(frogColor);
				StdDraw.filledRectangle(startX[i],startY[i],  L/25, L/40);
				StdDraw.setPenColor(textColor);
				StdDraw.text(startX[i],startY[i],str[i]);
				StdDraw.show(10);

			}   


		}

		StdDraw.setPenColor(Color.BLUE);
		StdDraw.text(L/2,L/2,"Now start the game ! !");
		StdDraw.show(1200);





	}






}
