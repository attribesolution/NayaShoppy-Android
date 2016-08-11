package com.attribe.nayashoppy.app.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.SubCategoryAdapter;
import com.attribe.nayashoppy.app.model.Children;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 22-Jul-16.
 */
public abstract class BaseFragment extends Fragment{

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    public void init(View view){

        this.view = view;
        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.expandable_list);
        ArrayList<Children> childMenu = (ArrayList<Children>) getArguments().
                                        getSerializable(NavigationUtils.CHILD_MENU);

        SubCategoryAdapter adapter = new SubCategoryAdapter(getActivity(),
                childMenu);


        listView.setAdapter(adapter);

        onViewInitialized(listView,childMenu,adapter);

    }

    public abstract void onViewInitialized(ListView listView, ArrayList<Children> childMenu, SubCategoryAdapter adapter);



}
