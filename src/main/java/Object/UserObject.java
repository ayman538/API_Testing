package Object;

import Model.RequestModel.UserReqModel;

public class UserObject {
    public static UserReqModel UserInfo(int id ,String username , String firstName , String lastName,String email, String password , String phone , int userStatus)  {
        UserReqModel UserReqModelObj = new UserReqModel();
        UserReqModelObj.id=id;
        UserReqModelObj.username=username;
        UserReqModelObj.firstName=firstName;
        UserReqModelObj.lastName=lastName;
        UserReqModelObj.email=email;
        UserReqModelObj.password=password;
        UserReqModelObj.phone=phone;
        UserReqModelObj.userStatus=userStatus;
        return UserReqModelObj;
    }
}
