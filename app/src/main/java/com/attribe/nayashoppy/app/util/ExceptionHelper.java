package com.attribe.nayashoppy.app.util;

/**
 * Created by Sabih Ahmed on 21-Jul-16.
 */
public class ExceptionHelper {


    public static void toolBarNotAddedInView(Exception exception) throws CustomException {

        throw new CustomException("Add Toolbar in view");



    }
}
