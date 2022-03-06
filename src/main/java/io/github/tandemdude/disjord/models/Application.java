package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {
    private long id;
    private String name;
    private String icon;
    private String description;
    @JsonProperty("rpc_origins")
    private List<String> rpcOrigins;
    @JsonProperty("bot_public")
    private boolean botPublic;
    @JsonProperty("bot_require_code_grant")
    private boolean botRequireCodeGrant;
    @JsonProperty("terms_of_service_url")
    private String termsOfServiceUrl;
    @JsonProperty("privacy_policy_url")
    private String privacyPolicyUrl;
    private User owner;
    private String summary;
    @JsonProperty("verify_key")
    private String verifyKey;
    @JsonProperty("guild_id")
    private Long guildId;
    @JsonProperty("primary_sku_id")
    private Long primarySkuId;
    private String slug;
    @JsonProperty("cover_image")
    private String coverImage;
    private Integer flags;
}
