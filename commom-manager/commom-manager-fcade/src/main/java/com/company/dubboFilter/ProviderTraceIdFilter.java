package com.company.dubboFilter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.company.utils.TraceIdUtil;
import com.google.common.base.Strings;

/**
 * Created by tomyu on 2019/1/2.
 */
@Activate(group = {Constants.PROVIDER})
public class ProviderTraceIdFilter implements Filter {
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String traceId = RpcContext.getContext().getAttachment("traceId");

		System.out.println("本次调用dubbo-service的traceId是"+traceId+",调用服务是"
				+invocation.getMethodName());


		Result invoke = invoker.invoke(invocation);


		return invoke;
	}
}
