package com.zja.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLBRuleImpl implements MyLBRule{
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }

    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current+1;
        }while (!atomicInteger.compareAndSet(current,next));
        return next;
    }
}
