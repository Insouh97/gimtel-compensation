package ma.s2m.gimtel.compensationator.processors.fee_section.impl;

import ma.s2m.gimtel.compensationator.processors.fee_section.FeeSectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

@Component
public class V1FeeSectionProcessorStrategy implements FeeSectionProcessorStrategy {

    @Override
    public byte [] execute(byte [] bytes) throws Exception {

        StringBuilder feeBuilder = new StringBuilder();
        feeBuilder.append("FS ("+StaticData.feeDtos.length +")\n");

        Arrays.asList(StaticData.feeDtos).forEach(fr -> {
            feeBuilder.append("FR#  " + fr.getId() + " , " + fr.getFee() +"\n"  );
        });

        byte [] feeSection = feeBuilder.toString().getBytes();
        byte[] allByteArray = new byte[bytes.length + feeSection.length];
        ByteBuffer buff = ByteBuffer.wrap(allByteArray);
        buff.put(bytes);
        buff.put(feeSection);
        return buff.array();
    }
}
