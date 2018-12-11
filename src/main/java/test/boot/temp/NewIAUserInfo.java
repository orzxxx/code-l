package test.boot.temp;

import com.xyzq.afa2.entity.activity.IAUserInfo;

public class NewIAUserInfo extends IAUserInfo {
	
	private String hrUnit;
	
	private String qqNumber;
	
	private String wechatcodeUrl;
	
	private String introduce;

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public String getWechatcodeUrl() {
		return wechatcodeUrl;
	}

	public void setWechatcodeUrl(String wechatcodeUrl) {
		this.wechatcodeUrl = wechatcodeUrl;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getHrUnit() {
		return hrUnit;
	}

	public void setHrUnit(String hrUnit) {
		this.hrUnit = hrUnit;
	}
	
}
