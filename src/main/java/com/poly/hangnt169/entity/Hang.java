package com.poly.hangnt169.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "hang")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hang {

    @Id
    @Column(name = "id")
    @GeneratedValue()
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten_hang")
    private String tenHang;

}
