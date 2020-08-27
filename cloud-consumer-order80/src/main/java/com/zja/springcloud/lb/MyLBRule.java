package com.zja.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLBRule {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
