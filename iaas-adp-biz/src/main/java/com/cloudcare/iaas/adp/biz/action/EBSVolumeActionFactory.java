package com.cloudcare.iaas.adp.biz.action;

import com.cloudcare.common.lang.serialize.JSON;
import com.cloudcare.iaas.adp.biz.action.parent.CloudBlockStorageModule;
import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeForm;
import com.cloudcare.iaas.adp.biz.domain.form.QueryVolumeForm;
import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeSnapshotForm;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeResponse;
import com.cloudcare.iaas.adp.biz.domain.reponse.QueryVolumeResponse;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeSnapshotResponse;
import com.cloudcare.iaas.adp.biz.service.EBSService;
import com.cloudcare.web.api.annotation.Action;
import com.cloudcare.web.api.annotation.ParentModule;
import com.cloudcare.web.api.support.AbstractActionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by wangxiaosan on 17/5/12.
 */
@Controller("volume")
@ParentModule(CloudBlockStorageModule.class)
public class EBSVolumeActionFactory extends AbstractActionFactory {

    @Autowired
    private EBSService ebsService;

    @Action("createVolume|v1")
    public CreateVolumeResponse createVolume(String param){
        CreateVolumeForm volumeForm = JSON.toBean(param,CreateVolumeForm.class);
        return ebsService.createVolume(volumeForm);
    }

    @Action("queryVolume|v1")
    public QueryVolumeResponse queryVolume(String param) {
        QueryVolumeForm volumeForm = JSON.toBean(param, QueryVolumeForm.class);
        return ebsService.queryVolume(volumeForm);
    }


}
