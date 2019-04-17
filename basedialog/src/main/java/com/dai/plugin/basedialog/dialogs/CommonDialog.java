package com.dai.plugin.basedialog.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dai.plugin.basedialog.R;
import com.dai.plugin.basedialog.base.BaseDialog;
import com.dai.plugin.basedialog.bean.DialogBean;

public class CommonDialog extends BaseDialog<DialogBean> {

    public CommonDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public int getDialogLayout() {
        return R.layout.default_dialog_common;
    }

    private TextView tvTitle;
    private TextView tvContent;
    private Button btnOk;

    @Override
    public void init() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvContent = (TextView) findViewById(R.id.tv_content);
        btnOk = (Button) findViewById(R.id.btn_ok);
    }

    @Override
    public void showDialog() {
        if (!TextUtils.isEmpty(dialogBean.getTitle())) {
            tvTitle.setText(dialogBean.getTitle());
        }
        if (!TextUtils.isEmpty(dialogBean.getContent())) {
            tvContent.setText(dialogBean.getContent());
        }
        if (!TextUtils.isEmpty(dialogBean.getBtnTextOk())) {
            btnOk.setText(dialogBean.getBtnTextOk());
        }
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onDialogSelectListener != null) {
                    onDialogSelectListener.onOkClicked();
                }
            }
        });
        show();
    }
}