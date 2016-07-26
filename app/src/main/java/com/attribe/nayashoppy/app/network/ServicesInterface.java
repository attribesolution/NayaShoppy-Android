package com.attribe.nayashoppy.app.network;

import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.model.Menu;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 06-Jun-16.
 */
public interface ServicesInterface {

    @GET(EndPoints.STAGE_GET_MENU)
    Call<Menu> getMenu();



}
