package com.example.kotlin.service

import com.example.kotlin.dto.AddCustomerRequest
import com.example.kotlin.dto.CustomerResponse
import com.example.kotlin.dto.UpdateCustomerRequest

interface CustomerService {
    fun findAll() : List<CustomerResponse>
    fun findById(id: Long): CustomerResponse?
    fun save(addCustomerRequest: AddCustomerRequest): CustomerResponse
    fun update(updateCustomerRequest: UpdateCustomerRequest): CustomerResponse
    fun deleteById(id: Long)
}
