package test.boot.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ForTestServiceImpl {
	
	public String f1() {
		return "f1";
	}
	
	public String f2() {
		return "f2";
	}
}
