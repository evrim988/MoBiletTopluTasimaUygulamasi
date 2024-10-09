package com.eergun.mobilet.dto.response;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BaseResponseDto<T> {
	Boolean success;
	String message;
	Integer code;
	T data;
}