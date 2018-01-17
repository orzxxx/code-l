package test.boot.service;

import java.util.List;

import test.boot.dto.DatasourceDTO;

public interface DatasourceService {

	List<DatasourceDTO> listDatasource();

	int saveDatasource(DatasourceDTO record);

	int updateDatasource(DatasourceDTO record);

	int removeDatasource(int id);

	DatasourceDTO getDatasource(int id);

}
