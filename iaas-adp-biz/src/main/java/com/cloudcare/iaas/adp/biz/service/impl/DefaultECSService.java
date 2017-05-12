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

    private static final int MAX_PAGE_SIZE = 50;

    @Override
    public ListVMImageResponse queryImages() {
        ListVMImageResponse response = new ListVMImageResponse();
        DescribeImagesRequest request = new DescribeImagesRequest();
        request.setOwnerId(1092687136033631L);
        request.setActionName("DescribeImages");
        request.setPageSize(MAX_PAGE_SIZE);
        DescribeImagesResponse process = AliyunClient.getInstance().process(request);
        Integer totalCount = process.getTotalCount();

        List<DescribeImagesResponse.Image> images = Lists.newArrayList();
        int totalPage = totalCount % MAX_PAGE_SIZE == 0 ? totalCount / MAX_PAGE_SIZE : totalCount / MAX_PAGE_SIZE + 1;
        for (int i = 1; i <= totalPage; i++) {
            request.setPageNumber(i);
            DescribeImagesResponse pageImages = AliyunClient.getInstance().process(request);
            images.addAll(pageImages.getImages());
        }
        if (! images.isEmpty()) {
            List<VMImageInfo> infos = Lists.newArrayList();
            images.parallelStream().forEach(i -> {
                VMImageInfo info = new VMImageInfo();
                info.setVmImageID(i.getImageId());
                info.setVmImageName(i.getOSName());
                infos.add(info);
            });
            response.setIaasVmImageIDs(infos);
        }
        return response;


    }
}
