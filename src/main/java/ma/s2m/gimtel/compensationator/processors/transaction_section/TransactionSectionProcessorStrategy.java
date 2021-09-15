package ma.s2m.gimtel.compensationator.processors.transaction_section;

import java.io.FileWriter;

public interface TransactionSectionProcessorStrategy {

    public void execute(FileWriter writer) throws Exception;

}
