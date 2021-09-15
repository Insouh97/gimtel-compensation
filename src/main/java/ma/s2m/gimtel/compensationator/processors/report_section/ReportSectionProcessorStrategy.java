package ma.s2m.gimtel.compensationator.processors.report_section;

import java.io.FileWriter;

public interface ReportSectionProcessorStrategy {

    public byte [] execute(byte [] bytes) throws Exception;

}
