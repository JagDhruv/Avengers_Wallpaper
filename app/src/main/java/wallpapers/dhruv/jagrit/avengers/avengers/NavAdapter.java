package wallpapers.dhruv.jagrit.avengers.avengers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by JAGRIT on 20-04-2015.
 */
public class NavAdapter  extends RecyclerView.Adapter<NavAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private int position;
    private Context context;
    List<Information> data= Collections.emptyList();


    public NavAdapter(Context context, List<Information> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.customlayout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        this.position=position;
        Information current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0) {
                    Intent intent = new Intent(context, NextActivity.class);
                    intent.putIntegerArrayListExtra("cap", NextActivity.avengers1);
                    context.startActivity(intent);
                }
                else if(position==1){
                    Intent intent = new Intent(context, NextActivity.class);
                    intent.putIntegerArrayListExtra("iron", NextActivity.avengers2);
                    context.startActivity(intent);
                }
                else if (position==2){
                    Intent intent = new Intent(context, NextActivity.class);
                    intent.putIntegerArrayListExtra("thor", NextActivity.avengers3);
                    context.startActivity(intent);

                }

                else if(position==3){
                    Intent intent = new Intent(context, NextActivity.class);
                    intent.putIntegerArrayListExtra("hulk", NextActivity.avengers4);
                    context.startActivity(intent);
                }

                else if(position==4){
                    Intent intent = new Intent(context, NextActivity.class);
                    intent.putIntegerArrayListExtra("hawk", NextActivity.avengers5);
                    context.startActivity(intent);
                }

                else if(position == 5){

                    Intent intent = new Intent(context, NextActivity.class);
                    intent.putIntegerArrayListExtra("widow", NextActivity.avengers6);
                    context.startActivity(intent);
                }

                else if(position == 6){

                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putIntegerArrayListExtra("ultron", MainActivity.avengers);
                    context.startActivity(intent);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        public MyViewHolder(View itemView) {
            super(itemView);

            title= (TextView) itemView.findViewById(R.id.textView1);
            icon = (ImageView) itemView.findViewById(R.id.iconView);

        }

    }

}
