package com.zydata.exception.master;

import com.zydata.exception.BaseException;

public class MasterException extends BaseException {
    public MasterException() {
        super();
    }

    public MasterException(String message) {
        super(message);
    }

    public MasterException(String message, Throwable cause) {
        super(message, cause);
    }

    public MasterException(Throwable cause) {
        super(cause);
    }

    protected MasterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
