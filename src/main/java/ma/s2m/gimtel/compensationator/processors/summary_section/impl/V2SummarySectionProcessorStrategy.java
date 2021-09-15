package ma.s2m.gimtel.compensationator.processors.summary_section.impl;

import ma.s2m.gimtel.compensationator.processors.summary_section.SummarySectionProcessorStrategy;
import org.springframework.stereotype.Component;

import java.io.FileWriter;


@Component
public class V2SummarySectionProcessorStrategy implements SummarySectionProcessorStrategy {
    @Override
    public void execute(FileWriter writer) throws Exception {

        writer.write("v2SS (1)\n");
        writer.write("SR# " +
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

    }
}
