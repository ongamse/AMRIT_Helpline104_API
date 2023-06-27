package com.iemr.helpline104.service.foodSafetyCopmlaint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iemr.helpline104.data.foodSafetyCopmlaint.T_FoodSafetyCopmlaint;

public interface FoodSafetyCopmlaintService {
	
	List<T_FoodSafetyCopmlaint> getFoodSafetyComplaints(Long benificiaryRegID, Long benCallID, String requestID,String phoneNo) throws Exception;
	
	public T_FoodSafetyCopmlaint save(T_FoodSafetyCopmlaint t_foodSafetyCopmlaint, HttpServletRequest request) throws Exception;
}
