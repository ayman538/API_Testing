package utils;

import Model.RequestModel.UserReqModel;
import Objects.UserObject;
import Restwrapper.Headers;
import Restwrapper.restwrapper;
import Enum.EndPoints;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class createUserUtils {
    public static UserReqModel getUserResponse() {
        return restwrapper.restGet(EndPoints.USER, Headers.generalHeaders(), UserReqModel.class);
    }
    public static UserReqModel createUserRequest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserReqModel userReqModel = objectMapper.readValue(new File("UserInfo.json"), UserReqModel.class);
        System.out.println(userReqModel.email + "   emaaaail");

        return restwrapper.restPost(EndPoints.USER, Headers.generalHeaders(), objectMapper.writeValueAsString(userReqModel), UserReqModel.class);
    }
}
