package com.ghq.pig.farm;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ghq.pig.farm.feeding.service.IFeedingService;

@SpringBootTest
class PigFarmApplicationTests {

	@Autowired
	private IFeedingService feedingService;

	@Test
	void contextLoads() throws IOException {
		System.out.println(feedingService.getById(1000));
	}

	@Test
	void creatSHA256() {
		System.out.println(DigestUtils.sha256Hex("123456"));
	}

}
