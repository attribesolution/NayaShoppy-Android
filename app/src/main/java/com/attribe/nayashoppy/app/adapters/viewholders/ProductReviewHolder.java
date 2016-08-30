package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import org.w3c.dom.Text;

/**
 * Created by Sabih Ahmed on 29-Aug-16.
 */
public class ProductReviewHolder extends RecyclerView.ViewHolder{

    public TextView userName;
    public TextView reviewDate;
    public TextView review;

    public ProductReviewHolder(View itemView) {
        super(itemView);


        userName = (TextView) itemView.findViewById(R.id.review_user_name);
        reviewDate = (TextView)itemView.findViewById(R.id.review_date);
        review = (TextView)itemView.findViewById(R.id.review_text);
    }
}
