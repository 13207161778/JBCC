package inperceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class LoginMetnod extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object username = ServletActionContext.getContext().getSession().get("username");
        Object password = ServletActionContext.getContext().getSession().get("password");
        System.out.println(username+"  ---- "+password);
        if (username==null&&password==null){
            return "login";
        }
        return actionInvocation.invoke();
    }
}
