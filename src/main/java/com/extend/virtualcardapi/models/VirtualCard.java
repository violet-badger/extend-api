package com.extend.virtualcardapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VirtualCard {
    String id;
    String status;
    String displayName;
    String expires;
    String balanceCents;
    String spentCents;
}
