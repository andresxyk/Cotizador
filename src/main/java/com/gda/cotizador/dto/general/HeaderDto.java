package com.gda.cotizador.dto.general;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HeaderDto {
	@NotNull
	@NotBlank
	@Schema(description = "Fijo = 'De donde proviene' para simulate y generate || Fijo = 'COTIZACION' para search")
	private String lineanegocio;

	@Schema(description = "Fecha peticiformato: yyyy-MM-dd'T'HH:mm:ss.SSS")
	private String dregistro;

	@NotNull
	@Schema(description = "Marca proveniente, Fijo: 0 para search-marca, search-convenio")
	private Integer marca;

	@NotNull
	@NotBlank
	@Schema(description = "Usuario y contraseencriptado conforme convenio")
	private String token;

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof com.gda.cotizador.dto.general.HeaderDto))
			return false;
		com.gda.cotizador.dto.general.HeaderDto other = (com.gda.cotizador.dto.general.HeaderDto) o;
		if (!other.canEqual(this))
			return false;
		Object this$marca = getMarca(), other$marca = other.getMarca();
		if ((this$marca == null) ? (other$marca != null) : !this$marca.equals(other$marca))
			return false;
		Object this$lineanegocio = getLineanegocio(), other$lineanegocio = other.getLineanegocio();
		if ((this$lineanegocio == null) ? (other$lineanegocio != null) : !this$lineanegocio.equals(other$lineanegocio))
			return false;
		Object this$dregistro = getDregistro(), other$dregistro = other.getDregistro();
		if ((this$dregistro == null) ? (other$dregistro != null) : !this$dregistro.equals(other$dregistro))
			return false;
		Object this$token = getToken(), other$token = other.getToken();
		return !((this$token == null) ? (other$token != null) : !this$token.equals(other$token));
	}

	protected boolean canEqual(Object other) {
		return other instanceof com.gda.cotizador.dto.general.HeaderDto;
	}

	public int hashCode() {
		int PRIME = 59;
		int result = 1;
		Object $marca = getMarca();
		result = result * 59 + (($marca == null) ? 43 : $marca.hashCode());
		Object $lineanegocio = getLineanegocio();
		result = result * 59 + (($lineanegocio == null) ? 43 : $lineanegocio.hashCode());
		Object $dregistro = getDregistro();
		result = result * 59 + (($dregistro == null) ? 43 : $dregistro.hashCode());
		Object $token = getToken();
		return result * 59 + (($token == null) ? 43 : $token.hashCode());
	}

	public String toString() {
		return "HeaderDto(lineanegocio=" + getLineanegocio() + ", dregistro=" + getDregistro() + ", marca=" + getMarca()
				+ ", token=" + getToken() + ")";
	}

	public void setLineanegocio(String lineanegocio) {
		this.lineanegocio = lineanegocio;
	}

	public void setDregistro(String dregistro) {
		this.dregistro = dregistro;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLineanegocio() {
		return this.lineanegocio;
	}

	public String getDregistro() {
		return this.dregistro;
	}

	public Integer getMarca() {
		return this.marca;
	}

	public String getToken() {
		return this.token;
	}
}
