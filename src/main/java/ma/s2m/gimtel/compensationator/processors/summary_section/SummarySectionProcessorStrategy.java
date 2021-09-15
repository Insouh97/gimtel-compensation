package ma.s2m.gimtel.compensationator.processors.summary_section;

import java.io.FileWriter;

public interface SummarySectionProcessorStrategy {

    public void execute(FileWriter writer) throws Exception;

}
