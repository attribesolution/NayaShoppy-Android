package com.attribe.nayashoppy.app.config;

/**
 * Created by Sabih Ahmed on 29-Aug-16.
 */
public class AppConfig {

    private int mode =-1;

    private static AppConfig mInstance ;

    private AppConfig() {


    }

    public static synchronized AppConfig getInstance(){
        if(mInstance ==null){

            mInstance = new AppConfig();
            return mInstance;
        }
        else{

            return mInstance;
        }


    }

    public int getMode() {

        return mode;

    }

    public void setMode(int mode) {
        this.mode = mode;
    }


}
