package com.atyeti.inventory.stockMovement.dto.response;



public class TrendDto {
    private String productCode;
    private String period;
    private long inflow;
    private long outflow;

    public TrendDto() {}
    public TrendDto(String productCode, String period, long inflow, long outflow) {
        this.productCode = productCode;
        this.period = period;
        this.inflow = inflow;
        this.outflow = outflow;
    }

    public String getProductCode() { return productCode; }
    public String getPeriod() { return period; }
    public long getInflow() { return inflow; }
    public long getOutflow() { return outflow; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public void setPeriod(String period) { this.period = period; }
    public void setInflow(long inflow) { this.inflow = inflow; }
    public void setOutflow(long outflow) { this.outflow = outflow; }
}
