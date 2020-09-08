package com.xtzhou.ruleengine.test;

import com.xtzhou.ruleengine.demo.Flight;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import sun.net.www.protocol.http.HttpURLConnection;

public class SpringELTest {
    /**
     * 这个测试非常简单，不需要启动容器就能完成,只要new一下表达式解析器然后解析表达式就可以了
     */
    @Test
    public void testSpringELWithOutSpringBoot() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        String source = "true&&false";
        Expression expression = expressionParser.parseExpression(source);
        boolean answer = expression.getValue(Boolean.class);
        Assert.assertFalse(answer);
        //上面是简单的测试，那么我们如果要完成isOverCabin&&isCodeShare这种呢，找两个类玩一下啊
        Flight flight = new Flight();
        //StandardEvaluationContext接受一个对象就可以通过反射获取到对象中的method了,但是一定要括号，我们想想启动容器是不是就不用括号了
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(flight);
        source = "isOverCabin()&&isCodeShare()";
        expression = expressionParser.parseExpression(source);
        answer = expression.getValue(standardEvaluationContext, Boolean.class);
        System.out.println(answer);
    }

    /**
     * 排查jar包冲突和ClassNotFound异常
     */
    @Test
    public void testFindTheConflictClassDef() {
        String path = HttpURLConnection.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        System.out.println(path);
    }
}
