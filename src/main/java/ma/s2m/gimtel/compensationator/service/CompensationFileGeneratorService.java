package ma.s2m.gimtel.compensationator.service;

import ma.s2m.gimtel.compensationator.processors.fee_section.FeeSectionProcessorContext;
import ma.s2m.gimtel.compensationator.processors.header_section.HeaderSectionProcessorContext;
import ma.s2m.gimtel.compensationator.processors.report_section.ReportSectionProcessorContext;
import ma.s2m.gimtel.compensationator.processors.summary_section.SummarySectionProcessorContext;
import ma.s2m.gimtel.compensationator.processors.transaction_section.TransactionSectionProcessorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileWriter;

@Service
public class CompensationFileGeneratorService {


    private HeaderSectionProcessorContext headerSectionProcessorContext;

    private TransactionSectionProcessorContext transactionSectionProcessorContext;


    private FeeSectionProcessorContext feeSectionProcessorContext;

    private ReportSectionProcessorContext reportSectionProcessorContext;

    private SummarySectionProcessorContext summarySectionProcessorContext;


    public CompensationFileGeneratorService(HeaderSectionProcessorContext h,TransactionSectionProcessorContext t,
                                            FeeSectionProcessorContext f,ReportSectionProcessorContext r,
                                            SummarySectionProcessorContext s){

        headerSectionProcessorContext = h;
        transactionSectionProcessorContext = t;
        feeSectionProcessorContext = f;
        reportSectionProcessorContext = r;
        summarySectionProcessorContext = s;
        this.init();
    }

    private void init(){
        headerSectionProcessorContext.setNextInChain(transactionSectionProcessorContext);
        transactionSectionProcessorContext.setNextInChain(feeSectionProcessorContext);
        feeSectionProcessorContext.setNextInChain(reportSectionProcessorContext);
        reportSectionProcessorContext.setNextInChain(summarySectionProcessorContext);
    }


    public void handle() throws Exception{
        FileWriter writer = new FileWriter("C:\\Users\\Dell\\Documents\\outputGimtelCompensation\\output.csv");
        headerSectionProcessorContext.process(writer,"v1");
        writer.close();
    }

}
