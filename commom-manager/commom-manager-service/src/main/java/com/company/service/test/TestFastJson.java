package com.company.service.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.company.utils.Jsons;
import com.google.common.base.Joiner;
import org.apache.commons.lang.text.StrBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.Executors;

/**
 * Created by v-leiyu on 2018/3/26.
 */
public class TestFastJson {
	public static void main(String[] args) {
		String time = "{\"deadLine\":\"2017-11-02 20:27:35\",\"id\":\"kk\",\"na\":\"kk\"}";
//		String time = "{\"deadLine\":\"2017-11-02 20:27:35\"}";
		ParserConfig parserConfig=new ParserConfig();

		Student student = JSON.parseObject(time,Student.class);
		System.out.println(11);
		//使用json反序列化
		//jason 数据比 对象多或者少，都没事， 只会把能对得上的参数封装起来

		ObjectMapper objectMapper=new ObjectMapper();
		String s = null;
		try {
			s = objectMapper.writeValueAsString(new Student());
			System.out.println(s);

			//ObjectMapper 序列化 null 不会报错，返回是null
			System.out.println(objectMapper.writeValueAsString(null));

			String jsonStr="{\n" + "\t\"partner_id\": \"2088721879145864\",\n"
					+ "\t\"notify_time\": \"2018-04-20 10:50:15\",\n"
					+ "\t\"sign_modify_time\": \"2018-04-20 10:26:58\",\n" + "\t\"status\": \"NORMAL\",\n"
					+ "\t\"agreement_no\": \"20185220427756011669\",\n" + "\t\"sign_type\": \"RSA\",\n"
					+ "\t\"alipay_user_id\": \"2088002589149697\",\n" + "\t\"notify_type\": \"dut_user_sign\",\n"
					+ "\t\"invalid_time\": \"2115-02-01 00:00:00\",\n"
					+ "\t\"sign\": \"NsZU4hEqoxVVQiPFCSlnbmyhZi8l8iwbeGacFbCGACksoIPUGkdi7Hd66fd88sSLI5y3OqP2bKFqk8LNxifyronH1sPP4QroHDbzhRDMFM/mE7S1CvJHqEhRQCNcftotHIv9cSn41ekfeaeLtMPdFz0DYU3fKn6aJrvC+Vo/fCg=\",\n"
					+ "\t\"valid_time\": \"2018-04-20 10:26:58\",\n"
					+ "\t\"product_code\": \"GENERAL_WITHHOLDING_P\",\n"
					+ "\t\"external_sign_no\": \"hh1$DDPOS_SPORT\",\n" + "\t\"scene\": \"INDUSTRY|DIGITAL_MEDIA\",\n"
					+ "\t\"notify_id\": \"6ec299d912b6d15246d5e08d64124a5hmh\",\n"
					+ "\t\"sign_time\": \"2018-04-20 10:26:58\"\n" + "}";
			Map map = objectMapper.readValue(jsonStr, Map.class);

			String join = Joiner.on("&").withKeyValueSeparator("=").join(map);
			System.out.println(join);

			System.out.println(URLEncoder.encode("INDUSTRY|DIGITAL_MEDIA"));

			System.out.println(URLDecoder.decode("%7B%22externalAgreementNo%22%3A%22hh1%24DDPOS_SPORT%22%2C%22productCode%22%3A%22GENERAL_WITHHOLDING_P%22%2C%22scene%22%3A%22INDUSTRY%7CDIGITAL_MEDIA%22%2C%22notifyUrl%22%3A%22http%3A%2F%2Fapitest.pay.pptv.com%2Fnotify%2FaliAgreement%22%7D"));

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		Student student =new Student();
		student.time="kk";
		student.id="kk";
		System.out.println(JSON.toJSON(student));
	}

	@Test
	public void test2() {
		int s=10010;
		System.out.println(~s);

	}



	public  static String printBnary(StringBuilder binars,int param){
		StringBuilder binarsRe=new StringBuilder();
		String[] strs=binars.toString().split(",");
		int strLength=strs.length;
		while (strLength>=1){

			binarsRe.append(strs[strLength-1]+" ");
			strLength--;
		}
		return binarsRe.toString();
	}

	@Test
	public void test3() {
		List<String> array=new LinkedList<>();
		array.add("1101");
		array.add("1100");
		System.out.println(CalculateBinaryNumbers(array));

		char a='1';
		System.out.println(Character.getNumericValue(a)*15);

		char[] chars = "1101".toCharArray();
		for (char c:chars){
			System.out.println(c=='1');
		}
	}



	public static String CalculateBinaryNumbers(List<String> array) {
		for (int i=1;i<array.size();i+=2){
			String rev = getRev(array.get(i));
			array.set(i,rev);
		}

		int temp=0;
		for (int i=0;i<array.size();i++){
			temp+=getInt(array.get(i));
		}

		return Integer.toBinaryString(temp);
	}

	public static int getInt(String num){
		char[] chars = num.toCharArray();
		int tempt=0;
		for (int i=chars.length-1;i>=0;i--){
			tempt+=Character.getNumericValue(chars[i])*(int)Math.pow(2,chars.length-1-i);
		}
//		Executors.newCachedThreadPool();
		return tempt;
	}

	public static String getRev(String num){
		StrBuilder strBuilder=new StrBuilder();


		char[] chars = num.toCharArray();
		for (char ch: chars){
			if (ch=='1'){
				strBuilder.append(0);
			}
			if (ch=='0'){
				strBuilder.append(1);
			}
		}
		return strBuilder.toString();
	}


	public static String getFavoriteCities(List<String> userCities) {

		Map<String,Integer> temptMap=new HashMap<String , Integer>();

		for (String userCitie:userCities){
			String[] ar = userCitie.split("->");
			for(int i=0;i<ar.length;i++){
				if(temptMap.containsKey(ar[i])){
					temptMap.put(ar[i],temptMap.get(ar[i])+1);
				}else {
					temptMap.put(ar[i],1);
				}
			}
		}

		List<String> keys=new ArrayList<>();

		int temptInt=0;
		for (String key : temptMap.keySet()){
			if (temptMap.get(key)>temptInt)
				temptInt=temptMap.get(key);
		}


		for (String key : temptMap.keySet()){
			if (temptMap.get(key)==temptInt)
				keys.add(key);
		}

		String result="";
		Collections.sort(keys);
		for (String key : keys){
			result=key+","+result;
		}

		return result+temptInt;

	}

	@Test
	public void testRead(){
		try {
			FileReader fileReader = new FileReader(new File("C:\\Users\\v-leiyu\\Desktop\\test3.txt"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readLine = bufferedReader.readLine();
			System.out.println(readLine.length());
//			 readLine ="DDUUDDUU";
			int countingValleys = Student.countingValleys(readLine.length(), readLine);
			System.out.println(countingValleys);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

		}
		}


	}

class  Student implements Serializable{


	@JSONField(name = "deadLine")
	String time;
	String id;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	static int sockMerchant(int n, int[] ar) {
		Map<Integer,Integer> temptMap=new HashMap<Integer , Integer>();
		for(int i=0;i<n;i++){
			if(temptMap.containsKey(ar[i])){
				temptMap.put(ar[i],temptMap.get(ar[i])+1);
			}else {
				temptMap.put(ar[i],1);
			}
		}
		int result=0;
		for (Map.Entry<Integer,Integer> entry:temptMap.entrySet()){
			result += entry.getValue()/2;
		}

		return result;
		}


	static int countingValleys(int n, String s) {
		int result=0;

		char[] chars = s.toCharArray();
		int i;
		for ( i=0;i<n;i++){

			if (chars[i]=='D'){
				result++;
			}
			int tempt=0;
			for (int j=i;j<n;j++){
				if (chars[j]=='D'){
					tempt--;
				}else if (chars[j]=='U'){
					tempt++;
				}
				if (tempt==0){
					i=j;
					break;
				}
			}
			if (tempt!=0){
				return  result;
			}

		}
		return result;
	}

	static int countingValleys2(int n, String s) {
		if (s.length()==0)
			return 0;

		int result=0;
		if (s.startsWith("D"))
			result++;

		int tempt=0;
		char[] chars = s.toCharArray();
		int i;
		for ( i=0;i<n;i++){
			if (chars[i]=='D'){
				tempt--;
			}else if (chars[i]=='U'){
				tempt++;
			}
			if (tempt==0)
				break;
		}
		if (i==n-1)
			return result;

		s= s.substring(i+1,n);
		result += countingValleys(s.length(), s);

		return  result;
	}



	}
