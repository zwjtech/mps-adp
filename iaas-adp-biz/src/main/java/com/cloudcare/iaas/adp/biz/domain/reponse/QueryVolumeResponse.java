package com.cloudcare.iaas.adp.biz.domain.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by guyan on 2017/5/12.
 */
public class QueryVolumeResponse extends BaseResponse{
    @Override
    public int getRequestExecuteStatus() {
        return requestExecuteStatus;
    }

    @Override
    public void setRequestExecuteStatus(int requestExecuteStatus) {
        this.requestExecuteStatus = requestExecuteStatus;
    }

    @Override
    public String getErrorDescription() {
        return errorDescription;
    }

    @Override
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }


    @JsonProperty("request_execute_status")
    private int requestExecuteStatus;

    public String getIaasVolumeID() {
        return iaasVolumeID;
    }

    public void setIaasVolumeID(String iaasVolumeID) {
        this.iaasVolumeID = iaasVolumeID;
    }

    public int getIaasVolumeIO() {
        return iaasVolumeIO;
    }

    public void setIaasVolumeIO(int iaasVolumeIO) {
        this.iaasVolumeIO = iaasVolumeIO;
    }

    public int getIaasVolumeSize() {
        return iaasVolumeSize;
    }

    public void setIaasVolumeSize(int iaasVolumeSize) {
        this.iaasVolumeSize = iaasVolumeSize;
    }

    public String getIaasVolumeName() {
        return iaasVolumeName;
    }

    public void setIaasVolumeName(String iaasVolumeName) {
        this.iaasVolumeName = iaasVolumeName;
    }

    public String getIaasVolumeDescription() {
        return iaasVolumeDescription;
    }

    public void setIaasVolumeDescription(String iaasVolumeDescription) {
        this.iaasVolumeDescription = iaasVolumeDescription;
    }

    public String getIaasVolumeStatus() {
        return iaasVolumeStatus;
    }

    public void setIaasVolumeStatus(String iaasVolumeStatus) {
        this.iaasVolumeStatus = iaasVolumeStatus;
    }

    public String getIaasVolumeSourceBackupID() {
        return iaasVolumeSourceBackupID;
    }

    public void setIaasVolumeSourceBackupID(String iaasVolumeSourceBackupID) {
        this.iaasVolumeSourceBackupID = iaasVolumeSourceBackupID;
    }

    public String getIaasVolumeSourceSnapshotID() {
        return iaasVolumeSourceSnapshotID;
    }

    public void setIaasVolumeSourceSnapshotID(String iaasVolumeSourceSnapshotID) {
        this.iaasVolumeSourceSnapshotID = iaasVolumeSourceSnapshotID;
    }

    public int getIaasVolumeCreateTime() {
        return iaasVolumeCreateTime;
    }

    public void setIaasVolumeCreateTime(int iaasVolumeCreateTime) {
        this.iaasVolumeCreateTime = iaasVolumeCreateTime;
    }

    public int getIaasVolumeUpdateTime() {
        return iaasVolumeUpdateTime;
    }

    public void setIaasVolumeUpdateTime(int iaasVolumeUpdateTime) {
        this.iaasVolumeUpdateTime = iaasVolumeUpdateTime;
    }

    public String getIaasVmID() {
        return iaasVmID;
    }

    public void setIaasVmID(String iaasVmID) {
        this.iaasVmID = iaasVmID;
    }

    public String getIaasVolumeAttachPoint() {
        return iaasVolumeAttachPoint;
    }

    public void setIaasVolumeAttachPoint(String iaasVolumeAttachPoint) {
        this.iaasVolumeAttachPoint = iaasVolumeAttachPoint;
    }

    @JsonProperty("iaas_volume_ID")
    private String iaasVolumeID;

    @JsonProperty("error_description")
    private String errorDescription;

    @JsonProperty("iaas_volume_IO")
    private int iaasVolumeIO;

    @JsonProperty("iaas_volume_size")
    private int iaasVolumeSize;

    @JsonProperty("iaas_volume_name")
    private String iaasVolumeName;

    @JsonProperty("iaas_volume_description")
    private String iaasVolumeDescription;

    @JsonProperty("iaas_volume_status")
    private String iaasVolumeStatus;

    @JsonProperty("iaas_volume_source_backup_ID")
    private String iaasVolumeSourceBackupID;

    @JsonProperty("iaas_volume_source_snapshot_ID")
    private String iaasVolumeSourceSnapshotID;

    @JsonProperty("iaas_volume_create_time")
    private int iaasVolumeCreateTime;

    @JsonProperty("iaas_volume_update_time")
    private int iaasVolumeUpdateTime;

    @JsonProperty("iaas_vm_ID")
    private String iaasVmID;

    @JsonProperty("iaas_volume_attach_point")
    private String iaasVolumeAttachPoint;

    @Override
    public String toString() {
        return "QueryVolumeResponse{" +
                "requestExecuteStatus=" + requestExecuteStatus +
                ", iaasVolumeID='" + iaasVolumeID + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                ", iaasVolumeIO=" + iaasVolumeIO +
                ", iaasVolumeSize=" + iaasVolumeSize +
                ", iaasVolumeName='" + iaasVolumeName + '\'' +
                ", iaasVolumeDescription='" + iaasVolumeDescription + '\'' +
                ", iaasVolumeStatus='" + iaasVolumeStatus + '\'' +
                ", iaasVolumeSourceBackupID='" + iaasVolumeSourceBackupID + '\'' +
                ", iaasVolumeSourceSnapshotID='" + iaasVolumeSourceSnapshotID + '\'' +
                ", iaasVolumeCreateTime=" + iaasVolumeCreateTime +
                ", iaasVolumeUpdateTime=" + iaasVolumeUpdateTime +
                ", iaasVmID='" + iaasVmID + '\'' +
                ", iaasVolumeAttachPoint='" + iaasVolumeAttachPoint + '\'' +
                '}';
    }
}
