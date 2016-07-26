package com.attribe.nayashoppy.app.screens.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.SubCategoryAdapter;
import com.attribe.nayashoppy.app.model.Children;
import com.attribe.nayashoppy.app.screens.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 22-Jul-16.
 */
public class Fashion extends BaseFragment {

    private View view;
    ArrayList<Children> childMenuList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fasion,container,false);

        super.init(view);
//        Bundle bundleExtra = getArguments();
//        childMenuList = (ArrayList<Children>) bundleExtra.getSerializable(NavigationUtils.CHILD_MENU);
//
//
//
//        init(view);
        return view;
    }

    @Override
    public void onViewInitialized(ListView listView, ArrayList<Children> childMenu, SubCategoryAdapter adapter) {

    }

    //    public void init(View view) {
//        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.expandable_list);
//
//        SubCategoryAdapter adapter = new SubCategoryAdapter(getActivity(),childMenuList);
//
//
//        listView.setAdapter(adapter);
//    }
}
