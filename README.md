# BaseDialog

#### 介绍
这是一个基于Android自带Dialog封装的一个Dialog调用框架，代码结构清晰，扩展性好。

#### 安装教程

项目的root Gradle下添加 maven { url 'https://jitpack.io' }，如下

```markdown
    ```
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }

    allprojects {
        repositories {
            google()
            jcenter()
            maven { url 'https://jitpack.io' }
        }
    }
    ```
```
modle 的Gradle添加

```markdown
implementation 'com.github.daixuenan:BaseDialog:v1.0.1'
```

#### 使用说明

1. 直接调用

```markdown
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
```

2. 自定义调用
```markdown
        //新建自定义MyDialogBean
        public class MyDialogBean {

            private String myTitle;

            private String myContent;

            public String getMyTitle() {
                return myTitle;
            }

            public void setMyTitle(String myTitle) {
                this.myTitle = myTitle;
            }

            public String getMyContent() {
                return myContent;
            }

            public void setMyContent(String myContent) {
                this.myContent = myContent;
            }
        }
```