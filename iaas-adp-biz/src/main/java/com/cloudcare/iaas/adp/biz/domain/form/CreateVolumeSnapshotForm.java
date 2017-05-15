package com.cloudcare.iaas.adp.biz.domain.form;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by 11620 on 2017/5/15.
 */
public class CreateVolumeSnapshotForm {
    @JsonProperty("iaas_volume_snapshot_name")
    private  String iaasVolumeSnapshotName;
    @JsonProperty("iaas_volume_ID")
    private String iaasVolumeID;
    @JsonProperty("iaas_volume_snapshot_descripiton")
    private String iaasVolumeSnapshotDescripiton;

    public String getIaasVolumeSnapshotName() {
        return iaasVolumeSnapshotName;
    }

    public void setIaasVolumeSnapshotName(String iaasVolumeSnapshotName) {
        this.iaasVolumeSnapshotName = iaasVolumeSnapshotName;
    }

    public String getIaasVolumeID() {
        return iaasVolumeID;
    }

    public void setIaasVolumeID(String iaasVolumeID) {
        this.iaasVolumeID = iaasVolumeID;
    }

    public String getIaasVolumeSnapshotDescripiton() {
        return iaasVolumeSnapshotDescripiton;
    }

    public void setIaasVolumeSnapshotDescripiton(String iaasVolumeSnapshotDescripiton) {
        this.iaasVolumeSnapshotDescripiton = iaasVolumeSnapshotDescripiton;
    }

    @Override
    public String toString() {
        return "CreateVolumeSnapshotForm{" +
                "iaasVolumeSnapshotName='" + iaasVolumeSnapshotName + '\'' +
                ", iaasVolumeID='" + iaasVolumeID + '\'' +
                ", iaasVolumeSnapshotDescripiton='" + iaasVolumeSnapshotDescripiton + '\'' +
                '}';
    }
}
