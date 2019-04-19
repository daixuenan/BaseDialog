package com.dai.plugin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;

import com.dai.plugin.basedialog.base.BaseDialog;

public class MyCommonDialog extends BaseDialog<MyDialogBean> {

    private TextView tvTitle;
    private TextView tvContent;

    public MyCommonDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public int getDialogLayout() {
        return R.layout.dialog_my_common;
    }

    @Override
    public void init() {
        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
    }

    @Override
    public void showDialog() {
        if (!TextUtils.isEmpty(dialogBean.getMyTitle())) {
            tvTitle.setText(dialogBean.getMyTitle());
        }
        if (!TextUtils.isEmpty(dialogBean.getMyContent())) {
            tvContent.setText(dialogBean.getMyContent());
        }
    }
}
