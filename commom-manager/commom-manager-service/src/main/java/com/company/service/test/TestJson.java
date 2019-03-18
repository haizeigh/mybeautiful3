package com.company.service.test;

import com.company.utils.Jsons;
import com.google.common.base.Joiner;
import org.junit.Test;
import sun.misc.Unsafe;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tomyu on 2018/7/6.
 */
public class TestJson {

	public static void main(String[] args) {
		String json="{\"correlator\":[\"H154356258190531\"],\"cp_order_id\":[\"20181130152257784212992\"],\"cp_user_id\":[\"test001\"],\"product_id\":[\"50243272\"],\"order_type\":[\"1\"],\"fee\":[\"2000\"],\"result_code\":[\"00\"],\"result_msg\":[\"success\"],\"op_type\":[\"0\"],\"response_time\":[\"20181130152331\"],\"sign_msg\":[\"1e14897d17a889e8ddfa929445b45b60\"]}";
//        ObjectMapper objectMapper=new ObjectMapper();
		Map<String,ArrayList<String>> map = Jsons.DEFAULT.fromJson(json, Map.class);
		Map<String,String> urlMap=new HashMap<>();
		for (String key : map.keySet()){
			String value=map.get(key).get(0);
			urlMap.put(key, URLEncoder.encode(value));
		}
		System.out.println(Joiner.on("&").withKeyValueSeparator("=").join(urlMap));
	}

	@Test
	public  void test() {
		String json="{\"payChannel\":\"SN\",\"statementId\":\"20180709151446599462848\",\"totalFee\":0.01,\"subject\":null,\"endTime\":1531120494000,\"transactionId\":\"1807090000006459391\",\"extraParam\":{},\"checkAmount\":true}";
//        ObjectMapper objectMapper=new ObjectMapper();
		Map<String,Object> map = Jsons.DEFAULT.fromJson(json, Map.class);
		Map<String,String> urlMap=new HashMap<>();
		for (String key : map.keySet()){
			String value=map.get(key)+"";
			urlMap.put(key,URLEncoder.encode(value));
		}
		System.out.println(Joiner.on("&").withKeyValueSeparator("=").join(urlMap));
	}


	@Test
	public void testMapToUrl(){
		String json="{\"batchId\":[\"201902281158319851032192\"],\"detail\":[\"[{\\\"paySuccessTime\\\":\\\"2019-02-28 11:58:32\\\",\\\"status\\\":\\\"OPS\\\",\\\"accSerialNo\\\":\\\"1902284498156296586\\\",\\\"currency\\\":\\\"CNY\\\",\\\"paymentInfo\\\":[{\\\"paymentName\\\":\\\"零钱宝余额支付\\\",\\\"payAmount\\\":1,\\\"rscCode\\\":\\\"BOF_BOF_BALANCE_EPP\\\",\\\"payTypeCode\\\":\\\"BOF_BALANCE\\\",\\\"payProvider\\\":\\\"EPP\\\"}],\\\"orderAmount\\\":1,\\\"outOrderNo\\\":\\\"wy190228yfb03\\\",\\\"contractNo\\\":\\\"25147707\\\",\\\"merchantNo\\\":\\\"70090479\\\",\\\"merchantOrderTime\\\":\\\"2019-02-28 11:58:32.0\\\",\\\"orderId\\\":\\\"1902280000026053807\\\"}]\"],\"merchantNo\":[\"70090479\"],\"responseCode\":[\"0000\"],\"responseMsg\":[\"处理成功\"],\"sign\":[\"c_bjyMmFyCU7HjK35QVpuU5No3h-LyF_B97O_u-rVYm7eJzPQ2GVY5Bxx4LyCWnR_HoMhY6LoAVq9i-XpbhY9IRHSRAKFfGNJOcs5qDnPxu_Qgp_2R77fyvYRVqdu-iZgNsaTDsOCVHCtrbyzuuVmTe6beRYG_yfAcywLbF5ibA\"],\"sign_type\":[\"RSA\"],\"vk_version\":[\"0\"]}";
		Map<String,List> map = Jsons.DEFAULT.fromJson(json, Map.class);
		Map<String,String> mymap=new HashMap<>();
		for (Map.Entry<String,List> entry :map.entrySet()){
			mymap.put(entry.getKey(),entry.getValue().get(0)+"");
		}
		System.out.println(Joiner.on("&").withKeyValueSeparator("=").join(mymap));

//		Unsafe us=Unsafe.getUnsafe();
//		us.allocateMemory(20l);


	}
}
