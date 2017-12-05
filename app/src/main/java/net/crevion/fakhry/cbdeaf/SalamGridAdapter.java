package net.crevion.fakhry.cbdeaf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by mgmub on 05/12/17.
 */

public class SalamGridAdapter extends BaseAdapter {

    private Context mContext;

    public SalamGridAdapter(Context context){
        mContext = context;
    }
    @Override
    public int getCount() {
        return mButtonId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView  , ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mButtonId[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mButtonId = {
            R.drawable.ic_icon_app, R.drawable.ic_icon_app,
            R.drawable.ic_icon_app, R.drawable.ic_icon_app,
            R.drawable.ic_icon_app, R.drawable.ic_icon_app,
            R.drawable.ic_icon_app, R.drawable.ic_icon_app,
            R.drawable.ic_icon_app, R.drawable.ic_icon_app,
            R.drawable.ic_icon_app, R.drawable.ic_icon_app,
            R.drawable.ic_icon_app, R.drawable.ic_icon_app,
            R.drawable.ic_icon_app, R.drawable.ic_icon_app,
            R.drawable.ic_icon_app, R.drawable.ic_icon_app
    };

}
