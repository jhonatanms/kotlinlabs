package com.example.kotlin.dto

data class UpdateCustomerRequest (
    val id:Long,
    val name: String,
    val email: String? = null
)
