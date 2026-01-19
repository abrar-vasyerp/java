import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public Connection getConnection() throws SQLException{
        String url="jdbc:postgresql://localhost:5432/testdb";
        String user="postgres";
        String pass="postgres";
        Connection conn= DriverManager.getConnection(url,user,pass);

        return conn;
    }
    public void insertProduct(Product product){
        String sql="INSERT INTO products(product_name,tax,price) VALUES(?,?,?)";
        try(Connection conn=getConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql)){
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getTax());
            preparedStatement.setBigDecimal(3,product.getPrice());
            int i=preparedStatement.executeUpdate();
            System.out.println(i+" products added");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Product> getAllProducts(){
        List<Product> productList=new ArrayList<>();
        try(Connection conn=getConnection();
            Statement stmt=conn.createStatement()){
            String sql="SELECT * FROM products WHERE isDeleted IS FALSE";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                Product product=new Product();
                product.setProductName(rs.getString("product_name"));
                product.setProductId(rs.getInt("product_id"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setTax(rs.getDouble("tax"));
                product.setCreatedOn(rs.getTimestamp("created_on").toLocalDateTime());
                product.setModifiedOn(rs.getTimestamp("modified_on").toLocalDateTime());
                productList.add(product);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
    public Product getProductById(int productId){
        Product product=new Product();
        String sql="SELECT * FROM products WHERE isDeleted IS FALSE AND product_id=?";
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,productId);
            ResultSet rs=ps.executeQuery();

                rs.next();
                product.setProductName(rs.getString("product_name"));
                product.setProductId(rs.getInt("product_id"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setTax(rs.getDouble("tax"));
                product.setCreatedOn(rs.getTimestamp("created_on").toLocalDateTime());
                product.setModifiedOn(rs.getTimestamp("modified_on").toLocalDateTime());




        }
        catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    public int deleteProduct(int productId) {

        String sql="UPDATE products SET isDeleted=TRUE WHERE product_id=?";
        int i=0;
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            i= ps.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public int updateProductNameById(int productId,String productName) {
        String sql="UPDATE products SET product_name=? WHERE product_id=?";
        int i=0;
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1,productName);
            ps.setInt(2, productId);
            i= ps.executeUpdate();
            System.out.println(i);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
    public int updateProductPriceById(int productId, BigDecimal price){
        String sql="UPDATE products SET price=? WHERE product_id=?";
        int i=0;
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setBigDecimal(1,price);
            ps.setInt(2, productId);
            i= ps.executeUpdate();
            System.out.println(i);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
    public void modifyTimestamp(int productId){
        String sql="UPDATE products SET modified_on=? WHERE product_id=?";
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setTimestamp(1,Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(2, productId);
            ps.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
