package com.company.service.http;

/**
 * Created by muzhe-wang on 16/7/1.
 */
public class HttpsException  extends RuntimeException {

    public HttpsException() {
        super();
    }

    public HttpsException(String message) {
        super(message);
    }

    public HttpsException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpsException(Throwable cause) {
        super(cause);
    }

}
