//package nl.ocwduo.vzub.autorisatie.filter.performance;
//
//import nl.ocwduo.componenten.logging.performance.domain.PerformanceLoggingConstants;
//import nl.ocwduo.logx.api.LogxApiHolder;
//import nl.ocwduo.logx.api.LogxException;
//import org.slf4j.MDC;
//
//import javax.servlet.ServletRequestEvent;
//import javax.servlet.ServletRequestListener;
//import javax.servlet.annotation.WebFilter;
//import java.util.Observable;
//import java.util.Observer;
//
///**
// * Created by in434jag on 22-3-2016.
// */
//@WebFilter
//public class ServletRequestPerformanceLogFilter implements ServletRequestListener, Observer {
//
//    @Override
//    public void requestInitialized(ServletRequestEvent sre) {
//        try {
//            LogxApiHolder.addObserver(this);
//        } catch (LogxException e) {
//            throw new RuntimeException(e.getMessage(), e);
//        }
//    }
//
//    @Override
//    public void update(Observable o, Object arg) {
//        final Long authentication = LogxApiHolder.get().opvragenAuditcontextId();
//        if (authentication != null && authentication != 0) {
//            MDC.put(PerformanceLoggingConstants.AUDIT_ID_TYPE, "AUDITCONTEXTID");
//            MDC.put(PerformanceLoggingConstants.AUDIT_ID, String.valueOf(authentication));
//        }
//    }
//
//    @Override
//    public void requestDestroyed(ServletRequestEvent sre) {
//        LogxApiHolder.removeObserver(this);
//    }
//}