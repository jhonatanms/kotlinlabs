package com.example.kotlin.extensions

import com.example.kotlin.domain.Customer
import com.example.kotlin.dto.CustomerResponse

fun Customer.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(
        id = id,
        name = name,
        email = email ?: ""
    )
}