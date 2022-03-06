package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {
    private long id;
    private String name;
    private int color;
    private boolean hoist;
    private String icon;
    @JsonProperty("unicode_emoji")
    private String unicodeEmoji;
    private int position;
    private String permissions;
    private boolean managed;
    private boolean mentionable;
    private RoleTags tags;
}
