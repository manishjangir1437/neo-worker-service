package com.neo.v1.enums;

import com.neo.core.provider.ServiceKeyMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static com.neo.v1.constants.WorkerConstants.CODE_S3_DELETE_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.CODE_S3_GET_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.CODE_S3_UPLOAD_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.CODE_TRIGGER_SERVICE_UNAVAILABLE;
import static com.neo.v1.constants.WorkerConstants.MSG_AUDIT_S3_DELETE_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.MSG_AUDIT_S3_GET_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.MSG_AUDIT_S3_UPLOAD_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.MSG_AUDIT_TRIGGER_SERVICE_UNAVAILABLE;
import static com.neo.v1.constants.WorkerConstants.MSG_S3_DELETE_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.MSG_S3_GET_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.MSG_S3_UPLOAD_DOCUMENT_ERROR;
import static com.neo.v1.constants.WorkerConstants.MSG_TRIGGER_SERVICE_UNAVAILABLE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;


@Getter
@AllArgsConstructor
public enum WorkerServiceKeyMapping implements ServiceKeyMapping {

    TRIGGER_SERVICE_UNAVAILABLE(CODE_TRIGGER_SERVICE_UNAVAILABLE,
            SERVICE_UNAVAILABLE,
            MSG_TRIGGER_SERVICE_UNAVAILABLE,
            MSG_AUDIT_TRIGGER_SERVICE_UNAVAILABLE),
    S3_UPLOAD_DOCUMENT_ERROR(CODE_S3_UPLOAD_DOCUMENT_ERROR, INTERNAL_SERVER_ERROR, MSG_S3_UPLOAD_DOCUMENT_ERROR,
            MSG_AUDIT_S3_UPLOAD_DOCUMENT_ERROR),
    S3_DELETE_DOCUMENT_ERROR(CODE_S3_DELETE_DOCUMENT_ERROR, INTERNAL_SERVER_ERROR, MSG_S3_DELETE_DOCUMENT_ERROR,
            MSG_AUDIT_S3_DELETE_DOCUMENT_ERROR),
    S3_GET_DOCUMENT_ERROR(CODE_S3_GET_DOCUMENT_ERROR, INTERNAL_SERVER_ERROR, MSG_S3_GET_DOCUMENT_ERROR,
            MSG_AUDIT_S3_GET_DOCUMENT_ERROR);

    private String code;
    private HttpStatus httpStatus;
    private String messageKey;
    private String errorMessageKey;
}