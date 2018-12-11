package com.xyzq.mid.entity.middev;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "middev.T_CLIENT_ACC_INFO_ABNORMAL")
public class ClientAccInfoAbnormal {

	/**	* 用户账号	*/	@Column(name = "CLIENT_ID")	private String clientId;	/**	* 数据日期	*/	@Column(name = "LOAD_DATE")	private Date loadDate;	/**	* 	*/	@Column(name = "CREATE_TIME")	private Date createTime;
	public String getClientId() {		return clientId;	}	public void setClientId(String clientId) {		this.clientId = clientId;	}	public Date getLoadDate() {		return loadDate;	}	public void setLoadDate(Date loadDate) {		this.loadDate = loadDate;	}	public Date getCreateTime() {		return createTime;	}	public void setCreateTime(Date createTime) {		this.createTime = createTime;	}
}