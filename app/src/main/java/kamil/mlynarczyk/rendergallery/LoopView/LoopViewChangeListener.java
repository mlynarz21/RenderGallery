package kamil.mlynarczyk.rendergallery.LoopView;

import android.os.Handler;
import android.support.v4.view.ViewPager;

/**
 * Created by mlyna on 19.11.2017.
 */

public class LoopViewChangeListener implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;

    public LoopViewChangeListener(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
    }

    public void onPageScrollStateChanged(int state) {
        if (state == 0) {
            int size = this.viewPager.getAdapter().getCount() - 2;
            int position = this.viewPager.getCurrentItem();
            int page = position;
            if (position == 0) {
                page = size;
            } else if (position == size + 1) {
                page = 1;
            } else if (position >= 1 && position <= size) {
                int i = position - 1;
            }
            if (position != page) {
                final int curr = page;
                new Handler().post(new Runnable() {
                    public void run() {
                        LoopViewChangeListener.this.viewPager.setCurrentItem(curr, false);
                    }
                });
            }
        }
    }
}
