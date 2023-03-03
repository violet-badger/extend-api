package com.extend.virtualcardapi.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LogInInfo {
    String email;
    String password;
}
