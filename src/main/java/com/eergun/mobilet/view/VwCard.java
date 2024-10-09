package com.eergun.mobilet.view;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@AllArgsConstructor
public class VwCard {
	String serialNumber;
	Double remainingUsage;
}