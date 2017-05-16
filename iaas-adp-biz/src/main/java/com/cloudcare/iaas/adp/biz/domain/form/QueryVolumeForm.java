package com.cloudcare.iaas.adp.biz.domain.form;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by guyan on 2017/5/15.
 */
public class QueryVolumeForm {
    public String getIaasVolumeID() {
        return iaasVolumeID;
    }

    public void setIaasVolumeID(String iaasVolumeID) {
        this.iaasVolumeID = iaasVolumeID;
    }

    @JsonProperty("iaas_volume_ID")
    private String iaasVolumeID;

    @Override
    public String toString() {
        return "QueryVolumeForm{" +
                "iaasVolumeID='" + iaasVolumeID + '\'' +
                '}';
    }
}
