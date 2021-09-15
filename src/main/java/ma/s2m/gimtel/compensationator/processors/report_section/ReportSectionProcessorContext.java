package ma.s2m.gimtel.compensationator.processors.report_section;

import ma.s2m.gimtel.compensationator.processors.CompensationChainGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class ReportSectionProcessorContext implements CompensationChainGenerator {

    private ReportSectionProcessorStrategy reportSectionProcessorStrategy;
    private CompensationChainGenerator next = null;


    public ReportSectionProcessorContext(@Value("${compensation.version}") String version, ApplicationContext context){
        reportSectionProcessorStrategy = (ReportSectionProcessorStrategy)context.getBean("v" + version + "ReportSectionProcessorStrategy");
    }


    @Override
    public void setNextInChain(CompensationChainGenerator compensationChainGenerator) {
        next = compensationChainGenerator;
    }


    @Override
    public void process(FileWriter writer) throws Exception{
        this.reportSectionProcessorStrategy.execute(writer);
        if(next != null)
         next.process(writer);

    }

}
