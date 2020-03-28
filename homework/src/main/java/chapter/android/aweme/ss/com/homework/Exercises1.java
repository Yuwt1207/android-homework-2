package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import chapter.android.aweme.ss.com.homework.widget.application;
import chapter.android.aweme.ss.com.homework.MainActivity;

import static chapter.android.aweme.ss.com.homework.MainActivity.str;

/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */
public class Exercises1 extends AppCompatActivity {


    private static final String TAG = "yuweitao";

    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";
    private static final String ON_RESTORE_INSTANCE_STATE = "onRestoreInstanceState";
    private static final String LIFECYCLE_CALLBACKS_TEXT_KEY = "callbacks";

    private TextView mLifecycleDisplay;
//    private application app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises1);


        mLifecycleDisplay=findViewById(R.id.tv);
        mLifecycleDisplay.setText(str);
        //只要把每个操作都存放在一个全局变量里，当activity执行onCreate()的时候重新打印出来就行
        //花了我一下午搞application没搞出来，static十分钟接解决，我是傻逼
        //老师为什么我把application变量定义在onCreate外面，然后在onCreate里面调用方法会导致程序直接闪退，定义在onCreate里面就不会
        logAndAppend(ON_CREATE);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);

    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);

    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);

    }


    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndAppend(ON_STOP);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndAppend(ON_DESTROY);

    }

    private void logAndAppend(String lifecycleEvent) {

        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
        mLifecycleDisplay.append(lifecycleEvent + "\n");
        lifecycleEvent+="\n";
        str+=lifecycleEvent;
    }
//
    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logAndAppend(ON_SAVE_INSTANCE_STATE);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logAndAppend(ON_RESTORE_INSTANCE_STATE);

    }
}
