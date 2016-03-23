//package nl.ocwduo.vzub.autorisatie.filter.performance;
//
//import nl.ocwduo.componenten.logging.performance.domain.PerformanceLoggingConstants;
//import nl.ocwduo.componenten.logging.performance.web.filter.DefaultPerformanceLoggingFilter;
//import nl.ocwduo.logx.api.LogxApi;
//import nl.ocwduo.logx.api.LogxApiHolder;
//import nl.ocwduo.logx.api.LogxException;
//import org.slf4j.MDC;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Observable;
//import java.util.Observer;
//
///**
// * Created by in434jag on 22-3-2016.
// */
//@WebFilter
//public class LogxWebServicePerformanceLogFilter extends DefaultPerformanceLoggingFilter implements Observer {
//
//
//    @Override
//    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
//                                    final FilterChain chain) throws IOException, ServletException {
//        try {
//            LogxApiHolder.addObserver(this);
//            super.doFilterInternal(request, response, chain);
//        } catch (LogxException e) {
//            throw new ServletException("Cannot add observer", e);
//        } finally {
//            LogxApiHolder.removeObserver(this);
//        }
//    }
//
//    @Override
//    protected void setAuditContextId() {
//        // cannot know auditcontext id because logx filter comes afterwards.
//        // added this object as an observer of the initialisation of the api
//    }
//
//    public void update(Observable o, Object arg) {
//        if (arg instanceof LogxApi) {
//            final Long acxId = ((LogxApi) arg).opvragenAuditcontextId();
//            if (acxId != null) {
//                MDC.put(PerformanceLoggingConstants.AUDIT_ID_TYPE, "AUDITCONTEXTID");
//                MDC.put(PerformanceLoggingConstants.AUDIT_ID, String.valueOf(acxId));
//            }
//        }
//    }
//}