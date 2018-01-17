package test.boot.service;

import java.util.List;

import test.boot.model.table.SchemaInfo;

public interface DatabaseService {

	List<SchemaInfo> listSchemaByDatasourceId(int dId) throws Exception;
	
}
