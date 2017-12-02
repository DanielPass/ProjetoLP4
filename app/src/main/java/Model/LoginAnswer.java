package Model;

/**
 * Created by Alexsander on 01/12/2017.
 */

public class LoginAnswer {

    private String status;
    private String token;
    private String message;

    public LoginAnswer(){}

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
