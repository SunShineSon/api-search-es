package com.hlb.base.core.util.string;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;

public class StringUtils extends org.apache.commons.lang.StringUtils{
	public static String upperFirst(String str){
		String result = str.substring(0, 1).toUpperCase() + str.substring(1);
		return result;
	}
	
	public static String lowerFirst(String str){
		String result = str.substring(0, 1).toLowerCase() + str.substring(1);
		return result;
	}
	
	public  static String[] getBySplit(String content,String splitTag)
	{
		String[] aryRtn=new String[2];
		int pos=content.lastIndexOf(splitTag);
		aryRtn[0]=content.substring(0,pos);
		aryRtn[1]=content.substring(pos+splitTag.length());
		return aryRtn;
	}
	
	/**
	 * 替换标量。<br>
	 * <pre>
	 * 使用方法如下：
	 * String template="com/hotent/{path}/model/{class}";
	 * Map<String,String> map=new HashMap<String,String>();
	 * map.put("path","platform");
	 * map.put("class","Role");
	 * String tmp=replaceVariable(template,map);
	 * </pre>
	 * @param template
	 * @param map
	 * @return
	 * @throws CodegenException 
	 */
	public static String replaceVariable(String template,Map<String,String> map)
	{
		Pattern regex = Pattern.compile("\\{(.*?)\\}");
		Matcher regexMatcher = regex.matcher(template);
		while (regexMatcher.find()) {
			String key=regexMatcher.group(1);
			String toReplace=regexMatcher.group(0);
			String value=(String)map.get(key);
			if(value!=null){
				template=template.replace(toReplace, value);
			}
		}  
		
		return template;
	}
	
	/**
	 * 去掉前面的字符
	 * @param toTrim
	 * @param trimStr
	 * @return
	 */
	public static String trimPrefix(String toTrim,String trimStr)
	{
		while(toTrim.startsWith(trimStr))
		{
			toTrim=toTrim.substring(trimStr.length());
		}
		return toTrim;
	}
	
	/**
	 * 删除后面的字符
	 * @param toTrim
	 * @param trimStr
	 * @return
	 */
	public static String trimSufffix(String toTrim,String trimStr)
	{
		while(toTrim.endsWith(trimStr))
		{
			toTrim=toTrim.substring(0,toTrim.length()-trimStr.length());
		}
		return toTrim;
	}
	
	/**
	 * 删除指定的字符
	 * @param toTrim
	 * @param trimStr
	 * @return
	 */
	public static String trim(String toTrim,String trimStr)
	{
		return trimSufffix(trimPrefix(toTrim, trimStr), trimStr);
	}
	
	public static String combilePath(String baseDir,String dir)
	{
		baseDir=trimSufffix(baseDir, File.separator) ;
		dir=trimPrefix(dir,File.separator);
		
		return baseDir + File.separator + dir;
	}
	
	/**
	 * 使用字符换替换内容
	 * @param content 内容
	 * @param startTag 开始标签
	 * @param endTag 结束标签
	 * @param repalceWith 使用替换
	 * @return
	 */
	public static String replace(String content,String startTag,String endTag,String repalceWith)
	{
		String tmp=content.toLowerCase();
		String tmpStartTag=startTag.toLowerCase();
		String tmpEndTag=endTag.toLowerCase();
		
		
		StringBuffer sb=new StringBuffer();
		int beginIndex=tmp.indexOf(tmpStartTag);
		int endIndex=tmp.indexOf(tmpEndTag);
		while(beginIndex!=-1 && endIndex!=-1 && beginIndex<endIndex)
		{
			String pre=content.substring(0,tmp.indexOf(tmpStartTag)+tmpStartTag.length());
			String suffix=content.substring(tmp.indexOf(tmpEndTag));
			
			tmp=suffix.toLowerCase();
			content=suffix.substring(endTag.length());
			
			beginIndex=tmp.indexOf(tmpStartTag);
			endIndex=tmp.indexOf(tmpEndTag);
			String replaced=pre + "\r\n" +  repalceWith  +"\r\n" + endTag;
			sb.append(replaced);
		}
		sb.append(content);
		return sb.toString();
	}
	
	/**
	 * 判断指定的内容是否存在
	 * @param content 内容
	 * @param begin 开始标签
	 * @param end 结束标签
	 * @return
	 */
	public static boolean isExist(String content,String begin,String end)
	{
		String tmp=content.toLowerCase();
		begin=begin.toLowerCase();
		end=end.toLowerCase();
		int beginIndex=tmp.indexOf(begin);
		int endIndex=tmp.indexOf(end);
		if(beginIndex!=-1  && endIndex!=-1 && beginIndex<endIndex)
			return true;
		return false;
	}
	
	/**
	 * 截取字符串中的 指定两字串 中间的 字符串
	 * @param start
	 * @param end
	 * @return
	 */
	public static String subString(String content,String start,String end){
		String str=content;
		if(content.indexOf(start)!=-1){
			if(content.indexOf(end)!=-1){
				str=content.substring(content.indexOf(start)+start.length(),content.lastIndexOf(end));
			}else{
				str=content.substring(content.indexOf(start)+start.length());
			}
		}
		
		return str;
	}
	
