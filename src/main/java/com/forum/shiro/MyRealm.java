package com.forum.shiro;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forum.entity.User;
import com.forum.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

@RequiredArgsConstructor
public class MyRealm extends AuthorizingRealm {
    private final IUserService userService;

    //授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //来到这里条件：1、访问了带有权限要求的页面；2、已经通过登录认证的用户
        // 获取用户的首要信息【自定义的】
        User principal = (User) principalCollection.getPrimaryPrincipal();
        // 权限信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据首要信息获取对应角色，权限信息
        if (principal.getUsername().equals("admin")){
            //授权角色
            info.addRole("admin");//添加角色
            /*
             * 授权实例：根据实际业务情况进行设计
             * 可以是url，比如"/delete"
             * 可以是名字，比如"查询"*/
//            info.addStringPermission("delete");//添加权限
        }else {
            //授权角色
            info.addRole("user");//添加角色
        }
        return info;
    }

    //认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken t) throws AuthenticationException {
        //获取用户的令牌
        UsernamePasswordToken token = (UsernamePasswordToken) t;
        //获取用户令牌的信息
        String username = token.getUsername();

        //根据用户名查询用户是否存在
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        //没有查询到抛出用户不存在的异常
        if (user == null){
            throw new UnknownAccountException();
        }
        //金额低于0抛出用户被冻结的异常
//        if (user.getMoney() < 0){
//            throw new LockedAccountException();
//        }

        //返回的主体信息
        Object principal = user;
        //需要验证的证书（数据库查出来的：密码）
        Object credentials = user.getPassword();
        //加密的盐值
        ByteSource salt =  ByteSource.Util.bytes(user.getUsername());
        //主体的名称
        String realmName = getName();
        //验证密码是否正确（会自动用配置好的加密算法加密）
        return new SimpleAuthenticationInfo(principal,credentials, salt,realmName);
    }
}

