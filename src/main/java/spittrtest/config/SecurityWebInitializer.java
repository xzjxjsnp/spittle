package spittrtest.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
}
