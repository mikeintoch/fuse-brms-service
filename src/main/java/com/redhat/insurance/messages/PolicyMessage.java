package com.redhat.insurance.messages;

import com.redhat.insurance.model.Car;
import com.redhat.insurance.model.Driver;
import com.redhat.insurance.model.Policy;

public class PolicyMessage {
	
	private Car car;
	
	private Driver driver;
	
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
	public PolicyMessage(Car car) {
		super();
		this.car = car;
	}
	public PolicyMessage(Driver driver) {
		super();
		this.driver = driver;
	}
	public PolicyMessage(Policy policy) {
		super();
		this.policy = policy;
	}
	
}
