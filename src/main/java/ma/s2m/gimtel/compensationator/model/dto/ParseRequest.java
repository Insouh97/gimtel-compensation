package ma.s2m.gimtel.compensationator.model.dto;

public class ParseRequest {

    private String version;
    private String intputFileName;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIntputFileName() {
        return intputFileName;
    }

    public void setIntputFileName(String intputFileName) {
        this.intputFileName = intputFileName;
    }
}
