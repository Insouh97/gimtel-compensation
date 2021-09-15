package ma.s2m.gimtel.compensationator.service;

import ma.s2m.gimtel.compensationator.processors.fee_section.FeeSectionProcessorContext;
import ma.s2m.gimtel.compensationator.processors.header_section.HeaderSectionProcessorContext;
import ma.s2m.gimtel.compensationator.processors.report_section.ReportSectionProcessorContext;
import ma.s2m.gimtel.compensationator.processors.summary_section.SummarySectionProcessorContext;
import ma.s2m.gimtel.compensationator.processors.transaction_section.TransactionSectionProcessorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileWriter;

@Service
public class CompensationFileGeneratorService {


    private HeaderSectionProcessorContext headerSectionProcessorContext;

    private TransactionSectionProcessorContext transactionSectionProcessorContext;


    private FeeSectionProcessorContext feeSectionProcessorContext;

    private ReportSectionProcessorContext reportSectionProcessorContext;

    private SummarySectionProcessorContext summarySectionProcessorContext;

    private String outputFileDir;


    public CompensationFileGeneratorService(HeaderSectionProcessorContext h, TransactionSectionProcessorContext t,
                                            FeeSectionProcessorContext f, ReportSectionProcessorContext r,
                                            SummarySectionProcessorContext s,
                                            @Value("${compensation.outputFileDir}") String outputFileDir){

        headerSectionProcessorContext = h;
        transactionSectionProcessorContext = t;
        feeSectionProcessorContext = f;
        reportSectionProcessorContext = r;
        summarySectionProcessorContext = s;
        this.outputFileDir = outputFileDir;
        this.init();
    }

    private void init(){
        headerSectionProcessorContext.setNextInChain(transactionSectionProcessorContext);
        transactionSectionProcessorContext.setNextInChain(feeSectionProcessorContext);
        feeSectionProcessorContext.setNextInChain(reportSectionProcessorContext);
        reportSectionProcessorContext.setNextInChain(summarySectionProcessorContext);
    }


    public void handle() throws Exception{
        FileWriter writer = new FileWriter(this.outputFileDir);
        headerSectionProcessorContext.process(writer);
        writer.close();
    }

}
