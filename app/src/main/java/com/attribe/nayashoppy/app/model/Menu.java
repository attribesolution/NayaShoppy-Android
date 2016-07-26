package com.attribe.nayashoppy.app.model;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 26-Jul-16.
 */
public class Menu {

    public Meta meta;
    public ArrayList<Datum> data = new ArrayList<Datum>();


    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    //===============================================Inner Classes======================================================
    public class Meta {
        public Integer status;
        public String message;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}
