package com.indi.kodt.core.util;

import java.io.Reader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * com.inditaxi.kodt.core.util - StringUtil.java
 * </pre>
 *
 * @ClassName : StringUtil
 * @Description : String 관련 유틸리티 제공한다.
 * @author : kks
 * @date : 2019. 01. 14.
 * @Version : 1.0
 *
 */
public class StringUtil {

	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
	public static final String EMPTY = "";
	private StringUtil() {

	}

	/**
	 * @Title : isNull
	 * @Description : 파라미터 스트링이 null or "" 이면 true, 아니면 false
	 * @param param 검사문자열
	 * @return boolean true or false
	 */
	public static boolean isNull(String param) {
		if (param == null || "".equals(param)|| "null".equals(param)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Title : nvl
	 * @Description : null인 경우 ""을 return
	 * @param value 검사문자열
	 * @return String 결과문자열
	 */
	public static String nvl(String value) {
		return nvl(value, "");
	}

	/**
	 * @Title : nvl
	 * @Description : value가 null인 경우 defalult값을 return
	 * @param value        검사문자열
	 * @param defaultValue 디폴트문자열
	 * @return String 결과문자열
	 */
	public static String nvl(String value, String defaultValue) {
		if (value == null || value.equals("") || value.equals("null")) {
			return defaultValue;
		} else {
			return value;
		}
	}

	/**
	 * @Title : nvl
	 * @Description : 숫자형의 value가 null인 경우 defalult값을 return
	 * @param value        검사문자열
	 * @param defaultValue 디폴트숫자
	 * @return int 결과숫자
	 */
	public static int nvl(String value, int defaultValue) {
		if (value == null || "".equals(value) || "null".equals(value)) {
			return defaultValue;
		} else {
			return Integer.parseInt(value);
		}
	}
	/**
	 * @Title : nvl
	 * @Description : 숫자형의 value가 null인 경우 defalult값을 return
	 * @param value        검사문자열
	 * @param defaultValue 디폴트숫자
	 * @return double 결과숫자
	 */
	public static double nvl(String value, double defaultValue) {
		if (value == null || "".equals(value) || "null".equals(value)) {
			return defaultValue;
		} else {
			return Double.parseDouble(value);
		}
	}

	/**
	 * @Title : nvl
	 * @Description : null인 경우 ""을 return
	 * @param value 검사오브젝트
	 * @return String 결과문자열
	 */
	public static String nvl(Object value) {
		return nvl(value, "");
	}

	/**
	 * @Title : nvl
	 * @Description : value가 null인 경우 defalult값을 return
	 * @param value        검사오브젝트
	 * @param defaultValue 디폴트문자열
	 * @return String 결과문자열
	 */
	public static String nvl(Object value, String defaultValue) {
		if (value == null) {
			return defaultValue;
		} else {
			if (value.toString().equals("")) {
				return defaultValue;
			} else {
				return value.toString();
			}
		}
	}

	/**
	 * @Title : nvl
	 * @Description : value가 null인 경우 defalult값을 return
	 * @param value        검사오브젝트
	 * @param defaultValue 디폴트숫자
	 * @return int 결과숫자
	 */
	public static int nvl(Object value, int defaultValue) {
		if (value == null) {
			return defaultValue;
		} else {
			if (value.toString().equals("")) {
				return defaultValue;
			} else {
				return Integer.parseInt(value.toString());
			}
		}
	}

	/**
	 * @Title : substring
	 * @Description : String.substring(int start, int end) 대체, NullPointException 방지
	 * @param src   원본문자열
	 * @param start 시작index
	 * @param end   끝index
	 * @return String 컷팅된 문자열
	 */
	public static String substring(String src, int start, int end) {

		if (src == null || "".equals(src) || "null".equals(src)) {
			return EMPTY;
		}

		// handle negatives
        if (end < 0) {
	        end = src.length() + end; // remember end is negative
	    }
	    if (start < 0) {
	        start = src.length() + start; // remember start is negative
	    }
	    // check length next
	    if (end > src.length()) {
	        end = src.length();
	    }
	      // if start is greater than end, return ""
	    if (start > end) {
	        return EMPTY;
	    }
	      if (start < 0) {
	        start = 0;
	    }
	    if (end < 0) {
	        end = 0;
	    }

	    return src.substring(start, end);

	}

	/**
	 * @Title : isNotNull
	 * @Description : 파라미터 스트링이 null 이 아니고, "" 이 아니면 true, 아니면 false;
	 * @param param 검사문자열
	 * @return boolean true or false
	 */
	public static boolean isNotNull(String param) {
		if (param != null && !"".equals(param) && !"null".equals(param)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Title : isEmpty
	 * @Description : 파라미터 스트링이 null 이거나 "" 이면 true 아니면 flase;
	 * @param param 검사문자열
	 * @return boolean true or false
	 */
	public static boolean isEmpty(String str) {
		boolean flag;
		flag = (str == null || "".equals(str) || "null".equals(str)) ? true : false;
		return flag;
	}

	/**
	 * 복수건에 대한 equals 함수 (OR 조건)
	 *
	 * @param compareStandard 비교 기준 문자열
	 * @param targets         비교 대상 문자열(복수건)
	 * @return boolean 비교 값
	 */
	public static boolean equalsAtLeast(String compareStandard, String... targets) {
		if (StringUtil.isEmpty(compareStandard)) {
			return false;
		}
		for (String target : targets) {
			if (compareStandard.equals(target)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 복수건에 대한 equalsIgnoreCase 함수 (OR 조건)
	 *
	 * @param compareStandard 비교 기준 문자열
	 * @param targets         비교 대상 문자열(복수건)
	 * @return boolean 비교 값
	 */
	public static boolean equalsIgnoreCaseAtLeast(String compareStandard, String... targets) {
		if (StringUtil.isEmpty(compareStandard)) {
			return false;
		}
		for (String target : targets) {
			if (compareStandard.equalsIgnoreCase(target)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 비어있는 문자열(<code>""</code>)은 null로 전환하고 다른 문자는 그대로 리턴합니다.
	 *
	 * @param str 비교 기준 문자열
	 * @return str 변경 된 문자열
	 */
	public static String emptyToNull(String str) {
		if ("".equals(str)) {
			return null;
		} else {
			return str;
		}
	}

	/**
	 * inputString 문자열의 왼쪽에 format 문자를 채워서 length 길이로 변경
	 *
	 * @param inputString 입력 문자열
	 * @param length      변경 결과 문자열의 총길이
	 * @param format      총길이로 변경하기 위해 채울 문자
	 * @return String 변경 된 문자열
	 */
	public static String lpad(String strContext, int iLen, String strChar) {
        String strResult = "";
        StringBuilder sbAddChar = new StringBuilder();
        for (int i = strContext.length(); i < iLen; i++) { // iLen길이 만큼 strChar문자로 채운다.
            sbAddChar.append(strChar);
        }
        strResult = sbAddChar + strContext; // LPAD이므로, 채울문자열 + 원래문자열로 Concate한다.
        return strResult;
    }

	/**
	 * inputString 문자열의 오른쪽에 format 문자를 채워서 length 길이로 변경
	 *
	 * @param inputString 입력 문자열
	 * @param length      변경 결과 문자열의 총길이
	 * @param ch          총길이로 변경하기 위해 채울 문자
	 * @return String 변경 된 문자열
	 */
	public static String rpad(String strContext, int iLen, String strChar) {
        String strResult = "";
        StringBuilder sbAddChar = new StringBuilder();
        for (int i = strContext.length(); i < iLen; i++) { // iLen길이 만큼 strChar문자로 채운다.
            sbAddChar.append(strChar);
        }
        strResult = strContext + sbAddChar; // rPAD이므로, 원래문자열 + 채울문자열로 Concate한다.
        return strResult;
    }

	/**
	 * 복수건에 대한 startsWith 함수 (OR 조건)
	 *
	 * @param compareStandard 비교 기준 문자열
	 * @param targets         비교 대상 문자열(복수건)
	 * @return boolean 비교 값
	 */
	public static boolean startsWithAtLeast(String compareStandard, String... targets) {
		if (StringUtil.isEmpty(compareStandard)) {
			return false;
		}
		for (String target : targets) {
			if (compareStandard.startsWith(target)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 모두 빈 문자열이인지 검사합니다.
	 *
	 * @param targets 비교 대상 문자열(복수)
	 * @return boolean 하나라도 비어있지 않으면 <code>false</code>
	 */
	public static boolean areEmptyAll(String... targets) {
		for (String target : targets) {
			if (!StringUtils.isEmpty(target)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 하나의 문자열이라고 공백, 혹은 NULL인지 검사
	 *
	 * @param targets 비교 대상 문자열(복수)
	 * @return boolean 하나라도 비어있으면 <code>true</code>
	 */
	public static boolean containsEmpty(String... targets) {
		for (String target : targets) {
			if (StringUtils.isEmpty(target)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 날짜형식 문자열의 구분자로 들어있는 ., - 등을 제거한다.
	 *
	 * @param dateString 날짜 형식 문자열
	 * @return String 변경 된 문자열
	 */
	public static String removeDateDelim(String dateString) {
		if (StringUtil.isEmpty(dateString)) {
			return "";
		}
		return dateString.replaceAll("(\\.|-)", "");
	}

	/**
	 * 오라클 SQL 함수 <code>DECODE()</code>처럼 구현하였습니다. <blockquote>
	 *
	 * <pre>
	 * <code>StringUtil.decode("1", "1", "A")</code> returns "A"
	 * <code>StringUtil.decode("0", "1", "A", "ZZZ")</code> returns "ZZZ"
	 * <code>StringUtil.decode("2", "1", "A", "2", "B")</code> returns "B"
	 * <code>StringUtil.decode("0", "1", "A", "2", "B", "ZZZ")</code> returns "ZZZ"
	 * <code>StringUtil.decode("3", "1", "A", "2", "B", "3", "C")</code> returns "C"
	 * <strong><code>StringUtil.decode("4", "1", "A", "2", "B", "3", "C")</code> returns null</strong>
	 * <code>StringUtil.decode("0", "1", "A", "2", "B", "3", "C", "ZZZ")</code> returns "ZZZ"
	 * </pre>
	 *
	 * </blockquote>
	 *
	 * @param standard          기준되는 문자열
	 * @param firstCompareValue 첫번째 비교대상 문자열
	 * @param firstReplaceStr   첫번째 교체 문자열
	 * @param others            그 이후
	 * @return String 바뀌어진 문자열
	 */
	public static String decode(String standard, String firstCompareValue, String firstReplaceStr, String... others) {
		if (firstCompareValue.equals(standard)) {
			return firstReplaceStr;
		}
		for (int i = 0; i < others.length; i += 2) {
			if (i == others.length - 1) {
				return others[i];
			} else if (others[i].equals(standard)) {
				return others[i + 1];
			}
		}
		return null;
	}
	/**
	 * 숫자 포맷 형식을 변경 한다.
	 *
	 * @param num 변경 할 문자열
	 * @return String 변경 된 문자열
	 */
	public static String formatNumber(String num) {
		DecimalFormat df = new DecimalFormat("#,###");
		if (num == null || "".equals(num) || num =="null") {
			return "0";
		} else {
			return df.format(Long.parseLong(num));
		}

	}

	/**
	 * 숫자 포맷 형식을 변경 한다. ( 확장 )
	 *
	 * @param num 변경 할 문자열
	 * @return String 변경 된 문자열
	 */
	public static String formatNumber(String num,int selectNum) {
		DecimalFormat df = null;
		switch(selectNum) {
			case 1 : df = new DecimalFormat("#,##0.##"); break;	// 소수점 이하 2번째자리까지 표시 (소수점 이하가 없을 경우 표시하지 않는다.)
			case 2 : df = new DecimalFormat("#,##0.00"); break;   // 소수점 이하 2번째자리까지 표시 (소수점 이하가 없을 경우 0.00으로 표시한다.)
		}
		if (num == null || "".equals(num) || num =="null" || df == null) {
			return "0";
		} else {
			double parseNum = Double.parseDouble(num);
			return df.format(parseNum);
		}

	}

	/**
	 * 비교 대상 값이 null 이거나 공백이면 대채 값 리턴
	 *
	 * @param s 변경 할 문자열
	 * @param y 대체 할 문자열
	 * @return String 변경 된 문자열
	 */

	public static String toNNull(String s, String y) {
		if (s == null)
			return y;
		if ("null".equals(s))
			return y;
		if ("".equals(s))
			return y;
		else
			return s;
	}

	/**
	 * 비교 대상 값이 null 이면 공백 값 리턴
	 *
	 * @param s 변경 할 문자열
	 * @return String 변경 된 문자열
	 */
	public static String toNNull(String s) {
		if (s == null)
			return "";
		if ("null".equals(s))
			return "";
		else
			return s.trim();
	}

	/**
	 * 파일명 특수문자 검사
	 *
	 * @param fileNm 파일 명
	 * @return String 변경 된 문자열
	 */
	public static String fileNameCheck(String fileNm) {

		try {
			if (!"".equals(fileNm) && fileNm != null) {
				fileNm = fileNm.replaceAll("/", "");
				fileNm = fileNm.replaceAll("\\\\", "");
				fileNm = fileNm.replaceAll("&", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("fileNameCheckFileName=>" + fileNm);
		}
		return fileNm;
	}

	/**
	 * 공백을 제거함.
	 *
	 * @param str 변경 할 문자열
	 * @return String 변경 된 문자열
	 */
	public static String getTrimString(String str) {
		if (isEmpty(str)) {
			return str;
		} else {
			return str.trim();
		}

	}
	/**
	 * @Title       : isNullZero
	 * @Description : 널값이 오면 0 아니면 int형 변환후 리턴
	 * @param str
	 * @return
	 */
	public static int isNullZero(String str) {

		if (str == null || "".equals(str) || str =="null") {
			return 0;
		} else {
			return Integer.parseInt(str);
		}
	}

	/**
	 * @Title       : isNullZeroDouble
	 * @Description : 널값이 오면 0 아니면 double형 변환후 리턴
	 * @param str
	 * @return
	 */
	public static double isNullZeroDouble(String str) {

		if (str == null || "".equals(str) || str =="null") {
			return 0;
		} else {
			return Double.parseDouble(str);
		}
	}


	/**
	 * @Title       : koreanBytesRPad
	 * @Description : 기본 UTF-8 형식에서 한글은 3BYTE 인데 EUC_KR 형식으로 2BYTE 변경 후 RPAD 형식으로 리턴.
	 * @param str
	 * @return
	 */
	public static String koreanBytesRPad(String strContext,int iLen) throws Exception{
    	String strResult = "";

    	if(!StringUtil.isNull(strContext)) {

    		int strLength = strContext.getBytes("euc-kr").length;

    		//총 문자열 길이에서 해당 한글 문자 byte 길이를 뺀 나머지는 SPACE
    		iLen = iLen - strLength;

    		strResult = strContext+rpad("",iLen," ");

    	}else {

    		strResult = rpad("",iLen," ");

    	}

    	return strResult;
    }
	/**
	 * @Title       : koreanBytesLPad
	 * @Description : 기본 UTF-8 형식에서 한글은 3BYTE 인데 EUC_KR 형식으로 2BYTE 변경 후 RPAD 형식으로 리턴.
	 * @param str
	 * @return
	 */
	public static String koreanBytesLPad(String strContext,int iLen) throws Exception{
		String strResult = "";

		if(!StringUtil.isNull(strContext)) {

			int strLength = strContext.getBytes("euc-kr").length;

			//총 문자열 길이에서 해당 한글 문자 byte 길이를 뺀 나머지는 SPACE
			iLen = iLen - strLength;

			strResult = strContext+lpad("",iLen," ");

		}else {

			strResult = lpad("",iLen," ");

		}

		return strResult;
	}


	/**
	 * @Title       : koreanBytesRPad
	 * @Description : 기본 UTF-8 형식에서 한글은 3BYTE 인데 KSC-5601 형식으로 2BYTE 변경 후 RPAD 형식으로 리턴.
	 * @param str
	 * @return
	 */
	public static String koreanTaxRPad(String strContext,int iLen) throws Exception{
    	String strResult = "";

    	if(!StringUtil.isNull(strContext)) {

    		int strLength = strContext.getBytes("ksc5601").length;

    		//총 문자열 길이에서 해당 한글 문자 byte 길이를 뺀 나머지는 SPACE
    		iLen = iLen - strLength;

    		strResult = strContext+rpad("",iLen," ");

    	}else {

    		strResult = rpad("",iLen," ");

    	}

    	return strResult;
    }
	/**
	 * @Title       : koreanBytesLPad
	 * @Description : 기본 UTF-8 형식에서 한글은 3BYTE 인데 KSC-5601 형식으로 2BYTE 변경 후 RPAD 형식으로 리턴.
	 * @param str
	 * @return
	 */
	public static String koreanTaxLPad(String strContext,int iLen) throws Exception{
		String strResult = "";

		if(!StringUtil.isNull(strContext)) {

			int strLength = strContext.getBytes("ksc5601").length;

			//총 문자열 길이에서 해당 한글 문자 byte 길이를 뺀 나머지는 SPACE
			iLen = iLen - strLength;

			strResult = strContext+lpad("",iLen," ");

		}else {

			strResult = lpad("",iLen," ");

		}

		return strResult;
	}

	  /**
	   * 년 월 일 날짜 더하기
	   *
	   * @param regDate(날짜) , y(년) , m(월), d(일)
	   * @Exam  addDate("20180910",1,12,1) -->20200911
	   * @return String
	   */
	public static String addDate(String regDate, int y, int m, int d) throws Exception  {

		if(isNull(regDate)) {
			return "0";
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		Date date = format.parse(regDate);
		cal.setTime(date);
        cal.add(Calendar.YEAR, y);		//년 더하기
        cal.add(Calendar.MONTH, m);		//년 더하기
        cal.add(Calendar.DATE, d);		//년 더하기

		return format.format(cal.getTime());

	}
	/**
	 * 년 월 일 날짜 빼기
	 *
	 * @param regDate(날짜) , y(년) , m(월), d(일)
	 * @Exam  addDate("20180910",1,12,1) -->20200911
	 * @return String
	 */
	public static String subtractDate(String regDate, int y, int m, int d) throws Exception  {

		if(isNull(regDate)) {
			return "0";
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		Date date = format.parse(regDate);
		cal.setTime(date);
		cal.add(Calendar.YEAR, y*(-1));		//년 더하기
		cal.add(Calendar.MONTH, m*(-1));		//년 더하기
		cal.add(Calendar.DATE, d*(-1));		//년 더하기

		return format.format(cal.getTime());

	}
	/**
	* 두 날짜간의 월 차이 구하기
	 * @throws ParseException
	* */
	public static int getMonthsDifference(String dt1, String dt2) throws ParseException{

		if(isNull(dt1) || isNull(dt2)) {
			return 0;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Date date1 = format.parse(dt1);
		Date date2 = format.parse(dt2);

	        /* 해당년도에 12를 곱해서 총 개월수를 구하고 해당 월을 더 한다. */
		int month1 = date1.getYear() * 12 + date1.getMonth();
		int month2 = date2.getYear() * 12 + date2.getMonth();

		return month2 - month1;
	}
	/**
	 * 두 날짜간의 월 차이 구하기 ( 15일 기준(중간일) )
	 * @throws ParseException
	 * */
	public static int getMonthsDifference2(String dt1, String dt2) throws ParseException{

		if(isNull(dt1) || isNull(dt2)) {
			return 0;
		}
		int syear = Integer.parseInt(substring(dt1,0,4));
		int eyear = Integer.parseInt(substring(dt2,0,4));
		int smonth = Integer.parseInt(substring(dt1,4,6));
		int emonth = Integer.parseInt(substring(dt2,4,6));
		int sday = Integer.parseInt(substring(dt1,6,8));
		int eday = Integer.parseInt(substring(dt2,6,8));
		int yearnum = (eyear - syear);
		int monthnum = 0;

		if(yearnum > 0) {
			monthnum = (yearnum * 12) - (smonth + emonth) + 1;
			if(sday > 15) {
				monthnum = monthnum -1;
			}
			if(eday <= 15) {
				monthnum = monthnum -1;
			}
		}else {
			monthnum = (emonth - smonth) + 1;
			if(sday > 15) {
				monthnum = monthnum -1;
			}
			if(eday <= 15) {
				monthnum = monthnum -1;
			}
		}

		return monthnum;
	}
	/**
	   * 주민번호 복호화.
	   *
	   * @param
	   * @Exam  decrypt
	   * @return String
	   */
	public static String decrypt(String pers) throws Exception  {

		byte[] key = new byte[64];
		for( int j = 0; j < key.length; j++ ) {
			key[j] = (byte)j;
		}
		String decrypt1 = null;
		if(StringUtil.isNull(pers)) {
			decrypt1 = pers;
		}else {
			if(pers.length() > 7) {
				decrypt1 = Seed128Cipher.decrypt(pers, key, null);//복호화.
			}else {
				decrypt1 = pers;
			}
		}
		return decrypt1;

	}
	/**
	 * 주민번호 암호화
	 *
	 * @param
	 * @Exam  decrypt
	 * @return String
	 */
	public static String encrypt(String pers) throws Exception  {

		byte[] key = new byte[64];
		for( int i = 0; i < key.length; i++ ) {
			key[i] = (byte)i;
		}

		String encrypt = null;
		if(StringUtil.isNull(pers)) {
			encrypt = pers;
		}else {
			if(pers.length() > 7) {
				encrypt = Seed128Cipher.encrypt(pers, key, null);//암호화.
			}else {
				encrypt = pers;
			}
		}
		return encrypt;

	}
	/**
	 * 주민번호 뒷자리 *
	 *
	 * @param
	 * @Exam  decrypt
	 * @return String
	 */
	public static String lastPersNoStar(String pers) throws Exception  {

		String str = null;
		if(StringUtil.isNull(pers)) {
			str = pers;
		}else {
			str = substring(pers,0,1);
			str = str+"******";
		}
		return str;

	}

	public static String readCLOB(java.sql.Clob clobVal) throws Exception{

	  StringBuffer outBuffer = new StringBuffer();
	  Reader l_clobStream = null;
	  try{
	    l_clobStream = clobVal.getCharacterStream();
	    int l_nchars = 0;
	    char[] l_buffer = new char[4096];
	    while((l_nchars = l_clobStream.read(l_buffer))!=-1){
	      outBuffer.append(l_buffer,0,l_nchars);
	    }
	  }catch(Exception e){
	    throw e;
	  }finally{
	    try{
	      l_clobStream.close();
	    }catch(Exception e){
	      throw e;
	    }
	  }
	  return outBuffer.toString();
	}


}
