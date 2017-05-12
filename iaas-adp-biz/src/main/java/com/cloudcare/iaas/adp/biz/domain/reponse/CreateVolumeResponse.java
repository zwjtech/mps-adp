package com.cloudcare.iaas.adp.biz.domain.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by wangxiaosan on 17/5/12.
 */
public class CreateVolumeResponse extends BaseResponse {

    @JsonProperty("iaas_volume_ID")
    private String iaasVolumeID;

    public String getIaasVolumeID() {
        return iaasVolumeID;
    }

    public void setIaasVolumeID(String iaasVolumeID) {
        this.iaasVolumeID = iaasVolumeID;
    }

    @Override
    public String toString() {
        return "CreateVolumeResponse{" +
                "iaasVolumeID='" + iaasVolumeID + '\'' +
                '}';
    }
}
