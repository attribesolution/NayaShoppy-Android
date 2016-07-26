package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 19-Jul-16.
 */
public class CategoryGridHolder extends RecyclerView.ViewHolder {

    public CardView parentView;
    public TextView categoryName;
    public ImageView categoryImage;

    public CategoryGridHolder(View itemView) {
        super(itemView);

        parentView = (CardView)itemView.findViewById(R.id.card_category);
        categoryName = (TextView) itemView.findViewById(R.id.category_name);
        categoryImage = (ImageView)itemView.findViewById(R.id.category_image);


    }
}
