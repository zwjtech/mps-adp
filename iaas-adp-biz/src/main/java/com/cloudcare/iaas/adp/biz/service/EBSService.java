package com.cloudcare.iaas.adp.biz.service;

import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeForm;
import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeSnapshotForm;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeResponse;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeSnapshotResponse;

/**
 * Created by wangxiaosan on 17/5/12.
 */
public interface EBSService {
    CreateVolumeResponse createVolume(CreateVolumeForm volumeForm);

    CreateVolumeSnapshotResponse createVolumeSnapshot(CreateVolumeSnapshotForm volumeSnapshotForm);
}
