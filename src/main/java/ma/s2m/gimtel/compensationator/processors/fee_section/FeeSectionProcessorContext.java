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
        feeSectionProcessorStrategy = (FeeSectionProcessorStrategy)context.getBean("v" + version + "FeeSectionProcessorStrategy");
    }


    @Override
    public void setNextInChain(CompensationChainGenerator compensationChainGenerator) {
        next = compensationChainGenerator;
    }


    @Override
    public byte [] process(byte [] bytes) throws Exception{
        bytes = this.feeSectionProcessorStrategy.execute(bytes);
        if(next != null)
         return  next.process(bytes);
        return bytes;
    }

}
