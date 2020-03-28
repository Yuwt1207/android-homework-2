package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

public class Adapter extends RecyclerView.Adapter<Adapter.LinearViewHolder> {
    @NonNull

    private Context mContext;
    private int mitemcount;
    List<Message> messages;
    InputStream assetInput;
    public Adapter(Context context){
        this.mContext=context;
        try {
            assetInput = mContext.getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);
            mitemcount=messages.size();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Adapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {



        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.im_list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.LinearViewHolder viewHolder, final int i) {
        //这里读data设置每个holder的内容

            mitemcount=messages.size();
            viewHolder.tv_title.setText(messages.get(i).getTitle());
            viewHolder.tv_time.setText(messages.get(i).getTime());
            viewHolder.tv_description.setText(messages.get(i).getDescription());
            switch (messages.get(i).getIcon()){
                case "TYPE_ROBOT":
                    viewHolder.iv_avater.setImageResource(R.drawable.session_robot);
                    break;
                case "TYPE_GAME":
                    viewHolder.iv_avater.setImageResource(R.drawable.icon_micro_game_comment);
                    break;
                case "TYPE_SYSTEM":
                    viewHolder.iv_avater.setImageResource(R.drawable.session_system_notice);
                    break;
                case "TYPE_STRANGER":
                    viewHolder.iv_avater.setImageResource(R.drawable.session_stranger);
                    break;
                case "TYPE_USER":
                    viewHolder.iv_avater.setImageResource(R.drawable.icon_girl);
                    break;
            }
            if(messages.get(i).isOfficial())
            {
                viewHolder.iv_robot_notice.setVisibility(View.VISIBLE);
            }
            else
            {
                viewHolder.iv_robot_notice.setVisibility(View.INVISIBLE);
            }



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,ex3jumpActivity.class);
                intent.putExtra("position",Integer.toString(i));
                intent.putExtra("name",messages.get(i).getTitle());
                intent.putExtra("time",messages.get(i).getTime());
                intent.putExtra("description",messages.get(i).getDescription());
                intent.putExtra("icon",messages.get(i).getIcon());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mitemcount;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_title;
        private TextView tv_time;
        private TextView tv_description;
        private ImageView iv_avater;
        private ImageView iv_robot_notice;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_time=itemView.findViewById(R.id.tv_time);
            tv_description=itemView.findViewById(R.id.tv_description);
            iv_avater=itemView.findViewById(R.id.iv_avatar);
            iv_robot_notice=itemView.findViewById(R.id.robot_notice);
        }
    }




}
