package com.attribe.nayashoppy.app.network.bals;

import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.model.Menu;
import com.attribe.nayashoppy.app.network.RestClient;
import com.attribe.nayashoppy.app.network.interfaces.MenuListener;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 25-Jul-16.
 */
public class MenuBAL {


    private static ArrayList<Datum> menuList;

    public static ArrayList<Datum> getMenu(final MenuListener menuListener){



        Call<Menu> menu = RestClient.getAdapter().getMenu();

        menu.enqueue(new Callback<Menu>() {
            @Override
            public void onResponse(Call<Menu> call, Response<Menu> response) {
                menuList = new ArrayList();
                if(response.isSuccessful()){

                    if(!response.body().getData().isEmpty()){
                        menuListener.onMenuReceived();
                        menuList = response.body().getData();
                        try {
                            DevicePreferences.getInstance().setMenu(menuList);
                            menuListener.onMenuStored();
                        } catch (Exception e) {
                            //TODO:handle exception
                            e.printStackTrace();
                        }
                    }

                    else{
                        menuListener.onDataIssue(response.body().getMeta().getMessage());
                    }
                }


            }

            @Override
            public void onFailure(Call<Menu> call, Throwable t) {

                menuListener.onFailure(t.getMessage());
            }
        });


         return menuList;
    }
}
