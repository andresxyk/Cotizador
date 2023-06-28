package com.gda.cotizador.dto.cotizacion;

public class CExamenDto {

	private Integer cexamen;
	private String sexamen;
	private String snemonico;
	private boolean blistapublico;
	private short uestaciontomatlalpan;
	private short ulaboratoriogabinete;
	private String sexamenweb;
	private Short upatologia;
	private Boolean bentregausb;
	private Boolean bregistrarconsumo;
	private int cmarca;
	private Integer cexamenazteca;
	private String sexamenlabcore;
	private Integer cexamenproceso;

	
	
	public CExamenDto() {
		super();
	}

	public CExamenDto(Integer cexamen, String sexamen, String snemonico, boolean blistapublico,
				String sexamenweb, Boolean bentregausb, Boolean bregistrarconsumo, int cmarca, Integer cexamenazteca, String sexamenlabcore,
				Integer cexamenproceso) {
			super();
			this.cexamen = cexamen;
			this.sexamen = sexamen;
			this.snemonico = snemonico;
			this.blistapublico = blistapublico;
			this.sexamenweb = sexamenweb;
			this.bentregausb = bentregausb;
			this.bregistrarconsumo = bregistrarconsumo;
			this.cmarca = cmarca;
			this.cexamenazteca = cexamenazteca;
			this.sexamenlabcore = sexamenlabcore;
			this.cexamenproceso = cexamenproceso;
		}

	public Integer getCexamen() {
		return cexamen;
	}

	public void setCexamen(Integer cexamen) {
		this.cexamen = cexamen;
	}

	public String getSexamen() {
		return sexamen;
	}

	public void setSexamen(String sexamen) {
		this.sexamen = sexamen;
	}

	public String getSnemonico() {
		return snemonico;
	}

	public void setSnemonico(String snemonico) {
		this.snemonico = snemonico;
	}

	public boolean isBlistapublico() {
		return blistapublico;
	}

	public void setBlistapublico(boolean blistapublico) {
		this.blistapublico = blistapublico;
	}

	public short getUestaciontomatlalpan() {
		return uestaciontomatlalpan;
	}

	public void setUestaciontomatlalpan(short uestaciontomatlalpan) {
		this.uestaciontomatlalpan = uestaciontomatlalpan;
	}

	public short getUlaboratoriogabinete() {
		return ulaboratoriogabinete;
	}

	public void setUlaboratoriogabinete(short ulaboratoriogabinete) {
		this.ulaboratoriogabinete = ulaboratoriogabinete;
	}

	public String getSexamenweb() {
		return sexamenweb;
	}

	public void setSexamenweb(String sexamenweb) {
		this.sexamenweb = sexamenweb;
	}

	public Short getUpatologia() {
		return upatologia;
	}

	public void setUpatologia(Short upatologia) {
		this.upatologia = upatologia;
	}

	public Boolean getBentregausb() {
		return bentregausb;
	}

	public void setBentregausb(Boolean bentregausb) {
		this.bentregausb = bentregausb;
	}

	public Boolean getBregistrarconsumo() {
		return bregistrarconsumo;
	}

	public void setBregistrarconsumo(Boolean bregistrarconsumo) {
		this.bregistrarconsumo = bregistrarconsumo;
	}

	public int getCmarca() {
		return cmarca;
	}

	public void setCmarca(int cmarca) {
		this.cmarca = cmarca;
	}

	public Integer getCexamenazteca() {
		return cexamenazteca;
	}

	public void setCexamenazteca(Integer cexamenazteca) {
		this.cexamenazteca = cexamenazteca;
	}

	public String getSexamenlabcore() {
		return sexamenlabcore;
	}

	public void setSexamenlabcore(String sexamenlabcore) {
		this.sexamenlabcore = sexamenlabcore;
	}

	public Integer getCexamenproceso() {
		return cexamenproceso;
	}

	public void setCexamenproceso(Integer cexamenproceso) {
		this.cexamenproceso = cexamenproceso;
	}

}
