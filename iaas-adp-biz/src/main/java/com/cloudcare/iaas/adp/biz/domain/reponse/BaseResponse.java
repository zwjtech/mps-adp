package com.cloudcare.iaas.adp.biz.domain.reponse;

import java.io.Serializable;

/**
 * Created by wangxiaosan on 17/5/10.
 */
public class BaseResponse implements Serializable {
    private int request_execute_status;
    private String error_description;

    public int getRequest_execute_status() {
        return request_execute_status;
    }

    public void setRequest_execute_status(int request_execute_status) {
        this.request_execute_status = request_execute_status;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "request_execute_status=" + request_execute_status +
                ", error_description='" + error_description + '\'' +
                '}';
    }
}
