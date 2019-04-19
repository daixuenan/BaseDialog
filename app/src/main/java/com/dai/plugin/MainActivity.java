package com.dai.plugin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dai.plugin.basedialog.DialogUtils;
import com.dai.plugin.basedialog.bean.DialogBean;
import com.dai.plugin.basedialog.dialogs.CommonDialog;
import com.dai.plugin.basedialog.interfaces.OnDialogClosedListener;
import com.dai.plugin.basedialog.interfaces.OnDialogSelectListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCommon = findViewById(R.id.btnCommon);
        Button btnCustom = findViewById(R.id.btnCustom);
        btnCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCommonDialog();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMyDialog();
            }
        });
    }

    private void showCommonDialog() {
        //设置Dialog参数 该类为内部定义实体类，可能不满足需求，需以自定义为主。
        DialogBean dialogBean = new DialogBean();
        dialogBean.setTitle("标题");
        dialogBean.setContent("内容");

        //初始化dialog CommonDialog(可自定义)
        DialogUtils.getInstance().setDialog(new CommonDialog(MainActivity.this))
                //设置DialogBean，此处需要用DialogBean类，自定义的Dialog可自定义数据类型
                .setDialogBean(dialogBean)
                //选择监听
                .setOnDialogSelectListener(new OnDialogSelectListener() {
                    @Override
                    public void onOkClicked() {

                    }
                })
                //dialog消失监听
                .setOnDialogClosedListener(new OnDialogClosedListener() {
                    @Override
                    public void onClosed() {

                    }
                })
                //展示Dialog
                .show();
    }

    //自定义Dialog
    private void showMyDialog() {
        //设置Dialog参数 该类为内部定义实体类，可能不满足需求，需以自定义为主。
        MyDialogBean myDialogBean = new MyDialogBean();
        myDialogBean.setMyTitle("标题");
        myDialogBean.setMyContent("内容");

        //初始化dialog CommonDialog(可自定义)
        DialogUtils.getInstance().setDialog(new CommonDialog(MainActivity.this))
                //设置DialogBean，此处需要用DialogBean类，自定义的Dialog可自定义数据类型
                .setDialogBean(myDialogBean)
                //选择监听
                .setOnDialogSelectListener(new OnDialogSelectListener() {
                    @Override
                    public void onOkClicked() {

                    }
                })
                //dialog消失监听
                .setOnDialogClosedListener(new OnDialogClosedListener() {
                    @Override
                    public void onClosed() {

                    }
                })
                //展示Dialog
                .show();
    }
}
