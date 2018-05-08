package com.ubs.opsit.interviews;

import java.util.Arrays;

public class TimeConvertorImpl implements TimeConverter {

	private char[] topRowLamp = new char[1];
	private final char[] fiveHoursRowLamps = new char[4];
	private final char[] oneHourRowLamps = new char[4];
	private final char[] fiveMinutesRowLamps = new char[11];
	private final char[] oneMinuteRowLamps = new char[4];
	
	TimeConvertorImpl(){
		Arrays.fill(topRowLamp, 'O');
		Arrays.fill(fiveHoursRowLamps, 'O');
		Arrays.fill(oneHourRowLamps, 'O');
		Arrays.fill(fiveMinutesRowLamps, 'O');
		Arrays.fill(oneMinuteRowLamps, 'O');
	}
	
	
	@Override
	public String convertTime(String inputTime) {
		if(inputTime == null || "".equals(inputTime) ){
            throw new RuntimeException("Input time can not be null or empty.");
        }
        
		String inputTimeParts[]=inputTime.split(":");
        
		if(inputTimeParts.length != 3){ 
            throw new RuntimeException("Time format provided is not valid.");
        }
        
		if(Integer.parseInt(inputTimeParts[0])==24 && (Integer.parseInt(inputTimeParts[2])>0 || Integer.parseInt(inputTimeParts[1]) >0)){
        	throw new RuntimeException("Incorrect time for conversion");
        }
		
		return setBerlinClockTime(Integer.valueOf(inputTimeParts[0]),Integer.valueOf(inputTimeParts[1]),Integer.valueOf(inputTimeParts[2]));
	}
	
	public String setBerlinClockTime(int hours, int minutes, int seconds) {
		
		int countLampsFiveHourRow = hours / 5;
		int countLampsOneHourRow = hours % 5;
		int countLampsFiveMinutesRow = minutes / 5;
		int countLampsOneMinutesRow = minutes % 5;
		
		if(seconds % 2 == 0) {
			topRowLamp[0] = 'Y';
		}else{
			topRowLamp[0] = '0';
		}
		for(int i = 0;i<countLampsFiveHourRow; i++) {
			fiveHoursRowLamps[i] = 'R';
		}
		for (int i = 0; i < countLampsOneHourRow; i++) {
			oneHourRowLamps[i] = 'R';
		}
		for (int i = 0; i < countLampsFiveMinutesRow; i++) {
			if (i % 3 > 1) {
				fiveMinutesRowLamps[i] = 'R';
			} else {
				fiveMinutesRowLamps[i] = 'Y';
			}
		}
		for (int i = 0; i < countLampsOneMinutesRow; i++) {
			oneMinuteRowLamps[i] = 'Y';
		}
		
		StringBuilder result = new StringBuilder();
		result.append(topRowLamp);
		result.append(System.getProperty("line.separator"));
		result.append(fiveHoursRowLamps);
		result.append(System.getProperty("line.separator"));
		result.append(oneHourRowLamps);
		result.append(System.getProperty("line.separator"));
		result.append(fiveMinutesRowLamps);
		result.append(System.getProperty("line.separator"));
		result.append(oneMinuteRowLamps);
		
		return result.toString();
	}

}
