package com.dai.plugin.basedialog.bean;

import java.io.Serializable;

public class DialogBean implements Serializable {

    //标题
    private String title;

    //内容
    private String content;

    //确认按钮文案
    private String btnTextOk;

    //取消按钮文案
    private String btnTextCancel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBtnTextOk() {
        return btnTextOk;
    }

    public void setBtnTextOk(String btnTextOk) {
        this.btnTextOk = btnTextOk;
    }

    public String getBtnTextCancel() {
        return btnTextCancel;
    }

    public void setBtnTextCancel(String btnTextCancel) {
        this.btnTextCancel = btnTextCancel;
    }

}
