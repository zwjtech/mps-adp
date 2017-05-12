package com.cloudcare.iaas.adp.biz.service.impl;

import com.aliyuncs.ecs.model.v20140526.CreateDiskRequest;
import com.aliyuncs.ecs.model.v20140526.CreateDiskResponse;
import com.cloudcare.common.lang.service.AbstractBaseService;
import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeForm;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeResponse;
import com.cloudcare.iaas.adp.biz.service.EBSService;
import com.cloudcare.iaas.adp.biz.util.AliyunClient;
import org.springframework.stereotype.Service;

/**
 * Created by wangxiaosan on 17/5/12.
 */
@Service
public class DefaultEBSService extends AbstractBaseService implements EBSService {

    private static final String CREATE_DISK_ACTION = "CreateDisk";

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
}