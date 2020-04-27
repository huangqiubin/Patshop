package com.hqb.patshop.config.shiro;

import com.hqb.patshop.app.login.service.MemberService;
import com.hqb.patshop.mbg.model.UmsMemberDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseRealm extends AuthorizingRealm {

    @Autowired
    private MemberService memberService;
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //能进入到这里，表示账号已经通过验证了
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //通过service获取角色和权限
//        Set<String> permissions = permissionService.listPermissions(userName);
//        Set<String> roles = roleService.listRoleNames(userName);

        //授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        //把通过service获取到的角色和权限放进去
//        s.setStringPermissions(permissions);
//        s.setRoles(roles);
        return s;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String userName = token.getPrincipal().toString();
        String password = new String(t.getPassword());
        //获取数据库中的密码
        UmsMemberDao memberInfo = memberService.getMemberInfo(userName);
        String passwordInDB = memberInfo.getPassword();
//        String salt = memberInfo.getSalt();
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        //盐也放进去
        //这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
        //如果为空就是账号不存在，如果不相同就是密码错误，但是都抛出AuthenticationException，而不是抛出具体错误原因，免得给破解者提供帮助信息
        if (null == passwordInDB || !passwordInDB.equals(password))
            throw new AuthenticationException();
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName, password, getName());
        return a;


//        String mytoken = (String) token.getCredentials();
//        // 解密获得username，用于和数据库进行对比
//        String username = JWTUtil.getUsername(mytoken);
//        if (username == null) {
//            throw new AuthenticationException("token invalid");
//        }
//
//        UmsMemberDao memberInfo = memberService.getMemberInfo(username);
//        if (memberInfo == null) {
//            throw new AuthenticationException("User didn't existed!");
//        }
//
//        if (!JWTUtil.verify(mytoken, username, memberInfo.getPassword())) {
//            throw new AuthenticationException("Username or password error");
//        }
//
//        return new SimpleAuthenticationInfo(token, token, getName());
    }

//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JWTToken;
//    }

    @Override
    public String getName() {
        return "databaseRealm";
    }
}