	public static String getFileExt(String fileName){
		if(fileName.lastIndexOf(".")>-1){
			return fileName.substring(fileName.lastIndexOf(".")+1);	
		}
		return "";
	}
	
	public static String appendNamePostfix(String fileName,String namePostfix){
		if(fileName.lastIndexOf(".")>0){
			return fileName.substring(0, fileName.lastIndexOf(".")) + "_md" + fileName.substring(fileName.lastIndexOf("."));	
		}else{
			return fileName + "_md";
		}		
	}

	
	public static String removeNumber(String str){
		String regEx = "[0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        //替换与模式匹配的所有字符（即非数字的字符将被""替换）
        return m.replaceAll("").trim();		
	}
	 
	/**
	 * 将null 字符串 返回""
	 * @param str
	 * @return
	 */
	public static String get(String str){
		if(str==null){
			return "";
		}
		return str;
	}
	public static String filterOffUtf8Mb4(String text) throws UnsupportedEncodingException {
		 if(text == null || text.trim().length() == 0)
			  return null;
		 StringBuffer buffer = new StringBuffer();
		 
		 for(int i=0;i<text.length();i++){
			 if((text.codePointAt(i) & 0xF8) == 0xF0)
			 {
				 i +=3;
				 continue;
			 }
			 buffer.append(text.charAt(i));
		 }		 		 
		 return buffer.toString();
	}	
	/**
	* 过滤掉超过3个字节的UTF8字符
	* @param text
	* @return
	* @throws UnsupportedEncodingException
	*/
	public static String filterOffUtf8Mb4_bak(String text) throws UnsupportedEncodingException {
	        byte[] bytes = text.getBytes("utf-8");
	        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
	        int i = 0;
	        while (i < bytes.length) {
	            short b = bytes[i];
	            if (b > 0) {
	                buffer.put(bytes[i++]);
	                continue;
	            }


	            b += 256; // 去掉符号位


	            if (((b >> 5) ^ 0x6) == 0) {
	                buffer.put(bytes, i, 2);
	                i += 2;
	            } else if (((b >> 4) ^ 0xE) == 0) {
	            buffer.put(bytes, i, 3);
	                i += 3;
	            } else if (((b >> 3) ^ 0x1E) == 0) {
	                i += 4;
	            } else if (((b >> 2) ^ 0x3E) == 0) {
	                i += 5;
	            } else if (((b >> 1) ^ 0x7E) == 0) {
	                i += 6;
	            } else {
	                buffer.put(bytes[i++]);
	            }
	        }
	        buffer.flip();
	        return new String(buffer.array(), "utf-8");
	}	
	
	/**
	 * 从request获取参数
	 * @param request
	 * @param name 属性名
	 * @param defval 如果获取的参数为nul时默认值
	 * @return String
	 */
	public static final String getParam(ServletRequest request, String name, String defval) {
		String param = request.getParameter(name);
		return (param != null ? param : defval);
	}

	/**
	 * 从request获取参数
	 * @param request
	 * @param name 属性名
	 * @param defval 如果获取的参数为nul时默认值
	 * @return int
	 */
	public static final int getParam(ServletRequest request, String name, int defval) {
		String param = request.getParameter(name);
		int value = defval;
		if (param != null) {
			try {
				value = Integer.parseInt(param.trim());
			} catch (NumberFormatException ignore) {
			}
		}
		return value;
	}
	/**
	 * 从request获取参数
	 * @param request
	 * @param name 属性名
	 * @param defval 如果获取的参数为nul时默认值
	 * @return long
	 */
	public static final long getParam(ServletRequest request, String name, long defval) {
		String param = request.getParameter(name);
		long value = defval;
		if (param != null) {
			try {
				value = Long.parseLong(param);
			} catch (NumberFormatException ignore) {
			}
		}
		return value;
	}
	/**
	 * 从request获取参数
	 * @param request
	 * @param name 属性名
	 * @param defval 如果获取的参数为nul时默认值
	 * @return double
	 */
	public static final double getParam(ServletRequest request, String name, double defval) {
		String param = request.getParameter(name);
		double value = defval;
		if (param != null) {
			try {
				value = Double.parseDouble(param);
			} catch (NumberFormatException ignore) {
			}
		}
		return value;
	}
	
	/**
	 * 不支持正则表达式的replaceAll 函数 ，不用考虑转义问题，很管用。
	 * 
	 * @param source
	 * @param find
	 * @param tostr
	 * @return
	 */
	public static String replaceString(String source, String find, String tostr) {
		String endvalue = null, endstr_f = null, endstr_e = null;
		int findend = 0, findstart = 0;
		endvalue = source;
		while (true) {
			findstart = endvalue.indexOf(find, findend);
			if (findstart != -1) {
				findend = findstart + find.length();
				endstr_f = endvalue.substring(0, findstart);
				endstr_e = endvalue.substring(findend);
				endvalue = endstr_f + tostr + endstr_e;
			} else {
				break;
			}
		}
		return (endvalue);
	}


