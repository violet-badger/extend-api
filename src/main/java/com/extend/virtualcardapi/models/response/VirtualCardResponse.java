package com.extend.virtualcardapi.models.response;

import com.extend.virtualcardapi.models.VirtualCard;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VirtualCardResponse {
    VirtualCard[] virtualCards;
}
