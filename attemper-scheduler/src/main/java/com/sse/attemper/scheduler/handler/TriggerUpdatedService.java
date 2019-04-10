package com.sse.attemper.scheduler.handler;

import com.sse.attemper.common.param.scheduler.TriggerChangedParam;
import com.sse.attemper.scheduler.ext.trigger.TriggerHandlerInMemory;
import com.sse.attemper.sys.service.BaseServiceAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * update job or trigger in scheduler
 */
@Service
public class TriggerUpdatedService extends BaseServiceAdapter {

    private TriggerHandlerInMemory triggerHandler = new TriggerHandlerInMemory();

    public Void updateTrigger(TriggerChangedParam param) {
        String jobName = param.getJobName();
        String tenantId = injectAdminedTenant().getId();
        List<String> oldTriggerNames = param.getOldTriggerNames();
        triggerHandler.unscheduleTriggers(tenantId, oldTriggerNames);
        triggerHandler.schedule(jobName, tenantId);
        return null;
    }
}