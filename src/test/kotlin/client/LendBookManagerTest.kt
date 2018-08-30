package client


import org.junit.Test
import service.BookService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever

class LendBookManagerTest{

    @Test
    fun should_CallLendMethod_when_BookIsAvailable(){
        //Triple A
        // Arrange
        val bookService : BookService = mock()
        whenever(bookService.inStock(22)).thenReturn(true)
        val sut = LendBookManager(bookService)

        // Act
        sut.checkout(22,88)

        // Assert
        verify(bookService).lend(22,88)

    }

    @Test(expected = IllegalStateException::class)
    fun should_ThrowIllegalStateException_when_BookIsNotAvailable(){
        //Triple A
        // Arrange
        val bookService : BookService = mock()
        val sut = LendBookManager(bookService)

        // Act
        sut.checkout(22,88)

        // Assert

    }
}