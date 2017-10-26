/*
 * This file is generated by jOOQ.
*/
package test.boot.entry.mysql.tables;


import java.sql.Date;
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
import test.boot.entry.mysql.tables.records.TStockmarketInfoRecord;


/**
 * 股票市场信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TStockmarketInfo extends TableImpl<TStockmarketInfoRecord> {

    private static final long serialVersionUID = -120293519;

    /**
     * The reference instance of <code>datasync.t_stockmarket_info</code>
     */
    public static final TStockmarketInfo T_STOCKMARKET_INFO = new TStockmarketInfo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TStockmarketInfoRecord> getRecordType() {
        return TStockmarketInfoRecord.class;
    }

    /**
     * The column <code>datasync.t_stockmarket_info.release_time</code>. 发布时间
     */
    public final TableField<TStockmarketInfoRecord, Timestamp> RELEASE_TIME = createField("release_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "发布时间");

    /**
     * The column <code>datasync.t_stockmarket_info.trade_date</code>. 交易日期
     */
    public final TableField<TStockmarketInfoRecord, Date> TRADE_DATE = createField("trade_date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "交易日期");

    /**
     * The column <code>datasync.t_stockmarket_info.ratio_sh</code>. 上证涨幅
     */
    public final TableField<TStockmarketInfoRecord, String> RATIO_SH = createField("ratio_sh", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this, "上证涨幅");

    /**
     * The column <code>datasync.t_stockmarket_info.ratio_sz</code>. 深圳涨幅
     */
    public final TableField<TStockmarketInfoRecord, String> RATIO_SZ = createField("ratio_sz", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this, "深圳涨幅");

    /**
     * The column <code>datasync.t_stockmarket_info.ratio_sy</code>. 创业板涨幅
     */
    public final TableField<TStockmarketInfoRecord, String> RATIO_SY = createField("ratio_sy", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this, "创业板涨幅");

    /**
     * The column <code>datasync.t_stockmarket_info.total_up</code>. 上涨股票数
     */
    public final TableField<TStockmarketInfoRecord, Integer> TOTAL_UP = createField("total_up", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "上涨股票数");

    /**
     * The column <code>datasync.t_stockmarket_info.total_down</code>. 下跌股票数
     */
    public final TableField<TStockmarketInfoRecord, Integer> TOTAL_DOWN = createField("total_down", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "下跌股票数");

    /**
     * The column <code>datasync.t_stockmarket_info.comment</code>. 点评
     */
    public final TableField<TStockmarketInfoRecord, String> COMMENT = createField("comment", org.jooq.impl.SQLDataType.CLOB, this, "点评");

    /**
     * The column <code>datasync.t_stockmarket_info.remark</code>. 备注
     */
    public final TableField<TStockmarketInfoRecord, String> REMARK = createField("remark", org.jooq.impl.SQLDataType.CLOB, this, "备注");

    /**
     * Create a <code>datasync.t_stockmarket_info</code> table reference
     */
    public TStockmarketInfo() {
        this("t_stockmarket_info", null);
    }

    /**
     * Create an aliased <code>datasync.t_stockmarket_info</code> table reference
     */
    public TStockmarketInfo(String alias) {
        this(alias, T_STOCKMARKET_INFO);
    }

    private TStockmarketInfo(String alias, Table<TStockmarketInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private TStockmarketInfo(String alias, Table<TStockmarketInfoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "股票市场信息");
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
    public UniqueKey<TStockmarketInfoRecord> getPrimaryKey() {
        return Keys.KEY_T_STOCKMARKET_INFO_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TStockmarketInfoRecord>> getKeys() {
        return Arrays.<UniqueKey<TStockmarketInfoRecord>>asList(Keys.KEY_T_STOCKMARKET_INFO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TStockmarketInfo as(String alias) {
        return new TStockmarketInfo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TStockmarketInfo rename(String name) {
        return new TStockmarketInfo(name, null);
    }
}
