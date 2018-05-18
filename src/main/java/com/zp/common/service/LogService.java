package com.zp.common.service;

import org.springframework.stereotype.Service;

import com.zp.common.domain.LogDO;
import com.zp.common.domain.PageDO;
import com.zp.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
