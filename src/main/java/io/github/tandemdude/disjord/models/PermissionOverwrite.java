package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.tandemdude.disjord.models.enums.OverwriteType;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionOverwrite {
    private long id;
    private OverwriteType type;
    private String allow;
    private String deny;
}
