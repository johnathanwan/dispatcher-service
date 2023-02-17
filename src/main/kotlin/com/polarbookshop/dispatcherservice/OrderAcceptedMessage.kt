package com.polarbookshop.dispatcherservice

@JvmRecord
data class OrderAcceptedMessage(val orderId: Long)