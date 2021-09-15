package ma.s2m.gimtel.compensationator.processors.transaction_section;

import ma.s2m.gimtel.compensationator.processors.CompensationChainGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class TransactionSectionProcessorContext implements CompensationChainGenerator {

    private TransactionSectionProcessorStrategy transactionSectionProcessorStrategy;
    private CompensationChainGenerator next = null;


    public TransactionSectionProcessorContext(@Value("${compensation.version}") String version, ApplicationContext context){
        transactionSectionProcessorStrategy = (TransactionSectionProcessorStrategy)context.getBean(version + "TransactionSectionProcessorStrategy");
    }


    @Override
    public void setNextInChain(CompensationChainGenerator compensationChainGenerator) {
        next = compensationChainGenerator;
    }


    @Override
    public void process(FileWriter writer, String version) throws Exception{
        this.transactionSectionProcessorStrategy.execute(writer);
        if(next != null)
         next.process(writer,version);

    }

}
