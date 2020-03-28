package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class ex3jumpActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        getSupportActionBar().hide();//隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏最上面的状态拦

        tv=findViewById(R.id.tv_content_info);
        Bundle bundle=getIntent().getExtras();
        String position=bundle.getString("position");
        String name=bundle.getString("name");
        String time=bundle.getString("time");
        String description=bundle.getString("description");
        String icon=bundle.getString("icon");
        tv.setText("这是第"+position+"个item\n名字是"+name+"\n时间是"+time+"前\n内容是:"+description);
        tv.setTextSize(30);
    }
}
