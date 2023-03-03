package com.extend.virtualcardapi.service;

import com.extend.virtualcardapi.client.ExtendClient;
import com.extend.virtualcardapi.models.VirtualCard;
import com.extend.virtualcardapi.models.response.VirtualCardResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VirtualCardServiceTest {

    private ExtendClient extendClient = mock(ExtendClient.class);
    private VirtualCardService virtualCardService = new VirtualCardService(extendClient);

    @Test
    public void testGetVirtualCard() {
        VirtualCard virtualCard = VirtualCard.builder()
                .balanceCents("5000")
                .displayName("Thinh's Card")
                .id("123")
                .build();
        VirtualCard[] virtualCards = new VirtualCard[1];
        virtualCards[0] = virtualCard;
        VirtualCardResponse virtualCardResponse = new VirtualCardResponse(virtualCards);
        when(extendClient.getVirtualCard()).thenReturn(virtualCardResponse);

        VirtualCard[] virtualCardsFromTestResponse = virtualCardService.getVirtualCard();

        assertThat(virtualCardsFromTestResponse[0].getBalanceCents().equals("5000"));
        assertThat(virtualCardsFromTestResponse[0].getDisplayName().equals("Thinh's Card"));
        assertThat(virtualCardsFromTestResponse[0].getId().equals("123"));
    }
}
