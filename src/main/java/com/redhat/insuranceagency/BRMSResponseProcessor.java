package com.redhat.insuranceagency;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import com.jayway.jsonpath.JsonPath;
import com.redhat.insurance.messages.PolicyMessage;

public class BRMSResponseProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		PolicyMessage resp = exchange.getProperty("PolicyMessage",PolicyMessage.class);
		Message in = exchange.getIn();
		String json = in.getBody(String.class);
				
		System.out.println("Mensaje: " + json);
		
		List<Integer> carRisk = JsonPath.read(json, "$..riesgoAuto");
		List<Integer> driverRisk = JsonPath.read(json,"$..riesgoConductor");
		List<Integer> pricePolicy = JsonPath.read(json, "$..precio");
		List<String> tipoPolicy = JsonPath.read(json, "$..tipo");

		
		
		if(carRisk.size() > 0){
			if(carRisk.get(0) != null){
				resp.getCar().setRiesgoAuto(carRisk.get(0));
			}else{
				resp.getCar().setRiesgoAuto(0);
			}
		}
		
		if(driverRisk.size() > 0){
			if(driverRisk.get(0) != null){
				resp.getDriver().setRiesgoConductor(driverRisk.get(0));
			}else{
				resp.getDriver().setRiesgoConductor(0);
			}
		}
		
		if(pricePolicy.size() > 0){
			if(pricePolicy.get(0) != null){
				resp.getPolicy().setPrecio(pricePolicy.get(0));
			}else{
				resp.getPolicy().setPrecio(0);
			}
		}
		
		if(tipoPolicy.size() > 0){
			if(tipoPolicy.get(0) != null){
				resp.getPolicy().setTipo(tipoPolicy.get(0));
			}else{
				resp.getPolicy().setTipo("Estandar");
			}
		}
		
		resp.getPolicy().setIvaTotal(resp.getPolicy().getPrecio() * 0.16);
		resp.getPolicy().setTotal(resp.getPolicy().getPrecio()+resp.getPolicy().getIvaTotal());

		in.setBody(resp);
		exchange.setOut(in);
	}

}
