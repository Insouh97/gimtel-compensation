package ma.s2m.gimtel.compensationator.sim;


import ma.s2m.gimtel.compensationator.model.dto.FeeDto;
import ma.s2m.gimtel.compensationator.model.dto.ReportDto;
import ma.s2m.gimtel.compensationator.model.dto.TransactionDto;

public class StaticData {

    public static final Long BANK_CODE = 3671L;
    public static final String START_DATE = "13/09/2021 00:00";
    public static final String END_DATE = "13/09/2021 02:00";
    public static final String SEQ_NUMBER = "RTEF5R5";
    public static final String GENERATION_DATE = "13/09/2021 02:01";
    public static final String VERSION = "v1.20";

    public static final TransactionDto[] transactionDtos  = {new TransactionDto(1L,"FAST CASH"),new TransactionDto(2L,"WITHDRAWAL"),new TransactionDto(3L,"TRANSFER")};
    public static final FeeDto[] feeDtos = {new FeeDto(1L,120D),new FeeDto(2L,50D)};
    public static final ReportDto[] reportDtos = {new ReportDto(1L,"WITHRAWALS"),new ReportDto(2L,"PIN CHANGE")};



}
