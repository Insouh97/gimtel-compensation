package ma.s2m.gimtel.compensationator.processors.report_section.impl;

import ma.s2m.gimtel.compensationator.processors.report_section.ReportSectionProcessorStrategy;
import ma.s2m.gimtel.compensationator.sim.StaticData;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;


@Component
public class V2ReportSectionProcessorStrategy implements ReportSectionProcessorStrategy {

    @Override
    public byte [] execute(byte [] bytes) throws Exception {

        StringBuilder reportBuilder = new StringBuilder();


        reportBuilder.append("v2RS ("+StaticData.reportDtos.length +")\n");
        Arrays.asList(StaticData.reportDtos).forEach(rr -> {

            reportBuilder.append("RR# " + rr.getId() + " , " + rr.getTitle() +"\n"  );
        });

        byte [] reportSection = reportBuilder.toString().getBytes();
        byte[] allByteArray = new byte[bytes.length + reportSection.length];
        ByteBuffer buff = ByteBuffer.wrap(allByteArray);
        buff.put(bytes);
        buff.put(reportSection);
        return buff.array();

    }
}
