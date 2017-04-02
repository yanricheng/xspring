package net.yanrc.xpring.activity.exception;

/**
 * Created by yanricheng on 2017/3/6.
 */
public enum StatusInfo {

    DataNotFoundException(450, "data not found");

    StatusInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorInfo getErrorInfo() {
        return new ErrorInfo(code, msg);
    }

}
