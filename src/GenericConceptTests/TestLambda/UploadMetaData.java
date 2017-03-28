package GenericConceptTests.TestLambda;

import java.util.UUID;

public class UploadMetaData {
    private UUID uploadId;

    private UUID userId;

    private UUID patientId;

    private String deviceSerial;

    private String dataStoreLocation;

    public UUID getUploadId() {
        return uploadId;
    }

    public void setUploadId(UUID uploadId) {
        this.uploadId = uploadId;
    }

    public String getDataStoreLocation() {
        return dataStoreLocation;
    }

    public void setDataStoreLocation(String dataStoreLocation) {
        this.dataStoreLocation = dataStoreLocation;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
