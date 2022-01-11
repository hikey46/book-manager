package com.book.manager.presentation.controller

import com.book.manager.application.service.AdminBookService
import com.book.manager.domain.model.Book
import com.book.manager.presentation.form.RegisterBookRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("admin/book")
@CrossOrigin
class AdminBookController(
  private val adminBookService: AdminBookService
) {
  @PostMapping("/register")
  fun register(@RequestBody request: RegisterBookRequest) {
    adminBookService.register(
      Book(
        request.id,
        request.title,
        request.author,
        request.releaseDate
      )
    )
  }

  @DeleteMapping("/delete/{book_id}")
  fun delete(@PathVariable("book_id") book_id: Long) {
    adminBookService.delete(book_id)
  }
}
