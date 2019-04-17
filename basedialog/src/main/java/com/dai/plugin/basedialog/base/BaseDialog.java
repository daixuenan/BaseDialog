package com.dai.plugin.basedialog.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.dai.plugin.basedialog.R;
import com.dai.plugin.basedialog.interfaces.OnDialogClosedListener;
import com.dai.plugin.basedialog.interfaces.OnDialogSelectListener;

public abstract class BaseDialog<T> extends Dialog {

    //宽度占屏幕比例
    public static final float DIALOG_WIDTH = 0.7f;

    //获取layoutID
    public abstract int getDialogLayout();

    //dialog按钮点击
    protected OnDialogSelectListener onDialogSelectListener;

    //dialog关闭
    protected OnDialogClosedListener onDialogClosedListener;

    //dialog参数
    protected T dialogBean;

    protected Context mContext;

    //占屏幕宽度比例 范围 0-1
    private float width = DIALOG_WIDTH;

    //初始化dialog
    public abstract void init();

    //展示dialog
    public abstract void showDialog();

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
        this.mContext = context;
        setContentView(getDialogLayout());

        //初始化尺寸
        initView();

        //初始化监听
        initListeners();

        //初始化控件
        init();
    }

    private void initView() {
        //设置屏幕尺寸
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = (int) (screenWidth * width);
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        this.getWindow().setAttributes(params);
        getWindow().getDecorView().setBackgroundResource(R.drawable.shape_rect_corner_bg_white);
    }

    private void initListeners() {
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (onDialogClosedListener != null) {
                    onDialogClosedListener.onClosed();
                }
            }
        });
    }

    public void setDialogBean(T dialogBean) {
        this.dialogBean = dialogBean;
    }

    public void setOnDialogSelectListener(OnDialogSelectListener onDialogSelectListener) {
        this.onDialogSelectListener = onDialogSelectListener;
    }

    public void setOnDialogClosedListener(OnDialogClosedListener onDialogClosedListener) {
        this.onDialogClosedListener = onDialogClosedListener;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
