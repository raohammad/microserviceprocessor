package com.flexilogix;

public class Data{
	 
	private String time;
	private String label;
	
	public Data(){}
	
	public Data(String d, String l){
		this.time =d;
		this.label =l;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return "SinkData [time=" + time + ", label=" + label + "]";
	}
}
