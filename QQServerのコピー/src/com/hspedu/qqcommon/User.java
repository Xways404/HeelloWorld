package com.hspedu.qqcommon;

import java.io.Serializable;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * クライエントインフォ
 */
public class User implements Serializable {
    //互換性
    private static final long serialVersionUID = 1L;

    private String userId;//ユーザー名
    private String passwd;//ユーザーパスワード

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
