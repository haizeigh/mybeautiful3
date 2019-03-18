package com.company.service.test;

import com.company.utils.Jsons;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by tomyu on 2018/9/5.
 */
public class TestJsonToUrl {
	public static void main(String[] args) {
		String j="{\"trade_no\":\"2018101222001452760505334019\",\"notify_time\":\"2018-10-12 09:54:51\",\"subject\":\"体育高级会员包1年（勿动）\",\"sign_type\":\"RSA\",\"notify_type\":\"trade_status_sync\",\"out_trade_no\":\"20181012095435810274432\",\"trade_status\":\"TRADE_SUCCESS\",\"sign\":\"DC8caonguV/P94cnpiGJc/OE0bhMwAUJdwYJiEDeULtFwE4Mq/xaM11NwU2Sb7RAJIl1lcz482RjnVuYDJuUp GJUYBakiUghMiLhcsjxRBJihP8wYgbj6HceYps1vYucrnI3oazj3152ApnzWNvJ2FaqQS37 LagTjd1hZDDmM=\",\"is_success\":\"T\",\"total_fee\":\"0.01\",\"service\":\"alipay.wap.create.direct.pay.by.user\",\"seller_id\":\"2088721879145864\",\"notify_id\":\"RqPnCoPT3K9/vwbh3Ih103F/OfYY0eeUU2JcinK3zq7aggi2f/XyYoUJpxJze5IZp8wG\",\"payment_type\":\"1\"}";

		Map<String,List<String>> map = Jsons.DEFAULT.fromJson(j, Map.class);

		Map<String,String> map1= Maps.newHashMap();
		for (Map.Entry<String,List<String>> entry: map.entrySet()){
			map1.put(entry.getKey(), URLEncoder.encode(entry.getValue().get(0)));
		}

		String join = Joiner.on("&").withKeyValueSeparator("=").join(map1);
		System.out.println(join);

	}


	@Test
	public  void testNOList() {
		String j="{\"trade_no\":\"2018101222001452760505334019\",\"notify_time\":\"2018-10-12 09:54:51\",\"subject\":\"体育高级会员包1年（勿动）\",\"sign_type\":\"RSA\",\"notify_type\":\"trade_status_sync\",\"out_trade_no\":\"20181012095435810274432\",\"trade_status\":\"TRADE_SUCCESS\",\"sign\":\"DC8caonguV/P94cnpiGJc/OE0bhMwAUJdwYJiEDeULtFwE4Mq/xaM11NwU2Sb7RAJIl1lcz482RjnVuYDJuUp GJUYBakiUghMiLhcsjxRBJihP8wYgbj6HceYps1vYucrnI3oazj3152ApnzWNvJ2FaqQS37 LagTjd1hZDDmM=\",\"is_success\":\"T\",\"total_fee\":\"0.01\",\"service\":\"alipay.wap.create.direct.pay.by.user\",\"seller_id\":\"2088721879145864\",\"notify_id\":\"RqPnCoPT3K9/vwbh3Ih103F/OfYY0eeUU2JcinK3zq7aggi2f/XyYoUJpxJze5IZp8wG\",\"payment_type\":\"1\"}";

		Map<String,String> map = Jsons.DEFAULT.fromJson(j, Map.class);

		Map<String,String> map1= Maps.newHashMap();
		for (Map.Entry<String,String> entry: map.entrySet()){
			map1.put(entry.getKey(), URLEncoder.encode(entry.getValue()));
		}

		String join = Joiner.on("&").withKeyValueSeparator("=").join(map1);
		System.out.println(join);

	}
}
