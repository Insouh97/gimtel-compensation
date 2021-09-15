package ma.s2m.gimtel.compensationator.processors.fee_section;

import java.io.FileWriter;

public interface FeeSectionProcessorStrategy {

    public byte []  execute(byte [] bytes) throws Exception;

}
