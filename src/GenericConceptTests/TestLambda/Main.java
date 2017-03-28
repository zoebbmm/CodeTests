package GenericConceptTests.TestLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by weizhou on 4/5/16.
 */
public class Main {
    public static void main(String[] args) {

        Stream.of("One", "Two", "Three", "Four")
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        DataGenerator dataGenerator = new DataGenerator();
        ArrayList<UploadMetaData> uploadMetaDataArrayList = new ArrayList<>();

        ArrayList<UUID> uuidArrayList = new ArrayList<>();

        UploadMetaData uploadMetaData1 = dataGenerator.generateData("serial-1", "s3-1");
        UploadMetaData uploadMetaData2 = dataGenerator.generateData("serial-1", "s3-2");
        UploadMetaData uploadMetaData3 = dataGenerator.generateData("serial-3", "s3-3");
        UploadMetaData uploadMetaData4 = dataGenerator.generateData("serial-4", "s3-4");
        UploadMetaData uploadMetaData5 = dataGenerator.generateData("serial-5", "s3-5");

        uploadMetaDataArrayList.add(uploadMetaData1);
        uploadMetaDataArrayList.add(uploadMetaData2);
        uploadMetaDataArrayList.add(uploadMetaData3);
        uploadMetaDataArrayList.add(uploadMetaData4);
        uploadMetaDataArrayList.add(uploadMetaData5);

        uuidArrayList.add(uploadMetaData1.getUploadId());
        uuidArrayList.add(uploadMetaData2.getUploadId());

        List<UUID> dataStoreList = uploadMetaDataArrayList.stream().filter(uploadMetaData -> uploadMetaData.getDeviceSerial().equals("serial-1")).map(UploadMetaData::getUploadId).collect(Collectors.toList());
        System.out.println(dataStoreList.get(0));

        System.out.println(uuidArrayList.contains(dataStoreList.get(0)));

        uploadMetaDataArrayList.stream().filter(uploadMetaData -> uuidArrayList.contains(uploadMetaData.getUploadId())).forEach(uploadMetaData -> uploadMetaData.setDeviceSerial("test"));

        System.out.println("done");

        ArrayList<String> strings = new ArrayList<>();
        String str1 = dataGenerator.generateUUIDString();
        String str2 = dataGenerator.generateUUIDString();
        String str3 = dataGenerator.generateUUIDString();
        String str4 = dataGenerator.generateUUIDString();
        String str5 = dataGenerator.generateUUIDString();

        strings.add(str1);
        strings.add(str2);
        strings.add(str3);
        strings.add(str4);
        strings.add(str5);

        List<String> subStrings = strings.subList(0,3);
        System.out.println("*****  " + subStrings.size());

        List<UUID> uuids = strings.stream().map(UUID::fromString).collect(Collectors.toList());

        System.out.println(uuids.get(0));

    }
}
