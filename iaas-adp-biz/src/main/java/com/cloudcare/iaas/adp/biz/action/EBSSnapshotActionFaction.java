package com.cloudcare.iaas.adp.biz.action;

import com.cloudcare.common.lang.serialize.JSON;
import com.cloudcare.iaas.adp.biz.action.parent.CloudBlockStorageModule;
import com.cloudcare.iaas.adp.biz.domain.form.CreateVolumeSnapshotForm;
import com.cloudcare.iaas.adp.biz.domain.reponse.CreateVolumeSnapshotResponse;
import com.cloudcare.iaas.adp.biz.service.EBSService;
import com.cloudcare.web.api.annotation.Action;
import com.cloudcare.web.api.annotation.ParentModule;
import com.cloudcare.web.api.support.AbstractActionFactory;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by 11620 on 2017/5/15.
 */
@Controller("snapshot")
@ParentModule(CloudBlockStorageModule.class)
public class EBSSnapshotActionFaction extends AbstractActionFactory {
    @Autowired
    private EBSService ebsService;

    @Action("createVolumeSnapshot|v1")
    public CreateVolumeSnapshotResponse createVolumeSnapshot(String param) {
        CreateVolumeSnapshotForm volumeSnapshotForm = new CreateVolumeSnapshotForm();
        if (isNotBlank(param)) {
            volumeSnapshotForm = JSON.toBean(param, CreateVolumeSnapshotForm.class);
            CreateVolumeSnapshotForm volumeSnapshotForm1 = new Gson().fromJson(param, CreateVolumeSnapshotForm.class);

        }
        return ebsService.createVolumeSnapshot(volumeSnapshotForm);
    }
}
