package com.cloudcare.iaas.adp.biz.service.impl;

import com.aliyuncs.ecs.model.v20140526.DescribeImagesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeImagesResponse;
import com.cloudcare.common.lang.service.AbstractBaseService;
import com.cloudcare.iaas.adp.biz.domain.reponse.ListVMImageResponse;
import com.cloudcare.iaas.adp.biz.domain.reponse.VMImageInfo;
import com.cloudcare.iaas.adp.biz.service.ECSService;
import com.cloudcare.iaas.adp.biz.util.AliyunClient;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 17/5/10.
 */
@Service
public class DefaultECSService extends AbstractBaseService implements ECSService {


    @Override
    public ListVMImageResponse queryImages() {
        ListVMImageResponse response = new ListVMImageResponse();
        DescribeImagesRequest request = new DescribeImagesRequest();
        request.setOwnerId(1092687136033631L);
        request.setActionName("DescribeImages");
        DescribeImagesResponse process = AliyunClient.getInstance().process(request);
        if (nonNull(process) && !process.getImages().isEmpty()) {
            List<VMImageInfo> infos = Lists.newArrayList();
            process.getImages().parallelStream().forEach(i->{
                VMImageInfo info = new VMImageInfo();
                info.setVm_image_ID(i.getImageId());
                info.setVm_image_name(i.getOSName());
                infos.add(info);
            });
            response.setIaas_vm_image_IDs(infos);
        }
        return response;
    }
}
