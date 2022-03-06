package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tandemdude.disjord.models.enums.StickerFormat;
import io.github.tandemdude.disjord.models.enums.StickerType;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sticker {
    private long id;
    @JsonProperty("pack_id")
    private Long packId;
    private String name;
    private String description;
    private String tags;
    private StickerType type;
    @JsonProperty("format_type")
    private StickerFormat formatType;
    private Boolean available;
    @JsonProperty("guild_id")
    private Long guildId;
    private User user;
    @JsonProperty("sort_value")
    private int sortValue;
}
