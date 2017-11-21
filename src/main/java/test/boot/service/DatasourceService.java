package test.boot.service;

import java.util.List;

import test.boot.entity.tables.pojos.TDatasource;
import test.boot.entity.tables.records.TDatasourceRecord;

public interface DatasourceService {

	List<TDatasource> listDatasource();

	int saveDatasource(TDatasourceRecord record);

	int updateDatasource(TDatasourceRecord record);

	int removeDatasource(int id);

	TDatasource getDatasource(int id);

}
