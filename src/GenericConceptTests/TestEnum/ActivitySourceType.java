package GenericConceptTests.TestEnum;

/**
 * Created by weizhou on 3/18/16.
 */
public enum  ActivitySourceType {
    Modem("Modem"),
    SDCard("SDCard"),
    Bluetooth("Bluetooth"),
    User("User"),
    System("System"),

    SmartCard("SmartCard"),
    DirectConnect("DirectConnect"),
    MemoryCard("MemoryCard"),
    XMLImport("XMLImport"),
    EP2Import("EP2Import");


    private String sourceType;

    ActivitySourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public String toString() {
        return sourceType;
    }
}
