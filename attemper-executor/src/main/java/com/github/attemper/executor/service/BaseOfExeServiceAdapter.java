package com.github.attemper.executor.service;

import com.github.attemper.common.constant.CommonConstants;

import java.util.HashMap;
import java.util.Map;

public class BaseOfExeServiceAdapter {

    protected Map<String, Object> toTenantIdMap(String tenantId) {
        Map<String, Object> map = new HashMap<>(4);
        map.put(CommonConstants.tenantId, tenantId);
        return map;
    }
}