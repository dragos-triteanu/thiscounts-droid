package eu.thiscounts.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.List;

import eu.thiscounts.R;

/**
 * Created by xPku on 7/3/16.
 */
public class ListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<String> mItems;
    private Context mCtx;

    public ListAdapter(Context ctx, List<String> items){
        mCtx = ctx;
        this.mItems = items;
        mInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(1);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_card_item, null);
        }

        View cardImage = convertView.findViewById(R.id.cardImage);

        return convertView;
    }
}
