package com.kotlinDemo.Controller

import com.kotlinDemo.Entity.Book
import com.kotlinDemo.Service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {

    @GetMapping
    fun getAllBooks(): List<Book> = bookService.getAllBooks()

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): Book? = bookService.getBookById(id)

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody book: Book):
            Book = bookService.createBook(book)

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody updatedBook: Book): Book? {
        return bookService.updateBook(id, updatedBook)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Long) {
        bookService.deleteBook(id)
    }
}
