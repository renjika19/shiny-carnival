package com.revature.Arithmetic;

public class Arithmetic {
	public int addition(int ...nums) {
		int result = 0;
		for(int i:nums) {
			result += i;
		}
		return result;
	}
	
	public int subtraction(int ...nums) {
		int result = 0;
		if(nums.length==0) {
			return 0;
		}else {
			result = nums[0];
			for(int i =1; i<nums.length; i++) {
				result -= nums[i];
			}
		}
		return result;
	}
	
	public int multiplication(int ...nums) {
		int result = 0;
		if(nums.length == 0) {
			return 0;
		}else {
			result = nums[0];
			for(int i = 1; i<nums.length;i++) {
				result *= nums[i];
			}
		}
		return result;
	}
	
	public int division(int ...nums) {
		int result =0;
		if(nums.length==0) {
			return 0;
		}else {
			result =nums[0];
			for(int i = 1; i<nums.length;i++) {
				result /= nums[i];
			}
		}
		return result;
	}
}
