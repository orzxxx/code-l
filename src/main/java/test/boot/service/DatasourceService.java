package test.boot.service;

import java.util.List;

import test.boot.entity.tables.pojos.Datasource;
import test.boot.entity.tables.records.DatasourceRecord;

public interface DatasourceService {

	List<Datasource> listDatasource();

	int saveDatasource(DatasourceRecord record);

	int updateDatasource(DatasourceRecord record);

	int removeDatasource(int id);

	Datasource getDatasource(int id);

}
