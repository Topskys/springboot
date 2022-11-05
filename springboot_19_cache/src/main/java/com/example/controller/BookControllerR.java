package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.service.IBookServiceMp;
import com.example.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books") // http://127.0.0.1:8002/books
public class BookControllerR {

    @Autowired
    private IBookServiceMp bookServiceMp;

    @PostMapping
    public R saveBook(@RequestBody Book book){
//        R r=new R();
//        boolean flag=bookServiceMp.saveBook(book);
//        r.setFlag(flag);
//        return r;
//        return  new R(bookServiceMp.saveBook(book));
//        throw new IOException();// 抛出异常后面代码不执行
        boolean flag=bookServiceMp.saveBook(book);//  boolean flag=bookServiceMp.insert(book);
        return  new R(flag,flag?"成功":"失败");
    }

    @DeleteMapping("{id}")// http://127.0.0.1:8002/books/2
    public R deleteBook(@PathVariable Integer id){// @PathVariable 参数来源
        return new R(true,bookServiceMp.deleteBook(id));
    }

    @PutMapping
    public R updateBook(@RequestBody Book book){
        return  new R(bookServiceMp.updateBook(book));
    }


    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){// id="{id}"
        return new R(true,bookServiceMp.queryBook(id));
    }

    @GetMapping
    public R getAll(Book book){
        return new R(true,bookServiceMp.queryBookList(book)) ;
    }

//    @GetMapping
//    public R getAllMPList(){
//        return new R(true,bookServiceMp.list());
//    }


//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){// http://127.0.0.1:8002/books/2/10
//        IPage<Book> page=bookServiceMp.getPage(currentPage,pageSize);
//        page=currentPage > page.getPages()?bookServiceMp.getPage((int)page.getPages(),pageSize):page;// 如果currentPage>总页码值，就把总页码值赋给当前页码值。
//        return  new R(true,page);
//    }


    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){// String name,...or Book book接收参数paramStr
        IPage<Book> page=bookServiceMp.getPage(currentPage,pageSize,book);
        page=currentPage > page.getPages()?bookServiceMp.getPage((int)page.getPages(),pageSize,book):page;// 如果currentPage>总页码值，就把总页码值赋给当前页码值。
        return  new R(true,page);
    }
}
