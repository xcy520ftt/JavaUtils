package com.heima.travel.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.ResourceBundle;

/**
 * @package com.heima.travel.utils
 * @description: 发送邮件工具类
 * @author: 许超越
 * @date 2019/5/12 16:26
 * @version: V1.0
 */
public class SendEmail {
    private static String host;
    private static String charset;
    private static String user;
    private static String password;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("email");
        host = bundle.getString("host");
        charset = bundle.getString("charset");
        user = bundle.getString("user");
        password = bundle.getString("password");
    }

    /**
     * 发送邮件
     */
    public static void sendEmail(String emailTo, String msg) throws EmailException {
        // 创建发送邮件对象
        HtmlEmail email = new HtmlEmail();

        //配置参数
        email.setHostName(host);
        email.setCharset(charset);

        //设置授权信息
        email.setAuthentication(user,password);

        //设置邮件收发对象
        email.setFrom(user, "qq邮箱");
        email.addTo(emailTo, "qq邮箱" );

        //设置邮件主题和正文
        email.setSubject("【黑马旅游官方网站】");
        email.setMsg(msg);

        // 发送邮件
        email.send();
    }
}
