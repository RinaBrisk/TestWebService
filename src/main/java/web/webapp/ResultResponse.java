package web.webapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import web.webapp.enums.ErrorMsg;
import web.webapp.enums.TypeOfRequest;
import web.webapp.model.Project;

import javax.ws.rs.core.Response;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
        this.result = result;
        if (result == null || result.isEmpty()) {
            message = ErrorMsg.PROJECTS_NOT_FOUND.getText();
        }
    }

    public ResultResponse(Boolean result, TypeOfRequest typeOfRequest) {
        this();
        switch (typeOfRequest) {
            case POST:
                if (result) {
                    Response.Status status = Response.Status.CREATED;
                    code = status.getStatusCode();
                    state = status.getReasonPhrase();
                } else {
                    setBadRequest();
                    message = ErrorMsg.ERROR_IN_INPUT_PARAMS.getText();
                }
                break;
            case PUT:
                if (!result) {
                    setBadRequest();
                    message = ErrorMsg.PROJECTS_NOT_FOUND.getText();
                }
                break;
            case DELETE:
                if (result) {
                    Response.Status status = Response.Status.NO_CONTENT;
                    code = status.getStatusCode();
                    state = status.getReasonPhrase();
                } else {
                    setBadRequest();
                    message = ErrorMsg.PROJECT_NOT_FOUND.getText();
                }
                break;
        }
    }

    private void setBadRequest() {
        Response.Status status = Response.Status.BAD_REQUEST;
        code = status.getStatusCode();
        state = status.getReasonPhrase();
    }

}
