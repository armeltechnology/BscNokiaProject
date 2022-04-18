package ng.nokiaBSC.application.config;

import java.util.concurrent.Executor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.Data;


@Configuration
@EnableAsync
@ConfigurationProperties(prefix = "application.infothread")
@Data
public class AsyncConfig {
	
	private int poolSize;
	private int maxPoolSize;
	private int queueCapaciy;
	private String threadNamePrefix;
	
	
	@Bean(name = "taskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor= new ThreadPoolTaskExecutor();
		
		executor.setCorePoolSize(getPoolSize());
		executor.setMaxPoolSize(getMaxPoolSize());
		executor.setQueueCapacity(getQueueCapaciy());
		executor.setThreadNamePrefix(getThreadNamePrefix());
		executor.initialize();
		return executor;
	}

}
