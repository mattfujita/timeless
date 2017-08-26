package com.libertymutual.goforcode.timeless.services;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.timeless.models.Timeless;

public class TimelessTest {
	
	private Timeless timeless;
	
	@Before
	public void setUp() {
		timeless = new Timeless();
	}
	
	@Test
	public void test_that_calcuating_total_hours_works() {
		//arrange
		timeless.setMondayHours(1);
		timeless.setTuesdayHours(1);
		timeless.setWednesdayHours(1);
		timeless.setThursdayHours(1);
		timeless.setFridayHours(1);
		
		
		//act
		double result = timeless.calculateTotalHours();
		
		//assert
		assertThat(result).isEqualTo(5.0);
		
	}

}
