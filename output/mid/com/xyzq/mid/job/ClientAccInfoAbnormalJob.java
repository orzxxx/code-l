package com.xyzq.mid.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.xyzq.mid.dao.middev.ClientAccInfoAbnormallMapper;
import com.xyzq.mid.entity.middev.ClientAccInfoAbnormal;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * 
 */
public class ClientAccInfoAbnormalJob implements SimpleJob {

    private static Logger logger = LoggerFactory.getLogger(ClientAccInfoAbnormalJob.class);

    @Autowired
    private ClientAccInfoAbnormalMapper clientaccinfoabnormalMapper;
    
    @Override
    public void execute(ShardingContext shardingContext) {
    	ThreadContext.put("serialNumber", UUID.randomUUID().toString());
    	ThreadContext.put("kv", "item=" + shardingContext.getShardingItem());
    	ThreadContext.put("jobName", "ClientAccInfoAbnormalJob");
      logger.info("[ClientAccInfoAbnormalJob]开始");
      ClientAccInfoAbnormal result = new ClientAccInfoAbnormal();
		result.setClientId(entry.getClientId());
      logger.info("[ClientAccInfoAbnormalJob]结束");
    }

}