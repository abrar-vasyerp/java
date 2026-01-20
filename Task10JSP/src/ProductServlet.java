import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    ProductService productService;

    public void init(){
        productService=new ProductService();
    }
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException{
        String action= httpServletRequest.getServletPath();
        switch (action){
            case "/new" :
                showNewForm(httpServletRequest,httpServletResponse);
                break;
            case "/insert" :
                try{
                    insertProduct(httpServletRequest,httpServletResponse);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                break;
            case "/delete" :
                deleteProduct(httpServletRequest,httpServletResponse);
                break;
            case "/update" :
                updateProduct(httpServletRequest,httpServletResponse);
                break;
            case "/edit" :
                showNewEditForm(httpServletRequest,httpServletResponse);
                break;
            default:
                showProducts(httpServletRequest,httpServletResponse);

                break;

        }
    }

    private void showProducts(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException,IOException{
        List<Product> productList=productService.getAllProducts();
        httpServletRequest.setAttribute("productList",productList);
        RequestDispatcher requestDispatcher=httpServletRequest.getRequestDispatcher("product-list.jsp");
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException{
        this.doGet(httpServletRequest,httpServletResponse);
    }
    private void showNewForm(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException,IOException{
        RequestDispatcher requestDispatcher=httpServletRequest.getRequestDispatcher("product-form.jsp");
        requestDispatcher.forward(httpServletRequest,httpServletResponse);
        requestDispatcher.forward(httpServletRequest,httpServletResponse);
    }
    private void insertProduct(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException,IOException{
        Product newProduct=new Product();
        newProduct.setProductName(httpServletRequest.getParameter("productName"));
        newProduct.setTax(Double.parseDouble(httpServletRequest.getParameter("tax")));
        newProduct.setPrice(new BigDecimal(httpServletRequest.getParameter("price")));
        productService.addItem(newProduct);
        httpServletResponse.sendRedirect("list");

    }
    private void updateProduct(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException,IOException{
        Product product=new Product();
        int id=Integer.parseInt(httpServletRequest.getParameter("id"));
        product.setProductName(httpServletRequest.getParameter("productName"));
        product.setTax(Double.parseDouble(httpServletRequest.getParameter("tax")));
        product.setPrice(new BigDecimal(httpServletRequest.getParameter("price")));
        productService.addItem(product);
        httpServletResponse.sendRedirect("list");
    }
    private void deleteProduct(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException,IOException{
        int id=Integer.parseInt(httpServletRequest.getParameter("id"));
        productService.deleteProduct(id);
        httpServletResponse.sendRedirect("list");

    }
    private void showNewEditForm(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException,IOException{
        int id=Integer.parseInt(httpServletRequest.getParameter("id"));
        Product existingProduct=productService.getProductById(id);
        RequestDispatcher requestDispatcher=httpServletRequest.getRequestDispatcher("product-form.jsp");
        httpServletRequest.setAttribute("product",existingProduct);
        requestDispatcher.forward(httpServletRequest,httpServletResponse);
    }
}
