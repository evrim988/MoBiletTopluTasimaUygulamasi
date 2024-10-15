package com.eergun.mobilet.dto.response;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BaseResponse<T> {
	Boolean success;
	String message;
	Integer code;
	T data;
}