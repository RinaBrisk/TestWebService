package web.webapp;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMsg {

    MISSING_FIELD_URL("Missing field: Url"),
    INCORRECT_FIELD_URL("incorrect field: Url"),
    PROJECT_NOT_FOUND("Project not found");

    public String text;

}
