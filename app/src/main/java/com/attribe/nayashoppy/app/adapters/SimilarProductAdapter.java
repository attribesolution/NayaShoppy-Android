package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.SimilarProductHolder;
import com.attribe.nayashoppy.app.model.product_detail.Datum;
import com.attribe.nayashoppy.app.util.Common;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 25-Aug-16.
 */
public class SimilarProductAdapter extends RecyclerView.Adapter<SimilarProductHolder>{

    private final ArrayList<Datum> mDataset;
    private Context mContext;
    private ISimilarProductClickListener similarProductListener;

    public SimilarProductAdapter(ArrayList<Datum> similarProductList) {
        this.mDataset= similarProductList;
    }

    public void setSimilarProductListener(ISimilarProductClickListener similarProductListener) {
        this.similarProductListener = similarProductListener;
    }

    @Override
    public SimilarProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View row = LayoutInflater.from(mContext).inflate(R.layout.similar_prod_item, parent, false);

        SimilarProductHolder holder = new SimilarProductHolder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(SimilarProductHolder holder, int position) {

        Datum similarProd = mDataset.get(position);

        try {
            Common.setImage(mContext,similarProd.getImages().get(0).getImage_path(),holder.prodImage);
        }catch (Exception exc){

        }

        holder.prodName.setText(similarProd.getProduct_name());
        holder.prodPrice.setText(similarProd.getLowest_price());

        holder.parent.setOnClickListener(new SimilarProductClickListener(similarProd));
        holder.prodImage.setOnClickListener(new SimilarProductClickListener(similarProd));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    private class SimilarProductClickListener implements View.OnClickListener {
        private final Datum mProduct;

        public SimilarProductClickListener(Datum similarProd) {
            mProduct = similarProd;
        }

        @Override
        public void onClick(View view) {

            similarProductListener.OnSimilarProductClick(mProduct);
            //NavigationUtils.showProductDetailScreen(mContext,mProduct);
        }
    }


    public interface ISimilarProductClickListener{

        void OnSimilarProductClick(Datum product);


    }
}
