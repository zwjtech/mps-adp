package com.cloudcare.iaas.adp.biz.domain.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by wangxiaosan on 17/5/10.
 */
public class VMImageInfo {

    @JsonProperty("vm_image_ID")
    private String vmImageID;

    @JsonProperty("vm_image_name")
    private String vmImageName;

    public String getVmImageID() {
        return vmImageID;
    }

    public void setVmImageID(String vmImageID) {
        this.vmImageID = vmImageID;
    }

    public String getVmImageName() {
        return vmImageName;
    }

    public void setVmImageName(String vmImageName) {
        this.vmImageName = vmImageName;
    }

    @Override
    public String toString() {
        return "VMImageInfo{" +
                "vmImageID='" + vmImageID + '\'' +
                ", vmImageName='" + vmImageName + '\'' +
                '}';
    }
}
