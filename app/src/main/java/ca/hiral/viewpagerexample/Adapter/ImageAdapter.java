package ca.hiral.viewpagerexample.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Admin on 24-05-2017.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public  Integer[] mThumbIds ;


    public ImageAdapter(Context c, Integer[] mThumbIds){
        mContext = c;
        this.mThumbIds = mThumbIds;
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
