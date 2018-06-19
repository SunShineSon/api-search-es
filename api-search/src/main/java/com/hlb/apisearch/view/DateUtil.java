package com.hlb.apisearch.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 时间处理公用类
 * @author 	chenzy
 *
 */
public class DateUtil {
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 将Date类型时间转换格式为yyyy-MM-dd的String数据
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date){
		return datePatternFormat(date, DATE_PATTERN);
	}
	/**
	 * 将Date类型时间转换格式为yyyy-MM-dd的String数据
	 * @param date
	 * @return
	 */
	public static String timeFormat(Date date){
		return datePatternFormat(date, TIME_PATTERN);
	}
	
	/**
	 * 将Date类型时间转换格式为yyyy-MM-dd的String数据
	 * @param date
	 * @return
	 */
	  public static String fmtDateToYMDHM(Date date) {  
	        return fmtDateToStr(date, "yyyy-MM-dd");  
	    }
	  
	  
	  /** 
	     *  
	     * Description:格式化日期,String字符串转化为Date 
	     *  
	     * @param date 
	     * @param dtFormat 
	     *            例如:yyyy-MM-dd HH:mm:ss yyyyMMdd 
	     * @return 
	     */  
	    public static String fmtDateToStr(Date date, String dtFormat) {  
	        if (date == null)  
	            return "";  
	        try {  
	            SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);  
	            return dateFormat.format(date);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return "";  
	        }  
	    }
	
	
	/**
	 * 根据格式将Date类型时间转换String数据
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String datePatternFormat(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 将Date类型时间转换格式为yyyy-MM-dd的String数据
	 * @param date
	 * @return
	 */
	public static Date dateParse(String date){
		return datePatternParse(date, DATE_PATTERN);
	}
	/**
	 * 将起始yyyy-MM-dd类型时间转换格式为yyyy-MM-dd 00:00:00 Date数据
	 * @param date
	 * @return
	 */
	public static Date startDateParse(String date){
		return datePatternParse(date+" 00:00:00", TIME_PATTERN);
	}
	/**
	 * 将结束yyyy-MM-dd类型时间转换格式为yyyy-MM-dd 23:59:59 Date数据
	 * @param date
	 * @return
	 */
	public static Date endDateParse(String date){
		return datePatternParse(date+" 23:59:59", TIME_PATTERN);
	}
	/**
	 * 将Date类型时间转换格式为yyyy-MM-dd的String数据
	 * @param date
	 * @return
	 */
	public static Date timeParse(String date){
		return datePatternParse(date, TIME_PATTERN);
	}
	/**
	 * 根据格式将String类型时间转换Date类型
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date datePatternParse(String date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 日期时间加减处理  
	 * @param date 时间对象
	 * @param format 时间转化格式
	 * @param field 类型 参考 小时 如:GregorianCalendar.HOUR
	 * @param amount
	 * @return
	 */
	public static Date dateStrAdd(String date,String format,int field,int amount){		
		return dateAdd(datePatternParse(date, format), field, amount);
	}
	/**
	 * 日期时间加减处理 
	 * @param date 时间对象
	 * @param field 类型  参考 小时 如:GregorianCalendar.HOUR
	 * @param amount
	 * @return
	 */
	public static Date dateAdd(Date date,int field,int amount){
		GregorianCalendar gc =new GregorianCalendar();
		gc.setTime(date);
		gc.add(field, amount);
		return gc.getTime();
	} 
	/**
	 * 计算两个任意时间中间的间隔天数
	 * @param startday
	 * @param endday
	 * @return
	 */
	public static int getDaysBetweenByStr (String d1, String d2,String format){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(datePatternParse(d1,format));
		Calendar c2 = Calendar.getInstance();
		c2.setTime(datePatternParse(d2,format));
		return getDaysBetween (c1,c2) ;
	}
	/**
	 * 计算两个任意时间中间的间隔天数
	 * @param startday
	 * @param endday
	 * @return
	 */
	public static int getDaysBetweenByDate (Date d1, Date d2){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		return getDaysBetween (c1,c2) ;
	}
	/**
	 * 计算两个任意时间中间的间隔天数
	 * @param startday
	 * @param endday
	 * @return
	 */
	public static int getDaysBetween (Calendar d1, Calendar d2) {
        if (d1.after(d2)) { 
            java.util.Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);//得到当年的实际天数
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }
	 /**
     * 当月第一天
     * @param date
     * @return
     */
    private static String getFirstDay(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        gc.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format( gc.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        return str.toString();

    }
    /**
     * 当月最后一天
     * @param date
     * @return
     */
    private static String getLastDay(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
        GregorianCalendar  gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        gc.set(Calendar.DAY_OF_MONTH,  gc.getActualMaximum(Calendar.DAY_OF_MONTH));
        String day_last = df.format(gc.getTime());
        StringBuffer str = new StringBuffer().append(day_last).append(" 23:59:59");
        return str.toString();
    }
    
    /**
     * 获取当天的浮动天数时间
     * @Discription 
     * @author 郭
     * @create time 2017-3-16下午3:06:59
     * @param date
     * @param befor
     * @return
     */
    public static String getLastDay(Date date, int befor){
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(date);
    	ca.add(Calendar.DATE, befor);
    	Date dealDate = ca.getTime();
    	return fmtDateToYMDHM(dealDate);
    }
	public static void main(String[] args) {
		/*System.out.println(dateFormat(new Date()));
		System.out.println(timeFormat(new Date()));
		System.out.println(dateParse("2015-7-7"));
		System.out.println(timeParse("2015-7-7 20:00:00"));
		System.out.println(dateStrAdd("2015-7-7", DATE_PATTERN, GregorianCalendar.DATE, 1));
		System.out.println(dateFormat(dateAdd(new Date(), GregorianCalendar.DATE, -2)));
		System.out.println(getDaysBetweenByStr("2015-07-10","2015-07-15",DATE_PATTERN));
		System.out.println(getFirstDay(new Date()));
		System.out.println(getLastDay(new Date()));
		System.out.println(getDaysBetweenByDate(new Date(1467951132000L), new Date(1435813933000L)));*/
		
		
		System.out.println(dateParse("2015-7-7 20:00:00"));
	}
	
	//增加秒
	  public static Date addSecond(Date old,int n) {
	   		Calendar cal = Calendar.getInstance();
			cal.setTime(old);
			cal.add(Calendar.SECOND, n);
			return cal.getTime();
	    }
	  
	//当前时间几天后
	public static String addDay(String day){
		long now = System.currentTimeMillis();
		Long longday=(long) (24L*60L*60L*1000L*Double.valueOf(day));
		Long cure = now + longday;
		return timeFormat(new Date(cure));
	}
}
