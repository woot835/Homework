package homework14;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class Bot {

	public static void main(String[] args) throws AWTException {

		Robot botty = new Robot();

		botty.delay(5000);

		botty.mousePress(InputEvent.BUTTON3_MASK);
		botty.delay(500);
		botty.mouseRelease(InputEvent.BUTTON3_MASK);
		
		botty.keyPress(KeyEvent.VK_W);
		botty.delay(500);
	    botty.keyRelease(KeyEvent.VK_W);
	    
	    botty.delay(2000);
	    botty.keyPress(KeyEvent.VK_D);
	    botty.mousePress(InputEvent.BUTTON1_MASK);
	    botty.delay(60000);
	    
	    botty.mouseRelease(InputEvent.BUTTON1_MASK);
	    botty.keyRelease(KeyEvent.VK_D);
	    
	    botty.mousePress(InputEvent.BUTTON3_MASK);
		botty.delay(500);
		botty.mouseRelease(InputEvent.BUTTON3_MASK);
	    
		/*
		 *  AFK Bot made for Rocket League.
		 *  The bot itself when started will make the car flip and then proceed to do spins and use any boost that is available
		 *  The spinning will proceed for 60 seconds and then it will flip itself back up.
		 */
		
		

	}

}
