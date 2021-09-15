package ma.s2m.gimtel.compensationator.model.dto;

public class FeeDto {

    private Long id;
    private Double fee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public FeeDto(Long id, Double fee) {
        this.id = id;
        this.fee = fee;
    }
}
