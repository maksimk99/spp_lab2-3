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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Job {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer jobId;
    @NotBlank(message = "description can't be null")
    private String description;
    @NotNull(message = "price can't be null")
    private BigDecimal price;
    @NotNull(message = "position count can't be null")
    @Min(value = 1, message = "position count can't be less than 1")
    private Integer positionCount;
    private Integer occupiedCount;
    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne(optional = false)
    @JoinColumn(name = "work_type_id")
    private WorkType workType;
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
