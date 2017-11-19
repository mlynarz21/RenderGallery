package kamil.mlynarczyk.rendergallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

/**
 * Created by mlyna on 19.11.2017.
 */

public class RenderProvider {
    private ArrayList<Drawable> renderList;
    private Context context;

    public RenderProvider(Context context){
        renderList = new ArrayList<>();
        this.context = context;
        prepareRenderData();
    }


    private void prepareRenderData() {
        renderList.add(context.getDrawable(R.drawable.render1));
        renderList.add(context.getDrawable(R.drawable.render2));
        renderList.add(context.getDrawable(R.drawable.render3));
        renderList.add(context.getDrawable(R.drawable.render4));
        renderList.add(context.getDrawable(R.drawable.render5));
        renderList.add(context.getDrawable(R.drawable.render6));
        renderList.add(context.getDrawable(R.drawable.render7));
        renderList.add(context.getDrawable(R.drawable.render8));
        renderList.add(context.getDrawable(R.drawable.render9));
        renderList.add(context.getDrawable(R.drawable.render10));
        renderList.add(context.getDrawable(R.drawable.render11));
        renderList.add(context.getDrawable(R.drawable.render12));
        renderList.add(context.getDrawable(R.drawable.render13));
        renderList.add(context.getDrawable(R.drawable.render14));
        renderList.add(context.getDrawable(R.drawable.render15));
        renderList.add(context.getDrawable(R.drawable.render16));
    }

    public ArrayList<Drawable> getRenderList(){
        return renderList;
    }
}
