package test.boot.dao;

import static test.boot.entity.tables.TemplateGroupTemplate.R_TEMPLATE_GROUP_TEMPLATE;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.boot.entity.tables.records.TemplateGroupTemplateRecord;

@Component
public class TemplateGroupTemplateDao {
	
	@Autowired
	private DSLContext create;

	public int save(TemplateGroupTemplateRecord record) {
		return create.insertInto(R_TEMPLATE_GROUP_TEMPLATE)
				.set(record)
				.execute();
	}
	
	public int save(List<TemplateGroupTemplateRecord> records) {
		return create.batchInsert(records)
				.execute().length;
	}
	
	public List<TemplateGroupTemplateRecord> listByTemplageGroupId(int tgId) {
		return create.selectFrom(R_TEMPLATE_GROUP_TEMPLATE)
				.orderBy(R_TEMPLATE_GROUP_TEMPLATE.ID.desc())
				.fetchInto(TemplateGroupTemplateRecord.class);
	}
	
	public int removeByTemplateGroupId(int tgId) {
		return create.delete(R_TEMPLATE_GROUP_TEMPLATE)
				.where(R_TEMPLATE_GROUP_TEMPLATE.TG_ID.eq(tgId))
				.execute();
	}
}
