package com.eloancn.shared.until;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 *	Java 8 日期处理类 
 */
public class Date8Untils {
	
	/**************************************/
	/***************   日期       ***************/
	/**************************************/
	
	
	//获取当前日期(例如：2014-01-14)
	public LocalDate getDateOfNow(){
		return LocalDate.now();
	}
	
	/**
	 * 获取当前日期
	 * @param year 年
	 * @param month 月（两位数）
	 * @param day 天
	 * @return 日期对象(例如：2014-01-14)
	 */
	public LocalDate getDateOfNow(String year, String month, String day){
		return LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
	}
	
	//判断两个日期是否相等
	public boolean isDateEquals(LocalDate dateOne, LocalDate dateTwo){
		return dateOne.equals(dateTwo);
	}
	
	/**************************************/
	/*************   日期_年         **************/
	/**************************************/
	
	
	public String getYearOfNow(){
		return String.valueOf(LocalDate.now().getYear());
	}
	
	/**************************************/
	/*************   日期_月         **************/
	/**************************************/
	
	
	public String getMonthOfNow(){
		return String.valueOf(LocalDate.now().getMonthValue());
	}
	
	/**************************************/
	/*************   日期_周         **************/
	/**************************************/
	
	
	public String getDateByAddWeek(long addNum){
		return String.valueOf(LocalDate.now().plus(addNum, ChronoUnit.WEEKS));
	}
	
	public String getDateByAddWeek(String data, long addNum){
		return String.valueOf(LocalDate.parse(data).plus(addNum, ChronoUnit.WEEKS));
	}
	
	/**************************************/
	/*************   日期_日         **************/
	/**************************************/
	
	
	//获取当前月的当前天数
	public String getDayOfMonth(){
		return String.valueOf(LocalDate.now().getDayOfMonth());
	}
	
	//获取当前年的当前天数
	public String getDayOfYear(){
		return String.valueOf(LocalDate.now().getDayOfYear());
	}
	
	//获取当前月的第一天
	public String getFirstDayOfMonth(){
		return String.valueOf(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).getDayOfMonth());
	}
	
	//获取当前月的最后一天
	public String getLastDayOfMonth(){
		return String.valueOf(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());
	}
	
	//获取两日期相差天数
	public long daysBetween(String dayOneStr,String dayTwoStr) {  
	     
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dayOneLD = LocalDate.parse(dayOneStr, dtf);
		LocalDate dayTwoLD = LocalDate.parse(dayTwoStr, dtf);
		return dayTwoLD.toEpochDay() - dayOneLD.toEpochDay();
    } 
	
	/**************************************/
	/***************   时间       ***************/
	/**************************************/
	
	
	public String getTime(){
		return String.valueOf(LocalTime.now().withNano(0));
	}
	
	/**************************************/
	/*************   时间_时         **************/
	/**************************************/
	
	
	public String getTimeByAddHours(String hours){
		return String.valueOf(LocalTime.now().plusHours(Long.valueOf(hours)).withNano(0));
	}
	
	public String getTimeByAddHours(LocalTime localTime, String hours){
		return String.valueOf(localTime.plusHours(Long.valueOf(hours)).withNano(0));
	}
	
	/**************************************/
	/*************   时间_分         **************/
	/**************************************/
	
	
	public String getTimeByAddMinutes(String minutes){
		return String.valueOf(LocalTime.now().plusMinutes(Long.valueOf(minutes)).withNano(0));
	}
	
	public String getTimeByAddMinutes(LocalTime localTime, String minutes){
		return String.valueOf(localTime.plusMinutes(Long.valueOf(minutes)).withNano(0));
	}
	
	/**************************************/
	/*************   时间_秒         **************/
	/**************************************/
	
	
	//获得当前时间毫秒数
	public long getcurrentTimeMillis(){
		return Instant.now().toEpochMilli();
	}
	
}
