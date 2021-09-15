package ma.s2m.gimtel.compensationator.processors.transaction_section.impl;

import ma.s2m.gimtel.compensationator.processors.transaction_section.TransactionSectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;


@Component
public class V1TransactionSectionProcessorStrategy implements TransactionSectionProcessorStrategy {

    @Override
    public byte [] execute(byte [] bytes) throws Exception {

        StringBuilder transactionBuilder = new StringBuilder();

        transactionBuilder.append("TS ("+StaticData.transactionDtos.length +")\n");
        Arrays.asList(StaticData.transactionDtos).forEach(tr -> {

                transactionBuilder.append("TR#  " + tr.getId() + " , " + tr.getTrType() +"\n"  );
        });

        byte [] transactionSection = transactionBuilder.toString().getBytes();
        byte[] allByteArray = new byte[bytes.length + transactionSection.length];
        ByteBuffer buff = ByteBuffer.wrap(allByteArray);
        buff.put(bytes);
        buff.put(transactionSection);

        return buff.array();
    }
}
