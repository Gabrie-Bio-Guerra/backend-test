package br.com.fcamaratest.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fcamaratest.model.Park;
import br.com.fcamaratest.repository.ParkRepository;

public class ParkForm {
	
	@NotNull @NotEmpty
	private String name;
	@NotNull @NotEmpty
	private String cnpj;
	@NotNull @NotEmpty
	private String address;
	@NotNull @NotEmpty
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

	public Park update(Long id, ParkRepository parkRepository) {
		Park park = parkRepository.getOne(id);
		park.setName(this.name);
		park.setCnpj(this.cnpj);
		park.setAddress(this.address);
		park.setPhone(this.phone);
		return park;
	}
}
