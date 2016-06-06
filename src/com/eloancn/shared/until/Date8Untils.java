package com.eloancn.shared.until;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 *	Java 8 ���ڴ����� 
 */
public class Date8Untils {
	
	/**************************************/
	/***************   ����       ***************/
	/**************************************/
	
	
	//��ȡ��ǰ����(���磺2014-01-14)
	public LocalDate getDateOfNow(){
		return LocalDate.now();
	}
	
	/**
	 * ��ȡ��ǰ����
	 * @param year ��
	 * @param month �£���λ����
	 * @param day ��
	 * @return ���ڶ���(���磺2014-01-14)
	 */
	public LocalDate getDateOfNow(String year, String month, String day){
		return LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
	}
	
	//�ж����������Ƿ����
	public boolean isDateEquals(LocalDate dateOne, LocalDate dateTwo){
		return dateOne.equals(dateTwo);
	}
	
	/**************************************/
	/*************   ����_��         **************/
	/**************************************/
	
	
	public String getYearOfNow(){
		return String.valueOf(LocalDate.now().getYear());
	}
	
	/**************************************/
	/*************   ����_��         **************/
	/**************************************/
	
	
	public String getMonthOfNow(){
		return String.valueOf(LocalDate.now().getMonthValue());
	}
	
	/**************************************/
	/*************   ����_��         **************/
	/**************************************/
	
	
	public String getDateByAddWeek(long addNum){
		return String.valueOf(LocalDate.now().plus(addNum, ChronoUnit.WEEKS));
	}
	
	public String getDateByAddWeek(String data, long addNum){
		return String.valueOf(LocalDate.parse(data).plus(addNum, ChronoUnit.WEEKS));
	}
	
	/**************************************/
	/*************   ����_��         **************/
	/**************************************/
	
	
	//��ȡ��ǰ�µĵ�ǰ����
	public String getDayOfMonth(){
		return String.valueOf(LocalDate.now().getDayOfMonth());
	}
	
	//��ȡ��ǰ��ĵ�ǰ����
	public String getDayOfYear(){
		return String.valueOf(LocalDate.now().getDayOfYear());
	}
	
	//��ȡ��ǰ�µĵ�һ��
	public String getFirstDayOfMonth(){
		return String.valueOf(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).getDayOfMonth());
	}
	
	//��ȡ��ǰ�µ����һ��
	public String getLastDayOfMonth(){
		return String.valueOf(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());
	}
	
	//��ȡ�������������
	public long daysBetween(String dayOneStr,String dayTwoStr) {  
	     
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dayOneLD = LocalDate.parse(dayOneStr, dtf);
		LocalDate dayTwoLD = LocalDate.parse(dayTwoStr, dtf);
		return dayTwoLD.toEpochDay() - dayOneLD.toEpochDay();
    } 
	
	/**************************************/
	/***************   ʱ��       ***************/
	/**************************************/
	
	
	public String getTime(){
		return String.valueOf(LocalTime.now().withNano(0));
	}
	
	/**************************************/
	/*************   ʱ��_ʱ         **************/
	/**************************************/
	
	
	public String getTimeByAddHours(String hours){
		return String.valueOf(LocalTime.now().plusHours(Long.valueOf(hours)).withNano(0));
	}
	
	public String getTimeByAddHours(LocalTime localTime, String hours){
		return String.valueOf(localTime.plusHours(Long.valueOf(hours)).withNano(0));
	}
	
	/**************************************/
	/*************   ʱ��_��         **************/
	/**************************************/
	
	
	public String getTimeByAddMinutes(String minutes){
		return String.valueOf(LocalTime.now().plusMinutes(Long.valueOf(minutes)).withNano(0));
	}
	
	public String getTimeByAddMinutes(LocalTime localTime, String minutes){
		return String.valueOf(localTime.plusMinutes(Long.valueOf(minutes)).withNano(0));
	}
	
	/**************************************/
	/*************   ʱ��_��         **************/
	/**************************************/
	
	
	//��õ�ǰʱ�������
	public long getcurrentTimeMillis(){
		return Instant.now().toEpochMilli();
	}
	
}
