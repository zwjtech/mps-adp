package com.cloudcare.iaas.adp.biz.domain.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by 11620 on 2017/5/15.
 */
public class CreateVolumeSnapshotResponse extends BaseResponse {
    @JsonProperty("iaas_volume_ID")
      private String  iaasvolumeID;
    @JsonProperty("iaas_volume_snapshot_ID")
    private String  iaasvolumesnapshotID;

    public String getIaasvolumeID() {
        return iaasvolumeID;
    }

    public void setIaasvolumeID(String iaasvolumeID) {
        this.iaasvolumeID = iaasvolumeID;
    }

    public String getIaasvolumesnapshotID() {
        return iaasvolumesnapshotID;
    }

    public void setIaasvolumesnapshotID(String iaasvolumesnapshotID) {
        this.iaasvolumesnapshotID = iaasvolumesnapshotID;
    }

    @Override
    public String toString() {
        return "CreateVolumeSnapshotResponse{" +
                "iaasvolumeID='" + iaasvolumeID + '\'' +
                ", iaasvolumesnapshotID='" + iaasvolumesnapshotID + '\'' +
                '}';
    }
}
