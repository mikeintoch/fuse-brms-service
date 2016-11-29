package com.redhat.insuranceagency.brms;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BRMSExec {

	@SerializedName("lookup")
    @Expose
    private String lookup;
	
    @SerializedName("commands")
    @Expose
    private List<BRMSCommand> commands = new ArrayList<BRMSCommand>();

    /**
     * 
     * @return
     *     The commands
     */
    public List<BRMSCommand> getCommands() {
        return commands;
    }

    /**
     * 
     * @param commands
     *     The commands
     */
    public void setCommands(List<BRMSCommand> commands) {
        this.commands = commands;
    }
    public void addCommand(BRMSCommand comm){
    	this.commands.add(comm);
    }

	public BRMSExec() {
		super();
		this.commands= new ArrayList<BRMSCommand>();
	
	}

	public String getLookup() {
		return lookup;
	}

	public void setLookup(String lookup) {
		this.lookup = lookup;
	}
}