	/**
	 * 截字符串 按字符显示实际宽度 （可判断中英文）
	 * 
	 * @return String
	 */
	public static String subStringTitle(String str, int len, String addstr) {
		if (str == null)
			return "";
		if (addstr == null)
			addstr = "";
		if (len < 0)
			return null;
		if (length(str) > len) {
			str = StringUtils.substring(str, len - 1) + addstr;
		}
		return str;
	}

	/**
	 * 截取字符串 (一个中文字占一个位,两个英文占一个位)
	 * 
	 * @param str
	 * @param len
	 * @return String
	 */
	public static String substring(String str, int len) {
		if (str == null)
			str = "";
		if (len < 0)
			len = 0;
		str = str.replaceAll(" ", "");
		len *= 2;
		StringBuffer sb = new StringBuffer();
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < '\377')
				counter++;
			else
				counter += 2;
			if (counter > len)
				break;
			sb.append(c);
		}

		return sb.toString();
	}

	/**
	 * 判断字符串长度，(一个中文字占一个位,两个英文占一个位)
	 * 
	 * @param str
	 * @return int
	 */
	public static int length(String str) {
		int strlen = 0;
		int sign = 0;
		if (str == null)
			str = "";
		char a[] = str.toCharArray();
		for (int i = 0; a != null && i < a.length; i++)
			if (a[i] < '\377') {
				if (++sign == 2) {
					strlen++;
					sign = 0;
				}
			} else {
				strlen++;
			}

		return strlen;
	}

	/**
	 * 正则表达式分割字串，目前支持空格，逗号，分号
	 * 
	 * @return String[]
	 */
	public static String[] matchStr(String str) {
		return str.split(" |\\,|\\;|\\，|\\；");
	}



	/**
	 * 根据当前的时间加随机数生成文件名，来保证没有重复文件名
	 * 
	 * @return String
	 */
	public static String getRandomFileName() {
		return getFormatDate(getNowDate(), "yyMMddHHmmssSSSS") + new Random().nextInt(1000);
	}

	/**
	 * 返回现在日期时间Date
	 * 
	 * @return Date
	 */
	public static Date getNowDate() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * 获取年
	 * 
	 * @return String
	 */
	public static String getYear() {
		return getFormatDate(getNowDate(), "yyyy");
	}

	/**
	 * 获取月日
	 * 
	 * @return String
	 */
	public static String getMonthDay() {
		return getFormatDate(getNowDate(), "MMdd");
	}

	/**
	 * 获取简洁 日期时间
	 * 
	 * @param date
	 * @return String
	 */
	public static String getSimpleDate(Date date) {
		return getFormatDate(date, "yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 将字符串转换为Long
	 * @param s
	 * @return
	 */
	public static Long stringToLong(String s){
		if(s != null){
			try{
				return new Long(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 将字符转换为long
	 * @param s
	 * @return
	 */
	public static long string4long(String s){
		if(s != null){
			try{
				return Long.parseLong(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return 0l;
	}

	/**
	 * 将字符串转换为Integer
	 * @param s
	 * @return
	 */
	public static Integer stringToInteger(String s){
		if(s != null){
			try{
				return new Integer(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 将字符转换为int
	 * @param s
	 * @return
	 */
	public static int string4int(String s){
		if(s != null){
			try{
				return Integer.parseInt(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * 将字符串转换为Float
	 * @param s
	 * @return
	 */
	public static Float stringToFloat(String s){
		if(s != null){
			try{
				return new Float(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 将字符转换为float
	 * @param s
	 * @return
	 */
	public static float string4float(String s){
		if(s != null){
			try{
				return Float.parseFloat(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return 0.0f;
	}
	
	/**
	 * 将字符串转换为Double
	 * @param s
	 * @return
	 */
	public static Double stringToDouble(String s){
		if(s != null){
			try{
				return new Double(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 将字符转换为double
	 * @param s
	 * @return
	 */
	public static double string4double(String s){
		if(s != null){
			try{
				return Double.parseDouble(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return 0.00d;
	}
	
	/**
	 * 将字符串转换为Integer
	 * @param s
	 * @return
	 */
	public static Short stringToShort(String s){
		if(s != null){
			try{
				return new Short(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 格式化日期，显示指定格式
	 * 
	 * @return String
	 */
	public static String getFormatDate(Date date, String formatParam) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatParam);
		return formatter.format(date);
	}
	
	/**
	 * 格式化日期，显示指定格式
	 * formatParam : yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String getFormatDate(Long date, String formatParam) {
		if (date == null) {
			return null;
		}
		Date d = new Date(date);
		SimpleDateFormat formatter = new SimpleDateFormat(formatParam);
		return formatter.format(d);
	}
	
}
