package com.kotlinDemo.Service

import com.kotlinDemo.Entity.Book
import com.kotlinDemo.Repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAllBooks(): List<Book> = bookRepository.findAll()

    fun getBookById(id: Long): Book? = bookRepository.findById(id).orElse(null)

    fun createBook(book: Book): Book = bookRepository.save(book)

    fun updateBook(id: Long, updatedBook: Book): Book? {
        return bookRepository.findById(id).map {
            val newBook = it.copy(title = updatedBook.title, author = updatedBook.author)
            bookRepository.save(newBook)
        }.orElse(null)
    }

    fun deleteBook(id: Long) {
        bookRepository.deleteById(id)
    }
}
