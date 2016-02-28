//*********************************************************************************************//
//  CSE 131 LAB 10   LAB_SECTION: Tuesday 11:30-13:00
//  Name: MINGFEI CHEN    WUSTL Key: chenmingfei
//  Student ID: 438830

//  Class: Game
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
import lab10.FrogAnimation;



public class Game implements FroggerGame {

	int score = 0;
	int lock = 0;
	String name;
	String[ ]  teamMembers;
	
	public static void main(String[] args) {
		String[] team = new String[2];
		team[0] = "Peter";
		team[1] = "Mike";
		Game x = new Game("Frogger", team);



		x.playGame() ;




	}

	public Game(String name, String[] teamMembers)     // constructor
	{
		this.name = name;             
		this.teamMembers = teamMembers;
	}
	
	
	@Override
	/**
	 * no return, implement the game
	 */
	public void playGame() {
		
		
		
		StdDraw.clear();
		
	
		FrogAnimation.animation(1);             // Game title 
		
		StdDraw.clear();                        // clear the title
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		Frog player1 =new Frog(0.1,0.03,0.015,0.015,0.04,5,Color.MAGENTA);     //initial one frog
		Frog player2 =new Frog(0.9,0.03,0.015,0.015,0.04,5,Color.BLUE);         //initial another frog
		player1.drawFrog();        // draw two frogs first
		player2.drawFrog();
	
/*********************************************  this part declare the goals  !!!!!!!!!*******************************************************************/   		
		int GoalNum = 5;double firstGoal_x =0.1;  double firstGoal_y =0.8; double Goal_length =0.08; double Goal_width =0.04; double distance = 0.2;
		LinkedList<Goal> goalList = new LinkedList<Goal>(); 
		for(int i=0;i<GoalNum;i++)
		    {
			goalList.add(new Goal(firstGoal_x+distance*i,firstGoal_y,Goal_length,Goal_width ));
		    }
/********************************************************************************************************************************************************/   		

		
		
/*********************************************  this part declare the Cars  !!!!!!!!!*******************************************************************/  
		int CarNumPerline = 4;   Color[] colorArray = {Color.RED, Color.GRAY, Color.ORANGE};  double speed =0.008;
		int line = 3; double x_distance =0.25; double y_distance = 0.15; double init_x =0.2;  double init_y = 0.15; double carLength = 0.04;  double carWidth = 0.025; 
		LinkedList<Car> carList = new LinkedList<Car>(); 
		for(int i=0;i<line;i++)
		    {
			for(int j=0;j<CarNumPerline;j++)
			  {
				carList.add(new Car(init_x+ j *x_distance, init_y+ i *y_distance, carLength, carWidth, speed-0.002*i,colorArray[i] ));
			  }
		    }
/********************************************************************************************************************************************************/ 		

		
		
/*********************************************  this part declare the Logs  !!!!!!!!!*******************************************************************/  
		int logLine =4; int logNum = 3; double log_x_distance =0.3; double log_init_x =0.2; double log_y_distance = 0.036;  double log_init_y = 0.55; double LogLength = 0.1;  double LogWidth = 0.013; 
		double[] logX = {0.1,0.12,0.08,0.3,};
		double[] logLength = {0.08,0.09,0.11,0.07};
		double[] logSpeed = {0.01,0.008,0.014,0.005};
		LinkedList<Car> logList = new LinkedList<Car>(); 
		for(int i=0;i<logLine;i++)
		{
		for(int j=0;j<logNum;j++)
			  {
			logList.add(new Car(logX[i]+ j*log_x_distance, log_init_y+i*log_y_distance, logLength[i], LogWidth, logSpeed[i],Color.GREEN ));
			  }
		}  
/********************************************************************************************************************************************************/ 		
		
		
		
/*********************************************  this part declare the Streams  !!!!!!!!!*******************************************************************/  
		 double stream_init_x =0.2;  double stream_init_y = 0.6; double streamLength = 0.9;  double streamWidth = 0.065; 
		LinkedList<Car> streamList = new LinkedList<Car>(); 

	
			streamList.add(new Car( stream_init_x,  stream_init_y,  streamLength,  streamWidth, 0,Color.lightGray ));   // one stream 
			
		    
/********************************************************************************************************************************************************/ 		
		
		
		
		
		
		
		
		
		StdDraw.setPenColor(Color.red);
		while(true)
		{
			
		
			while (!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) { 
				

			//if collide with car, move the f. position to initial, cut lives 
				
				if(player1.HitCar(carList)) player1.Die(0.1,0.03);
				if(player2.HitCar(carList)) player2.Die(0.9,0.03);
		
			//if collide with car, move the f. position to initial, gain scores 
				if(player1.HitGoal(goalList)) player1.Win(0.1,0.03);
				if(player2.HitGoal(goalList)) player2.Win(0.9,0.03);
	         
			// if collide with stream and not on logs, die	
				if((player1.y>= stream_init_y-streamWidth/2)&&(player1.y<= stream_init_y+streamWidth/2)&& (!player1.isOnLog(logList))) player1.Die(0.1,0.03); 
				if((player2.y>= stream_init_y-streamWidth/2)&&(player2.y<= stream_init_y+streamWidth/2)&& (!player2.isOnLog(logList))) player2.Die(0.9,0.03); 
    
				/***  this line clear every thing  !!!!!!!!!************/        
                StdDraw.clear();
     
                /***  this line clear every thing  !!!!!!!!!!************/   	
            	
        
                
                StdDraw.text(.15, .99, "Player 1: "+ this.teamMembers[0]);     // show information of player1
            	StdDraw.text(.15, .9,  " remaining lives=" + player1.lives);

				StdDraw.text(.15, .95,  " Scores: "+player1.score);
				
				
				 StdDraw.text(.8, .99, "Player 2: "+ this.teamMembers[1]);      // show information of player2
			   	StdDraw.text(.8, .9, " remaining lives=" + player2.lives);

				StdDraw.text(.8, .95, " Scores: "+player2.score);
				
				
				
				if(player1.lives<=0)
				{   
					
					StdDraw.text(.5, .5,  "Player 1:" + this.teamMembers[0]+" Game Over !: ");   // show Game over information of player 1
					StdDraw.text(.5, .4,  "Your final score is :  " +  player1.score);
					StdDraw.text(.5, .3,  "If you want restart, press NUMBER 1 !");
					
					
					if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_WHITE))	    // restart if NUM 1 is pressed
					{
						player1.lives =  5;                                     // recover the lives
						player1.score =  0;                                     // clear the scores
						StdDraw.clear();
						StdDraw.text(.5, .5,  "now restart !: ");
						StdDraw.show(1000);
						
						for(int i=0;i<goalList.size();i++)                 // recover the goals
						{  
							goalList.get(i).invaded = false;
						}
					}
					
				}
				
				
				if(player2.lives<=0)
				{   
					
					StdDraw.text(.5, .5,   "Player 2:" + this.teamMembers[1]+" Game Over !: ");    // show Game over information of player 2
					StdDraw.text(.5, .4,  "Your final score is :  " +  player2.score);
					StdDraw.text(.5, .35,  "If you want restart, press NUMBER 2 !");
					
					if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_WHITE))	         // restart if NUM 2 is pressed
					{
						player2.lives =  5;                                             // recover the lives
						player2.score =  0;                                            // clear the scores
						StdDraw.clear();
						StdDraw.text(.5, .5,  "now restart !: ");
						StdDraw.show(1000);
						for(int i=0;i<goalList.size();i++)                            // recover the goals
						{  
							goalList.get(i).invaded = false;
						}
						
					}
					
				}
				
				
				
				for(int i=0;i<streamList.size();i++)              // draw the stream
				{
                   streamList.get(i).drawHit();
				}
				
				for(int i=0;i<logList.size();i++)                    // draw the logs
				{
					logList.get(i).drawHit();
				}
          
				for(int i=0;i<carList.size();i++)                 // draw the cars
				{
					carList.get(i).drawHit();
				}
				for(int i=0;i<goalList.size();i++)                // draw the goals
				{
					goalList.get(i).drawHit();
				}
			
				
				if(player1.isOnLog(logList))  player1.moveItself();    // if frog is on log, ride this log
				if(player2.isOnLog(logList))  player2.moveItself();
				
				player1.Move(0);         // if not on logs, move if press: up left right down
				player2.Move(1);
				StdDraw.show(50);
				
				
				
				
				boolean AllGoalInvaded = true;  
				for(int i=0;i<goalList.size();i++)
				{  
					AllGoalInvaded = AllGoalInvaded && goalList.get(i).invaded;    // if goal is invaded, get black to indicate that it is invaded
				}
				 
				if(AllGoalInvaded) 
					{
						for(int i=0;i<goalList.size();i++)
							{  
								goalList.get(i).invaded = false;           // if all goals are black, recover
							}
				
					}
				
				
				
				
				
			}


		}
	}

  
	@Override
	/**
	 * return the name of Game
	 */
	public String getGameName() {

		return this.name;
	}

	@Override
	/**
	 * return the teamMembers of Game
	 */
	public String[] getTeamMembers() {
	
		return this.teamMembers;
	}






}
