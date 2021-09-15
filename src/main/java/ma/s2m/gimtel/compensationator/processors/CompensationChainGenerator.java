package ma.s2m.gimtel.compensationator.processors;

import java.io.FileWriter;

public interface CompensationChainGenerator {

    public void setNextInChain(CompensationChainGenerator compensationChainGenerator);
    public void process(FileWriter writer,String version) throws Exception;
}
