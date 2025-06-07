package com.emprendecix.modelos;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_auditoria", schema = "sc_promemprendedores")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audi_id")
    private Long id;

    @Column(name = "audi_usuario")
    private String usuario;

    @Column(name = "audi_tabla")
    private String tabla;

    @Column(name = "audi_operacion")
    private String operacion;

    @Column(name = "audi_fecha")
    private LocalDateTime fecha;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "audi_valores_anteriores", columnDefinition = "jsonb")
    private JsonNode valoresAnteriores;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "audi_valores_nuevos", columnDefinition = "jsonb")
    private JsonNode valoresNuevos;
}
