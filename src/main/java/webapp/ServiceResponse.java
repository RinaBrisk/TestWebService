package webapp;

import lombok.Data;

@Data
public class ServiceResponse {

    private String result;
    private String state;

    public  ServiceResponse(String result, String state){
        this.result = result;
        this.state = state;
    }

}
