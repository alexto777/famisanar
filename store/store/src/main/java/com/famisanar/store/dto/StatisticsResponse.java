package com.famisanar.store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticsResponse {

    private String mostSoldProduct;
    private String leastSoldProduct;
    private Double totalSales;
    private Double averageSales;
}