package inperceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

public class LoginInperceptor extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Object username = ServletActionContext.getContext().getSession().get("username");
        Object password = ServletActionContext.getContext().getSession().get("password");
        if (username.equals("")&&password.equals("")){
            return "login";
        }
        return actionInvocation.invoke();
    }
}
