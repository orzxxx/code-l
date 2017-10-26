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
import org.jooq.types.UInteger;

import test.boot.entry.mysql.Datasync;
import test.boot.entry.mysql.Keys;
import test.boot.entry.mysql.tables.records.TProdAccountInfoRecord;


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
public class TProdAccountInfo extends TableImpl<TProdAccountInfoRecord> {

    private static final long serialVersionUID = 1533991031;

    /**
     * The reference instance of <code>datasync.t_prod_account_info</code>
     */
    public static final TProdAccountInfo T_PROD_ACCOUNT_INFO = new TProdAccountInfo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TProdAccountInfoRecord> getRecordType() {
        return TProdAccountInfoRecord.class;
    }

    /**
     * The column <code>datasync.t_prod_account_info.PROD_CODE</code>. 产品编号
     */
    public final TableField<TProdAccountInfoRecord, String> PROD_CODE = createField("PROD_CODE", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "产品编号");

    /**
     * The column <code>datasync.t_prod_account_info.FUND_ACCOUNT</code>. 资金账号
     */
    public final TableField<TProdAccountInfoRecord, String> FUND_ACCOUNT = createField("FUND_ACCOUNT", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "资金账号");

    /**
     * The column <code>datasync.t_prod_account_info.MATCH_RATIO</code>. 匹配度
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> MATCH_RATIO = createField("MATCH_RATIO", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "匹配度");

    /**
     * The column <code>datasync.t_prod_account_info.INTER_ASSET</code>. 体内资产
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> INTER_ASSET = createField("INTER_ASSET", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "体内资产");

    /**
     * The column <code>datasync.t_prod_account_info.OUTER_ASSET</code>. 体外资产
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> OUTER_ASSET = createField("OUTER_ASSET", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "体外资产");

    /**
     * The column <code>datasync.t_prod_account_info.TOTAL_ASSET</code>. 总资产
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> TOTAL_ASSET = createField("TOTAL_ASSET", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "总资产");

    /**
     * The column <code>datasync.t_prod_account_info.TOTAL_ASSET_MARK</code>. 总资产分值
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> TOTAL_ASSET_MARK = createField("TOTAL_ASSET_MARK", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "总资产分值");

    /**
     * The column <code>datasync.t_prod_account_info.EXPIRE_ASSET</code>. 到期资产资产
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> EXPIRE_ASSET = createField("EXPIRE_ASSET", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "到期资产资产");

    /**
     * The column <code>datasync.t_prod_account_info.EXPIRE_ASSET_MARK</code>. 到期资产分值
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> EXPIRE_ASSET_MARK = createField("EXPIRE_ASSET_MARK", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "到期资产分值");

    /**
     * The column <code>datasync.t_prod_account_info.HISTORY_MARK</code>. 同公司基金购买历史
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> HISTORY_MARK = createField("HISTORY_MARK", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "同公司基金购买历史");

    /**
     * The column <code>datasync.t_prod_account_info.LAST_12_YIELD_RATIO</code>. 近12个月客户收益率
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> LAST_12_YIELD_RATIO = createField("LAST_12_YIELD_RATIO", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "近12个月客户收益率");

    /**
     * The column <code>datasync.t_prod_account_info.YIELD_MARK</code>. 收益率分值
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> YIELD_MARK = createField("YIELD_MARK", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "收益率分值");

    /**
     * The column <code>datasync.t_prod_account_info.STOCK_TURN_RATIO</code>. 股票周转率
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> STOCK_TURN_RATIO = createField("STOCK_TURN_RATIO", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "股票周转率");

    /**
     * The column <code>datasync.t_prod_account_info.STOCK_TURN_RATIO_MARK</code>. 股票周转率分值
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> STOCK_TURN_RATIO_MARK = createField("STOCK_TURN_RATIO_MARK", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "股票周转率分值");

    /**
     * The column <code>datasync.t_prod_account_info.BUY_ABLE</code>. 购买可能性
     */
    public final TableField<TProdAccountInfoRecord, BigDecimal> BUY_ABLE = createField("BUY_ABLE", org.jooq.impl.SQLDataType.DECIMAL.precision(20, 2).nullable(false), this, "购买可能性");

    /**
     * The column <code>datasync.t_prod_account_info.UPDATE_TIME</code>. 更新时间
     */
    public final TableField<TProdAccountInfoRecord, Timestamp> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "更新时间");

    /**
     * The column <code>datasync.t_prod_account_info.ORG_ID</code>. 营业部编号
     */
    public final TableField<TProdAccountInfoRecord, String> ORG_ID = createField("ORG_ID", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "营业部编号");

    /**
     * The column <code>datasync.t_prod_account_info.HOLD_STATUS</code>. 持有状态
     */
    public final TableField<TProdAccountInfoRecord, UInteger> HOLD_STATUS = createField("HOLD_STATUS", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "持有状态");

    /**
     * Create a <code>datasync.t_prod_account_info</code> table reference
     */
    public TProdAccountInfo() {
        this("t_prod_account_info", null);
    }

    /**
     * Create an aliased <code>datasync.t_prod_account_info</code> table reference
     */
    public TProdAccountInfo(String alias) {
        this(alias, T_PROD_ACCOUNT_INFO);
    }

    private TProdAccountInfo(String alias, Table<TProdAccountInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private TProdAccountInfo(String alias, Table<TProdAccountInfoRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<TProdAccountInfoRecord> getPrimaryKey() {
        return Keys.KEY_T_PROD_ACCOUNT_INFO_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TProdAccountInfoRecord>> getKeys() {
        return Arrays.<UniqueKey<TProdAccountInfoRecord>>asList(Keys.KEY_T_PROD_ACCOUNT_INFO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TProdAccountInfo as(String alias) {
        return new TProdAccountInfo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TProdAccountInfo rename(String name) {
        return new TProdAccountInfo(name, null);
    }
}
