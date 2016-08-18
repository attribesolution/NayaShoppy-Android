package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 18-Aug-16.
 */
public class SupplierListHolder extends RecyclerView.ViewHolder{


    public ImageView storeLogo;
    public TextView price;
    public Button store;
    public LinearLayout detailContainer;

    public SupplierListHolder(View itemView) {
        super(itemView);
        storeLogo = (ImageView) itemView.findViewById(R.id.supplier_logo);
        price = (TextView) itemView.findViewById(R.id.supplier_quoted_price);
        store = (Button) itemView.findViewById(R.id.supplier_store_button);

        detailContainer = (LinearLayout) itemView.findViewById(R.id.details_container);
    }
}
