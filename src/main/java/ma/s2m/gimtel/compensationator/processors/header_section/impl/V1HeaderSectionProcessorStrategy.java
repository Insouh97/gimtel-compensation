package ma.s2m.gimtel.compensationator.processors.header_section.impl;

import ma.s2m.gimtel.compensationator.processors.header_section.HeaderSectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class V1HeaderSectionProcessorStrategy implements HeaderSectionProcessorStrategy {
    @Override
    public void execute(FileWriter writer) throws Exception {
        writer.write(StaticData.BANK_CODE + " , " +
                StaticData.START_DATE + " , " +
                StaticData.END_DATE + " , " +
                StaticData.SEQ_NUMBER + " , " +
                StaticData.GENERATION_DATE + " , " +
                "v1\n"
        );
    }
}
