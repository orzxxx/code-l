/*package test.boot.dao;

import static test.boot.entry.mysql.tables.TProdInfo.T_PROD_INFO;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.boot.entry.mysql.tables.pojos.TProdInfo;
import test.boot.entry.mysql.tables.records.TProdInfoRecord;

@Component
public class TProdInfoDao {
	@Autowired
	private DSLContext create;
	
	public List<TProdInfo> list() {
		return create.selectFrom(T_PROD_INFO)
				.fetchInto(TProdInfo.class);
	}
	
	public TProdInfo get(String id) {
		return create.selectFrom(T_PROD_INFO)
				.where(T_PROD_INFO.PROD_CODE.eq(id))
				.fetchOneInto(TProdInfo.class);
	}
	
	public List<TProdInfo> page(int offset, int limit) {
		return create.selectFrom(T_PROD_INFO)
				.limit(offset, limit)
				.fetchInto(TProdInfo.class);
	}
	
	public int save(TProdInfoRecord record) {
		return create.insertInto(T_PROD_INFO)
				.set(record)
				//.onDuplicateKeyUpdate()
				//.set(record)
				.execute();
	}
	
	public int save(List<TProdInfoRecord> records) {
		return create.batchInsert(records)
				.execute().length;
	}
	
	public int save(List<TProdInfoRecord> records) {
		Query[] queries = records
				.stream()
				.map(r -> create.insertInto(T_PROD_INFO)
						.set(r)
						.onDuplicateKeyUpdate()
						.set(r))
				.toArray(Query[]::new);
				
		return create.batch(queries)
				.execute().length;
	}
	
	public int update(TProdInfoRecord record) {
		return create.update(T_PROD_INFO)
				.set(record)
				.where(T_PROD_INFO.PROD_CODE.eq(record.getProdCode()))
				.execute();
	}
	
	public int remove(Object id) {
		return create.delete(T_PROD_INFO)
				.where(T_PROD_INFO.PROD_CODE.eq(id + ""))
				.execute();
	}
}
*/