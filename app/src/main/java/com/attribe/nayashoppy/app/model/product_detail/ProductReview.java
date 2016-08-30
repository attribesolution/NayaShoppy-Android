package com.attribe.nayashoppy.app.model.product_detail;

import com.attribe.nayashoppy.app.model.Deals.Meta;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 29-Aug-16.
 */
public class ProductReview {
    public Meta meta;
    public ArrayList<Datum> data;



    public Meta getMeta() {
        return meta;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public class Datum {
        public int id;
        public String title;
        public int product_id;
        public String description;
        public String status;
        public String created;
        public int rating;
        public ArrayList<User> user;

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public int getProduct_id() {
            return product_id;
        }

        public String getDescription() {
            return description;
        }

        public String getStatus() {
            return status;
        }

        public String getCreated() {
            return created;
        }

        public int getRating() {
            return rating;
        }

        public ArrayList<User> getUser() {
            return user;
        }

        public class User {
            public int id;
            public String username;
            public String email;
            public int flags;
            public String unconfirmed_email;
            public String registration_ip;
            public String blocked_at;

            public int getId() {
                return id;
            }

            public String getUsername() {
                return username;
            }

            public String getEmail() {
                return email;
            }

            public int getFlags() {
                return flags;
            }

            public String getUnconfirmed_email() {
                return unconfirmed_email;
            }

            public String getRegistration_ip() {
                return registration_ip;
            }

            public String getBlocked_at() {
                return blocked_at;
            }
        }

    }

}
