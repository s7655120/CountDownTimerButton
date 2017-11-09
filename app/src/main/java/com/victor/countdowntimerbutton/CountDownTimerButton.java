package com.victor.countdowntimerbutton;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;

/**
 * Created by Victor on 2017/11/9.
 */
public class CountDownTimerButton extends android.support.v7.widget.AppCompatButton implements Handler.Callback {

    private Handler mCountDownTimerHandler;

    private int mCountDownTime;
    private int mCurrentTime;

    public CountDownTimerButton(Context context) {
        super(context);
        init();
    }

    public CountDownTimerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountDownTimerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mCountDownTimerHandler = new Handler(this);
    }

    public void setCountDownTime(int countDownTime){
        if(countDownTime < 3){
            mCountDownTime = 3;
        } else {
            this.mCountDownTime = countDownTime;
        }
    }

    public void startCountDown(){
        mCurrentTime = mCountDownTime;
        setText(mCurrentTime - 1 + "");
        mCountDownTimerHandler.sendEmptyMessage(1);
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.what == 1){
            if(mCurrentTime > 0){
                mCurrentTime = mCurrentTime - 1;
                setText(String.valueOf(mCurrentTime));
                mCountDownTimerHandler.sendEmptyMessageDelayed(1, 1000);
            } else {
                mCountDownTimerHandler.removeMessages(1);
            }
        }

        return false;
    }
}
