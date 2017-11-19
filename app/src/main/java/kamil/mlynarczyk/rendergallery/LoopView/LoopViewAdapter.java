package kamil.mlynarczyk.rendergallery.LoopView;


/**
 * Created by mlyna on 19.11.2017.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife; import butterknife.Unbinder;
import butterknife.internal.Utils;
import kamil.mlynarczyk.rendergallery.R;
import kamil.mlynarczyk.rendergallery.CircularActivity;
import java.util.ArrayList;
import java.util.List;

public class LoopViewAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ViewPager pager;
    private List<Drawable> pagerList;
    private List<Drawable> renderImageList;

    private class RenderViewHolder {
        private ImageView render;
        RelativeLayout relativeLayout;

        private RenderViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class RenderViewHolderViewBinding implements Unbinder {
        private RenderViewHolder target;

        @UiThread
        public RenderViewHolderViewBinding(RenderViewHolder target, View source) {
            this.target = target;
            target.render = (ImageView) Utils.findRequiredViewAsType(source, R.id.imageViewPage, "field 'imageView'", ImageView.class);
            target.relativeLayout = (RelativeLayout) Utils.findRequiredViewAsType(source, R.id.singleRenderContainer, "field 'relativeLayout'", RelativeLayout.class);
        }

        @CallSuper
        public void unbind() {
            RenderViewHolder target = this.target;
            if (target == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            target.render = null;
            target.relativeLayout = null;
        }
    }

    public LoopViewAdapter(Context context, LayoutInflater layoutInflater, List<Drawable> renderList) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.renderImageList = renderList;
        setData(renderList);
    }

    private void setData(List<Drawable> renderImages) {
        if (renderImages != null) {
            int size = renderImages.size();
            int pager_size = size + 2;
            ArrayList<Drawable> renderImagePageViewHolders = new ArrayList();
            int i = 0;
            while (i < pager_size) {
                if (i == 0) {
                    renderImagePageViewHolders.add(this.renderImageList.get(size - 1));
                } else if (i == pager_size - 1) {
                    renderImagePageViewHolders.add(this.renderImageList.get(0));
                } else if (i > 0 && i < pager_size - 1) {
                    renderImagePageViewHolders.add(this.renderImageList.get(i - 1));
                }
                i++;
            }
            this.pagerList = renderImagePageViewHolders;
        }
    }

    public int getCount() {
        if (this.pagerList == null) {
            return 0;
        }
        return this.pagerList.size();
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = this.layoutInflater.inflate(R.layout.gallery_page, container, false);
        RenderViewHolder pageViewHolder = new RenderViewHolder(itemView);
        pageViewHolder.render.setImageDrawable((this.pagerList.get(position)));
        pageViewHolder.render.setTransitionName((this.pagerList.get(position)) + "");
        container.addView(itemView);
        ((CircularActivity) this.context).scheduleStartPostponedTransition(pageViewHolder.render);
        return itemView;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}