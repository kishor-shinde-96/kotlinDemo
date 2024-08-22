package com.kotlinDemo.Repository

import com.kotlinDemo.Entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>