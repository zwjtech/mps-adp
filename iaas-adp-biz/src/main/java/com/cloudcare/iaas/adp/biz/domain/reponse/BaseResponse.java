package com.cloudcare.iaas.adp.biz.domain.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by wangxiaosan on 17/5/10.
 */
public class BaseResponse implements Serializable {

    @JsonProperty("request_execute_status")
    private int requestExecuteStatus;

    @JsonProperty("error_description")
    private String errorDescription;

    public BaseResponse(){
        this.requestExecuteStatus=1;
        this.errorDescription="";
    }


    public int getRequestExecuteStatus() {
        return requestExecuteStatus;
    }

    public void setRequestExecuteStatus(int requestExecuteStatus) {
        this.requestExecuteStatus = requestExecuteStatus;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "requestExecuteStatus=" + requestExecuteStatus +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
