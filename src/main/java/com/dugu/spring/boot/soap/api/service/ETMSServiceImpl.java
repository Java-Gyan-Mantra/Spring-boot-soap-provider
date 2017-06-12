package com.dugu.spring.boot.soap.api.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.dugu.spring.boot.soap.api.util.TMSUtils;
import com.management.tms.service.ETmsService;
import com.management.tms.service.TMSException;
import com.management.tms.service.types.RegisteredUser;
import com.management.tms.service.types.RegistrationRequest;
import com.management.tms.service.types.RegistrationResponse;
import com.management.tms.service.types.UserRequest;

@Service
public class ETMSServiceImpl implements ETmsService {

	@Override
	public RegistrationResponse register(RegistrationRequest inputRequest)
			throws TMSException {
		RegistrationResponse response = new RegistrationResponse();
		response.setName(inputRequest.getName());
		response.setRegistrationId("" + new Random().nextInt(362377));
		response.setIssueDate(convertDate(new Date()));
		TMSUtils.addUser(inputRequest);
		return response;
	}

	private XMLGregorianCalendar convertDate(Date date) {
		DatatypeFactory df = null;
		GregorianCalendar gc = null;
		try {
			df = DatatypeFactory.newInstance();
			gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
		} catch (DatatypeConfigurationException e) {
			System.out.println("Date can't be convertable");
		}
		return df.newXMLGregorianCalendar(gc);
	}

	@Override
	public RegisteredUser getUsersDetails(UserRequest inputRequest) {
		// TODO Auto-generated method stub
		RegisteredUser user = new RegisteredUser();
		TMSUtils.userList.stream().forEach(
				u -> user.getRegistrationRequest().add(u));
		return user;
	}

}
