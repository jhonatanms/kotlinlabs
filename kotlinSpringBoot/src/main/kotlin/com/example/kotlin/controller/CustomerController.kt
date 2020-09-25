package com.example.kotlin.controller

import com.example.kotlin.dto.AddCustomerRequest
import com.example.kotlin.dto.CustomerResponse
import com.example.kotlin.dto.UpdateCustomerRequest
import com.example.kotlin.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CustomerResponse>> {
        return ResponseEntity.ok(customerService.findAll())
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerResponse?> {
        val customer = customerService.findById(id)
        val status = if (customer != null) HttpStatus.OK else HttpStatus.NO_CONTENT
        return ResponseEntity.status(status).body(customer)
    }

    @PostMapping
    fun save(@RequestBody addCustomerRequest: AddCustomerRequest): ResponseEntity<CustomerResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(addCustomerRequest))
    }

    @PutMapping
    fun update(@RequestBody updateCustomerRequest: UpdateCustomerRequest): ResponseEntity<CustomerResponse> {
        return ResponseEntity.ok(customerService.update(updateCustomerRequest))
    }

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        customerService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}