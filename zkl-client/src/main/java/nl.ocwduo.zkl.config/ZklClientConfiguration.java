package nl.ocwduo.zkl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

/**
 * Created by Machiel de Jager on 24-2-2016.
 */
@Configuration
public class ZklClientConfiguration {

    @Value("#{ systemProperties['zkl.endpoint'] }")
    private String zklEndpoint;
    @Value("#{ systemProperties['zkl.user.esb'] }")
    private String zklUserEsb;
    @Value("#{ systemProperties['zkl.password.esb'] }")
    private String zklPasswordEsb;
    @Value("#{ systemProperties['zkl.read.timeout'] }")
    private String zklReadTimeout;
    @Value("#{ systemProperties['zkl.connect.timeout'] }")
    private String zklConnectTimeout;

    @Bean
    public JaxWsPortProxyFactoryBean zakelijkeKlantClient() {
        JaxWsPortProxyFactoryBean bean = new JaxWsPortProxyFactoryBean();
//        bean.setServiceInterface();
//        bean.setWsdlDocumentUrl();
//        bean.setNamespaceUri();
//        bean.setServiceName();
        bean.addCustomProperty("endpointAddress", zklEndpoint);
        bean.addCustomProperty("username", zklUserEsb);
        bean.addCustomProperty("password", zklPasswordEsb);
        bean.addCustomProperty("com.sun.xml.ws.request.timeout", zklReadTimeout);
        bean.addCustomProperty("com.sun.xml.ws.connect.timeout", zklConnectTimeout);
        bean.addCustomProperty("com.sun.xml.internal.ws.request.timeout", zklReadTimeout);
        bean.addCustomProperty("com.sun.xml.internal.ws.connect.timeout", zklConnectTimeout);
        return bean;
    }
//    <bean id="zakelijkeKlantClient" class="org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean">
//    <property name="serviceInterface" value="nl.duo.contract.zkl_zakelijke_klant_rpl_v1.ZKLZakelijkeKlantRPLV1PortType"/>
//    <property name="wsdlDocumentUrl" value="classpath:wsdl/ZKL_Zakelijke_Klant_RPL_V1.wsdl" />
//    <property name="namespaceUri" value="http://duo.nl/contract/ZKL_Zakelijke_Klant_RPL_V1" />
//    <property name="serviceName" value="ZKL_Zakelijke_Klant_RPL_V1" />
//    </bean>
}
