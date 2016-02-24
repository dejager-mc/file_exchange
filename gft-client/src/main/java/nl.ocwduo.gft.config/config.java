package nl.ocwduo.gft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

/**
 * Created by Machiel de Jager on 24-2-2016.
 */
@Configuration
public class config {

    @Bean
    public JaxWsPortProxyFactoryBean zakelijkeKlantClient() {
//        JaxWsPortProxyFactoryBean bean = new JaxWsPortProxyFactoryBean();
//        bean.setServiceInterface();
//        bean.setWsdlDocumentUrl();
        return null;
    }

//    <bean id="zakelijkeKlantClient" class="org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean">
//    <property name="serviceInterface" value="nl.duo.contract.zkl_zakelijke_klant_rpl_v1.ZKLZakelijkeKlantRPLV1PortType"/>
//    <property name="wsdlDocumentUrl" value="classpath:wsdl/ZKL_Zakelijke_Klant_RPL_V1.wsdl" />
//    <property name="namespaceUri" value="http://duo.nl/contract/ZKL_Zakelijke_Klant_RPL_V1" />
//    <property name="serviceName" value="ZKL_Zakelijke_Klant_RPL_V1" />
//    <property name="endpointAddress" value="${ENDPOINT}"/>
//    <property name="username" value="${USERNAMEESB}"/>
//    <property name="password" value="${PASSWORDESB}"/>
//    <property name="customProperties">
//    <map>
//    <entry key="com.sun.xml.ws.request.timeout">
//    <value type="java.lang.Integer">${READTIMEOUT}</value>
//    </entry>
//    <entry key="com.sun.xml.internal.ws.request.timeout">
//    <value type="java.lang.Integer">${READTIMEOUT}</value>
//    </entry>
//    <entry key="com.sun.xml.ws.connect.timeout">
//    <value type="java.lang.Integer">${CONNECTTIMEOUT}</value>
//    </entry>
//    <entry key="com.sun.xml.internal.ws.connect.timeout">
//    <value type="java.lang.Integer">${CONNECTTIMEOUT}</value>
//    </entry>
//    </map>
//    </property>
//    </bean>
}
