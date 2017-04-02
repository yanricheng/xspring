package net.yanrc.xpring.activity.exception;

/**
 * Created by yanricheng on 2017/3/6.
 */
public class ErrorInfo {
    int code;
    String msg;

    public ErrorInfo(){

    }

    public ErrorInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
