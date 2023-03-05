package com.neo.v1.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class WorkerConstants {


    public static final String WORKER_REWARDS_PROGRAM_UPDATE_QUEUE = "${rewards.worker.jms.queue.consumers.type.rewards.program.update}";
    public static final String WORKER_REWARDS_AUTO_CASHBACK_QUEUE = "${rewards.worker.jms.queue.consumers.type.rewards.auto.cashback}";
    public static final String WORKER_REWARDS_AUTO_MILES_QUEUE = "${rewards.worker.jms.queue.consumers.type.rewards.auto.miles}";
    public static final String WORKER_REWARDS_ENROLLMENT_QUEUE = "${rewards.worker.jms.queue.consumers.type.rewards.enrollment}";
    public static final String WORKER_REWARDS_REDEMPTION_STATUS_QUEUE = "${rewards.worker.jms.queue.consumers.type.rewards.redemption.status}";
    public static final String WORKER_REWARDS_EARNED_TOKENS_QUEUE = "${rewards.worker.jms.queue.consumers.type.rewards.earned.tokens}";
    public static final String WORKER_REWARDS_REDEMPTION_MILES_SETTLEMENT_QUEUE = "${rewards.worker.jms.queue.consumers.type.rewards.miles.redemption.settlement}";

    public static final String CODE_TRIGGER_SERVICE_UNAVAILABLE = "GENE-xxxx";
    public static final String MSG_TRIGGER_SERVICE_UNAVAILABLE = "com.neo.rewards.worker.trigger.service.error.message";
    public static final String MSG_AUDIT_TRIGGER_SERVICE_UNAVAILABLE = "com.neo.rewards.worker.trigger.service.error.audit.message";

    public static final String CODE_CUSTOMER_SERVICE_UNAVAILABLE = "DPW-xxxx";
    public static final String MSG_CUSTOMER_SERVICE_UNAVAILABLE = "com.neo.rewards.worker.customer.service.error.message";
    public static final String MSG_AUDIT_CUSTOMER_SERVICE_UNAVAILABLE = "com.neo.rewards.worker.customer.service.error.audit.message";

    public static final String CODE_UPLOADS_SERVICE_UNAVAILABLE = "DPW-xxxx";
    public static final String MSG_UPLOADS_SERVICE_UNAVAILABLE = "com.neo.rewards.worker.uploads.service.error.message";
    public static final String MSG_AUDIT_UPLOADS_SERVICE_UNAVAILABLE = "com.neo.rewards.worker.uploads.service.error.audit.message";

    public static final String CODE_S3_UPLOAD_DOCUMENT_ERROR = "DPW-xxxx";
    public static final String MSG_S3_UPLOAD_DOCUMENT_ERROR = "com.neo.rewards.worker.s3.upload.error.message";
    public static final String MSG_AUDIT_S3_UPLOAD_DOCUMENT_ERROR = "com.neo.rewards.worker.s3.upload.error.audit.message";

    public static final String CODE_S3_DELETE_DOCUMENT_ERROR = "DPW-xxxx";
    public static final String MSG_S3_DELETE_DOCUMENT_ERROR = "com.neo.rewards.worker.s3.delete.error.message";
    public static final String MSG_AUDIT_S3_DELETE_DOCUMENT_ERROR = "com.neo.rewards.worker.s3.delete.error.audit.message";

    public static final String CODE_S3_GET_DOCUMENT_ERROR = "DPW-xxxx";
    public static final String MSG_S3_GET_DOCUMENT_ERROR = "com.neo.rewards.worker.s3.get.error.message";
    public static final String MSG_AUDIT_S3_GET_DOCUMENT_ERROR = "com.neo.rewards.worker.s3.get.error.audit.message";

    public static final String CODE_PDF_PROCESSING_ERROR = "DPW-xxxx";
    public static final String MSG_PDF_PROCESSING_ERROR = "com.neo.rewards.worker.pdf.processing.error.message";
    public static final String MSG_AUDIT_PDF_PROCESSING_ERROR = "com.neo.rewards.worker.pdf.processing.error.audit.message";

    public static final int MAX_PDF_HEIGHT = 750;
    public static final int MAX_PDF_WIDTH = 570;
    public static final int DEFAULT_FLOAT_X = 20;
    public static final int DEFAULT_FLOAT_Y = 20;

    public static final String CONST_HEIGHT = "height";
    public static final String CONST_WIDTH = "width";
    public static final String CONST_X_SCALE = "xScale";
    public static final String CONST_Y_SCALE = "yScale";
}