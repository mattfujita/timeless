package com.libertymutual.goforcode.timeless.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Stack;

import org.junit.Test;

import com.libertymutual.goforcode.timeless.models.Timeless;

public class TimelessTest {
	
	private List<Double> list;
	private Timeless timeless;

	@Test
	public void test_that_method_is_storing_hours() {
		//arrange
		timeless.setMondayHours(8);
		
		//act
		timeless.getMondayHours();
		
		//assert
		assertThat(timeless.getMondayHours() == 8.0);
	}
	
	public void test_that_totalHours_has_right_amount() {
		
		//arrange
		timeless.setTotalHours(40);
		
		//act
		timeless.getTotalHours();
		
		//assert
		assertThat(timeless.getTotalHours() == 40.0);
	}
	
	public void test_that_calcuating_total_hours_works() {
		
		//arrange
		timeless.setMondayHours(1);
		timeless.setTuesdayHours(2);
		timeless.setWednesdayHours(3);
		timeless.setThursdayHours(4);
		timeless.setFridayHours(5);
		
		//act
		timeless.calculateTotalHours();
		
		//assert
		assertThat(timeless.getTotalHours() == 15);
		
	}

}
