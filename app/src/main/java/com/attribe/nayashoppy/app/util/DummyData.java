package com.attribe.nayashoppy.app.util;

import com.attribe.nayashoppy.app.model.ParentCategory;
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

    public static ArrayList<ParentCategory> getParentCategories() {
        ParentCategory category1 = new ParentCategory("Mobile & Tablets", "");
        ParentCategory category2 = new ParentCategory("Laptops & Peripherals", "");
        ParentCategory category3 = new ParentCategory("Tvs & Cameras", "");
        ParentCategory category4 = new ParentCategory("Fashion Store", "");
        ParentCategory category5 = new ParentCategory("Kids Corner", "");
        ParentCategory category6 = new ParentCategory("Beauty & Personal care", "");
        ParentCategory category7 = new ParentCategory("Home & Kitchen needs", "");
        ParentCategory category8 = new ParentCategory("Sports & HealthCare", "");
        ParentCategory category9 = new ParentCategory("Books","");


        ArrayList<ParentCategory> rowListItem = new ArrayList<ParentCategory>();

        rowListItem.add(category1);
        rowListItem.add(category2);
        rowListItem.add(category3);
        rowListItem.add(category4);
        rowListItem.add(category5);
        rowListItem.add(category6);
        rowListItem.add(category7);
        rowListItem.add(category8);
        rowListItem.add(category9);

        return rowListItem;
    }
}
