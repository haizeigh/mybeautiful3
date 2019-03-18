package com.company.service.test;

import com.company.service.http.Http;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by tomyu on 2018/9/29.
 */
public class TestJsoup {
	public static void main(String[] args) {
		//获取编辑推荐页
		Document document =null;
		try {
			 document = Jsoup.connect("http://127.0.0.1:8020/test2/Kibana.html")
					 //模拟google浏览器
					 .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
					.get();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		Elements select = document.select("#kibana-body").select("div.content").select("div").select("div")
				.select("div").select("div:nth-child(2)").select("div.discover-wrapper.col-md-10")
				.select("div.discover-info").select("strong");
		int num = Integer.parseInt(select.text());
		System.out.println(num);
		for (int i=1;i<num;i+=2){
			Elements main = document.select("#kibana-body").select("div.content").select("div").select("div").select("div")
					.select("div:nth-child(2)").select("div.discover-wrapper.col-md-10").select("div.discover-content").select("div.results")
					.select("div.discover-table").select("doc-table").select("div").select("table")
					.select("tbody").select("tr:nth-child("+i+")").select("td.discover-table-sourcefield").select("div")
					.select("dl").select("dd:nth-child(2)");
			String text = main.text();
			String substring = text.substring(text.indexOf("<?xml"), text.indexOf("</callbackReq>") + 14);
			System.out.println(substring);
			String request = Http.post("http://api.vip.pptv.com/unipay/cpordervalidate").body(substring).requestWithRetry();
			System.out.println(request);
		}

//		int totalNum = Integer.parseInt(main.text());


	}

	//kibanna的爬虫系列
	@Test
	public  void esTest() {
		//获取编辑推荐页
		Document document =null;
		try {
			document = Jsoup.connect("http://127.0.0.1:8020/test2/Kibana3.html")
					//模拟google浏览器
					.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
					.maxBodySize(0)
					.get();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
			Elements select = document.select("#kibana-body").select("div.content").select("div").select("div")
				.select("div").select("div:nth-child(2)").select("div.discover-wrapper.col-md-10")
				.select("div.discover-info").select("strong");
		int num = Integer.parseInt(select.text().replace(",",""));
		System.out.println(num);
		Elements main1 = document.select("#kibana-body").select("div.content").select("div").select("div").select("div")
				.select("div:nth-child(2)").select("div.discover-wrapper.col-md-10").select("div.discover-content").select("div.results")
				.select("div.discover-table").select("doc-table").select("div").select("table")
				.select("tbody");
		for (int i=1;i<2*num;i+=2){
			  String request="";
			  String text="";
			try {
				Elements main = main1.select("tr:nth-child(" + i + ")").select("td.discover-table-sourcefield")
						.select("div").select("dl").select("dd:nth-child(2)");
				text = main.text();
				request = text.substring(text.indexOf("<?xml"), text.indexOf("</callbackReq>") + 14);
//				System.out.println(substring);
//				String s = Http.post("http://api.vip.pptv.com/unipay/cpordervalidate").body(request).contentType("application/xml").requestWithRetry();
//				System.out.println(s.contains("<callbackRsp>1</callbackRsp>"));
				mythread mythread=new mythread(request);
				mythread.start();
			}
			catch (Exception e) {
				System.out.println(request);
				e.printStackTrace();
			}
			System.out.println(i);
		}

//		int totalNum = Integer.parseInt(main.text());
	}


	@Test
	public void  testUrl(){
		String request = Http.post("http://api.vip.pptv.com/unipay/cpordervalidate").contentType("application/xml")
				.body("<?xml version=\"1.0\" encoding=\"UTF-8\"?><callbackReq><hRet>0</hRet><appid>90272400620140305161030045900</appid><consumeCode>140326030384</consumeCode><cpid>86001117</cpid><fid>21505</fid><orderid>000020180129233945606724</orderid><ordertime>20181130080630</ordertime><payType>2</payType><payfee>1500</payfee><signMsg>7ca57eaee62caea141eb1e72e877089e</signMsg><status>00000</status><usercode></usercode></callbackReq>").requestWithRetry();
		System.out.println(request);
	}



	@Test
	public void login() throws IOException {
		String urlLogin = "https://quan.suning.com/lqzx_recommend.do?activityId=201811210003852805&activitySecretKey=XTFYThWXr3rtVMQOjEXYc6Hq&utm_source=union&utm_medium=14&adtype=5&utm_campaign=af6f5aae-544e-467d-97f3-d8abe82439ed&union_place=un";
		Connection connect = Jsoup.connect(urlLogin);
		// 伪造请求头
		connect.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
				"gzip, deflate");
		connect.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
		connect.header("Content-Length", "72").header("Content-Type",
				"application/x-www-form-urlencoded; charset=UTF-8");
		connect.header("Host", "qiaoliqiang.cn").header("Referer", "http://qiaoliqiang.cn/Exam/");
		connect.header("User-Agent",
				"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
				.header("X-Requested-With", "XMLHttpRequest");

		// 携带登陆信息
		connect.data("username", "362501197407067215").data("password", "123456").data("user_type", "2")
				.data("isRememberme", "yes");

		//请求url获取响应信息
		Connection.Response res = connect.ignoreContentType(true).method(Connection.Method.POST).execute();// 执行请求
		// 获取返回的cookie
		Map<String, String> cookies = res.cookies();
		for (Map.Entry<String, String> entry : cookies.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		System.out.println("---------华丽的分割线-----------");
		String body = res.body();// 获取响应体
		System.out.println(body); // {"login_result":"success_manager","user_type":"2","login_url":"examParper\/examPaper\/examparperManage.jsp"}
	}

}

class mythread extends Thread {
 private  String re;

	public mythread(String re) {
		this.re = re;
	}

	@Override public void run() {
		String s = Http.post("http://api.vip.pptv.com/unipay/cpordervalidate").body(re).contentType("application/xml")
				.requestWithRetry();
		System.out.println(s.contains("<callbackRsp>1</callbackRsp>"));
	}
}
