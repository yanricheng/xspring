//package net.yanrc.xpring.rpc.exception;
//
//import net.yanrc.app.common.error.Message;
//
///**
// * Created by yanricheng on 16-10-13.
// */
//public enum MessageEnum {
//
//    param_error("400", "参数错误:%s"),
//
//    db_error("800", "db操作错误:%s");
//
//    private String code;
//    private String text;
//
//    MessageEnum() {
//    }
//
//    MessageEnum(String code, String text) {
//        this.code = code;
//        this.text = text;
//    }
//
//    public Message message() {
//        return new Message(MessageEnum.this.code, MessageEnum.this.text);
//    }
//}
