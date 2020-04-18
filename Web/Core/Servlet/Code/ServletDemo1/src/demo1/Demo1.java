package demo1;


import javax.servlet.*;
import java.io.IOException;

public class Demo1 implements Servlet {
    // 只会执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // 可以被执行多次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("test");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    // 只被执行一次
    @Override
    public void destroy() {
        System.out.println("destroy");

    }
}



