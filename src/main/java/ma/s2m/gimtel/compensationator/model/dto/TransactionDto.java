package ma.s2m.gimtel.compensationator.model.dto;

public class TransactionDto {

    private Long id;
    private String trType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrType() {
        return trType;
    }

    public void setTrType(String trType) {
        this.trType = trType;
    }

    public TransactionDto(Long id, String trType) {
        this.id = id;
        this.trType = trType;
    }
}
