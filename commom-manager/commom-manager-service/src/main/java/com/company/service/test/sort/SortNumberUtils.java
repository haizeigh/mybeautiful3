package com.company.service.test.sort;

import com.google.common.base.Strings;
import org.apache.commons.lang.math.RandomUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tomyu on 2019/1/10.
 */
public class SortNumberUtils {
	private static File FILE=new File("E:/testSort.txt");

	public static void generateNumberFile(int Numbers,int random){
		FileWriter fileWriter=null;
		BufferedWriter bufferedOutputStream=null;
//		FileOutputStream fileOutputStream=null;
//		BufferedOutputStream bufferedOutputStream=null;
		try {
			 fileWriter=new FileWriter(FILE);
			 bufferedOutputStream=new BufferedWriter(fileWriter);
//			fileOutputStream=new FileOutputStream(FILE);
//			bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
			for (int i=0;i<Numbers;i++){
				int nextInt = RandomUtils.nextInt(random);
				bufferedOutputStream.write(nextInt+"");
				bufferedOutputStream.newLine();
//				bufferedOutputStream.write(new Integer(nextInt).byteValue());
//				bufferedOutputStream.write("\r\n".getBytes());
			}
			bufferedOutputStream.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if (bufferedOutputStream!=null)
					bufferedOutputStream.close();

					if (fileWriter!=null)
						fileWriter.close();
//					if (fileOutputStream!=null)
//						fileOutputStream.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	public static <T extends  Number>  List<T> readNumberFromFile(T toClass){
		List<T> list=new ArrayList<>();
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		try {
			 fileReader=new FileReader(FILE);
			 bufferedReader=new BufferedReader(fileReader);
			String num;
			while (!Strings.isNullOrEmpty(num=bufferedReader.readLine())){
				T number = covNumber(toClass, num.trim());
				if (number!=null)
					list.add(number);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if (bufferedReader!=null)
						bufferedReader.close();
					if (fileReader!=null)
						fileReader.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
		}
		return list;
	}

	public static  <T extends Number> T covNumber(T numClass,String value){
		if (Integer.class.isAssignableFrom(numClass.getClass())){
			return (T)Integer.valueOf(value);
		}else if (Long.class.isAssignableFrom(numClass.getClass())){
			return (T)Long.valueOf(value);
		}else if (Double.class.isAssignableFrom(numClass.getClass())){
			return (T)Double.valueOf(value);
		}else if (Short.class.isAssignableFrom(numClass.getClass())){
			return (T)Short.valueOf(value);
		}else if (Byte.class.isAssignableFrom(numClass.getClass())){
			return (T)Byte.valueOf(value);
		}else {
			return null;
		}
	}



	public static void main(String[] args) {
		generateNumberFile(25,20);
		List<Integer> list = readNumberFromFile(new Integer(0));
		System.out.println(list);
	}
}
