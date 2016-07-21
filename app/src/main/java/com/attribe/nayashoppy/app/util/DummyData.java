package com.attribe.nayashoppy.app.util;

import com.attribe.nayashoppy.app.model.Product;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 20-Jul-16.
 */
public class DummyData {

    public static ArrayList<Product> getDummyProducts(){

        ArrayList<Product> productList = new ArrayList<Product>();
        Product product1 = new Product("Sony Experia T2 Ultra","Rs 1300","Amazon","http://52.66.82.224/images/product/samsung-gallaxy.jpg");

        Product product2 = new Product("Leather Wallet","Rs 1300","Amazon","http://52.66.82.224/images/product/wallet.jpg");

        Product product3 = new Product("Puma shoes","Rs 1300","Amazon","http://52.66.82.224/images/product/pumashoes.jpg");
        Product product4 = new Product("Belt","Rs 1300","Amazon","http://52.66.82.224/images/product/belt.jpg");
        Product product5 = new Product("Fat Analyzer","Rs 1300","Amazon","http://52.66.82.224/images/product/fat_analyzor.jpg");


        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        return productList;
    }
}
