package web.webapp;

import web.webapp.model.Project;

import javax.ws.rs.core.Response;
import java.util.List;


public class ResultResponse {
    private List<Project> result;
    private int code;
    private String message;
    private String state;

    ResultResponse() {
        Response.Status status = Response.Status.OK;
        code = status.getStatusCode();
        state = status.getReasonPhrase();
    }


    public ResultResponse(List<Project> result) {
        this();
        if (result != null && !result.isEmpty()) {
            this.result = result;
        } else {
            setBadRequest();
            message = "Проекты не найдены";
        }
    }

    public ResultResponse(Boolean result, TypeOfRequest typeOfRequest) {
        this();
        switch (typeOfRequest) {
            case POST:
                if (result) {
                    Response.Status status = Response.Status.ACCEPTED;
                    code = status.getStatusCode();
                    state = status.getReasonPhrase();
                }else{
                    setBadRequest();
                    message = "Ошибка входных параметров";
                }
                break;
            case PUT:
            case DELETE:
                if (!result) {
                    setBadRequest();
                    message = "Проект не найден";
                }
        }
    }

    private void setBadRequest(){
        Response.Status status = Response.Status.BAD_REQUEST;
        code = status.getStatusCode();
        state = status.getReasonPhrase();
    }

}
