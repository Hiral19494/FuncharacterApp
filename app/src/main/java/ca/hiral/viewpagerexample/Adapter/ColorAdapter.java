package ca.hiral.viewpagerexample.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import ca.hiral.viewpagerexample.R;

/**
 * Created by Admin on 06-06-2017.
 */
public class ColorAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.pic_s9_white,
            R.drawable.pic_s9_2, R.drawable.pic_s9_3,
            R.drawable.pic_s9_4, R.drawable.pic_s9_5,
            R.drawable.pic_s9_6, R.drawable.pic_s9_7,
            R.drawable.pic_s9_8, R.drawable.pic_s9_9,
            R.drawable.pic_s9_10, R.drawable.pic_s9_11,
            R.drawable.pic_s9_13, R.drawable.pic_s9_14,
            R.drawable.pic_s9_15

    };

    // Constructor
    public ColorAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(100, 100));

        return imageView;
    }

}

