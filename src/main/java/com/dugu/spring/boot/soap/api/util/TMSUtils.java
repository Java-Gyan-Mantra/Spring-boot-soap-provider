package com.dugu.spring.boot.soap.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.dugu.spring.boot.soap.api.dto.Address;
import com.dugu.spring.boot.soap.api.dto.UserInfo;
import com.management.tms.service.types.RegisteredUser;
import com.management.tms.service.types.RegistrationRequest;

@Component
public class TMSUtils {

	public static List<RegistrationRequest> userList = new ArrayList<>();

	static {
		RegistrationRequest dummyUser = null;
		com.management.tms.service.types.Address add = null;
		for (int i = 1; i <= 5; i++) {
			dummyUser = new RegistrationRequest();
			dummyUser.setName("user" + i);
			dummyUser.setBloodGroup("A+ve");
			dummyUser.setBikeModel("model" + i);
			dummyUser.setAge(i * 10);
			dummyUser.setDlNo("GHJF" + new Random().nextInt(84683));
			add = new com.management.tms.service.types.Address();
			add.setStreet("street" + i);
			add.setCity("city" + i);
			add.setDist("Dist" + i);
			add.setState("state" + i);
			add.setPinCode(new Random().nextInt(8468783));
			dummyUser.getAddress().add(add);
			userList.add(dummyUser);
		}
	}

	public RegistrationRequest convertDTO2XMLData(UserInfo user, Address add) {
		RegistrationRequest request = new RegistrationRequest();
		request.setName(user.getName());
		request.setAge(user.getAge());
		request.setBikeModel(user.getBikeModel());
		request.setBloodGroup(user.getBloodGroup());
		request.setDlNo(user.getDlNo());
		com.management.tms.service.types.Address soapAddress = null;

		soapAddress = new com.management.tms.service.types.Address();
		soapAddress.setStreet(add.getStreet());
		soapAddress.setCity(add.getCity());
		soapAddress.setDist(add.getDist());
		soapAddress.setState(add.getState());
		soapAddress.setPinCode(add.getPinCode());
		request.getAddress().add(soapAddress);

		return request;
	}

	public static void addUser(RegistrationRequest request) {
		userList.add(request);
		System.out.println(userList);
	}

	public List<UserInfo> convertXML2DTO(RegisteredUser user) {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		List<RegistrationRequest> registrationRequests = user
				.getRegistrationRequest();
		registrationRequests.stream().forEach(
				req -> userInfos.add(new UserInfo(req.getName(), req
						.getBloodGroup(), req.getBikeModel(), req.getAge(), req
						.getDlNo(), new Address(req.getAddress().get(0)
						.getStreet(), req.getAddress().get(0).getCity(), req
						.getAddress().get(0).getDist(), req.getAddress().get(0)
						.getState(), req.getAddress().get(0).getPinCode()))));
		return userInfos;
	}
}
