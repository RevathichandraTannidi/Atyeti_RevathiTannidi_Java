package com.atyeti.inventory.stockMovement.dto.response;

import java.util.List;

public class ReportSummaryDto {
    private List<StockLevelDto> stockLevels;
    private List<TrendDto> movementTrends;
    private List<LowStockAlertDto> alerts;

    public ReportSummaryDto() {}
    public ReportSummaryDto(List<StockLevelDto> stockLevels,
                            List<TrendDto> movementTrends,
                            List<LowStockAlertDto> alerts) {
        this.stockLevels = stockLevels;
        this.movementTrends = movementTrends;
        this.alerts = alerts;
    }

    public List<StockLevelDto> getStockLevels() { return stockLevels; }
    public List<TrendDto> getMovementTrends() { return movementTrends; }
    public List<LowStockAlertDto> getAlerts() { return alerts; }
    public void setStockLevels(List<StockLevelDto> stockLevels) { this.stockLevels = stockLevels; }
    public void setMovementTrends(List<TrendDto> movementTrends) { this.movementTrends = movementTrends; }
    public void setAlerts(List<LowStockAlertDto> alerts) { this.alerts = alerts; }
}
