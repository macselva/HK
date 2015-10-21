package com.macslab.prova;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by massi on 22/04/2015.
 */
public class HkArrayAdapterItem extends ArrayAdapter<HkElement> {
    Context   mContext;
    int       mLayoutResId;
    ArrayList<HkElement> mData = new ArrayList<HkElement>();

    public HkArrayAdapterItem(Context ctx, int lyResId, ArrayList<HkElement> data) {
        super (ctx, lyResId, data);

        this.mContext = ctx;
        this.mLayoutResId = lyResId;
        this.mData = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
         * The convertView argument is essentially a "ScrapView" as described is Lucas post
         * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
         * It will have a non-null value when ListView is asking you recycle the row layout.
         * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
         */
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(mLayoutResId, parent, false);
        }

        HkElement objectItem = mData.get(position);

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(objectItem.getHkElemName());
        textViewItem.setTag(objectItem.getHkElemId());

        return convertView;
    }
}
