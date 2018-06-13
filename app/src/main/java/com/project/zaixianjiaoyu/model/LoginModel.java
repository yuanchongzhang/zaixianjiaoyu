package com.project.zaixianjiaoyu.model;

public class LoginModel {


    /**
     * UserID : 39493b7b-5a16-4254-800c-355b7b1ac729
     * LoginResult : true
     * ErrorMessage :
     * token : xywI9DLOUO7Se7mdg8eRk9oo/FjgybROfedfXsLC4hDnNZNpKuPtyh0A4h5mCWGDJi+c1NnufRLZoopJ0nto9lJHY1osz2R3eybmj7aHzX4x7BAKYLVK7XOZu8x0WdqDb0+ne5omSxxyl6XCsm8s+pX0wpARZZdLzoEyrTUXuBu80W3piIBOFh2tUxp7ffMiFzs6++dNd+ru0Nr/Efzit+VxHl46EfXuECRDzgxeph+NlFAI9PmJtZwSRI/8Y0xuXDWrDEd0X9MWdy5tLTbYfOHr8D56NIM/+ncA6DsA/fl2zwsRHMAUcDByb5VB1TnzHkuDY0RHHTCb9EZ43M3xB/67j6L/sYCKaHx/A4OokP05XXtcgi+s/25GymjEGYTUANFZMQmQTfaPO/3L+IVrqTrk2iOoOH/Mkm2LuFUTvsKlJ+d9d40oBdQQhiVEBK84aDMyJKYUFQLrTP8w9kFJv6is3oskbdTtRv72U30yVhmcsGDdbwXLp/SjPL8bhXeMY8SpmJavWkAer2pQjtiJPHAn6pkHfrf6wtdTZVDYQdZjSTj3Sf/j5zuLnWR6dBq792kmmseQD1DTwHjisxwxWRGfSgTN4kEF3eqf5gDlQcy/shkJ27MVozJGXSSagvLVRoDNAcQPNcwTAECei3pJCcrK11zEj4NgI/9yfUZycmb3FsqH4M3VL+iPp9R54FSR9HHxf2Pg39OqBhjm0dpP5rihRlNmiBiiByxdgZMDWOfVbYSTuFPif80TXl41Md40fSqYWeNULOVp5miHcwErCALUZ0OE3yBpFxbHiFnoe1eEgQdq23NVXw==
     */

    private String UserID;
    private boolean LoginResult;
    private String ErrorMessage;
    private String token;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public boolean isLoginResult() {
        return LoginResult;
    }

    public void setLoginResult(boolean LoginResult) {
        this.LoginResult = LoginResult;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
