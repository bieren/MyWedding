package com.sp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateTools {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String now = dateFormat.format(new Date());
		return now;
	}
	
	
	public static String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String now = dateFormat.format(new Date());
		return now;
	}

	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = dateFormat.format(new Date());
		return now;
	}

	public static String getCurrentExactDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmsssss");
		String now = dateFormat.format(new Date());
		return now;
	}

	public static String getCurrentDate(String format) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat(format);
		String now = dateFormat.format(new Date());
		return now;
	}

	public static String dateConversString(Date date, String format)
			throws Exception {
		DateFormat dateFormat = new SimpleDateFormat(format);
		String newDate = dateFormat.format(date);
		return newDate;
	}

	public static Date plusSecond(Date date, int ss) {
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.SECOND, +(ss));
			return now.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDateWithPlusDay(Date date, int datePlus) {
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DATE, datePlus);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.format(now.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 日期加减
	 *
	 * @param d
	 * @param field
	 *            类型
	 * @param amount
	 *            数量
	 * @return
	 */
	public static Date add(Date d, int field, int amount) {
		if (d == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 取得date的时间
	 * 
	 * @return
	 */
	public static Date getDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将日期转换成字符窜
	 * 
	 * @return
	 */
	public static String getDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date);
	}

	/**
	 * 添加天
	 *
	 * @param d
	 * @param amount
	 * @return
	 */
	public static Date addDay(Date d, int amount) {
		return add(d, Calendar.DATE, amount);
	}

	/**
	 * 指定的日期加天数
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static String addDateToString(String date, int amount) {
		if (date == null || "".equals(date.trim())) {
			return "";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDate(date));
		calendar.add(Calendar.DATE, amount);
		return getDateToString(calendar.getTime());
	}

	/**
	 * 取得date的时间
	 * 
	 * @return
	 */
	public static Date getDateTime(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * * 获取指定日期是星期几 参数为null时表示获取当前日期是星期几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekOfDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekOfDays[w];
	}

	/**
	 * 得到两个日期之间的日期包括两个日期.
	 * 
	 * @param p_start
	 *            Start Date
	 * @param p_end
	 *            End Date
	 * @return Dates List
	 */
	public static List<String> getDates(String p_start, String p_end) {
		Date date = DateTools.getDate(p_start);
		Calendar startcalendar = Calendar.getInstance();
		startcalendar.setTime(date);
		Date date2 = DateTools.getDate(p_end);
		Calendar endcalendar = Calendar.getInstance();
		endcalendar.setTime(date2);
		List<String> result = new ArrayList<String>();
		while (startcalendar.before(endcalendar)) {
			result.add(DateTools.getDateToString(startcalendar.getTime()));
			startcalendar.add(Calendar.DAY_OF_YEAR, 1);
		}
		result.add(p_end);
		return result;
	}

	public static String getFistDayofMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前月第一天
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}

	public static String getLastDayofMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		return last;
	}

	// 获取某年某月的最后一天
	public static String getLastDayofMonth(int year, int month) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(year, month - 1, 1);
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		return last;
	}

	/**
	 * 返回指定日期的月的第一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfMonth(String date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDate(date));
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				1);
		return calendar.getTime();
	}

	/**
	 * 返回指定日期的月的最后一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfMonth(String date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDate(date));
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				1);
		calendar.roll(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * 两个日期只差
	 * 
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int daysOfTwo(String fDate, String oDate) {
		Date fistDate = DateTools.getDate(fDate);
		Date endDate = DateTools.getDate(oDate);
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(fistDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(endDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		return day2 - day1;
	}

	/**
	 * 字符串转换为日期
	 * 
	 * @param strDate
	 * @param formatStr
	 * @return
	 */
	public static Date stringConversDate(String strDate, String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	//根据指定日期获取上周开始日期
	public static Date getLastWeekStart(String date) throws Exception{
	      Calendar cal = Calendar.getInstance();
	      Date d = sdf.parse(date);
	      cal.setTime(d);
	      cal.add(Calendar.WEEK_OF_MONTH, -1);
        cal.add(Calendar.DATE, -1 * cal.get(Calendar.DAY_OF_WEEK) + 1);
        return cal.getTime();
	}
    
    /**
     * 两个日期之间差的分钟数
     */
    public static int minuteOfTwo(String fTime, String oTime) {
    	Date fistDate = DateTools.getDateTime(fTime);
    	Date endDate = DateTools.getDateTime(oTime);
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fistDate);
        int hour1=aCalendar.get(Calendar.HOUR_OF_DAY);
        int time1 = aCalendar.get(Calendar.MINUTE);
        aCalendar.setTime(endDate);
        int hour2=aCalendar.get(Calendar.HOUR_OF_DAY);
        int time2 = aCalendar.get(Calendar.MINUTE);
        int hour=hour2-hour1;
        if(hour==0){
        	return time2 - time1;       	
        }else{
        	return 60;
        }
        
    }
    /**
     * 两个日期之间差的小时数
     */
    public static int hourOfTwo(String fTime, String oTime) {
    	Date fistDate = DateTools.getDateTime(fTime);
    	Date endDate = DateTools.getDateTime(oTime);
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fistDate);
        int day1=aCalendar.get(Calendar.DAY_OF_YEAR);
        int time1 = aCalendar.get(Calendar.HOUR_OF_DAY);
        aCalendar.setTime(endDate);
        int day2=aCalendar.get(Calendar.DAY_OF_YEAR);
        int time2 = aCalendar.get(Calendar.HOUR_OF_DAY);
        int day=day2-day1;
        if(day==0){
        	return time2 - time1;       	
        }else{
        	return 20;
        }
        
    }
	
	//根据指定日期获取上周结束日期
	public static Date getLastWeekEnd(String date) throws Exception{
	      Calendar cal = Calendar.getInstance();
	      Date d = sdf.parse(date);
	      cal.setTime(d);
	      cal.add(Calendar.WEEK_OF_MONTH, -1);
        cal.add(Calendar.DATE, -1 * cal.get(Calendar.DAY_OF_WEEK) + 7);
        return cal.getTime();
	}
	
	//根据指定日期获取上月开始日期
	public static Date getMonthStart(String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date d = sdf.parse(date);
		calendar.setTime(d);
		int index = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, (1 - index));
		return calendar.getTime();
	}

	//根据指定日期获取上月开始日期
	public static Date getLastMonthStart(String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date d = sdf.parse(date);
		calendar.setTime(d);
		calendar.add(Calendar.MONTH, -1);
		int index = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, (1 - index));
		return calendar.getTime();
	}

	//根据指定日期获取本月开始日期
	public static Date getMonthEnd(String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date d = sdf.parse(date);
		calendar.setTime(d);
		calendar.add(Calendar.MONTH, 1);
		int index = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, (-index));
		return calendar.getTime();
	}

	//根据指定日期获取上月结束日期
	public static Date getLastMonthEnd(String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date d = sdf.parse(date);
		calendar.add(Calendar.MONTH, -1);
		calendar.setTime(d);
		int index = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, (-index));
		return calendar.getTime();
	}

	//根据指定日期获取明天日期
	public static Date getNext(String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date d = sdf.parse(date);
		calendar.setTime(d);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

	//根据指定日期获取昨天日期
	public static Date getPre(String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date d = sdf.parse(date);
		calendar.setTime(d);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	/**
	 * 计算两个日期相差天数可跨年
	 */
	public static int daysBetween(String date1,String date2)  
    {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(DateTools.getDate(date1));  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(DateTools.getDate(date2));  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);  
          
       return Integer.parseInt(String.valueOf(between_days));         
    }  
  
	
	//下个月的第一天
	public static String get2NextMonthStart() throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date d = sdf.parse(getCurrentDate());
		calendar.setTime(d);
		calendar.add(Calendar.MONTH, 1);
		int index = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, 1-index);
		return DateTools.dateConversString(calendar.getTime(),"yyyy-MM-dd");
	}
	
	
	/**
	 * 计算两个日期相差天数可跨年
	 */
	public static Map<String, String> getDayBetweenTowDay(String date1,String date2)  
    {  
		String beginDate=date1;
		Map<String, String> map =new HashMap<String, String>();
		map.put(beginDate, beginDate);
		if (DateTools.daysBetween(date1, date2) > 0) {
			do{
				beginDate=addDateToString(beginDate, 1);
				map.put(beginDate, beginDate);
			}while(!beginDate.equals(date2));
		}
		
          
       return map;         
    } 
	
	public static void main(String[] args) throws Exception {
	}
}
