package web.webapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMsg {

    PROJECTS_NOT_FOUND("Проекты не найдены"),
    PROJECT_NOT_FOUND("Проект не найден"),
    ERROR_IN_INPUT_PARAMS("Ошибка входных параметров");

    public String text;

}
