package web.webappTest.utils;

import web.webapp.ResultResponse;
import web.webapp.enums.TypeOfRequest;

import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckUtil {

    public static void checkOkResponse(ResultResponse response, TypeOfRequest typeOfRequest) {
        checkNotNullValue(response);
        Response.Status status;
        switch (typeOfRequest) {
            case POST: {
                status = Response.Status.CREATED;
                break;
            }
            case DELETE: {
                status = Response.Status.NO_CONTENT;
                break;
            }
            default: {
                status = Response.Status.OK;
            }
            assertThat(response.getState(), is(status.getReasonPhrase()));
            assertThat(response.getCode(), is(status.getStatusCode()));
        }
    }

    public static void checkErrorResponse(ResultResponse response) {
        checkNotNullValue(response);
        Response.Status status = Response.Status.BAD_REQUEST;
        assertThat(response.getState(), is(status.getReasonPhrase()));
        assertThat(response.getCode(), is(status.getStatusCode()));
    }

    private static void checkNotNullValue(ResultResponse response){
        assertThat(response, notNullValue());
        assertThat(response.getCode(), notNullValue());
        assertThat(response.getState(), notNullValue());
        assertThat(response.getResult(), notNullValue());
    }

}


