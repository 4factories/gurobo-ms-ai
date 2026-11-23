package it.gurobo.ms.ai.entity;

import it.gurobo.ms.ai.entity.constants.ISchemaAIConstants;
import it.gurobo.ms.base.entity.AAnagraficaEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = ISchemaAIConstants.AI_CHAT, schema = ISchemaAIConstants.SCHEMA, uniqueConstraints = { @UniqueConstraint(columnNames = { "id_linea_produzione", "id_dipendente", "data_inizio", "id_tipologia_fase" }) })
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString(doNotUseGetters = true, callSuper = true)
public class AiConversazioneEntity extends AAnagraficaEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_ai_chat")
    @ToString.Exclude
    AIChatEntity chat;

}
