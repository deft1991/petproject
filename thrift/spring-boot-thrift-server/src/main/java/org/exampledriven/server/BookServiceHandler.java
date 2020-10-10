package org.exampledriven.server;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.thrift.TException;
import org.exampledriven.Book;
import org.exampledriven.BookService;
import org.springframework.stereotype.Service;
//import ru.trylogic.spring.boot.thrift.annotation.ThriftController;

import java.util.List;

@Service
//@ThriftController("/api")
public class BookServiceHandler implements BookService.Iface {

    @Override
    public List<Book> createBooks(List<Book> books) throws TException {
        Subject currentUser = SecurityUtils.getSubject();
        if ( !currentUser.isAuthenticated() ) {
            //collect user principals and credentials in a gui specific manner
            //such as username/password html form, X509 certificate, OpenID, etc.
            //We'll use the username/password example here since it is the most common.
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");

            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(true);

            currentUser.login(token);
        }
        books.forEach(book -> book.setIsbn(BookUtil.generateISBN()));
        return books;
    }

}
