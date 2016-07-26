package com.attribe.nayashoppy.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabih Ahmed on 25-Jul-16.
 */
public class Children implements Serializable {
    public Integer id;
    public String title;
    public Integer category_id;
    public String slug;
    public Integer brand_id;
    public Integer parent_id;
    public Integer type;
    public String image;
    public String others;
    public String description;
    public String meta_title;
    public String meta_keyword;
    public String meta_desc;
    public String menu_type;
    public Integer sort_order;
    public String status;
    public String created;
    public ArrayList<Children> children = new ArrayList<Children>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeta_title() {
        return meta_title;
    }

    public void setMeta_title(String meta_title) {
        this.meta_title = meta_title;
    }

    public String getMeta_keyword() {
        return meta_keyword;
    }

    public void setMeta_keyword(String meta_keyword) {
        this.meta_keyword = meta_keyword;
    }

    public String getMeta_desc() {
        return meta_desc;
    }

    public void setMeta_desc(String meta_desc) {
        this.meta_desc = meta_desc;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }


}
