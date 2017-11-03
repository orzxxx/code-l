/*
 * This file is generated by jOOQ.
*/
package test.boot.entry.mysql.tables;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import test.boot.entry.mysql.Datasync;
import test.boot.entry.mysql.Keys;
import test.boot.entry.mysql.tables.records.TAccountProdInfoRecord;


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
public class TAccountProdInfo extends TableImpl<TAccountProdInfoRecord> {

    private static final long serialVersionUID = 1185295064;

    /**
     * The reference instance of <code>datasync.t_account_prod_info</code>
     */
    public static final TAccountProdInfo T_ACCOUNT_PROD_INFO = new TAccountProdInfo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TAccountProdInfoRecord> getRecordType() {
        return TAccountProdInfoRecord.class;
    }

    /**
     * The column <code>datasync.t_account_prod_info.FUND_ACCOUNT</code>. 资金账号
     */
    public final TableField<TAccountProdInfoRecord, String> FUND_ACCOUNT = createField("FUND_ACCOUNT", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "资金账号");

    /**
     * The column <code>datasync.t_account_prod_info.PROD_CODE</code>. 产品编码
     */
    public final TableField<TAccountProdInfoRecord, String> PROD_CODE = createField("PROD_CODE", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "产品编码");

    /**
     * The column <code>datasync.t_account_prod_info.ORG_ID</code>. 营业部ID
     */
    public final TableField<TAccountProdInfoRecord, String> ORG_ID = createField("ORG_ID", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.VARCHAR)), this, "营业部ID");

    /**
     * The column <code>datasync.t_account_prod_info.INTER_ASSET</code>. 体内资产
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> INTER_ASSET = createField("INTER_ASSET", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "体内资产");

    /**
     * The column <code>datasync.t_account_prod_info.OUTER_ASSET</code>. 体外资产
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> OUTER_ASSET = createField("OUTER_ASSET", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "体外资产");

    /**
     * The column <code>datasync.t_account_prod_info.TOTAL_ASSET</code>. 总资产
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> TOTAL_ASSET = createField("TOTAL_ASSET", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "总资产");

    /**
     * The column <code>datasync.t_account_prod_info.MATCH_RATIO</code>. 匹配度
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> MATCH_RATIO = createField("MATCH_RATIO", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "匹配度");

    /**
     * The column <code>datasync.t_account_prod_info.LAST_12_YIELD_RATIO</code>. 产品近12个月收益率
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> LAST_12_YIELD_RATIO = createField("LAST_12_YIELD_RATIO", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "产品近12个月收益率");

    /**
     * The column <code>datasync.t_account_prod_info.MIN_MARK</code>. 起投点分值
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> MIN_MARK = createField("MIN_MARK", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false), this, "起投点分值");

    /**
     * The column <code>datasync.t_account_prod_info.STRESS_MARK</code>. 推荐重点分值
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> STRESS_MARK = createField("STRESS_MARK", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false), this, "推荐重点分值");

    /**
     * The column <code>datasync.t_account_prod_info.HISTORY_MARK</code>. 同公司基金购买历史
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> HISTORY_MARK = createField("HISTORY_MARK", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "同公司基金购买历史");

    /**
     * The column <code>datasync.t_account_prod_info.HOLD_STATUS</code>. 持有状态
     */
    public final TableField<TAccountProdInfoRecord, Integer> HOLD_STATUS = createField("HOLD_STATUS", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "持有状态");

    /**
     * The column <code>datasync.t_account_prod_info.BUY_ABLE</code>. 购买产品可能性分值
     */
    public final TableField<TAccountProdInfoRecord, BigDecimal> BUY_ABLE = createField("BUY_ABLE", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false), this, "购买产品可能性分值");

    /**
     * The column <code>datasync.t_account_prod_info.UPDATE_TIME</code>. 更新时间
     */
    public final TableField<TAccountProdInfoRecord, Timestamp> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "更新时间");

    /**
     * Create a <code>datasync.t_account_prod_info</code> table reference
     */
    public TAccountProdInfo() {
        this("t_account_prod_info", null);
    }

    /**
     * Create an aliased <code>datasync.t_account_prod_info</code> table reference
     */
    public TAccountProdInfo(String alias) {
        this(alias, T_ACCOUNT_PROD_INFO);
    }

    private TAccountProdInfo(String alias, Table<TAccountProdInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private TAccountProdInfo(String alias, Table<TAccountProdInfoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Datasync.DATASYNC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TAccountProdInfoRecord> getPrimaryKey() {
        return Keys.KEY_T_ACCOUNT_PROD_INFO_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TAccountProdInfoRecord>> getKeys() {
        return Arrays.<UniqueKey<TAccountProdInfoRecord>>asList(Keys.KEY_T_ACCOUNT_PROD_INFO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfo as(String alias) {
        return new TAccountProdInfo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TAccountProdInfo rename(String name) {
        return new TAccountProdInfo(name, null);
    }
}