package GenericConceptTests.TestLambda;

import java.util.UUID;

/**
 * Created by weizhou on 4/5/16.
 */
public class DataGenerator {
    public UploadMetaData generateData(String deviceSerial, String dataStore) {
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setPatientId(UUID.randomUUID());
        uploadMetaData.setUploadId(UUID.randomUUID());
        uploadMetaData.setUserId(UUID.randomUUID());
        uploadMetaData.setDeviceSerial(deviceSerial);
        uploadMetaData.setDataStoreLocation(dataStore);

        return uploadMetaData;
    }

    public String generateUUIDString() {
        return UUID.randomUUID().toString();
    }
}
