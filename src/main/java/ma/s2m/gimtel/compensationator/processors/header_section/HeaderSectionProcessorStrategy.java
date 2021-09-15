package ma.s2m.gimtel.compensationator.processors.header_section;

import java.io.FileWriter;

public interface HeaderSectionProcessorStrategy {

    public byte [] execute(byte [] bytes) throws Exception;

}
