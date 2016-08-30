package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * Created by Sabih Ahmed on 25-Aug-16.
 */
public class SimilarProductHolder extends RecyclerView.ViewHolder{

    public ImageView prodImage;
    public TextView prodName;
    public HtmlTextView prodPrice;
    public HtmlTextView prodSupplier;

    public SimilarProductHolder(View itemView) {
        super(itemView);

        prodImage = (ImageView) itemView.findViewById(R.id.similar_product_image);
        prodName = (TextView)itemView.findViewById(R.id.similar_product_name);
        prodPrice= (HtmlTextView)itemView.findViewById(R.id.similar_product_price);
        prodSupplier = (HtmlTextView)itemView.findViewById(R.id.similar_prod_supplier);
    }
}
