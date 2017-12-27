package net.crevion.fakhry.cbdeaf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mgmub on 05/12/17.
 */

public class SalamGridAdapter extends BaseAdapter {

    Context mContext;
    String[] gridViewString;
    int[] gridViewImageId;
    private static LayoutInflater inflater=null;

    public SalamGridAdapter(Context context, String[] aGridViewString, int[] aGridViewImageId){
        mContext = context;
        gridViewImageId = aGridViewImageId;
        gridViewString = aGridViewString;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView  , ViewGroup parent) {
        Holder holder=new Holder();

        View rowView;
//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        rowView = inflater.inflate(R.layout.salam_gridview_layout, null);
        holder.gv_text =(TextView) rowView.findViewById(R.id.textview_kalimat);
        holder.gv_img =(ImageView) rowView.findViewById(R.id.bt_icon);

        holder.gv_text.setText(gridViewString[position]);
        holder.gv_img.setImageResource(gridViewImageId[position]);

//        rowView.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Toast.makeText(mContext, "You Clicked "+gridViewString[position], Toast.LENGTH_SHORT).show();
//            }
//        });
//        if(convertView == null){
//            gridViewAndroid = new View(mContext);
//            gridViewAndroid = inflater.inflate(R.layout.salam_gridview_layout, null);
//            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.textview_kalimat);
//            ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.bt_icon);
//            textViewAndroid.setText(this.gridViewString[position]);
//            imageViewAndroid.setImageResource(this.gridViewImageId[position]);
//        }else{
//            gridViewAndroid = (View) convertView;
//        }
        return rowView;
    }

    public class Holder
    {
        TextView gv_text;
        ImageView gv_img;
    }


}
