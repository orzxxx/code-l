package test.boot.dao;

import static test.boot.entity.tables.TemplateGroup.T_TEMPLATE_GROUP;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.boot.entity.tables.pojos.TemplateGroup;
import test.boot.entity.tables.records.TemplateGroupRecord;

@Component
public class TemplateGroupDao {
	
	@Autowired
	private DSLContext create;
	
	public List<TemplateGroup> list() {
		return create.selectFrom(T_TEMPLATE_GROUP)
				.orderBy(T_TEMPLATE_GROUP.ID.desc())
				.fetchInto(TemplateGroup.class);
	}

	public int save(TemplateGroupRecord record) {
		TemplateGroupRecord result = 
				create.insertInto(T_TEMPLATE_GROUP)
				.set(T_TEMPLATE_GROUP.NAME, record.getName())
				.returning(T_TEMPLATE_GROUP.ID)
				.fetchOne();
		
		return result.getId();
	}

	public int update(TemplateGroupRecord record) {
		return create.update(T_TEMPLATE_GROUP)
				.set(record)
				.where(T_TEMPLATE_GROUP.ID.eq(record.getId()))
				.execute();
	}

	public int remove(int id) {
		return create.delete(T_TEMPLATE_GROUP)
				.where(T_TEMPLATE_GROUP.ID.eq(id))
				.execute();
	}

	public TemplateGroup get(int id) {
		return create.selectFrom(T_TEMPLATE_GROUP)
				.where(T_TEMPLATE_GROUP.ID.eq(id))
				.fetchOneInto(TemplateGroup.class);
	}
	
	public int countByName(Integer id, String name) {
		Condition condition = DSL.trueCondition();
		condition = condition.and(T_TEMPLATE_GROUP.NAME.eq(name));
		if (id != null) {
			condition = condition.and(T_TEMPLATE_GROUP.ID.notEqual(id));
		}
		return create.selectCount()
				.from(T_TEMPLATE_GROUP)
				.where(condition)
				.fetchOne(DSL.count());
	}
}