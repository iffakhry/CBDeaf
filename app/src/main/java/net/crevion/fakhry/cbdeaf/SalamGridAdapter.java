package net.crevion.fakhry.cbdeaf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mgmub on 05/12/17.
 */

public class SalamGridAdapter extends BaseAdapter {

    private Context mContext;
    private final String[] gridViewString;
    private final int[] gridViewImageId;

    public SalamGridAdapter(Context context, String[] gridViewString, int[] gridViewImageId){
        mContext = context;
        this.gridViewImageId = gridViewImageId;
        this.gridViewString = gridViewString;
    }
    @Override
    public int getCount() {
        return gridViewString.length;
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
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.salam_gridview_layout, null);
            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.gridview_text);
            ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.gridview_image);
            textViewAndroid.setText(gridViewString[position]);
            imageViewAndroid.setImageResource(gridViewImageId[position]);
        }else{
            gridViewAndroid = (View) convertView;
        }
        return gridViewAndroid;
    }


}
