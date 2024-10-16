package com.studets.ingsispermission.routes

import com.studets.ingsispermission.entities.User
import com.studets.ingsispermission.entities.request_types.CheckRequest
import com.studets.ingsispermission.entities.request_types.UserSnippet
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable

/** This interface is used to define the routes of the user controller */
interface UserControllerRoutes {

    /** This method is used to create a user */
    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User>

    /** This method is used to get a user by email */
    @GetMapping("/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<User>

    /** This method is used to get all users */
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>>

    /** This method is used to update a user */
    @PutMapping("/{email}")
    fun updateUser(@RequestBody user: User): ResponseEntity<User>

    /** This method is used to add a snippet to a user */
    @PostMapping("/add-snippet/{email}")
    fun addSnippetToUser(@PathVariable email: String, @RequestBody addSnippet: UserSnippet): ResponseEntity<String>

    /** This method is used to check if a user is the owner of a snippet */
    @PostMapping("/check-owner")
    fun checkIfOwner(@RequestBody checkRequest: CheckRequest): ResponseEntity<String>
}
