package com.example.wyj.loadingdemo.activity;


import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.example.wyj.loadingdemo.MainActivity;
import com.example.wyj.loadingdemo.R;
import com.example.wyj.loadingdemo.base.BaseActivity;
import com.example.wyj.loadingdemo.custom.ToastUtils;
import com.example.wyj.loadingdemo.utils.RegularVerification;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_email)
    public TextInputEditText mEmail;
    @BindView(R.id.tv_pwd)
    public TextInputEditText mPwd;

    @BindView(R.id.btn_login)
    Button btnLogin;

    private String email;
    private String pwd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_login:
                if (checkUserInputData()){
                    if (email.equals("1076006211@qq.com") && pwd.equals("wto123456")) {
                        ToastUtils.showToast(this,"登陆成功",ToastUtils.LENGTH_LONG);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        ToastUtils.showToast(this,"账号或者密码有误",ToastUtils.LENGTH_LONG);
                    }
                }
                break;


        }
    }

    /**
     * 核对登陆信息
     */
    private boolean checkUserInputData() {
        boolean isPass = true;
        email = mEmail.getText().toString();
        pwd = mPwd.getText().toString();

        if (email.isEmpty() || !RegularVerification.isEmail(email)) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }
        if (pwd.isEmpty() || pwd.length() < 6) {
            mPwd.setError("请输入至少6位密码");
            isPass = false;
        }

        return isPass;
    }
}
