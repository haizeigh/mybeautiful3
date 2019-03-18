package com.company.service.rabbit;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * Created by v-leiyu on 2018/1/7.
 */
public class Producer extends EndPoint {
	public Producer(String endpointName) throws IOException, TimeoutException {
		super(endpointName);
	}

	public void sendMessage(Serializable obj) throws IOException {

		/*默认的exchange:如果用空字符串去声明一个exchange，那么系统就会使用”amq.direct”这个exchange，
		我们创建一个queue时,默认的都会有一个和新建queue同名的routingKey绑定到这个默认的exchange上去*/
		channel.basicPublish("",endPointName,null, SerializationUtils.serialize(obj));
	}
}
