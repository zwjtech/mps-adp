package com.cloudcare.iaas.adp.biz.domain.reponse;

/**
 * Created by wangxiaosan on 17/5/10.
 */
public class VMImageInfo {
    private String vm_image_ID;
    private String vm_image_name;

    public String getVm_image_ID() {
        return vm_image_ID;
    }

    public void setVm_image_ID(String vm_image_ID) {
        this.vm_image_ID = vm_image_ID;
    }

    public String getVm_image_name() {
        return vm_image_name;
    }

    public void setVm_image_name(String vm_image_name) {
        this.vm_image_name = vm_image_name;
    }

    @Override
    public String toString() {
        return "VMImageInfo{" +
                "vm_image_ID='" + vm_image_ID + '\'' +
                ", vm_image_name='" + vm_image_name + '\'' +
                '}';
    }
}
