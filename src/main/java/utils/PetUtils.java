package utils;

import Model.RequestModel.PetReqModel;
import Restwrapper.Headers;
import Restwrapper.restWrapper;
import Enum.EndPoints;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PetUtils {

    static ObjectMapper objectMapper = new ObjectMapper();
    static String filePath = "Config/data.json";

    public static PetReqModel createPetRequest() throws IOException {
        PetReqModel petReqModel = objectMapper.readValue(new File(filePath), PetReqModel.class);

        return restWrapper.restPost(EndPoints.PET, Headers.generalHeaders(), petReqModel, PetReqModel.class);
    }

    public static PetReqModel updatePetRequest(String statusNewValue) throws IOException {
        PetReqModel petReqModel = objectMapper.readValue(new File(filePath), PetReqModel.class);
        petReqModel.status = statusNewValue;

        return restWrapper.restPut(EndPoints.PET, Headers.generalHeaders(), petReqModel, PetReqModel.class);
    }

    public static PetReqModel getPetWithID() throws IOException {
        PetReqModel petReqModel = objectMapper.readValue(new File(filePath), PetReqModel.class);

        return restWrapper.restGet(EndPoints.PET, Headers.generalHeaders(), String.valueOf(petReqModel.id), PetReqModel.class);
    }

    public static int deletePetWithID() throws IOException {
        PetReqModel petReqModel = objectMapper.readValue(new File(filePath), PetReqModel.class);

         return restWrapper.restDelete(EndPoints.PET, Headers.generalHeaders(), String.valueOf(petReqModel.id));
    }
}
