package com.itranswarp.learnjava.service;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnSmtpEnvCondition implements Condition {

  @Override
  public boolean matches(
    ConditionContext conditionContext,
    AnnotatedTypeMetadata annotatedTypeMetadata
  ) {
    return "true".equalsIgnoreCase(System.getenv("smtp"));
  }
}
