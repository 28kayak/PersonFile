import lejos.nxt.*;
import lejos.addon.*;
import lejos.nxt.addon.CompassHTSensor;
import lejos.nxt.addon.IRSeekerV2;
import lejos.nxt.addon.IRSeekerV2.Mode;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.Sound;
public class SoccerCar 
{
	private static IRSeekerV2 seeker = new IRSeekerV2(SensorPort.S1, Mode.AC);
	private static UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S4);
	
	
	
	private static CompassHTSensor compass = new CompassHTSensor(SensorPort.S2);
	private static LightSensor light = new LightSensor(SensorPort.S3);
	private static int []  strength = new int [5];
	private static int direction;
	private static float degree;
	public static void main (String [] args)throws Exception
	{
		int distance;
		ultra.setMode(ultra.MODE_CONTINUOUS);
		while(true)
		{
			goForward(300);
			if(ultra.getDistance()<8)
			{
				Sound.playTone(400*2, 50);
			}
			
			/**int [] dist = new int [8];
			ultra.ping();
			Thread.sleep(20); 
			ultra.getDistances(dist);
			LCD.clearDisplay();
			for(int index = 0; index < 8 ; index++)
			{
				
				LCD.drawString("Ping "+ dist[index], 0, index);
			}
			*/
			Thread.sleep(50);
		}
		
		//int distance;
		//ultra.setMode(ultra.MODE_CONTINUOUS);
		
		//compass.resetCartesianZero();//set direction to be zero.
		/**while(true)
		{
			Motor.A.setSpeed(900);
			Motor.A.backward();
			//LCD.drawInt((int)ultra.getDistance(), 5, 5);
			while((int)ultra.getDistance() > 8)
			{
				Sound.playTone(400, 40);
				followTheBall();
			}//while
			goForward(100);
			Thread.sleep(500);
			degree = compass.getDegreesCartesian();
			if(degree >= 330 || degree <= 30 )
			{
				if((ditecteBrightness() == 4 && degree < 20) ||( ditecteBrightness() == 3 && degree > 340))
				{// make sure face to enemy's goal
					Sound.beep();
					Motor.A.forward();
					goForward(900);
					Thread.sleep(1000);
				}
				else
				{
					goForward(900);
					//the body is in the middle of the filed and face to the enemy's goal.
					Thread.sleep(500);
				}
			}	
			else
			{
				takeTurn();
				
				if(ultra.getDistance() < 8 )
				{
					goForward(450);
					Thread.sleep(500);
				}
				else
				{
					Sound.twoBeeps();
					
				}
			}
			 
			
		}//while
		
		*/
	}//main
	
	static void goForward(int speed)
	{
		
		Motor.B.setSpeed(speed);
		Motor.C.setSpeed(speed);
		Motor.B.forward();
		Motor.C.forward();
	}//goForward
	static void clockWise(float speed)
	{
		Motor.C.setSpeed(speed);
		Motor.B.setSpeed((int)(speed*0.30));
		//casting speed*0.30 always change to an int.
		
		Motor.C.forward();
		//FWD(OUT_C,speed)G
		
		Motor.B.forward();
		//FWD(OUT_B,0.30*speed);
	}//ClockWise
	static void clockWise_InReverse(int speed)
	{
		//MigiGyakuKaiten
		Motor.B.setSpeed(speed);
		Motor.C.setSpeed(speed);
		Motor.B.backward();
		//REV(OUT_B,speed);
		Motor.C.forward();
		//FWD(OUT_C,speed);

	}//ClockWise_InRevers
	static void leftRotation(float speed)
	{
		Motor.C.setSpeed((int)(speed * 0.3));
		Motor.B.setSpeed(speed);
		Motor.B.forward();
		//FWD(OUT_B, speed);
		Motor.C.forward();
		//FWD(OUT_C, 0.3*speed)
	}//leftRotation
	static void leftRotation_InReverse(int speed)
	{
		//Hidari Gyaky Kaiten
		Motor.B.setSpeed(speed);
		Motor.C.setSpeed(speed);
		Motor.B.forward();
		//FWD(OUT_B, speed);
		Motor.C.backward();
		//REV(OUT_C.speed);
	}//LeftRotetation_InReverse
	static void goBackward(int speed)
	{
		Motor.B.backward();
		Motor.C.backward();
	}//goBackward
	static void rightBehind(float speed)
	{
		//MigiUshiro
		
		Motor.C.setSpeed((int)(speed*0.30));
		Motor.B.backward();
		//REV(OUT_B,speed);
		Motor.C.backward();
		//REV(OUT_C,0.30 * speed);
	}//RightBehind
	static void leftBehind(float speed)
	{
		Motor.B.setSpeed((int) (speed*0.30));
		Motor.C.setSpeed(speed);
		Motor.B.backward();
		Motor.C.backward();
		
	}//leftBehind
	static void followTheBall()

	{
		int [] maxValue = {182,153,162,177,167};
		int [] currentValue; 
		int seekerMax, indexMax, index,maximumRate; 
		
		currentValue = seeker.getSensorValues();
		direction =  seeker.getDirection();
		//for(index = 0; index < 5; index++)
		//{
			//String dispstring = "seeker" + strength[index];
			//LCD.drawString(dispstring, 5, index*8, false);
			//LCD.drawString("strength", 0, 0);
			//LCD.drawInt(currentValue [index],7,0,index+1);
			//LCD.drawString("direction", 0, 6);
			//LCD.drawInt(direction, 10, 0, 7);
		//}//for
		
		seekerMax = 0;
		indexMax = -1;//â‘Î‚ ‚è‚¦‚È‚¢Å’á”
		  
		for(index = 0; index < 5 ; index++)
		{
			currentValue[index] = currentValue[index] * 100 / maxValue[index] ;
			if(seekerMax < currentValue[index])
			{
				seekerMax = currentValue[index];
				indexMax = index;
			}//if
		}//for
		//LCD.drawInt(indexMax,10,5,7);
		maximumRate = seekerMax;
		switch(indexMax)
		{
			case 0:
				//HidariUsiro
				leftBehind(500);
				break;
			case 1:
				//HidariMae
				leftRotation(500);
				break;
			case 2:
				//Mae
				goForward(500);
				break;
			case 3:
				//MigiMae
				clockWise(500);
				break;
			case 4:
				//MigiUsiro
				rightBehind(500);
				break;
			default:
				Sound.playTone(400,400);
				Motor.B.stop();
				Motor.C.stop();
				break;
			}//switch
	}//followTheBall
	static void takeTurn()

	{
		float currntDirection ;
		currntDirection = compass.getDegreesCartesian();
		
		while(currntDirection > 10 && currntDirection < 350)
		{
			currntDirection = compass.getDegreesCartesian();
			//LCD.drawString("Dir is " + currntDirection , 0, 0);
			if(currntDirection < 180)
			{
				clockWise_InReverse(100);
			}//if
			else if (currntDirection >= 180)
			{
				leftRotation_InReverse(100);
			}//else if
		}//while
		Motor.B.stop();
		Motor.C.stop();
	}//takeTurn
	static int ditecteBrightness()
	{
		int readValue;
		/**int lightG, darkestG, middleG, black;
		lightG = ;
		middleG = 46;
		darkestG = 42;
		black = 3;
		*/
		readValue = light.readValue();
		if(readValue <= 415 )
		{
			return 1;
		}
		else if (readValue <= 450)
		{
			return 2;
		}
		else if (readValue <= 489)
		{
			return 3;
		}
		else if (readValue <= 520)
		{
			return 4;
		}
		else 
		{ 
			return 5;
		}
		
	}//ditecteBrightness
	
	/**static void readLightValue()
	{
		int readValue;
		int normalizedValue;
	
		readValue = light.readValue();
		LCD.drawString("readValue "+ readValue, 0, 0);
		normalizedValue = light.readNormalizedValue();
		LCD.drawString("normalized" + normalizedValue, 0, 3);
		
	}//readLightValue
	*/
	static void findDirection()
	{
		
	}//findDirection
	
}//class


