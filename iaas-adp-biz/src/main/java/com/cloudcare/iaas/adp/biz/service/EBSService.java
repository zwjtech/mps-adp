package com.cloudcare.iaas.adp.biz.service;

import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeForm;
import com.cloudcare.iaas.adp.biz.domain.form.QueryVolumeForm;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeResponse;
import com.cloudcare.iaas.adp.biz.domain.reponse.QueryVolumeResponse;

/**
 * Created by wangxiaosan on 17/5/12.
 */
public interface EBSService {
    CreateVolumeResponse createVolume(CreateVolumeForm volumeForm);
    QueryVolumeResponse queryVolume(QueryVolumeForm volumnForm);
}
