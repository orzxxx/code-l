/*
 * This file is generated by jOOQ.
*/
package test.boot.entity.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.UpdatableRecordImpl;

import test.boot.entity.tables.Test;


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
public class TestRecord extends UpdatableRecordImpl<TestRecord> implements Record1<Integer> {

    private static final long serialVersionUID = -1319507452;

    /**
     * Setter for <code>PUBLIC.TEST.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.TEST.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<Integer> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<Integer> valuesRow() {
        return (Row1) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Test.TEST.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestRecord values(Integer value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TestRecord
     */
    public TestRecord() {
        super(Test.TEST);
    }

    /**
     * Create a detached, initialised TestRecord
     */
    public TestRecord(Integer id) {
        super(Test.TEST);

        set(0, id);
    }
}