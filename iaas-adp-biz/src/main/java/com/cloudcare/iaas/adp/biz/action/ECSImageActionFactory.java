package com.cloudcare.iaas.adp.biz.action;

import com.cloudcare.iaas.adp.biz.action.parent.CloudHostModule;
import com.cloudcare.iaas.adp.biz.domain.reponse.ListVMImageResponse;
import com.cloudcare.iaas.adp.biz.service.ECSService;
import com.cloudcare.web.api.annotation.Action;
import com.cloudcare.web.api.annotation.ParentModule;
import com.cloudcare.web.api.support.AbstractActionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by wangxiaosan on 17/5/10.
 */
@ParentModule(CloudHostModule.class)
@Controller("image")
public class ECSImageActionFactory extends AbstractActionFactory {

    @Autowired
    private ECSService ecsService;

    @Action("listImage|v2")
    public ListVMImageResponse queryImages(){
        return ecsService.queryImages();
    }
}
