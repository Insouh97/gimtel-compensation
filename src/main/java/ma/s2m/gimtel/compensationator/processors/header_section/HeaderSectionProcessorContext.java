package ma.s2m.gimtel.compensationator.processors.header_section;

import ma.s2m.gimtel.compensationator.processors.CompensationChainGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class HeaderSectionProcessorContext implements CompensationChainGenerator {

    private HeaderSectionProcessorStrategy headerSectionProcessorStrategy;
    private CompensationChainGenerator next = null;


    public HeaderSectionProcessorContext(@Value("${compensation.version}") String version, ApplicationContext context){
        headerSectionProcessorStrategy = (HeaderSectionProcessorStrategy)context.getBean("v" + version + "HeaderSectionProcessorStrategy");
    }


    @Override
    public void setNextInChain(CompensationChainGenerator compensationChainGenerator) {
        next = compensationChainGenerator;
    }


    @Override
    public byte [] process(byte [] bytes) throws Exception{
        bytes = this.headerSectionProcessorStrategy.execute(bytes);
        if(next != null)
         return next.process(bytes);
        return  bytes;
    }

}
