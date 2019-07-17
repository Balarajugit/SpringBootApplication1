package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

@Configuration
public class HazelcastConfig {
	
	@Bean
	public Config cacheHazelCast() {
		return new Config()
				.setInstanceName("TemparyMemory-Cache")
				.addMapConfig(new MapConfig()
						.setName("Customer-Object")
						.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizePolicy.FREE_HEAP_SIZE))
						.setTimeToLiveSeconds(2000)
						.setEvictionPolicy(EvictionPolicy.LRU)
						
						);
	}

}
