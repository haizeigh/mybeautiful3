package com.company.web.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by v-leiyu on 2017/9/8.
 */
@Component
public class FieldUtil {
	/**
	 * 将list集合内部所有对象的某个属性全部放到一个新的set集合中
	 * @param objs
	 * @param fieldName
	 * @return
	 */
	public static Set<String> getFieldSetFromObjs(String fieldName,Object... objs){
		Set<String> set= new HashSet<>();
		try {
			for (Object object:objs
				 ) {
				Class<?> myClass = object.getClass();
				Field myField = myClass.getDeclaredField(fieldName);
				myField.setAccessible(true);
				String fieldValue = (String)myField.get(object);
				String[] split = fieldValue.split(",");
				for (String s : split) {
					s=s.trim();
					if (!set.contains(s))
						set.add(s);
				}
			}
			return set;
		}
		catch (Exception e) {
			return Collections.EMPTY_SET;
		}
	}

}
