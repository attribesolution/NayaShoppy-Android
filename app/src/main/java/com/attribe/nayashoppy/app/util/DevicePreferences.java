package com.attribe.nayashoppy.app.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.attribe.nayashoppy.app.model.Datum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 09-Jun-16.
 */
public class DevicePreferences {


    private static final String KEY_MENU = "menu";
    private static DevicePreferences instance;
    private static SharedPreferences prefs;
    private Context mContext;

    public void init(Context context){

        this.mContext = context;

        prefs = mContext.getSharedPreferences("clientPrefs", Context.MODE_PRIVATE);
    }


    private DevicePreferences() {

    }

    public static DevicePreferences getInstance(){

        if(instance == null ){

            instance = new DevicePreferences();
        }

        return instance;

    }



    public void setMenu(ArrayList<Datum> menu) throws Exception{
        SharedPreferences.Editor editor;

        try {
            editor = prefs.edit();
            Gson gson = new Gson();

            String menuObject = gson.toJson(menu);
            editor.putString(KEY_MENU,menuObject);
            editor.commit();
        }
        catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                //TODO: Handle npe here
                throw new RuntimeException("Shared Pref not initialized ");
            }

            else{
                throw new RuntimeException("Something bad happened while storing menu");
            }


        }



    }

    public ArrayList<Datum> getMenu(){
        Gson gson = new Gson();
        String menu="";
        ArrayList<Datum> menuList=null;
        try {
            menu = prefs.getString(KEY_MENU, null);

            TypeToken<ArrayList<Datum>> token = new TypeToken<ArrayList<Datum>>() {};
            menuList = gson.fromJson(menu, token.getType());
        }catch (Exception e){


        }


        return menuList;

    }
}
