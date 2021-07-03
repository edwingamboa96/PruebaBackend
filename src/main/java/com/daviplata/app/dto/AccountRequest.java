package com.daviplata.app.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Solicitud para crear una nueva cuenta
 * @author Edwin Gamboa
 *
 */

public class AccountRequest {

	@JsonProperty(required = true)
	@NotEmpty
	@NotBlank
	private String nombre;

	@JsonProperty(required = true)
	@NotEmpty
	@NotBlank
	private String numeroDocumento;

	@JsonProperty(required = true)
	@NotNull
	@Positive
	private BigDecimal saldo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	

}
