package com.example.kotlin.extensions

import com.example.kotlin.domain.Customer
import com.example.kotlin.dto.AddCustomerRequest

fun AddCustomerRequest.toCustomer(): Customer {
    return Customer(
        name = name,
        email = email
    )
}