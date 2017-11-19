package kamil.mlynarczyk.rendergallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlyna on 18.11.2017.
 */

class RenderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Drawable> renderList;
    private List<Drawable> renderListRight;
    private List<Drawable> renderListLeft;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView leftRender, rightRender;

        public MyViewHolder(View view) {
            super(view);
            leftRender = (ImageView) view.findViewById(R.id.image_left);
            rightRender = (ImageView) view.findViewById(R.id.image_right);
        }

    }

    public RenderAdapter(List<Drawable> renderList, Context context) {
        this.renderList = renderList;
        this.context = context;
        renderListRight = new ArrayList<>();
        renderListLeft = new ArrayList<>();
        splitRenderLists();
    }

    private void splitRenderLists() {
        for(int i = 0; i<renderList.size(); i++){
            int splitter = i%2;

            switch (splitter){
                case (0):{
                    renderListLeft.add(renderList.get(i));
                }
                break;

                case (1):{
                    renderListRight.add(renderList.get(i));
                }
                break;
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.render_row_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public int getItemCount() {
        return renderListLeft.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Drawable leftRender = renderListLeft.get(position);
        Drawable rightRender;

        MyViewHolder viewHolder = (MyViewHolder) holder;
        Glide.with(context)
                .load(leftRender)
                .into(viewHolder.leftRender);

        if(renderListRight.size()>position) {
            rightRender = renderListRight.get(position);
            Glide.with(context)
                    .load(rightRender)
                    .into(viewHolder.rightRender);
        }
        else viewHolder.rightRender.setImageDrawable(null);

        viewHolder.rightRender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.leftRender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
