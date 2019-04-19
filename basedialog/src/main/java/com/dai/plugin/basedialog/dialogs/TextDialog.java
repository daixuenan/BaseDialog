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

public class TextDialog extends BaseDialog<DialogBean> {

    public TextDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public int getDialogLayout() {
        return R.layout.default_dialog_text;
    }

    private TextView tvText;
    private Button btnOk;

    @Override
    public void init() {
        tvText = (TextView) findViewById(R.id.tvText);
        btnOk = (Button) findViewById(R.id.btnOk);
    }

    @Override
    public void showDialog() {
        if (!TextUtils.isEmpty(dialogBean.getContent())) {
            tvText.setText(dialogBean.getContent());
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
    }
}