package test.boot;
import java.util.HashMap;
import java.util.Map;

import org.jooq.ExecuteContext;
import org.jooq.ExecuteType;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class Example {
   /* @Bean
    ExecuteListenerProvider LoggerListenerProvider() {
    	return new DefaultExecuteListenerProvider(new LoggerListener());
    }*/
   /* @Bean
    ExecuteListenerProvider stopWatchListenerProvider() {
    	return new DefaultExecuteListenerProvider(new StopWatchListener());
    }*/
    
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}

class StatisticsListener extends DefaultExecuteListener {
    public static Map<ExecuteType, Integer> STATISTICS = new HashMap<ExecuteType, Integer>();

    // Count "start" events for every type of query executed by jOOQ
    @Override
    public void end(ExecuteContext ctx) {
    	System.out.println(ctx.sql());
        System.out.println(ctx.rows());
    }
}