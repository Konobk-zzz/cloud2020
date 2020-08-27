package com.zja.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RoundRibbonRule {

    @Bean
    public IRule getRoundRibbon(){
        return new RandomRule();
    }
}
