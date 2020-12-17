package adapter.compatible;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.io.Serializable;

// log4j日志框架的适配器
// Log4jLoggerAdapter实现了LocationAwareLogger接口，
// 其中LocationAwareLogger继承自Logger接口，
// 也就相当于Log4jLoggerAdapter实现了Logger接口。
public final class Log4jLoggerAdapter extends MarkerIgnoringBase
        implements LocationAwareLogger, Serializable {
    final transient org.apache.log4j.Logger logger; // log4j
    public static final String FQCN = Log4jLoggerAdapter.class.getName();

    public Log4jLoggerAdapter(Logger logger) {
        this.logger = logger;
    }

    public boolean isTraceEnabled() {
        return false;
    }

    public void trace(String msg) {

    }

    public void trace(String format, Object arg) {

    }

    public void trace(String format, Object arg1, Object arg2) {

    }

    public void trace(String format, Object[] argArray) {

    }

    public void trace(String msg, Throwable t) {

    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public void debug(String msg) {
        logger.log(FQCN, Level.DEBUG, msg, null);
    }

    public void debug(String format, Object arg) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable());
        }
    }

    public void debug(String format, Object arg1, Object arg2) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable());
        }
    }

    public void debug(String format, Object[] argArray) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable());
        }
    }

    public void debug(String msg, Throwable t) {
        logger.log(FQCN, Level.DEBUG, msg, t);
    }
}
