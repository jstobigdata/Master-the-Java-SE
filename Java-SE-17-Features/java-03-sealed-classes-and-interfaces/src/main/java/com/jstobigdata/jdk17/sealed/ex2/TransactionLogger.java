package com.jstobigdata.jdk17.sealed.ex2;

public sealed interface TransactionLogger permits EmailLogger, SmsLogger {
}
