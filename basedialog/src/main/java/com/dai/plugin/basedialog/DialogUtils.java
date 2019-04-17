package com.dai.plugin.basedialog;

import com.dai.plugin.basedialog.base.BaseDialog;
import com.dai.plugin.basedialog.interfaces.OnDialogClosedListener;
import com.dai.plugin.basedialog.interfaces.OnDialogSelectListener;

public class DialogUtils {

    private volatile static DialogUtils instance = null;

    public static DialogUtils getInstance() {
        if (instance == null) {
            synchronized (DialogUtils.class) {
                if (instance == null) {
                    instance = new DialogUtils();
                }
            }
        }
        return instance;
    }

    private BaseDialog baseDialog;

    public DialogUtils setDialog(BaseDialog baseDialog) {
        this.baseDialog = baseDialog;
        return this;
    }

    //show
    public void show() {
        if (baseDialog != null) {
            baseDialog.showDialog();
        }
    }

    public DialogUtils setDialogBean(Object dialogBean) {
        if (baseDialog != null) {
            baseDialog.setDialogBean(dialogBean);
        }
        return this;
    }

    //按钮监听
    public DialogUtils setOnDialogSelectListener(OnDialogSelectListener onDialogSelectListener) {
        if (baseDialog != null) {
            baseDialog.setOnDialogSelectListener(onDialogSelectListener);
        }
        return this;
    }

    //关闭
    public DialogUtils setOnDialogClosedListener(OnDialogClosedListener onDialogClosedListener) {
        if (baseDialog != null) {
            baseDialog.setOnDialogClosedListener(onDialogClosedListener);
        }
        return this;
    }
}
