package com.attribe.nayashoppy.app.model.product_category;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 02-Sep-16.
 */
public class CategoryFilter {
    public int total;
    public int took;
    public Facets facets;


    public class Facets {
        public ArrayList<Filter> filters;

        public ArrayList<Filter> getFilters() {
            return filters;
        }


        public class Filter {
            public int key;
            public int count;
            public String name;
            public ArrayList<Value> values;

            public int getKey() {
                return key;
            }

            public int getCount() {
                return count;
            }

            public String getName() {
                return name;
            }

            public ArrayList<Value> getValues() {
                return values;
            }

            public class Value {
                public int key;
                public int count;
                public String name;


                public int getKey() {
                    return key;
                }

                public int getCount() {
                    return count;
                }

                public String getName() {
                    return name;
                }
            }
        }
    }
}
