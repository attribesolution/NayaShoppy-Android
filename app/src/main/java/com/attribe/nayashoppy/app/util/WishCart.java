package com.attribe.nayashoppy.app.util;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by attribe on 10/7/16.
 */
public class WishCart {
    public static ArrayList<WishProduct> wishList=new ArrayList<WishProduct>();
    private static WishCart wishCart;
   private Context contextl;


    private WishCart()
    {
    }
    public static WishCart getInstance(){
        if(wishCart == null)
        {


            wishCart =new WishCart();
           // wishList=new ArrayList<WishProduct>();
        }


        return wishCart;

    }

    /**
     * This method adds an item into wishlist and if item is already exist then they simply ignore
     * @param wishProduct
     */

    public void addWishItem(WishProduct wishProduct,Context context)
    {
        boolean isFound=false;
        if(DevicePreferences.getInstance().getWishList()!=null)
        {
            //for (WishProduct iterator:wishList)
                for (WishProduct iterator:DevicePreferences.getInstance().getWishList())
            {
                if (iterator.getProductId() == wishProduct.getProductId())//this statement checks whether product is present or not
                {


                    isFound = true;
                    Toast.makeText(context,"Item Already Exist",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            if(!isFound)//if item not found they simply add
            {
               // wishList.add(wishProduct);
                //DevicePreferences.getInstance().setWishlist(wishList);
                DevicePreferences.getInstance().addwishItem(wishProduct);
                Toast.makeText(context,"Item Added",Toast.LENGTH_SHORT).show();
            }

        }
        else
        {

           // wishList.add(wishProduct);
            //DevicePreferences.getInstance().setWishlist(wishList);
            DevicePreferences.getInstance().addwishItem(wishProduct);

            // DevicePreferences.getInstance().addwishItem(wishProduct);

            Toast.makeText(context,"Item Added",Toast.LENGTH_SHORT).show();

        }

    }
}
