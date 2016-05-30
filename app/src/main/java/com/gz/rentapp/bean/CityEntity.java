package com.gz.rentapp.bean;

/**
 * Created by Administrator on 2016/5/29.
 */
public class CityEntity {
   private int id ;
    private String name;
    private  int budget;
    private String description;
    private  int plan_days_count;
    private  int plan_nodes_count;
    private  String image_url;
    private long updated_at;

    public CityEntity(int id, String name, int budget, String description, int plan_days_count, int plan_nodes_count, String image_url, long updated_at) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.description = description;
        this.plan_days_count = plan_days_count;
        this.plan_nodes_count = plan_nodes_count;
        this.image_url = image_url;
        this.updated_at = updated_at;
    }

    public CityEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlan_days_count() {
        return plan_days_count;
    }

    public void setPlan_days_count(int plan_days_count) {
        this.plan_days_count = plan_days_count;
    }

    public int getPlan_nodes_count() {
        return plan_nodes_count;
    }

    public void setPlan_nodes_count(int plan_nodes_count) {
        this.plan_nodes_count = plan_nodes_count;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }
}
