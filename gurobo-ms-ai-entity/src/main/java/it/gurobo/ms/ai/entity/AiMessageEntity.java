package it.gurobo.ms.ai.entity;

import it.gurobo.ms.ai.commons.enumeration.EAiMessageType;
import jakarta.persistence.Column;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

public class AiMessageEntity {

    AiConversazioneEntity conversazione;

    @Column(name = "sequenza", nullable = false)
    Integer sequenza;

    EAiMessageType type;

    String contenuto;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", columnDefinition = "jsonb")
    Map<String, Object> metadata;

}
