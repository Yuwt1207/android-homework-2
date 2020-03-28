package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises2);

        Button btn=findViewById(R.id.button6);
        final TextView tv=findViewById(R.id.textView9);
        final View view=findViewById(R.id.exercises2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(Integer.toString(getAllChildViewCount(view)));
                tv.setTextSize(30);
            }
        });

    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        if(view==null){return 0;}
        int viewcount=0;
        if(view instanceof ViewGroup)
        {
            viewcount++;
            for(int i=0;i<((ViewGroup) view).getChildCount();i++)
            {
                View v=((ViewGroup) view).getChildAt(i);
                if(v instanceof ViewGroup)
                {
                    viewcount+=getAllChildViewCount(v);
                }
                else
                {
                    viewcount++;
                }
            }
        }
        return viewcount;
    }
}
