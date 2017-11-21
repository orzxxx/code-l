package test.boot.dao;

import static test.boot.entity.tables.TDatasource.T_DATASOURCE;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.boot.entity.tables.pojos.TDatasource;
import test.boot.entity.tables.records.TDatasourceRecord;

@Component
public class DatasourceDao {
	
	@Autowired
	private DSLContext create;
	
	public List<TDatasource> list() {
		return create.selectFrom(T_DATASOURCE)
				.orderBy(T_DATASOURCE.ID.desc())
				.fetchInto(TDatasource.class);
	}

	public int save(TDatasourceRecord record) {
		return create.insertInto(T_DATASOURCE)
				.set(record)
				.execute();
	}

	public int update(TDatasourceRecord record) {
		return create.update(T_DATASOURCE)
				.set(record)
				.where(T_DATASOURCE.ID.eq(record.getId()))
				.execute();
	}

	public int delete(int id) {
		return create.delete(T_DATASOURCE)
				.where(T_DATASOURCE.ID.eq(id))
				.execute();
	}

	public TDatasource get(int id) {
		return create.selectFrom(T_DATASOURCE)
				.where(T_DATASOURCE.ID.eq(id))
				.fetchOneInto(TDatasource.class);
	}
	
	public int countByName(Integer id, String name) {
		Condition condition = DSL.trueCondition();
		condition = condition.and(T_DATASOURCE.NAME.eq(name));
		if (id != null) {
			condition = condition.and(T_DATASOURCE.ID.notEqual(id));
		}
		return create.selectCount()
				.from(T_DATASOURCE)
				.where(condition)
				.fetchOne(DSL.count());
	}
}
