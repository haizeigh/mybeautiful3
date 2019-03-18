package com.company.service.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by v-leiyu on 2018/4/18.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override protected Object determineCurrentLookupKey() {
		return DataSourceHolder.getDataKey();
	}
}
