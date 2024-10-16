package com.eergun.mobilet.view;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VwTapping {
	private String message;
	private String stationName;
}