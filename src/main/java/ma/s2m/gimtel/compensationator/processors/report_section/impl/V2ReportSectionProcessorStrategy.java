package ma.s2m.gimtel.compensationator.processors.report_section.impl;

import ma.s2m.gimtel.compensationator.processors.report_section.ReportSectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


@Component
public class V2ReportSectionProcessorStrategy implements ReportSectionProcessorStrategy {
    @Override
    public void execute(FileWriter writer) throws Exception {

        writer.write("v2RS ("+StaticData.reportDtos.length +")\n");
        Arrays.asList(StaticData.reportDtos).forEach(rr -> {
            try {
                writer.write("RR# " + rr.getId() + " , " + rr.getTitle() +"\n"  );
            }catch (IOException io){io.printStackTrace();}

        });

    }
}
