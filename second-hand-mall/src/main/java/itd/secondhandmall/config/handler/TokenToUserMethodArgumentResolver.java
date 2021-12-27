
package itd.secondhandmall.config.handler;


import itd.secondhandmall.config.annotation.TokenToUser;
import itd.secondhandmall.dao.UserMapper;
import itd.secondhandmall.dao.UserTokenMapper;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.pojo.UserToken;
import itd.secondhandmall.util.AssertUtil;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

@Component
public class TokenToUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserTokenMapper userTokenMapper;

    public TokenToUserMethodArgumentResolver() {
    }

    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(TokenToUser.class)) {
            return true;
        }
        return false;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        if (parameter.getParameterAnnotation(TokenToUser.class) instanceof TokenToUser) {
            User user = null;
            String token = webRequest.getHeader("token");

            System.out.println("已处理");

            /* 检查token是否有效 */
            AssertUtil.isTrue(null== token || "".equals(token),"token为空");
            UserToken userToken = userTokenMapper.selectByToken(token);
            AssertUtil.isTrue(userToken == null || userToken.getExpireTime().getTime() <= System.currentTimeMillis(),"token无效或超过有效时间");

            /* 检查token对应的user是否有效 */
            user = userMapper.selectById(userToken.getId());
            AssertUtil.isTrue(user == null,"");   // 该user对应的user是否为空（可能这条记录被彻底删了）

            return user;
        }
        return null;
    }



}
