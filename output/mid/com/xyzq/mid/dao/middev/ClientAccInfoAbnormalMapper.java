package com.xyzq.mid.dao.middev;

import tk.mybatis.mapper.common.Mapper;

import com.xyzq.mid.entity.middev.ClientAccInfoAbnormal;
import java.util.List;

public interface ClientAccInfoAbnormalMapper extends Mapper<ClientAccInfoAbnormal> {

	void batchInsertForUpdate(List<ClientAccInfoAbnormal> records);
}