package test.boot.dao;

import static test.boot.entity.tables.Template.T_TEMPLATE;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.boot.entity.tables.pojos.Template;
import test.boot.entity.tables.records.TemplateRecord;

@Component
public class TemplateDao {
	
	@Autowired
	private DSLContext create;
	
	public List<Template> list() {
		return create.selectFrom(T_TEMPLATE)
				.orderBy(T_TEMPLATE.ID.desc())
				.fetchInto(Template.class);
	}

	public int save(TemplateRecord record) {
		return create.insertInto(T_TEMPLATE)
				.set(record)
				.execute();
	}

	public int update(TemplateRecord record) {
		return create.update(T_TEMPLATE)
				.set(record)
				.where(T_TEMPLATE.ID.eq(record.getId()))
				.execute();
	}

	public int delete(int id) {
		return create.delete(T_TEMPLATE)
				.where(T_TEMPLATE.ID.eq(id))
				.execute();
	}

	public Template get(int id) {
		return create.selectFrom(T_TEMPLATE)
				.where(T_TEMPLATE.ID.eq(id))
				.fetchOneInto(Template.class);
	}
	
	public int countByName(Integer id, String name) {
		Condition condition = DSL.trueCondition();
		condition = condition.and(T_TEMPLATE.NAME.eq(name));
		if (id != null) {
			condition = condition.and(T_TEMPLATE.ID.notEqual(id));
		}
		return create.selectCount()
				.from(T_TEMPLATE)
				.where(condition)
				.fetchOne(DSL.count());
	}
}
