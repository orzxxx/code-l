/*
 * This file is generated by jOOQ.
*/
package test.boot.entry.mysql.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class TDictLvl2Desc implements Serializable {

    private static final long serialVersionUID = 710514880;

    private String dictItem;
    private String dictDesc;

    public TDictLvl2Desc() {}

    public TDictLvl2Desc(TDictLvl2Desc value) {
        this.dictItem = value.dictItem;
        this.dictDesc = value.dictDesc;
    }

    public TDictLvl2Desc(
        String dictItem,
        String dictDesc
    ) {
        this.dictItem = dictItem;
        this.dictDesc = dictDesc;
    }

    public String getDictItem() {
        return this.dictItem;
    }

    public void setDictItem(String dictItem) {
        this.dictItem = dictItem;
    }

    public String getDictDesc() {
        return this.dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TDictLvl2Desc (");

        sb.append(dictItem);
        sb.append(", ").append(dictDesc);

        sb.append(")");
        return sb.toString();
    }
}