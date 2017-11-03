/*
 * This file is generated by jOOQ.
*/
package test.boot.entry.mysql.tables.records;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.TableRecordImpl;

import test.boot.entry.mysql.tables.TTopxStockinfo;


/**
 * topx股票信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TTopxStockinfoRecord extends TableRecordImpl<TTopxStockinfoRecord> implements Record18<Timestamp, Short, String, Date, String, String, BigDecimal, String, String, String, String, String, String, String, String, Integer, Integer, Timestamp> {

    private static final long serialVersionUID = 1737047957;

    /**
     * Setter for <code>datasync.t_topx_stockinfo.release_time</code>. 发布时间
     */
    public void setReleaseTime(Timestamp value) {
        set(0, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.release_time</code>. 发布时间
     */
    public Timestamp getReleaseTime() {
        return (Timestamp) get(0);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.type</code>. topx类型（1：上涨概率最大的股票）
     */
    public void setType(Short value) {
        set(1, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.type</code>. topx类型（1：上涨概率最大的股票）
     */
    public Short getType() {
        return (Short) get(1);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.sub_type</code>. 子类别（0，全市场，其他值具体行业）
     */
    public void setSubType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.sub_type</code>. 子类别（0，全市场，其他值具体行业）
     */
    public String getSubType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.trade_date</code>. 交易日期
     */
    public void setTradeDate(Date value) {
        set(3, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.trade_date</code>. 交易日期
     */
    public Date getTradeDate() {
        return (Date) get(3);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.stock_code</code>. 股票代码
     */
    public void setStockCode(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.stock_code</code>. 股票代码
     */
    public String getStockCode() {
        return (String) get(4);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.stock_name</code>. 股票名称
     */
    public void setStockName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.stock_name</code>. 股票名称
     */
    public String getStockName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.stock_price</code>. 股票价格
     */
    public void setStockPrice(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.stock_price</code>. 股票价格
     */
    public BigDecimal getStockPrice() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.growth_rate</code>. 涨跌幅
     */
    public void setGrowthRate(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.growth_rate</code>. 涨跌幅
     */
    public String getGrowthRate() {
        return (String) get(7);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.market_value</code>. 股票市值
     */
    public void setMarketValue(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.market_value</code>. 股票市值
     */
    public String getMarketValue() {
        return (String) get(8);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.rise_chance</code>. 上涨概率
     */
    public void setRiseChance(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.rise_chance</code>. 上涨概率
     */
    public String getRiseChance() {
        return (String) get(9);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.industry</code>. 所属行业
     */
    public void setIndustry(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.industry</code>. 所属行业
     */
    public String getIndustry() {
        return (String) get(10);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.ext_param</code>. 扩展字段（保留）
     */
    public void setExtParam(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.ext_param</code>. 扩展字段（保留）
     */
    public String getExtParam() {
        return (String) get(11);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.trunover_rate</code>. 换手率
     */
    public void setTrunoverRate(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.trunover_rate</code>. 换手率
     */
    public String getTrunoverRate() {
        return (String) get(12);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.growth</code>.
     */
    public void setGrowth(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.growth</code>.
     */
    public String getGrowth() {
        return (String) get(13);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.avg_ratio</code>.
     */
    public void setAvgRatio(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.avg_ratio</code>.
     */
    public String getAvgRatio() {
        return (String) get(14);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.similar_up</code>. 相似上涨股票数
     */
    public void setSimilarUp(Integer value) {
        set(15, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.similar_up</code>. 相似上涨股票数
     */
    public Integer getSimilarUp() {
        return (Integer) get(15);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.similar_down</code>. 相似下跌股票数
     */
    public void setSimilarDown(Integer value) {
        set(16, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.similar_down</code>. 相似下跌股票数
     */
    public Integer getSimilarDown() {
        return (Integer) get(16);
    }

    /**
     * Setter for <code>datasync.t_topx_stockinfo.update_time</code>. 更新时间
     */
    public void setUpdateTime(Timestamp value) {
        set(17, value);
    }

    /**
     * Getter for <code>datasync.t_topx_stockinfo.update_time</code>. 更新时间
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(17);
    }

    // -------------------------------------------------------------------------
    // Record18 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Timestamp, Short, String, Date, String, String, BigDecimal, String, String, String, String, String, String, String, String, Integer, Integer, Timestamp> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Timestamp, Short, String, Date, String, String, BigDecimal, String, String, String, String, String, String, String, String, Integer, Integer, Timestamp> valuesRow() {
        return (Row18) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field1() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.RELEASE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field2() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.SUB_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field4() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.TRADE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.STOCK_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.STOCK_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field7() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.STOCK_PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.GROWTH_RATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.MARKET_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.RISE_CHANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.INDUSTRY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.EXT_PARAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.TRUNOVER_RATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.GROWTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.AVG_RATIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field16() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.SIMILAR_UP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field17() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.SIMILAR_DOWN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field18() {
        return TTopxStockinfo.T_TOPX_STOCKINFO.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value1() {
        return getReleaseTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value2() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSubType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value4() {
        return getTradeDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getStockCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getStockName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value7() {
        return getStockPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getGrowthRate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getMarketValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getRiseChance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getIndustry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getExtParam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getTrunoverRate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getGrowth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getAvgRatio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value16() {
        return getSimilarUp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value17() {
        return getSimilarDown();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value18() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value1(Timestamp value) {
        setReleaseTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value2(Short value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value3(String value) {
        setSubType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value4(Date value) {
        setTradeDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value5(String value) {
        setStockCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value6(String value) {
        setStockName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value7(BigDecimal value) {
        setStockPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value8(String value) {
        setGrowthRate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value9(String value) {
        setMarketValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value10(String value) {
        setRiseChance(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value11(String value) {
        setIndustry(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value12(String value) {
        setExtParam(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value13(String value) {
        setTrunoverRate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value14(String value) {
        setGrowth(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value15(String value) {
        setAvgRatio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value16(Integer value) {
        setSimilarUp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value17(Integer value) {
        setSimilarDown(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord value18(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopxStockinfoRecord values(Timestamp value1, Short value2, String value3, Date value4, String value5, String value6, BigDecimal value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15, Integer value16, Integer value17, Timestamp value18) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TTopxStockinfoRecord
     */
    public TTopxStockinfoRecord() {
        super(TTopxStockinfo.T_TOPX_STOCKINFO);
    }

    /**
     * Create a detached, initialised TTopxStockinfoRecord
     */
    public TTopxStockinfoRecord(Timestamp releaseTime, Short type, String subType, Date tradeDate, String stockCode, String stockName, BigDecimal stockPrice, String growthRate, String marketValue, String riseChance, String industry, String extParam, String trunoverRate, String growth, String avgRatio, Integer similarUp, Integer similarDown, Timestamp updateTime) {
        super(TTopxStockinfo.T_TOPX_STOCKINFO);

        set(0, releaseTime);
        set(1, type);
        set(2, subType);
        set(3, tradeDate);
        set(4, stockCode);
        set(5, stockName);
        set(6, stockPrice);
        set(7, growthRate);
        set(8, marketValue);
        set(9, riseChance);
        set(10, industry);
        set(11, extParam);
        set(12, trunoverRate);
        set(13, growth);
        set(14, avgRatio);
        set(15, similarUp);
        set(16, similarDown);
        set(17, updateTime);
    }
}