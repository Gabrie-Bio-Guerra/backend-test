package br.com.fcamaratest.form;

import br.com.fcamaratest.model.Park;

public class ParkForm {
	
	private String name;
	private String cnpj;
	private String address;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Park convert(){
		Park park =  new Park(name, cnpj, address, phone);
		return park;
	}

	
}
