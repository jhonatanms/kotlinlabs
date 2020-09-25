package com.example.kotlin.dto

data class AddCustomerRequest (
    val name: String,
    val email: String? = null
)
