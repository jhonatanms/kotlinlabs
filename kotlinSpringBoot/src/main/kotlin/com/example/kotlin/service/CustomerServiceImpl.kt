package com.example.kotlin.service

import com.example.kotlin.dao.CustomerDao
import com.example.kotlin.domain.Customer
import com.example.kotlin.dto.AddCustomerRequest
import com.example.kotlin.dto.CustomerResponse
import com.example.kotlin.dto.UpdateCustomerRequest
import com.example.kotlin.extensions.toCustomer
import com.example.kotlin.extensions.toCustomerResponse
import java.lang.IllegalStateException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(private val customerDao: CustomerDao) : CustomerService {

    override fun findAll(): List<CustomerResponse> {
        return customerDao.findAll().map(Customer::toCustomerResponse)
    }

    override fun findById(id: Long): CustomerResponse? {
        return this.findCustomerById(id)?.toCustomerResponse()
    }

    override fun save(addCustomerRequest: AddCustomerRequest): CustomerResponse {
        return this.saveOrUpdate(addCustomerRequest.toCustomer())
    }

    override fun update(updateCustomerRequest: UpdateCustomerRequest): CustomerResponse {
        val customer = this.findCustomerById(updateCustomerRequest.id) ?: throw IllegalStateException("Customer not found")

        customer.apply {
            name = updateCustomerRequest.name
            email = updateCustomerRequest.email
        }

        return this.saveOrUpdate(customer)
    }

    override fun deleteById(id: Long) {
        return customerDao.deleteById(id)
    }

    private fun findCustomerById(id: Long): Customer? = customerDao.findByIdOrNull(id)

    private fun saveOrUpdate(customer: Customer) = customerDao.save(customer).toCustomerResponse()
}