package com.attribe.nayashoppy.app.screens.product_detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.SpecsListAdapter;
import com.attribe.nayashoppy.app.model.popular_products.Data;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.network.interfaces.ProductListener;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 16-Aug-16.
 */
public class FragmentSpecification extends Fragment {

    private View view;

    private WebView specs;
    private ExpandableListView specsList;
    private String slug = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_specification, container, false);

        init();
        return view;

    }

    private void init() {

        getProduct();

    }

    private void getProduct() {
        try {
            slug = getArguments().getString(NavigationUtils.KEY_PRODUCT_SLUG, "");
        }catch (Exception exc){
            //todo: handle exception
        }

        ProductsBAL.getProductDetail(slug, new ProductListener() {
            @Override
            public void onProductReceived(Data data) {
                setSpecifications(data.getFeaturesList());
            }

            @Override
            public void onDataIssue(String message) {

            }

            @Override
            public void onFailure(String message) {

            }
        });

    }

    private void setSpecifications(ArrayList<Data.FeaturesList> featuresList) {

        //setSpecsInHTML(featuresList);
        setSpecsInListView(featuresList);


    }

    /**This method sets specs in expandable list view
     *
     * @param featuresList
     */
    private void setSpecsInListView(ArrayList<Data.FeaturesList> featuresList) {

        specsList = (ExpandableListView) view.findViewById(R.id.specs_list);
        specsList.setAdapter(new SpecsListAdapter(getActivity(),featuresList));

    }

    /**This method sets Spcs in webView by HTML
     *
     * @param featuresList
     */
    private void setSpecsInHTML(ArrayList<Data.FeaturesList> featuresList) {
        //To use web view, hide expandable list & change webview's visibility to visible
        specs = (WebView) view.findViewById(R.id.specification);

        String featureName = "";
        String featureValue = "";
        String tableHTML = "<html >\n" +
                "<body>"+
                "<table width=\"100%\" border=\"0\" margin-bottom = \"25%\" cellpadding=\"5\" style=\" background-color: #e8e9eb;\">\n" ;

        String tableRow = "";



        String tableEnd=
                "</table>\n" +
                        "</body>"+
                        "</html>";
        String rowHeading="";
        String section = "";

        for(Data.FeaturesList feature:featuresList){

            rowHeading = " <tr>\n" +
                    "    <td colspan=\"2\" align=\"left\" style=\"padding-right:25px;\">"+feature.getFeatureGroupName()+"</td>\n" +
                    "  </tr>";
            for(Data.FeaturesList.FeatureValue  featureGroup:feature.getFeatureValues()){

                featureName = featureGroup.getFeatureName();
                featureValue = featureGroup.getFeatureValue();

                tableRow += "  <tr>\n" +
                        "    <td width=\"25%\" align=\"right\" bgcolor=\"#FFFFFF\" style=\"padding-right:25px;\">"+featureName+"</td>\n" +
                        "    <td width=\"75%\" bgcolor=\"#FFFFFF\" style=\"padding-left:25px;\">"+featureValue+"</td>\n" +
                        "\n" +
                        "  </tr>\n";

            }

            section += rowHeading+tableRow;

        }

        String finalTable =
                tableHTML = tableHTML.concat(section).concat(tableEnd);

        String simpleTable = "<html>\n" +
                "<table width=\"100%\" border=\"0\" cellpadding=\"5\" style=\" background-color: #e8e9eb;\">\n" +
                "<tr>\n" +
                "<td width=\"25%\" align=\"right\" bgcolor=\"#FFFFFF\" style=\"padding-right:25px;\">"+featureName+"</td>\n" +
                "<td width=\"75%\" bgcolor=\"#FFFFFF\" style=\"padding-left:25px;\">"+featureValue+"</td>\n" +
                "</tr>\n" +
                "\n" +
                "<tr>\n" +
                "<td>RAM</td>\n" +
                "<td>1 GB</td>\n" +
                "</tr>\n" +
                "\n" +
                "<tr>\n" +
                "<td>Expandable</td>\n" +
                "<td>NO</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "\n" +
                "</html>";


        try {

            specs.loadData(tableHTML,"text/html", null);
        }catch (Exception exc){

        }
    }
}
