package it.gurobo.ms.ai.entity;

import it.gurobo.ms.ai.entity.constants.ISchemaAIConstants;
import it.gurobo.ms.base.entity.AIntPkEntity;
import it.gurobo.ms.base.entity.AUUIDEntity;
import it.gurobo.ms.base.entity.enumeration.EManagementRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Table(name = ISchemaAIConstants.AI_CHAT, schema = ISchemaAIConstants.SCHEMA, uniqueConstraints = { @UniqueConstraint(columnNames = { "id_linea_produzione", "id_dipendente", "data_inizio", "id_tipologia_fase" }) })
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString(doNotUseGetters = true, callSuper = true)
public class AIChatEntity extends AUUIDEntity {

    @Column(name = "id_user", nullable = false, unique = true)
    private UUID idUser;


    public AIChatEntity(UUID uid) {
        super(uid);
    }

    public AIChatEntity(UUID uid, UUID idUser) {
        super(uid);
        this.idUser=idUser;
    }


}
