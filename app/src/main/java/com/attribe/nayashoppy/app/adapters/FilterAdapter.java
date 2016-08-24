package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.model.dummy_model.FilterKeys;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 23-Aug-16.
 */
public class FilterAdapter extends BaseAdapter {


    private Context mContext;
    private ArrayList<FilterKeys> mDataset;
    private View row;
    private KeySelectListener keySelectListener;


    public FilterAdapter(Context context, ArrayList<FilterKeys> keys) {
        this.mContext = context;
        this.mDataset = keys;
    }

    public void setKeySelectListener(KeySelectListener keySelectListener) {
        this.keySelectListener = keySelectListener;
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public FilterKeys getItem(int i) {
        return mDataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view!=null){

            holder = (ViewHolder) view.getTag();
        }

        else{

            view = LayoutInflater.from(mContext).inflate(R.layout.filter_key_item,viewGroup,false);

            holder = new ViewHolder(view);

            view.setTag(holder);
        }

        holder.keyName.setText(mDataset.get(i).getKey());

        holder.keyName.setOnClickListener(new KeyClickListener(i));


        return view;
    }

    class ViewHolder{
        TextView keyName;
        public ViewHolder(View row) {
            keyName = (TextView) row.findViewById(R.id.key_name);
        }
    }

    public interface KeySelectListener{

        void onKeySelected(int mPosition);
    }

    private class KeyClickListener implements View.OnClickListener {
        private final int mPosition;

        public KeyClickListener(int i) {
            this.mPosition = i;
        }

        @Override
        public void onClick(View view) {

            try {

                keySelectListener.onKeySelected(mPosition);
            }catch (Exception exc){

            }


        }
    }
}
