package com.attribe.nayashoppy.app.model.Slider;

import com.attribe.nayashoppy.app.model.Meta;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 02-Sep-16.
 */
public class Slider {

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
        public int category_id;
        public String slider_type;
        public String image;
        public String description;
        public String start_date;
        public String end_date;
        public String link;
        public String status;
        public String created;
        public ArrayList<Image> images;

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public int getCategory_id() {
            return category_id;
        }

        public String getSlider_type() {
            return slider_type;
        }

        public String getImage() {
            return image;
        }

        public String getDescription() {
            return description;
        }

        public String getStart_date() {
            return start_date;
        }

        public String getEnd_date() {
            return end_date;
        }

        public String getLink() {
            return link;
        }

        public String getStatus() {
            return status;
        }

        public String getCreated() {
            return created;
        }

        public ArrayList<Image> getImages() {
            return images;
        }

        public class Image {

            public int id;
            public int slider_id;
            public String image;
            public String description;
            public String link;
            public String created;


            public int getId() {
                return id;
            }

            public int getSlider_id() {
                return slider_id;
            }

            public String getImage() {
                return image;
            }

            public String getDescription() {
                return description;
            }

            public String getLink() {
                return link;
            }

            public String getCreated() {
                return created;
            }
        }
    }


}
