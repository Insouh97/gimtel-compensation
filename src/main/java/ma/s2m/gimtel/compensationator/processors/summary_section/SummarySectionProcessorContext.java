package ma.s2m.gimtel.compensationator.processors.summary_section;

import ma.s2m.gimtel.compensationator.processors.CompensationChainGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileWriter;


@Component
public class SummarySectionProcessorContext implements CompensationChainGenerator {

    private SummarySectionProcessorStrategy summarySectionProcessorStrategy;
    private CompensationChainGenerator next = null;


    public SummarySectionProcessorContext(@Value("${compensation.version}") String version, ApplicationContext context){
        summarySectionProcessorStrategy = (SummarySectionProcessorStrategy)context.getBean("v" + version + "SummarySectionProcessorStrategy");
    }


    @Override
    public void setNextInChain(CompensationChainGenerator compensationChainGenerator) {
        next = compensationChainGenerator;
    }


    @Override
    public byte [] process(byte [] bytes) throws Exception{
        bytes = this.summarySectionProcessorStrategy.execute(bytes);
        if(next != null)
         return next.process(bytes);
        return bytes;

    }

}
