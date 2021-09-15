package ma.s2m.gimtel.compensationator.processors.transaction_section.impl;

import ma.s2m.gimtel.compensationator.processors.transaction_section.TransactionSectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


@Component
public class V1TransactionSectionProcessorStrategy implements TransactionSectionProcessorStrategy {
    @Override
    public void execute(FileWriter writer) throws Exception {

        writer.write("TS ("+StaticData.transactionDtos.length +")\n");
        Arrays.asList(StaticData.transactionDtos).forEach(tr -> {
            try {
                writer.write("TR#  " + tr.getId() + " , " + tr.getTrType() +"\n"  );
            }catch (IOException io){io.printStackTrace();}

        });
    }
}
