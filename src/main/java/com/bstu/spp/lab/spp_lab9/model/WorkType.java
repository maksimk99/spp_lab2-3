package com.bstu.spp.lab.spp_lab9.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WorkType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer workTypeId;
    private String workTypeName;
}
