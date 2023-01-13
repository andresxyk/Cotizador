package com.gda.cotizador.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class CMarcaDto {

	private Integer cmarca;
    private String smarca;
    private String smarcabi;
}
