package com.company.logFilter;

import org.apache.log4j.MDC;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by tomyu on 2019/1/8.
 */
public class Log4jFilter extends Filter {

	@Override public int decide(LoggingEvent loggingEvent) {
		String ip = getIP();
		MDC.put("ip",ip);
		return NEUTRAL;
	}

	private String  getIP(){
		//网络接口
		try {
			InetAddress candidateAddress = null;
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()){
				NetworkInterface networkInterface = networkInterfaces.nextElement();
				//接口下的ip
				Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
				while (inetAddresses.hasMoreElements()){
					InetAddress inetAddress = inetAddresses.nextElement();
					if (!inetAddress.isLoopbackAddress()){
						if (inetAddress.isSiteLocalAddress()) {
							// 如果是site-local地址，就是它了
							return inetAddress.getHostAddress();
						} else if (inetAddress == null) {
							// site-local类型的地址未被发现，先记录候选地址
							candidateAddress = inetAddress;
						}
					}
				}
			}
			if (candidateAddress != null) {
				return candidateAddress.getHostAddress();
			}
			// 如果没有发现 non-loopback地址.只能用最次选的方案
			InetAddress localHost = InetAddress.getLocalHost();
			return localHost.getHostAddress();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}
}
