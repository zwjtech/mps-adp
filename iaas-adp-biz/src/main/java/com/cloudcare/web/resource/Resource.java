package com.cloudcare.web.resource;

import com.cloudcare.web.api.ActionResponse;
import com.cloudcare.web.api.support.SimpleActionRequest;
import com.cloudcare.web.container.ApiService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 17/5/10.
 */
@Controller
@Path("/{version}")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
    @Autowired
    ApiService apiService;

    @Context
    HttpServletRequest servletRequest;

    @Context
    HttpServletResponse servletResponse;

    @POST
    @Path("/{module:\\w*[/?\\w*]*}/{action}")
    @Consumes
    public Response createVolume(@PathParam("version") String version,@PathParam("module") String module,@PathParam("action") String action, String param) {
        Map<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("param", param);
        SimpleActionRequest actionRequest = new SimpleActionRequest();
        actionRequest.setContent(hashMap);
        ActionResponse execute = apiService.execute(module.replace("/","-")+"@"+action+"|"+version, actionRequest);
        return Response.ok().entity(execute.getContent()).build();
    }

    @GET
    @Path("/{module:\\w*[/?\\w*]*}/{action}")
    public Response doGet(@PathParam("version") String version,@PathParam("module") String module,@PathParam("action") String action) {
        SimpleActionRequest actionRequest = new SimpleActionRequest();
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        if(nonNull(parameterMap) && !parameterMap.isEmpty()) {
            Map<String, Object> hashMap = Maps.newHashMap();
            hashMap.putAll(parameterMap);
            actionRequest.setContent(hashMap);
        }
        ActionResponse execute = apiService.execute(module.replace("/","-")+"@"+action+"|"+version, actionRequest);
        return Response.ok().entity(execute.getContent()).build();
    }
}
