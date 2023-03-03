package com.extend.virtualcardapi.service;

import com.extend.virtualcardapi.client.ExtendClient;
import com.extend.virtualcardapi.models.VirtualCard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VirtualCardService {
    private ExtendClient extendClient;

    public VirtualCard[] getVirtualCard() {
        return extendClient.getVirtualCard().getVirtualCards();
    }

}
