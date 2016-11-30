package net.yanrc.xpring.rpc.model;

import java.io.Serializable;
import java.util.Date;

public class ConfigModifyHistoryModel implements Serializable {
    private Long id;

    private Long configPropertiesId;

    private Date operateTime;

    private String operator;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConfigPropertiesId() {
        return configPropertiesId;
    }

    public void setConfigPropertiesId(Long configPropertiesId) {
        this.configPropertiesId = configPropertiesId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}