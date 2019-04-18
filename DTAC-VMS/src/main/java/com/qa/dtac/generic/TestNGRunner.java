package com.qa.dtac.generic;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNGRunner
{
	public static void main(String[] args) {
		TestNG testng=new TestNG();
	List<String> list=new ArrayList<String>();
	list.add("./test-output/testng-failed.xml");
	testng.setTestSuites(list);
	testng.run();
	}

}
