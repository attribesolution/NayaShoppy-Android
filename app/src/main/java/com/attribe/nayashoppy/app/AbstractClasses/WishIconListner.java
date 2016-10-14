package com.attribe.nayashoppy.app.AbstractClasses;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.attribe.nayashoppy.app.util.WishCart;
import com.attribe.nayashoppy.app.util.WishProduct;

/**
 * Created by attribe on 10/13/16.
 */
public  class WishIconListner implements View.OnClickListener
{
    WishProduct wishCart;
    Context mContext;

    public WishIconListner(WishProduct wishCart,Context context)
    {
     this.wishCart = wishCart;
        this.mContext=context;

    }
    @Override
    public void onClick(View view)
    {
        WishCart.getInstance().addWishItem(wishCart,mContext);
    }
}
