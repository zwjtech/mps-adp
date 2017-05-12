package com.cloudcare.iaas.adp.biz.domain.form;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by wangxiaosan on 17/5/12.
 */
public class CreateVolumeForm {

    @JsonProperty("iaas_volume_name")
    private String iaasVolumeName;
    @JsonProperty("iaas_volume_source_backup_ID")
    private String iaasVolumeSourceBackupID;
    @JsonProperty("iaas_volume_IO")
    private String iaasVolumeIO;
    @JsonProperty("iaas_volume_source_snapshot_ID")
    private String iaasVolumeSourceSnapshotID;
    @JsonProperty("iaas_volume_size")
    private String iaasVolumeSize;
    @JsonProperty("iaas_volume_description")
    private String iaasVolumeDescription;

    public String getIaasVolumeName() {
        return iaasVolumeName;
    }

    public void setIaasVolumeName(String iaasVolumeName) {
        this.iaasVolumeName = iaasVolumeName;
    }

    public String getIaasVolumeSourceBackupID() {
        return iaasVolumeSourceBackupID;
    }

    public void setIaasVolumeSourceBackupID(String iaasVolumeSourceBackupID) {
        this.iaasVolumeSourceBackupID = iaasVolumeSourceBackupID;
    }

    public String getIaasVolumeIO() {
        return iaasVolumeIO;
    }

    public void setIaasVolumeIO(String iaasVolumeIO) {
        this.iaasVolumeIO = iaasVolumeIO;
    }

    public String getIaasVolumeSourceSnapshotID() {
        return iaasVolumeSourceSnapshotID;
    }

    public void setIaasVolumeSourceSnapshotID(String iaasVolumeSourceSnapshotID) {
        this.iaasVolumeSourceSnapshotID = iaasVolumeSourceSnapshotID;
    }

    public String getIaasVolumeSize() {
        return iaasVolumeSize;
    }

    public void setIaasVolumeSize(String iaasVolumeSize) {
        this.iaasVolumeSize = iaasVolumeSize;
    }

    public String getIaasVolumeDescription() {
        return iaasVolumeDescription;
    }

    public void setIaasVolumeDescription(String iaasVolumeDescription) {
        this.iaasVolumeDescription = iaasVolumeDescription;
    }

    @Override
    public String toString() {
        return "CreateVolumeForm{" +
                "iaasVolumeName='" + iaasVolumeName + '\'' +
                ", iaasVolumeSourceBackupID='" + iaasVolumeSourceBackupID + '\'' +
                ", iaasVolumeIO='" + iaasVolumeIO + '\'' +
                ", iaasVolumeSourceSnapshotID='" + iaasVolumeSourceSnapshotID + '\'' +
                ", iaasVolumeSize='" + iaasVolumeSize + '\'' +
                ", iaasVolumeDescription='" + iaasVolumeDescription + '\'' +
                '}';
    }
}
