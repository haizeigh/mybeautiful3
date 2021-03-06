package com.company.service.test;

import com.company.service.http.Https;
import com.company.utils.Jsons;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by tomyu on 2019/3/1.
 */
public class TestIOs {

	private static final String REQUEST_URL = "https://buy.itunes.apple.com/verifyReceipt";

	public static void main(String[] args) {
		String receipt="ewoJInNpZ25hdHVyZSIgPSAiQXlvR1AyY0RRMnhqTk5QKzFzMTEwZzFETVpJdUxxMXRzVUpCRFBXeTd4SG4xV2V1Y1RYVjhwVlg0dXB1NE9SWEYwbENtY0h2WnVZT2pIaGdwOVY2QllOd2tsK2duVWF3MjRTaCtxSzdKRFlIMzBNemFDMjFxaStETzlSRlpHZ2Y2Sjc2dHp5N0NUV3RNUmZTZytTV0FRdUtZZmplc3VxcmwvazVBNGNDbEt4YmMzQWhyMlZUb2l3aHltVVVpcUx1WVNBbU8zaUJ0QjJKRko2aEtFaGszSHpDSXp4UXFUZ3VPTUp6NDdsNEM3MzdHRWVYOG14T1VMWkt2SXRaeVUxTUNpQVZNMU5kdzhLRW0wOGRxZUNWdkZSOGdxOXRGd29aMDZVbFFNS0daVmlxamticXE0U2JBQmRwK1BHTVMxYi9XM0FkMVZaNWdyVVlOdnJ0dTloZFhENEFBQVdBTUlJRmZEQ0NCR1NnQXdJQkFnSUlEdXRYaCtlZUNZMHdEUVlKS29aSWh2Y05BUUVGQlFBd2daWXhDekFKQmdOVkJBWVRBbFZUTVJNd0VRWURWUVFLREFwQmNIQnNaU0JKYm1NdU1Td3dLZ1lEVlFRTERDTkJjSEJzWlNCWGIzSnNaSGRwWkdVZ1JHVjJaV3h2Y0dWeUlGSmxiR0YwYVc5dWN6RkVNRUlHQTFVRUF3dzdRWEJ3YkdVZ1YyOXliR1IzYVdSbElFUmxkbVZzYjNCbGNpQlNaV3hoZEdsdmJuTWdRMlZ5ZEdsbWFXTmhkR2x2YmlCQmRYUm9iM0pwZEhrd0hoY05NVFV4TVRFek1ESXhOVEE1V2hjTk1qTXdNakEzTWpFME9EUTNXakNCaVRFM01EVUdBMVVFQXd3dVRXRmpJRUZ3Y0NCVGRHOXlaU0JoYm1RZ2FWUjFibVZ6SUZOMGIzSmxJRkpsWTJWcGNIUWdVMmxuYm1sdVp6RXNNQ29HQTFVRUN3d2pRWEJ3YkdVZ1YyOXliR1IzYVdSbElFUmxkbVZzYjNCbGNpQlNaV3hoZEdsdmJuTXhFekFSQmdOVkJBb01Da0Z3Y0d4bElFbHVZeTR4Q3pBSkJnTlZCQVlUQWxWVE1JSUJJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBUThBTUlJQkNnS0NBUUVBcGMrQi9TV2lnVnZXaCswajJqTWNqdUlqd0tYRUpzczl4cC9zU2cxVmh2K2tBdGVYeWpsVWJYMS9zbFFZbmNRc1VuR09aSHVDem9tNlNkWUk1YlNJY2M4L1cwWXV4c1FkdUFPcFdLSUVQaUY0MWR1MzBJNFNqWU5NV3lwb041UEM4cjBleE5LaERFcFlVcXNTNCszZEg1Z1ZrRFV0d3N3U3lvMUlnZmRZZUZScjZJd3hOaDlLQmd4SFZQTTNrTGl5a29sOVg2U0ZTdUhBbk9DNnBMdUNsMlAwSzVQQi9UNXZ5c0gxUEttUFVockFKUXAyRHQ3K21mNy93bXYxVzE2c2MxRkpDRmFKekVPUXpJNkJBdENnbDdaY3NhRnBhWWVRRUdnbUpqbTRIUkJ6c0FwZHhYUFEzM1k3MkMzWmlCN2o3QWZQNG83UTAvb21WWUh2NGdOSkl3SURBUUFCbzRJQjF6Q0NBZE13UHdZSUt3WUJCUVVIQVFFRU16QXhNQzhHQ0NzR0FRVUZCekFCaGlOb2RIUndPaTh2YjJOemNDNWhjSEJzWlM1amIyMHZiMk56Y0RBekxYZDNaSEl3TkRBZEJnTlZIUTRFRmdRVWthU2MvTVIydDUrZ2l2Uk45WTgyWGUwckJJVXdEQVlEVlIwVEFRSC9CQUl3QURBZkJnTlZIU01FR0RBV2dCU0lKeGNKcWJZWVlJdnM2N3IyUjFuRlVsU2p0ekNDQVI0R0ExVWRJQVNDQVJVd2dnRVJNSUlCRFFZS0tvWklodmRqWkFVR0FUQ0IvakNCd3dZSUt3WUJCUVVIQWdJd2diWU1nYk5TWld4cFlXNWpaU0J2YmlCMGFHbHpJR05sY25ScFptbGpZWFJsSUdKNUlHRnVlU0J3WVhKMGVTQmhjM04xYldWeklHRmpZMlZ3ZEdGdVkyVWdiMllnZEdobElIUm9aVzRnWVhCd2JHbGpZV0pzWlNCemRHRnVaR0Z5WkNCMFpYSnRjeUJoYm1RZ1kyOXVaR2wwYVc5dWN5QnZaaUIxYzJVc0lHTmxjblJwWm1sallYUmxJSEJ2YkdsamVTQmhibVFnWTJWeWRHbG1hV05oZEdsdmJpQndjbUZqZEdsalpTQnpkR0YwWlcxbGJuUnpMakEyQmdnckJnRUZCUWNDQVJZcWFIUjBjRG92TDNkM2R5NWhjSEJzWlM1amIyMHZZMlZ5ZEdsbWFXTmhkR1ZoZFhSb2IzSnBkSGt2TUE0R0ExVWREd0VCL3dRRUF3SUhnREFRQmdvcWhraUc5Mk5rQmdzQkJBSUZBREFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBRGFZYjB5NDk0MXNyQjI1Q2xtelQ2SXhETUlKZjRGelJqYjY5RDcwYS9DV1MyNHlGdzRCWjMrUGkxeTRGRkt3TjI3YTQvdncxTG56THJSZHJqbjhmNUhlNXNXZVZ0Qk5lcGhtR2R2aGFJSlhuWTR3UGMvem83Y1lmcnBuNFpVaGNvT0FvT3NBUU55MjVvQVE1SDNPNXlBWDk4dDUvR2lvcWJpc0IvS0FnWE5ucmZTZW1NL2oxbU9DK1JOdXhUR2Y4YmdwUHllSUdxTktYODZlT2ExR2lXb1IxWmRFV0JHTGp3Vi8xQ0tuUGFObVNBTW5CakxQNGpRQmt1bGhnd0h5dmozWEthYmxiS3RZZGFHNllRdlZNcHpjWm04dzdISG9aUS9PamJiOUlZQVlNTnBJcjdONFl0UkhhTFNQUWp2eWdhWndYRzU2QWV6bEhSVEJoTDhjVHFBPT0iOwoJInB1cmNoYXNlLWluZm8iID0gImV3b0pJbTl5YVdkcGJtRnNMWEIxY21Ob1lYTmxMV1JoZEdVdGNITjBJaUE5SUNJeU1ERTVMVEF5TFRJNElERTJPalUyT2pRMElFRnRaWEpwWTJFdlRHOXpYMEZ1WjJWc1pYTWlPd29KSW5GMVlXNTBhWFI1SWlBOUlDSXhJanNLQ1NKMWJtbHhkV1V0ZG1WdVpHOXlMV2xrWlc1MGFXWnBaWElpSUQwZ0lrVXpOVU5CT0VJMExUaEVNMFV0TkROQlJpMDRRamhFTFRjeU5rRTROak0xT0VORU15STdDZ2tpYjNKcFoybHVZV3d0Y0hWeVkyaGhjMlV0WkdGMFpTMXRjeUlnUFNBaU1UVTFNVFF3TVRnd05EUTVNeUk3Q2draVpYaHdhWEpsY3kxa1lYUmxMV1p2Y20xaGRIUmxaQ0lnUFNBaU1qQXhPUzB3TXkweU9DQXlNem8xTmpvME1TQkZkR012UjAxVUlqc0tDU0pwY3kxcGJpMXBiblJ5YnkxdlptWmxjaTF3WlhKcGIyUWlJRDBnSW1aaGJITmxJanNLQ1NKd2RYSmphR0Z6WlMxa1lYUmxMVzF6SWlBOUlDSXhOVFV4TkRBeE9EQXhORFV3SWpzS0NTSmxlSEJwY21WekxXUmhkR1V0Wm05eWJXRjBkR1ZrTFhCemRDSWdQU0FpTWpBeE9TMHdNeTB5T0NBeE5qbzFOam8wTVNCQmJXVnlhV05oTDB4dmMxOUJibWRsYkdWeklqc0tDU0pwY3kxMGNtbGhiQzF3WlhKcGIyUWlJRDBnSW1aaGJITmxJanNLQ1NKcGRHVnRMV2xrSWlBOUlDSXhORE0yTURBME9UQXlJanNLQ1NKMWJtbHhkV1V0YVdSbGJuUnBabWxsY2lJZ1BTQWlabUprWkRJeE5qUXpZemRsTVROaE5HSmxNamhrTkRsaE9HWmhaalJpWkdKaU9ESmpNamsxWkNJN0Nna2liM0pwWjJsdVlXd3RkSEpoYm5OaFkzUnBiMjR0YVdRaUlEMGdJakUwTURBd01EVXpORGN3TnpBeU1DSTdDZ2tpWlhod2FYSmxjeTFrWVhSbElpQTlJQ0l4TlRVek9ERTNOREF4TkRVd0lqc0tDU0poY0hBdGFYUmxiUzFwWkNJZ1BTQWlOakkzTnpneE16QTVJanNLQ1NKMGNtRnVjMkZqZEdsdmJpMXBaQ0lnUFNBaU1UUXdNREF3TlRNME56QTNNREl3SWpzS0NTSmlkbkp6SWlBOUlDSXpPVFlpT3dvSkluZGxZaTF2Y21SbGNpMXNhVzVsTFdsMFpXMHRhV1FpSUQwZ0lqRTBNREF3TURFMU5UazJOamM1TVNJN0Nna2lkbVZ5YzJsdmJpMWxlSFJsY201aGJDMXBaR1Z1ZEdsbWFXVnlJaUE5SUNJNE16QXhNemc0TkRNaU93b0pJbUpwWkNJZ1BTQWlZMjl0TG5Cd0xuTndiM0owY3lJN0Nna2ljSEp2WkhWamRDMXBaQ0lnUFNBaVkyOXRMbk51YzNCdmNuUnpMbWx3YUc5dVpTNXZkWHBvYjNWNmRYRnBkWFJ2Ym1jdVFYVjBiMUpsYm1WM1RXVnRZbVZ5TkRnaU93b0pJbkIxY21Ob1lYTmxMV1JoZEdVaUlEMGdJakl3TVRrdE1ETXRNREVnTURBNk5UWTZOREVnUlhSakwwZE5WQ0k3Q2draWNIVnlZMmhoYzJVdFpHRjBaUzF3YzNRaUlEMGdJakl3TVRrdE1ESXRNamdnTVRZNk5UWTZOREVnUVcxbGNtbGpZUzlNYjNOZlFXNW5aV3hsY3lJN0Nna2liM0pwWjJsdVlXd3RjSFZ5WTJoaGMyVXRaR0YwWlNJZ1BTQWlNakF4T1Mwd015MHdNU0F3TURvMU5qbzBOQ0JGZEdNdlIwMVVJanNLZlE9PSI7CgkicG9kIiA9ICIxNCI7Cgkic2lnbmluZy1zdGF0dXMiID0gIjAiOwp9";
		String receiptPassWord="4b582189d1254acd8f92b64cec353ee1";
		getSubscribeReceiptResponse(receipt,"",receiptPassWord);
	}


	public static void getSubscribeReceiptResponse(String receipt, String evnMark,String receiptPassWord) {


		Map<String, String> appStoreRequestData = Maps.newHashMap();
		appStoreRequestData.put("receipt-data", receipt);
		appStoreRequestData.put("password", receiptPassWord);
		String receiptData = Jsons.DEFAULT.toJson(appStoreRequestData);
		System.out.println(receiptData);
		String responseData = null;
		try {

			responseData = Https.post(REQUEST_URL).contentType(HttpRequest.CONTENT_TYPE_JSON).body(receiptData).readTimeout(20).request();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(" 查询票据返回的结果是" + responseData);

	}
}
