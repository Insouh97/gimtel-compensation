package ma.s2m.gimtel.compensationator.processors.summary_section.impl;

import ma.s2m.gimtel.compensationator.processors.summary_section.SummarySectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;


@Component
public class V1SummarySectionProcessorStrategy implements SummarySectionProcessorStrategy {

    @Override
    public byte [] execute(byte [] bytes) throws Exception {

        StringBuilder summaryBuilder = new StringBuilder();

        summaryBuilder.append("SS (1)\n");
        summaryBuilder.append("SR# " +
                //Nbr Total Trx
                15 + " , " +
                //Net Settlment Amount
                180000 + " , " +
                //Nbr TRX CR
                250 + " , " +
                //Total CR
                10 + " , "+
                //Nbr TRX DB
                25 + " , " +
                //Total DB
                500 + " , " +
                //Nbr Inter Fee CR
                145 + " , " +
                //Total Inter Fee CR
                254 + " , " +
                //Nbr Inter Fee DB
                98 + " , " +
                //Total Inter Fee DB
                24000 + " , " +
                //Nbr SVC Fee
                86 + " , " +
                //Total SVC Fee
                710 + "\n"
        );

        byte [] summarySection = summaryBuilder.toString().getBytes();
        byte[] allByteArray = new byte[bytes.length + summarySection.length];
        ByteBuffer buff = ByteBuffer.wrap(allByteArray);
        buff.put(bytes);
        buff.put(summarySection);
        return buff.array();

    }
}
