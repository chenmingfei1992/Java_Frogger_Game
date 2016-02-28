//*********************************************************************************************//
//  CSE 131 LAB 10   LAB_SECTION: Tuesday 11:30-13:00
//  Name: MINGFEI CHEN    WUSTL Key: chenmingfei
//  Student ID: 438830

//  Class: FroggerMain
//  To restart the game: for player 1, press 1,  for player 2, press 2
//  Additional features: 
//      1. Require the player to cross the stream (jumping accross logs, turtles, etc.) as well as the street to reach the goal
//      2. Allow multiple players, either by letting them take turns or having them race towards the goal
//      3. Include a title screen and game over screen, with animations that you've created 
//*********************************************************************************************//

package lab10;

/*
 * Graded by Wesley Pawson
 * -3 Tons of excessive spacing
 * -1 Some of the lines go way beyond the end of the page, you shouldn't have to scroll to read
 * -0 You switch back and forth between C++ and java style brackets
 * -1 indentation is not consistent
 * -1 Names are hard coded
 * -1 You can keep dying/playing after the game is over
 * -1 You can go off the screen
 * -10 You can walk in the river
 * -5 win condition does not work, does not restart game after lose condition
 * +20 stream
 * +20 multiple players 
 * +0 great animations (but this counts as your required feature since it's worth the least) 
 * 117/100
 */

public class FroggerMain {
	public static void main(String[] args) {
		
		String[] team = new String[2];
		team[0] = "Peter";
		team[1] = "Mike";
		Game g = new Game("Frogger", team);
		g.playGame();
		System.exit(0);
	}
}
