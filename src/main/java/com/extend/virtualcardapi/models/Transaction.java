package com.extend.virtualcardapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    String id;
    String cardholderId;
    String cardholderName;
    String source;
    String merchantName;
    String recipientId;
    String type;
    String status;
}
