package net.yanrc.xpring.activity.domain;

import java.util.Date;

import net.yanrc.xpring.activity.biz.model.ActivityModel;

//@JsonIgnoreProperties(value = {"idx"})
public class Activity {

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

    public Activity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor == null ? null : lastEditor.trim();
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Activity id(Integer id) {
        this.id = id;
        return this;
    }

    public Activity type(Integer type) {
        this.type = type;
        return this;
    }

    public Activity isDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public Activity status(Integer status) {
        this.status = status;
        return this;
    }

    public Activity title(String title) {
        this.title = title;
        return this;
    }

    public Activity name(String name) {
        this.name = name;
        return this;
    }

    public Activity startTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Activity endTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Activity creator(String creator) {
        this.creator = creator;
        return this;
    }

    public Activity createTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Activity lastEditor(String lastEditor) {
        this.lastEditor = lastEditor;
        return this;
    }

    public Activity lastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
        return this;
    }

    public static Activity buildFromModel(ActivityModel model) {
        Activity activity = new Activity();
        activity.setId(model.getId());
        activity.setType(model.getType());
        activity.setIsDelete(model.getIsDelete());
        activity.setStatus(model.getStatus());
        activity.setTitle(model.getTitle());
        activity.setName(model.getName());
        activity.setStartTime(model.getStartTime());
        activity.setEndTime(model.getEndTime());
        activity.setCreator(model.getCreator());
        activity.setCreateTime(model.getCreateTime());
        activity.setLastEditor(model.getLastEditor());
        activity.setLastEditTime(model.getLastEditTime());
        return activity;
    }

    public ActivityModel buildToModel() {
        ActivityModel model = new ActivityModel();
        model.setId(this.id);
        model.setType(this.type);
        model.setIsDelete(this.isDelete);
        model.setStatus(this.status);
        model.setTitle(this.title);
        model.setName(this.name);
        model.setStartTime(this.startTime);
        model.setEndTime(this.endTime);
        model.setCreator(this.creator);
        model.setCreateTime(this.createTime);
        model.setLastEditor(this.lastEditor);
        model.setLastEditTime(this.lastEditTime);
        return model;
    }

}