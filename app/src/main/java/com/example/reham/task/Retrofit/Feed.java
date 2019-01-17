package com.example.reham.task.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by reham on 1/15/2019.
 */

public class Feed {
    @SerializedName("Id")
    private int Id;
    @SerializedName("TitleEN")
    private String titleEn;
    @SerializedName("TitleAR")
    private String titleAr;
    @SerializedName("Photo")
    private String photo;
    @SerializedName("ProductCount")
    private int productCount;
    @SerializedName("SubCategories")
    private List<Feed> subCategories;
    @SerializedName("HaveModel")
    private int haveModel;

    public Feed(int Id, String titleEn, String titleAr, String photo, int productCount, List<Feed> subCategories, int haveModel) {
        this.Id = Id;
        this.titleEn = titleEn;
        this.titleAr = titleAr;
        this.photo = photo;
        this.productCount = productCount;
        this.subCategories = subCategories;
        this.haveModel = haveModel;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleAr() {
        return titleAr;
    }

    public void setTitleAr(String titleAr) {
        this.titleAr = titleAr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public List<Feed> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Feed> subCategories) {
        this.subCategories = subCategories;
    }

    public int getHaveModel() {
        return haveModel;
    }

    public void setHaveModel(int haveModel) {
        this.haveModel = haveModel;
    }
}