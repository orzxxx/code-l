package test.boot.dao;

import static test.boot.entity.tables.Datasource.T_DATASOURCE;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.boot.entity.tables.pojos.Datasource;
import test.boot.entity.tables.records.DatasourceRecord;

@Component
public class DatasourceDao {
	
	@Autowired
	private DSLContext create;
	
	public List<Datasource> list() {
		return create.selectFrom(T_DATASOURCE)
				.orderBy(T_DATASOURCE.ID.desc())
				.fetchInto(Datasource.class);
	}

	public int save(DatasourceRecord record) {
		return create.insertInto(T_DATASOURCE)
				.set(record)
				.execute();
	}

	public int update(DatasourceRecord record) {
		return create.update(T_DATASOURCE)
				.set(T_DATASOURCE.NAME, record.getName())
				.set(T_DATASOURCE.URL, record.getUrl())
				.set(T_DATASOURCE.USERNAME, record.getUsername())
				.set(T_DATASOURCE.PASSWORD, record.getPassword())
				.where(T_DATASOURCE.ID.eq(record.getId()))
				.execute();
	}

	public int remove(int id) {
		return create.delete(T_DATASOURCE)
				.where(T_DATASOURCE.ID.eq(id))
				.execute();
	}

	public Datasource get(int id) {
		return create.selectFrom(T_DATASOURCE)
				.where(T_DATASOURCE.ID.eq(id))
				.fetchOneInto(Datasource.class);
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
