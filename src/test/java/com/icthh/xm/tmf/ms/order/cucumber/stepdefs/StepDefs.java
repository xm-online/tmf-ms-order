package com.icthh.xm.tmf.ms.order.cucumber.stepdefs;

import com.icthh.xm.tmf.ms.order.OrderApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = OrderApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
