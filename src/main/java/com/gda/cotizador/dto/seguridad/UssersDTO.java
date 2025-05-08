package com.gda.cotizador.dto.seguridad;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class UssersDTO {
    private String user;
    private String password;
}
