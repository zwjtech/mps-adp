package com.cloudcare.iaas.adp.biz.domain.reponse;

import java.util.List;

/**
 * Created by wangxiaosan on 17/5/10.
 */
public class ListVMImageResponse extends BaseResponse {
    private List<VMImageInfo>  iaas_vm_image_IDs;

    public List<VMImageInfo> getIaas_vm_image_IDs() {
        return iaas_vm_image_IDs;
    }

    public void setIaas_vm_image_IDs(List<VMImageInfo> iaas_vm_image_IDs) {
        this.iaas_vm_image_IDs = iaas_vm_image_IDs;
    }

    @Override
    public String toString() {
        return "ListVMImageResponse{" +
                "iaas_vm_image_IDs=" + iaas_vm_image_IDs +
                '}';
    }
}
