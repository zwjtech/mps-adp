package com.cloudcare.iaas.adp.biz.service;

import com.cloudcare.iaas.adp.biz.domain.reponse.ListVMImageResponse;

/**
 * Created by wangxiaosan on 17/5/10.
 */
public interface ECSService {
    ListVMImageResponse queryImages();

}
