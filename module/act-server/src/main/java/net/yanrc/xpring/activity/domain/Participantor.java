package net.yanrc.xpring.activity.domain;

import java.util.Date;

public class Participantor {
    private Integer id;

    private Integer isDelete;

    private Integer status;

    private String title;

    private String name;

    private String creator;

    private Date createTime;

    private String lastEditor;

    private Date lastEditTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Participantor id(Integer id) {
        this.id = id;
        return this;
    }

    public Participantor isDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public Participantor status(Integer status) {
        this.status = status;
        return this;
    }

    public Participantor status(String title) {
        this.title = title;
        return this;
    }

    public Participantor name(String name) {
        this.name = name;
        return this;
    }

    public Participantor creator(String creator) {
        this.creator = creator;
        return this;
    }

    public Participantor createTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Participantor lastEditor(String lastEditor) {
        this.lastEditor = lastEditor;
        return this;
    }

    public Participantor lastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
        return this;
    }
}