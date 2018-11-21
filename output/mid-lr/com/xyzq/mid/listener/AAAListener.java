
package com.xyzq.mid.listener;

import java.io.StringReader;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.xyzq.schema.${service}._1_0.BBBInType;

import com.xyzq.mid.service.AAAService;
import com.xyzq.mid.util.SpringContextUtil;

public class AAAListener implements MessageListener, ExceptionListener {

	private Logger log = LoggerFactory.getLogger(getClass());

	private AAAService service;
	
	private JAXBContext context;

	private Unmarshaller unmarshaller;
	{	
		try {
	    	context = JAXBContext.newInstance("cn.com.xyzq.schema.CCC._1_0");
	    	unmarshaller = context.createUnmarshaller();
	    	service = (AAAService)SpringContextUtil.getBean("aAA");
	    } catch (JAXBException e) {
	    	e.printStackTrace();
	    }
	}

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				TextMessage msg = (TextMessage) message;
				log.info("接收到的数据：\n" + msg.getText());				
				JAXBElement<BBBInType> element = (JAXBElement<BBBInType>) 
						unmarshaller.unmarshal(new StringReader(msg.getText()));
				BBBInType in = element.getValue();
				service.save(in.getEntries().getEntry());
				// 消息确认
				msg.acknowledge();
			} catch (JMSException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
	}

	public void onException(JMSException exception) {
		log.error("数据接收异常", exception);
	}

}
