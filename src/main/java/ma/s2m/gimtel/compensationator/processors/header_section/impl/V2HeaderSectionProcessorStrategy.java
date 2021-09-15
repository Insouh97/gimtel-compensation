package ma.s2m.gimtel.compensationator.processors.header_section.impl;

import ma.s2m.gimtel.compensationator.processors.header_section.HeaderSectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.nio.ByteBuffer;

@Component
public class V2HeaderSectionProcessorStrategy implements HeaderSectionProcessorStrategy {

    @Override
    public byte [] execute(byte [] bytes) throws Exception {

        StringBuilder headerBuilder = new StringBuilder();

        headerBuilder.append(StaticData.BANK_CODE + " , " +
                StaticData.START_DATE + " , " +
                StaticData.END_DATE + " , " +
                StaticData.SEQ_NUMBER + " , " +
                StaticData.GENERATION_DATE + " , " +
                "v2\n"
        );

        byte [] headerSection = headerBuilder.toString().getBytes();
        byte[] allByteArray = new byte[bytes.length + headerSection.length];
        ByteBuffer buff = ByteBuffer.wrap(allByteArray);
        buff.put(bytes);
        buff.put(headerSection);
        return buff.array();
    }
}
