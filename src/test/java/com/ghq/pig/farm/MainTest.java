package com.ghq.pig.farm;

import java.util.Base64;

public class MainTest {
	public static void main(String[] args) {
		System.out.println(Base64.getEncoder().encodeToString("admin".getBytes()));
	}
}
