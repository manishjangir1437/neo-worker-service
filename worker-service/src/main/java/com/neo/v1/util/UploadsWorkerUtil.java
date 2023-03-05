package com.neo.v1.util;

import com.neo.core.exception.ServiceException;
import org.apache.tika.Tika;

import java.util.HashMap;
import java.util.Map;

import static com.neo.v1.constants.WorkerConstants.CONST_HEIGHT;
import static com.neo.v1.constants.WorkerConstants.CONST_WIDTH;
import static com.neo.v1.constants.WorkerConstants.CONST_X_SCALE;
import static com.neo.v1.constants.WorkerConstants.CONST_Y_SCALE;
import static com.neo.v1.constants.WorkerConstants.DEFAULT_FLOAT_X;
import static com.neo.v1.constants.WorkerConstants.DEFAULT_FLOAT_Y;
import static com.neo.v1.constants.WorkerConstants.MAX_PDF_HEIGHT;
import static com.neo.v1.constants.WorkerConstants.MAX_PDF_WIDTH;

public class UploadsWorkerUtil {

    private static final Tika tika = new Tika();

    public static Tika getTika() {
        return tika;
    }

    public static String getMimeType(byte[] fileContent) {
        try {
            return getTika().detect(fileContent);
        } catch (Exception ex) {
            throw new ServiceException(null, ex);
        }
    }

    public static Map<String, Integer> getDimensionToDraw(int width, int height) {

        Map<String, Integer> dimension = new HashMap<>();
        int calculatedHeight = 0;
        int calculatedWidth = 0;
        if (width <= MAX_PDF_WIDTH && height <= MAX_PDF_HEIGHT) {
            int remainingWidth = MAX_PDF_WIDTH - width;
            int remainingHeight = MAX_PDF_HEIGHT - height;
            int xScale = (remainingWidth / 2) + DEFAULT_FLOAT_X;
            int yScale = (remainingHeight / 2) + DEFAULT_FLOAT_Y;
            dimension.put(CONST_HEIGHT, height);
            dimension.put(CONST_WIDTH, width);
            dimension.put(CONST_X_SCALE, xScale);
            dimension.put(CONST_Y_SCALE, yScale);
        } else if (width > MAX_PDF_WIDTH && height > MAX_PDF_HEIGHT) {
            int increaseProportionInHeight = (height - MAX_PDF_HEIGHT) / 3;
            int increaseProportionInWidth = (width - MAX_PDF_WIDTH) / 3;
            if (increaseProportionInHeight > increaseProportionInWidth) {
                calculatedHeight = MAX_PDF_HEIGHT;
                int diff = height / MAX_PDF_HEIGHT;
                diff = diff <= 1 ? 2 : diff;
                calculatedWidth = width / diff;
                int xScale = (MAX_PDF_WIDTH - calculatedWidth) / 2;
                dimension.put(CONST_HEIGHT, calculatedHeight);
                dimension.put(CONST_WIDTH, calculatedWidth);
                dimension.put(CONST_X_SCALE, xScale);
                dimension.put(CONST_Y_SCALE, DEFAULT_FLOAT_Y);
            } else {
                calculatedWidth = MAX_PDF_WIDTH;
                int diff = width / MAX_PDF_WIDTH;
                diff = diff <= 1 ? 2 : diff;
                calculatedHeight = height / diff;
                int yScale = (MAX_PDF_HEIGHT - calculatedHeight) / 2;
                dimension.put(CONST_HEIGHT, calculatedHeight);
                dimension.put(CONST_WIDTH, calculatedWidth);
                dimension.put(CONST_X_SCALE, DEFAULT_FLOAT_X);
                dimension.put(CONST_Y_SCALE, yScale);
            }
        } else if (width > MAX_PDF_WIDTH) {
            calculatedWidth = MAX_PDF_WIDTH;
            int diff = width / MAX_PDF_WIDTH;
            diff = diff <= 1 ? 2 : diff;
            calculatedHeight = height / diff;
            int yScale = (MAX_PDF_HEIGHT - calculatedHeight) / 2;
            dimension.put(CONST_HEIGHT, calculatedHeight);
            dimension.put(CONST_WIDTH, calculatedWidth);
            dimension.put(CONST_X_SCALE, DEFAULT_FLOAT_X);
            dimension.put(CONST_Y_SCALE, yScale);

        } else if (height > MAX_PDF_HEIGHT) {
            calculatedHeight = MAX_PDF_HEIGHT;
            int diff = height / MAX_PDF_HEIGHT;
            diff = diff <= 1 ? 2 : diff;
            calculatedWidth = width / diff;
            int xScale = (MAX_PDF_WIDTH - calculatedWidth) / 2;
            dimension.put(CONST_HEIGHT, calculatedHeight);
            dimension.put(CONST_WIDTH, calculatedWidth);
            dimension.put(CONST_X_SCALE, xScale);
            dimension.put(CONST_Y_SCALE, DEFAULT_FLOAT_Y);
        }
        return dimension;
    }


}
