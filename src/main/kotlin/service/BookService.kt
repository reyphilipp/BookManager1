package service

interface BookService {
    fun inStock(bookid:Int):Boolean
    fun lend(bookid:Int, memberid:Int)
}