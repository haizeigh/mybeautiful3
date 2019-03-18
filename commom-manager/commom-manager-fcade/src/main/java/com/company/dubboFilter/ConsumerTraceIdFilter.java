package com.company.dubboFilter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.company.utils.TraceIdUtil;
import com.google.common.base.Strings;

import java.util.UUID;

/**
 * Created by tomyu on 2019/1/2.
 */
@Activate(group = {Constants.CONSUMER})
public class ConsumerTraceIdFilter implements Filter {
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String uuid = UUID.randomUUID().toString();

		RpcContext.getContext().setAttachment("traceId", uuid);
		System.out.println("本次调用dubbo-service的traceId是"+uuid+",调用服务是"
				+invocation.getMethodName());
		return invoker.invoke(invocation);
	}
}
