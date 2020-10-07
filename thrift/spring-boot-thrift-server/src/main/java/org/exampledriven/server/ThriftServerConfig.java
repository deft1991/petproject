package org.exampledriven.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.exampledriven.BookService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThriftServerConfig {

    @Bean
    public ServletRegistrationBean thriftBookServlet(TProtocolFactory protocolFactory, BookServiceHandler handler) {
        TServlet tServlet = new TServlet(new BookService.Processor<>(handler), protocolFactory);

        return new ServletRegistrationBean(tServlet, "/book");
    }

    @Bean
    @ConditionalOnMissingBean(TProtocolFactory.class)
    TProtocolFactory thriftProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }
}
