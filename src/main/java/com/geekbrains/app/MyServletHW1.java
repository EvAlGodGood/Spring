package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServletHW1 extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().printf("<html><body><table border=1>" +
                "   <caption>Products</caption>" +
                "   <tr>" +
                "    <th>ID</th>" +
                "    <th>Title</th>" +
                "    <th>Cost</th>" +
                "   </tr>"
        );

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId("0"+(i+1));
            product.setTitle("Product_" + (i+1));
            product.setCost(((i+1)*333)/(5 + i) + " RUR"); // от балды

            resp.getWriter().printf("<tr>"
                    + "<td>" + product.getId() + "</td>"
                    + "<td>" + product.getTitle() + "</td>"
                    + "<td>" + product.getCost() + "</td>"
                    + "</tr>");
        }
        resp.getWriter().printf("</table></body></html>");
    }
    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }

}
