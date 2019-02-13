package com.example.girish.shopy.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Electronics {
        @SerializedName("error")
        @Expose
        private Boolean error;
        @SerializedName("product")
        @Expose
        private List<ElectronisLit> product = null;

        public Boolean getError() {
            return error;
        }

        public void setError(Boolean error) {
            this.error = error;
        }

        public List<ElectronisLit> getProduct() {
            return product;
        }

        public void setProduct(List<ElectronisLit> product) {
            this.product = product;
        }

}
