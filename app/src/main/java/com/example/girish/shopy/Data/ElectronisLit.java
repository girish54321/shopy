package com.example.girish.shopy.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElectronisLit{

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("des")
        @Expose
        private String des;
        @SerializedName("prise")
        @Expose
        private String prise;
        @SerializedName("img_url")
        @Expose
        private String imgUrl;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getPrise() {
            return prise;
        }

        public void setPrise(String prise) {
            this.prise = prise;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

    }