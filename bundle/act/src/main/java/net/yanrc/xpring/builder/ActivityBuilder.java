package net.yanrc.xpring.builder;

import net.yanrc.xpring.dal.domain.Activity;

import java.util.Date;

/**
 * Created by yanricheng on 2017/3/25.
 */
public class ActivityBuilder {
    private Integer id;

    private Integer type;

    private Integer isDelete;

    private Integer status;

    private String title;

    private String name;

    private Date startTime;

    private Date endTime;

    private String creator;

    private Date createTime;

    private String lastEditor;

    private Date lastEditTime;

    public static ActivityBuilder newInstance() {
        return new ActivityBuilder();
    }

    public Activity build() {
        Activity activity = new Activity();
        activity.setId(this.id);
        activity.setType(this.type);
        activity.setIsDelete(this.isDelete);
        activity.setStatus(this.status);
        activity.setTitle(this.title);
        activity.setName(this.name);
        activity.setStartTime(this.startTime);
        activity.setEndTime(this.endTime);
        activity.setCreator(this.creator);
        activity.setCreateTime(this.createTime);
        activity.setLastEditor(this.lastEditor);
        activity.setLastEditTime(this.lastEditTime);
        return activity;
    }

    public ActivityBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public ActivityBuilder type(Integer type) {
        this.type = type;
        return this;
    }

    public ActivityBuilder isDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public ActivityBuilder status(Integer status) {
        this.status = status;
        return this;
    }

    public ActivityBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ActivityBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ActivityBuilder startTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public ActivityBuilder endTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public ActivityBuilder creator(String creator) {
        this.creator = creator;
        return this;
    }

    public ActivityBuilder createTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public ActivityBuilder lastEditor(String lastEditor) {
        this.lastEditor = lastEditor;
        return this;
    }

    public ActivityBuilder lastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
        return this;
    }


}
