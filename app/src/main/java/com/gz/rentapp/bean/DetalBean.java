package com.gz.rentapp.bean;

/**
 * Created by Administrator on 2016/5/28.
 */
public class DetalBean  {
      private int id;
      private String name_zh_cn;
      private String name_en;
      private int poi_count;
      private int plans_count;
      private int articles_count;
      private  int contents_count;
      private  int destination_trips_coun;
      private  boolean locked;
      private boolean wiki_app_publish;
      private  long updated_at;
      private String image_url;
      private  int guides_count;

    public DetalBean(int id, String name_zh_cn, String name_en, int poi_count, int plans_count, int articles_count, int contents_count, int destination_trips_coun, boolean locked, boolean wiki_app_publish, long updated_at, String image_url, int guides_count) {
        this.id = id;
        this.name_zh_cn = name_zh_cn;
        this.name_en = name_en;
        this.poi_count = poi_count;
        this.plans_count = plans_count;
        this.articles_count = articles_count;
        this.contents_count = contents_count;
        this.destination_trips_coun = destination_trips_coun;
        this.locked = locked;
        this.wiki_app_publish = wiki_app_publish;
        this.updated_at = updated_at;
        this.image_url = image_url;
        this.guides_count = guides_count;
    }

    public DetalBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_zh_cn() {
        return name_zh_cn;
    }

    public void setName_zh_cn(String name_zh_cn) {
        this.name_zh_cn = name_zh_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getPoi_count() {
        return poi_count;
    }

    public void setPoi_count(int poi_count) {
        this.poi_count = poi_count;
    }

    public int getPlans_count() {
        return plans_count;
    }

    public void setPlans_count(int plans_count) {
        this.plans_count = plans_count;
    }

    public int getArticles_count() {
        return articles_count;
    }

    public void setArticles_count(int articles_count) {
        this.articles_count = articles_count;
    }

    public int getContents_count() {
        return contents_count;
    }

    public void setContents_count(int contents_count) {
        this.contents_count = contents_count;
    }

    public int getDestination_trips_coun() {
        return destination_trips_coun;
    }

    public void setDestination_trips_coun(int destination_trips_coun) {
        this.destination_trips_coun = destination_trips_coun;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isWiki_app_publish() {
        return wiki_app_publish;
    }

    public void setWiki_app_publish(boolean wiki_app_publish) {
        this.wiki_app_publish = wiki_app_publish;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getGuides_count() {
        return guides_count;
    }

    public void setGuides_count(int guides_count) {
        this.guides_count = guides_count;
    }
}
