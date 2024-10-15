package com.eergun.mobilet.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ErrorMessage {
    private int code;
    private String message;
    private Boolean success;
    private List<String> fields;
}