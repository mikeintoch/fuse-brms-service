package com.redhat.insurance.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.redhat.insurance.model.Car;
import com.redhat.insurance.model.Driver;
import com.redhat.insurance.model.Policy;

public class PolicyBRMSRequest {
	
	@SerializedName("com.redhat.insurance.Car")
    @Expose
	private Car car;
	
	@SerializedName("com.redhat.insurance.Driver")
    @Expose
	private Driver driver;
	
	@SerializedName("com.redhat.insurance.Policy")
    @Expose
	private Policy policy;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public PolicyBRMSRequest(Car car) {
		super();
		this.car = car;
	}
	public PolicyBRMSRequest(Driver driver) {
		super();
		this.driver = driver;
	}
	public PolicyBRMSRequest(Policy policy) {
		super();
		this.policy = policy;
	}
	
}
