package com.cloudcare.iaas.adp.biz.service.impl;

import com.aliyuncs.ecs.model.v20140526.CreateDiskRequest;
import com.aliyuncs.ecs.model.v20140526.CreateDiskResponse;
import com.aliyuncs.ecs.model.v20140526.CreateSnapshotRequest;
import com.aliyuncs.ecs.model.v20140526.CreateSnapshotResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeDisksRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeDisksResponse;
import com.cloudcare.common.lang.service.AbstractBaseService;
import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeForm;
import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeSnapshotForm;
import com.cloudcare.iaas.adp.biz.domain.form.QueryVolumeForm;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeResponse;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeSnapshotResponse;
import com.cloudcare.iaas.adp.biz.domain.reponse.QueryVolumeResponse;
import com.cloudcare.iaas.adp.biz.service.EBSService;
import com.cloudcare.iaas.adp.biz.util.AliyunClient;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wangxiaosan on 17/5/12.
 */
@Service
public class DefaultEBSService extends AbstractBaseService implements EBSService {

    private static final String CREATE_DISK_ACTION = "CreateDisk";
    private static final String CREATE_SNAPSHOT_ACTION = "CreateSnapshot";
    private static final int MAX_PAGE_SIZE = 50;

    @Override
    public CreateVolumeResponse createVolume(CreateVolumeForm volumeForm) {
        CreateDiskRequest createDiskRequest = new CreateDiskRequest();
        createDiskRequest.setActionName(CREATE_DISK_ACTION);
        createDiskRequest.setDiskName(volumeForm.getIaasVolumeName());


        createDiskRequest.setSnapshotId(volumeForm.getIaasVolumeSourceSnapshotID());
        createDiskRequest.setSize(Integer.valueOf(volumeForm.getIaasVolumeSize()));
        createDiskRequest.setDescription(volumeForm.getIaasVolumeDescription());
        CreateDiskResponse process = AliyunClient.getInstance().process(createDiskRequest);
        CreateVolumeResponse response = new CreateVolumeResponse();
        response.setIaasVolumeID(process.getDiskId());
        return response;
    }

    @Override
    public QueryVolumeResponse queryVolume(QueryVolumeForm volumeForm){
        QueryVolumeResponse response=new QueryVolumeResponse();

        DescribeDisksRequest request=new DescribeDisksRequest();
        request.setOwnerId(1092687136033631L);
        request.setActionName("DescribeDisks");
        request.setPageSize(1);
        request.setDiskIds("['"+volumeForm.getIaasVolumeID()+"']");
        DescribeDisksResponse process=AliyunClient.getInstance().process(request);
        List<DescribeDisksResponse.Disk> disks= Lists.newArrayList();
        disks.addAll(process.getDisks());

        if(!disks.isEmpty()){
            DescribeDisksResponse.Disk disk=disks.get(0);

            response.setIaasVolumeID(disk.getDiskId());
            //response.setIaasVolumeIO(disk.get);
            response.setIaasVolumeSize(disk.getSize());
            response.setIaasVolumeName(disk.getDiskName());
            response.setErrorDescription(disk.getDescription());
            response.setIaasVolumeStatus(disk.getStatus());
            //response.setIaasVolumeSourceBackupID(disk.get);
            response.setIaasVolumeSourceSnapshotID(disk.getSourceSnapshotId());
            try {
                response.setIaasVolumeCreateTime(Math.toIntExact(new SimpleDateFormat("yyyy-MM-dd").parse(disk.getCreationTime()).getTime()/1000));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //response.setIaasVolumeUpdateTime(disk.get);
            response.setIaasVmID(disk.getInstanceId());
            //response.setIaasVolumeAttachPoint(disk.get);
        }

        return response;
    }

    @Override
    public CreateVolumeSnapshotResponse createVolumeSnapshot(CreateVolumeSnapshotForm volumeSnapshotForm) {
        CreateSnapshotRequest createSnapshotRequest=new CreateSnapshotRequest();
        createSnapshotRequest.setActionName(CREATE_SNAPSHOT_ACTION);
        createSnapshotRequest.setDiskId(volumeSnapshotForm.getIaasVolumeID());

        createSnapshotRequest.setDescription(volumeSnapshotForm.getIaasVolumeSnapshotDescripiton());
        createSnapshotRequest.setOwnerId(1092687136033631L);
        CreateSnapshotResponse process = AliyunClient.getInstance().process(createSnapshotRequest);
        CreateVolumeSnapshotResponse createVolumeSnapshotResponse=new CreateVolumeSnapshotResponse();
        createVolumeSnapshotResponse.setIaasvolumeID(createSnapshotRequest.getDiskId());
        createVolumeSnapshotResponse.setIaasvolumesnapshotID(process.getSnapshotId());
        return createVolumeSnapshotResponse;
    }
}
