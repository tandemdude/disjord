package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThreadMetadata {
    private boolean archived;
    @JsonProperty("auto_archive_duration")
    private int autoArchiveDuration;
    @JsonProperty("archive_timestamp")
    private String archiveTimestamp;
    private boolean locked;
    private Boolean invitable;
    @JsonProperty("create_timestamp")
    private String createTimestamp;
}
