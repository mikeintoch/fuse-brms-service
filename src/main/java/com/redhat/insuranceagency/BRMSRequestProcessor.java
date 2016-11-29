package com.redhat.insuranceagency;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import com.redhat.insurance.messages.PolicyBRMSRequest;
import com.redhat.insurance.messages.PolicyMessage;
import com.redhat.insurance.model.Policy;
import com.redhat.insuranceagency.brms.BRMSCommand;
import com.redhat.insuranceagency.brms.BRMSExec;
import com.redhat.insuranceagency.brms.BRMSFireAllRules;
import com.redhat.insuranceagency.brms.BRMSInsert;

public class BRMSRequestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		Message out = exchange.getOut();

		PolicyMessage resp = in.getBody(PolicyMessage.class);
		PolicyBRMSRequest policyDummyRequest;
		BRMSExec exec = new BRMSExec();
		BRMSCommand comm;
		
		resp.setPolicy(new Policy(0,null));
		
		exec.setLookup("InsuranceCarSession");

		if (resp.getCar() != null) {
			System.out.println("Entrando en carro");
			comm = new BRMSCommand();
			policyDummyRequest = new PolicyBRMSRequest(resp.getCar());
			comm.setInsert(new BRMSInsert("car", policyDummyRequest));
			exec.addCommand(comm);
		}
		if (resp.getDriver() != null) {
			System.out.println("Entrando en driver");
			comm = new BRMSCommand();
			policyDummyRequest = new PolicyBRMSRequest(resp.getDriver());
			comm.setInsert(new BRMSInsert("driver", policyDummyRequest));
			exec.addCommand(comm);
		}

		System.out.println("Entrando en policy");
		comm = new BRMSCommand();
		policyDummyRequest = new PolicyBRMSRequest(resp.getPolicy());
		comm.setInsert(new BRMSInsert("policy", policyDummyRequest));
		exec.addCommand(comm);

		comm = new BRMSCommand();
		comm.setFireAllRules(new BRMSFireAllRules());
		exec.addCommand(comm);
		out.setBody(exec);
	}

}
