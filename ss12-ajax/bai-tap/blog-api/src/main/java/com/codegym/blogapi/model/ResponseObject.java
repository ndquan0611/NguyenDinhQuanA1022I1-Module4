package com.codegym.blogapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseObject {
    private String status;
    private String message;
    private Object data;
}
