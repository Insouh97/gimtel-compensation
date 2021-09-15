package ma.s2m.gimtel.compensationator.processors.fee_section.impl;

import ma.s2m.gimtel.compensationator.processors.fee_section.FeeSectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

@Component
public class V1FeeSectionProcessorStrategy implements FeeSectionProcessorStrategy {
    @Override
    public void execute(FileWriter writer) throws Exception {

        writer.write("FS ("+StaticData.feeDtos.length +")\n");
        Arrays.asList(StaticData.feeDtos).forEach(fr -> {
            try {
                writer.write("FR#  " + fr.getId() + " , " + fr.getFee() +"\n"  );
            }catch (IOException io){io.printStackTrace();}

        });
    }
}
