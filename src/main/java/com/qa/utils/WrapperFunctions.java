package com.qa.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

public class WrapperFunctions {
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to Waits for the specified amount of [timeInMilliseconds]
     * @param  timeUnitSeconds - wait time seconds
     */
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to generate Random Number
     * @param  number
     */
	public int generateRandomNumber(int number){
		Random random = new Random();
		int x = random.nextInt(number);   
		return x;
	}
	
	public static String randomestring(){
		String generateString1 = RandomStringUtils.randomAlphabetic(5);
		return (generateString1);
	}


}
