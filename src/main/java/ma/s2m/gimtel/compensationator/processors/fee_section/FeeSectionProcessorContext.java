package ma.s2m.gimtel.compensationator.processors.fee_section;

import ma.s2m.gimtel.compensationator.processors.CompensationChainGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class FeeSectionProcessorContext implements CompensationChainGenerator {

    private FeeSectionProcessorStrategy feeSectionProcessorStrategy;
    private CompensationChainGenerator next = null;


    public FeeSectionProcessorContext(@Value("${compensation.version}") String version, ApplicationContext context){
        feeSectionProcessorStrategy = (FeeSectionProcessorStrategy)context.getBean(version + "FeeSectionProcessorStrategy");
    }


    @Override
    public void setNextInChain(CompensationChainGenerator compensationChainGenerator) {
        next = compensationChainGenerator;
    }


    @Override
    public void process(FileWriter writer, String version) throws Exception{
        this.feeSectionProcessorStrategy.execute(writer);
        if(next != null)
         next.process(writer,version);

    }

}
