/*
 * This file is generated by jOOQ.
*/
package test.boot.entry.mysql.tables.records;


import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record14;
import org.jooq.Record2;
import org.jooq.Row14;
import org.jooq.impl.UpdatableRecordImpl;

import test.boot.entry.mysql.tables.TAccountProdInfo;


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
public class TAccountProdInfoRecord extends UpdatableRecordImpl<TAccountProdInfoRecord> implements Record14<String, String, String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, Integer, BigDecimal, Timestamp> {

    private static final long serialVersionUID = -411034726;

    /**
     * Setter for <code>datasync.t_account_prod_info.FUND_ACCOUNT</code>. 资金账号
     */
    public void setFundAccount(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.FUND_ACCOUNT</code>. 资金账号
     */
    public String getFundAccount() {
        return (String) get(0);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.PROD_CODE</code>. 产品编码
     */
    public void setProdCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.PROD_CODE</code>. 产品编码
     */
    public String getProdCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.ORG_ID</code>. 营业部ID
     */
    public void setOrgId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.ORG_ID</code>. 营业部ID
     */
    public String getOrgId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.INTER_ASSET</code>. 体内资产
     */
    public void setInterAsset(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.INTER_ASSET</code>. 体内资产
     */
    public BigDecimal getInterAsset() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.OUTER_ASSET</code>. 体外资产
     */
    public void setOuterAsset(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.OUTER_ASSET</code>. 体外资产
     */
    public BigDecimal getOuterAsset() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.TOTAL_ASSET</code>. 总资产
     */
    public void setTotalAsset(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.TOTAL_ASSET</code>. 总资产
     */
    public BigDecimal getTotalAsset() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.MATCH_RATIO</code>. 匹配度
     */
    public void setMatchRatio(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.MATCH_RATIO</code>. 匹配度
     */
    public BigDecimal getMatchRatio() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.LAST_12_YIELD_RATIO</code>. 产品近12个月收益率
     */
    public void setLast_12YieldRatio(BigDecimal value) {
        set(7, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.LAST_12_YIELD_RATIO</code>. 产品近12个月收益率
     */
    public BigDecimal getLast_12YieldRatio() {
        return (BigDecimal) get(7);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.MIN_MARK</code>. 起投点分值
     */
    public void setMinMark(BigDecimal value) {
        set(8, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.MIN_MARK</code>. 起投点分值
     */
    public BigDecimal getMinMark() {
        return (BigDecimal) get(8);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.STRESS_MARK</code>. 推荐重点分值
     */
    public void setStressMark(BigDecimal value) {
        set(9, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.STRESS_MARK</code>. 推荐重点分值
     */
    public BigDecimal getStressMark() {
        return (BigDecimal) get(9);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.HISTORY_MARK</code>. 同公司基金购买历史
     */
    public void setHistoryMark(BigDecimal value) {
        set(10, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.HISTORY_MARK</code>. 同公司基金购买历史
     */
    public BigDecimal getHistoryMark() {
        return (BigDecimal) get(10);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.HOLD_STATUS</code>. 持有状态
     */
    public void setHoldStatus(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.HOLD_STATUS</code>. 持有状态
     */
    public Integer getHoldStatus() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.BUY_ABLE</code>. 购买产品可能性分值
     */
    public void setBuyAble(BigDecimal value) {
        set(12, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.BUY_ABLE</code>. 购买产品可能性分值
     */
    public BigDecimal getBuyAble() {
        return (BigDecimal) get(12);
    }

    /**
     * Setter for <code>datasync.t_account_prod_info.UPDATE_TIME</code>. 更新时间
     */
    public void setUpdateTime(Timestamp value) {
        set(13, value);
    }

    /**
     * Getter for <code>datasync.t_account_prod_info.UPDATE_TIME</code>. 更新时间
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(13);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, String, String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, Integer, BigDecimal, Timestamp> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, String, String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, BigDecimal, Integer, BigDecimal, Timestamp> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.FUND_ACCOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.PROD_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.ORG_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field4() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.INTER_ASSET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field5() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.OUTER_ASSET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field6() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.TOTAL_ASSET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field7() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.MATCH_RATIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field8() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.LAST_12_YIELD_RATIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field9() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.MIN_MARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field10() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.STRESS_MARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field11() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.HISTORY_MARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.HOLD_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field13() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.BUY_ABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field14() {
        return TAccountProdInfo.T_ACCOUNT_PROD_INFO.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getFundAccount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getProdCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getOrgId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value4() {
        return getInterAsset();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value5() {
        return getOuterAsset();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value6() {
        return getTotalAsset();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value7() {
        return getMatchRatio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value8() {
        return getLast_12YieldRatio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value9() {
        return getMinMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value10() {
        return getStressMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value11() {
        return getHistoryMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getHoldStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value13() {
        return getBuyAble();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value14() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value1(String value) {
        setFundAccount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value2(String value) {
        setProdCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value3(String value) {
        setOrgId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value4(BigDecimal value) {
        setInterAsset(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value5(BigDecimal value) {
        setOuterAsset(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value6(BigDecimal value) {
        setTotalAsset(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value7(BigDecimal value) {
        setMatchRatio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value8(BigDecimal value) {
        setLast_12YieldRatio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value9(BigDecimal value) {
        setMinMark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value10(BigDecimal value) {
        setStressMark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value11(BigDecimal value) {
        setHistoryMark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value12(Integer value) {
        setHoldStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value13(BigDecimal value) {
        setBuyAble(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord value14(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TAccountProdInfoRecord values(String value1, String value2, String value3, BigDecimal value4, BigDecimal value5, BigDecimal value6, BigDecimal value7, BigDecimal value8, BigDecimal value9, BigDecimal value10, BigDecimal value11, Integer value12, BigDecimal value13, Timestamp value14) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TAccountProdInfoRecord
     */
    public TAccountProdInfoRecord() {
        super(TAccountProdInfo.T_ACCOUNT_PROD_INFO);
    }

    /**
     * Create a detached, initialised TAccountProdInfoRecord
     */
    public TAccountProdInfoRecord(String fundAccount, String prodCode, String orgId, BigDecimal interAsset, BigDecimal outerAsset, BigDecimal totalAsset, BigDecimal matchRatio, BigDecimal last_12YieldRatio, BigDecimal minMark, BigDecimal stressMark, BigDecimal historyMark, Integer holdStatus, BigDecimal buyAble, Timestamp updateTime) {
        super(TAccountProdInfo.T_ACCOUNT_PROD_INFO);

        set(0, fundAccount);
        set(1, prodCode);
        set(2, orgId);
        set(3, interAsset);
        set(4, outerAsset);
        set(5, totalAsset);
        set(6, matchRatio);
        set(7, last_12YieldRatio);
        set(8, minMark);
        set(9, stressMark);
        set(10, historyMark);
        set(11, holdStatus);
        set(12, buyAble);
        set(13, updateTime);
    }
}