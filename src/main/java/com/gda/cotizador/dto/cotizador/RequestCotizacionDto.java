package com.gda.cotizador.dto.cotizador;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

public class RequestCotizacionDto {
	@NotNull
    private String resourceType;

    private Integer id;
    
    @NotNull
    private HeaderDto header;

    @NotNull
    @Valid
    private Requisition requisition;

    @NotNull
	@NotBlank
	@Pattern(regexp = "(active)+", message = "El campo solo acepta los siguientes valores: active")
    private String status;

    @NotNull
	@NotBlank
    private String intent;

    @NotNull
    @Valid
    private Code code;

    @NotNull
	@NotBlank
	@Pattern(regexp = "[0-9]+", message = "Debe contener solo números.")
    private String quantityQuantity;

    private GDAMenssageDto GDA_menssage;
            
    
	public HeaderDto getHeader() {
		return header;
	}
	public void setHeader(HeaderDto header) {
		this.header = header;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setResourceType(String resourceType){
        this.resourceType = resourceType;
    }
    public String getResourceType(){
        return this.resourceType;
    }
    public void setRequisition(Requisition requisition){
        this.requisition = requisition;
    }
    public Requisition getRequisition(){
        return this.requisition;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setIntent(String intent){
        this.intent = intent;
    }
    public String getIntent(){
        return this.intent;
    }
    public void setCode(Code code){
        this.code = code;
    }
    public Code getCode(){
        return this.code;
    }
    public void setQuantityQuantity(String quantityQuantity){
        this.quantityQuantity = quantityQuantity;
    }
    public String getQuantityQuantity(){
        return this.quantityQuantity;
    }
	public GDAMenssageDto getGDA_menssage() {
		return GDA_menssage;
	}
	public void setGDA_menssage(GDAMenssageDto gDA_menssage) {
		GDA_menssage = gDA_menssage;
	}
    
}

