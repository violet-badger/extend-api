package com.extend.virtualcardapi.client;

import com.extend.virtualcardapi.config.ExtendClientConfig;
import com.extend.virtualcardapi.models.*;
import com.extend.virtualcardapi.models.response.LogInResponse;
import com.extend.virtualcardapi.models.response.VirtualCardResponse;
import com.extend.virtualcardapi.models.response.VirtualCardTransactionResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class ExtendClient {
    private static final String SIGN_IN = "signin";
    private static final String TRANSACTION = "transactions";
    private static final String VIRTUAL_CARDS = "virtualcards";

    private static final String STATUS = "status";

    private final RestTemplate restTemplate;
    private HttpHeaders headers;

    private final String url;
    private final String apiVersion;

    private String token;

    public ExtendClient(ExtendClientConfig extendClientConfig) {
        restTemplate = new RestTemplateBuilder()
                .build();
        this.url = extendClientConfig.getUrl();
        this.apiVersion = extendClientConfig.getApiVersion();
        setHeaders(extendClientConfig.getApiVersion());
        signIn(extendClientConfig.getEmail(), extendClientConfig.getPassword());
    }

    public Transaction getTransactionDetails(String transactionId) {
        HttpEntity<Void> entity = new HttpEntity<>(getAuthorizedHeaders());
        return restTemplate.exchange(url + TRANSACTION + "/" + transactionId, HttpMethod.GET, entity, Transaction.class).getBody();
    }

    public VirtualCardTransactionResponse getTransactions(String virtualCardId, Status status) {
        HttpEntity<Void> entity = new HttpEntity<>(getAuthorizedHeaders());
        return restTemplate.exchange(url + VIRTUAL_CARDS + "/" + virtualCardId + "/" + TRANSACTION + "?" + STATUS + "=" + status.getCode(),
                HttpMethod.GET, entity, VirtualCardTransactionResponse.class).getBody();
    }

    public VirtualCardResponse getVirtualCard() {
        HttpEntity<Void> entity = new HttpEntity<>(getAuthorizedHeaders());
        return restTemplate.exchange(url + VIRTUAL_CARDS, HttpMethod.GET, entity, VirtualCardResponse.class).getBody();
    }

    public void signIn(String email, String password) {
        LogInInfo logInInfo = LogInInfo.builder()
                .email(email)
                .password(password)
                .build();
        HttpEntity<LogInInfo> entity = new HttpEntity<>(logInInfo, getHeaders());
        LogInResponse logInReponse = restTemplate.exchange(url + SIGN_IN, HttpMethod.POST, entity, LogInResponse.class).getBody();
        this.token = logInReponse.getToken();
    }

    private void setHeaders(String apiVersion) {
        this.headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.valueOf(apiVersion)));
    }

    private HttpHeaders getAuthorizedHeaders() {
        HttpHeaders httpHeaders = getHeaders();
        httpHeaders.setBearerAuth(token);
        return httpHeaders;
    }

    private HttpHeaders getHeaders() {
        return this.headers;
    }
}
