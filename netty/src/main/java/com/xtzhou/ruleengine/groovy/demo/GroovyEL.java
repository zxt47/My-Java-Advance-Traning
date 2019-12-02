package com.xtzhou.ruleengine.groovy.demo;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class GroovyEL {
    public void UseGroovyShell()
    {
        Binding binding=new Binding();
        binding.setVariable("foo",new Integer(30));
        GroovyShell shell=new GroovyShell(binding);
        Object value=shell.evaluate("println 'Hello World! I\\'m in shell'; x = 123; return foo * 10");
        System.out.println(value);
    }
}
