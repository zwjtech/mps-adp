package com.cloudcare.iaas.adp.biz.util;

import com.aliyuncs.AcsRequest;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.cloudcare.common.lang.Configs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author lulin
 * @date 2016/6/1.
 */
public class AliyunClient {
    private final static Logger LOGGER = LoggerFactory.getLogger(AliyunClient.class);

    private final static String DEFAULT_REGION = "cn-hangzhou";

    private static AliyunClient singleInstance;

    private AliyunClient() {
    }

    public synchronized static AliyunClient getInstance() {
        if (null == singleInstance) {
            singleInstance = new AliyunClient();
        }
        return singleInstance;
    }


    public <T extends AcsResponse> T process(AcsRequest<T> request) {
        String regionId = request.getRegionId();
        if (Objects.isNull(request.getRegionId())) {
            regionId = DEFAULT_REGION;
            request.setRegionId(regionId);
        }

        IClientProfile profile = DefaultProfile.getProfile(regionId, Configs.getString("aliyun.accessKeyId"), Configs.getString("aliyun.accessKeySecret"));
        IAcsClient client = new DefaultAcsClient(profile);

        request.setConnectTimeout(Configs.getInt("aliyun.request.connectionTimeout"));
        request.setReadTimeout(Configs.getInt("aliyun.request.readTimeout"));
        request.setContentType(FormatType.JSON);
        request.setAcceptFormat(FormatType.JSON);

        try {
            return client.getAcsResponse(request, true, 3);
        } catch (ClientException e) {
            e.printStackTrace();
//            LOGGER.error("Invoke aliyun sdk api error. " + ErrorMsgHelper.getChineseErrorMsg(request.getProduct(), e.getErrMsg()), e);
            throw new RuntimeException(e.getMessage(),e);
        } finally {
            LOGGER.debug("Invoke aliyun sdk api url is : [" + request.getUrl() + "]");
        }

    }

}
