package coreClasses;

import java.util.Random;

public class Utility {

	public int RandomSelect(int min, int max) {
		  Random rand = new Random();
		  int randomNum = rand.nextInt((max - min) + 1) + min;
		  return randomNum;
		 }
	
}
