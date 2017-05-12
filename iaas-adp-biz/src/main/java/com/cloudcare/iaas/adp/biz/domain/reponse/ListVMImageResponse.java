package com.cloudcare.iaas.adp.biz.domain.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by wangxiaosan on 17/5/10.
 */
public class ListVMImageResponse extends BaseResponse {

    @JsonProperty("iaas_vm_image_IDs")
    private List<VMImageInfo>  iaasVmImageIDs;

    public List<VMImageInfo> getIaasVmImageIDs() {
        return iaasVmImageIDs;
    }

    public void setIaasVmImageIDs(List<VMImageInfo> iaasVmImageIDs) {
        this.iaasVmImageIDs = iaasVmImageIDs;
    }

    @Override
    public String toString() {
        return "ListVMImageResponse{" +
                "iaasVmImageIDs=" + iaasVmImageIDs +
                '}';
    }
}
