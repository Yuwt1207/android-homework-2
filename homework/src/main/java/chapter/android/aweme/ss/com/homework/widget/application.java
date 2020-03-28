package chapter.android.aweme.ss.com.homework.widget;

import android.app.Application;

public class application extends Application {

    public String str;

    public String getStr()
    {
        return this.str;
    }

    public void addStr(String s)
    {
        this.str+=s;
    }

    @Override
    public void onCreate() {

        super.onCreate();
        str="dassaf";
    }
}
