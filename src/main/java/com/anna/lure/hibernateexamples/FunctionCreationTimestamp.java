package com.anna.lure.hibernateexamples;

import org.hibernate.annotations.ValueGenerationType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ValueGenerationType(generatedBy = FuncCreationTimestamp.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FunctionCreationTimestamp {}
