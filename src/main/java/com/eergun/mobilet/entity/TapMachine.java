package com.eergun.mobilet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbltapmachine")
public class TapMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String machineType;
}
