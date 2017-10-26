/*
 * This file is generated by jOOQ.
*/
package test.boot.entry.mysql.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import test.boot.entry.mysql.tables.TDictLvl2Desc;


/**
 * 二级数据字典描述
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TDictLvl2DescRecord extends UpdatableRecordImpl<TDictLvl2DescRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -1171762024;

    /**
     * Setter for <code>datasync.t_dict_lvl2_desc.dict_item</code>. 字典项
     */
    public void setDictItem(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>datasync.t_dict_lvl2_desc.dict_item</code>. 字典项
     */
    public String getDictItem() {
        return (String) get(0);
    }

    /**
     * Setter for <code>datasync.t_dict_lvl2_desc.dict_desc</code>. 字典项描述
     */
    public void setDictDesc(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>datasync.t_dict_lvl2_desc.dict_desc</code>. 字典项描述
     */
    public String getDictDesc() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TDictLvl2Desc.T_DICT_LVL2_DESC.DICT_ITEM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TDictLvl2Desc.T_DICT_LVL2_DESC.DICT_DESC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getDictItem();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDictDesc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDictLvl2DescRecord value1(String value) {
        setDictItem(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDictLvl2DescRecord value2(String value) {
        setDictDesc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDictLvl2DescRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TDictLvl2DescRecord
     */
    public TDictLvl2DescRecord() {
        super(TDictLvl2Desc.T_DICT_LVL2_DESC);
    }

    /**
     * Create a detached, initialised TDictLvl2DescRecord
     */
    public TDictLvl2DescRecord(String dictItem, String dictDesc) {
        super(TDictLvl2Desc.T_DICT_LVL2_DESC);

        set(0, dictItem);
        set(1, dictDesc);
    }
}
