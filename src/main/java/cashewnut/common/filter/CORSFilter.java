package cashewnut.common.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Accept,x-requested-with,remember-me,Authorization,DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,If-Modified-Since,Cache-Control");
        response.setHeader("Access-Control-Allow-Origin", "*");

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}