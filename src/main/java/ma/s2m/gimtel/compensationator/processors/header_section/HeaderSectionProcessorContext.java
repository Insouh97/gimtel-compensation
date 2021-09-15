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
        headerSectionProcessorStrategy = (HeaderSectionProcessorStrategy)context.getBean(version + "HeaderSectionProcessorStrategy");
    }


    @Override
    public void setNextInChain(CompensationChainGenerator compensationChainGenerator) {
        next = compensationChainGenerator;
    }


    @Override
    public void process(FileWriter writer, String version) throws Exception{
        this.headerSectionProcessorStrategy.execute(writer);
        if(next != null)
         next.process(writer,version);

    }

}
