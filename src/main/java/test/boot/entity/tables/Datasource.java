/*
 * This file is generated by jOOQ.
*/
package test.boot.entity.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import test.boot.entity.Keys;
import test.boot.entity.Public;
import test.boot.entity.tables.records.DatasourceRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Datasource extends TableImpl<DatasourceRecord> {

    private static final long serialVersionUID = 215834089;

    /**
     * The reference instance of <code>PUBLIC.T_DATASOURCE</code>
     */
    public static final Datasource T_DATASOURCE = new Datasource();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DatasourceRecord> getRecordType() {
        return DatasourceRecord.class;
    }

    /**
     * The column <code>PUBLIC.T_DATASOURCE.ID</code>.
     */
    public final TableField<DatasourceRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("(NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_EAEC937E_F281_407C_92EF_D2648F19A07C)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>PUBLIC.T_DATASOURCE.URL</code>.
     */
    public final TableField<DatasourceRecord, String> URL = createField("URL", org.jooq.impl.SQLDataType.VARCHAR.length(64), this, "");

    /**
     * The column <code>PUBLIC.T_DATASOURCE.USERNAME</code>.
     */
    public final TableField<DatasourceRecord, String> USERNAME = createField("USERNAME", org.jooq.impl.SQLDataType.VARCHAR.length(32), this, "");

    /**
     * The column <code>PUBLIC.T_DATASOURCE.PASSWORD</code>.
     */
    public final TableField<DatasourceRecord, String> PASSWORD = createField("PASSWORD", org.jooq.impl.SQLDataType.VARCHAR.length(32), this, "");

    /**
     * The column <code>PUBLIC.T_DATASOURCE.NAME</code>.
     */
    public final TableField<DatasourceRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(64), this, "");

    /**
     * Create a <code>PUBLIC.T_DATASOURCE</code> table reference
     */
    public Datasource() {
        this("T_DATASOURCE", null);
    }

    /**
     * Create an aliased <code>PUBLIC.T_DATASOURCE</code> table reference
     */
    public Datasource(String alias) {
        this(alias, T_DATASOURCE);
    }

    private Datasource(String alias, Table<DatasourceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Datasource(String alias, Table<DatasourceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<DatasourceRecord, Integer> getIdentity() {
        return Keys.IDENTITY_T_DATASOURCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DatasourceRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_6;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DatasourceRecord>> getKeys() {
        return Arrays.<UniqueKey<DatasourceRecord>>asList(Keys.CONSTRAINT_6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Datasource as(String alias) {
        return new Datasource(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Datasource rename(String name) {
        return new Datasource(name, null);
    }
}