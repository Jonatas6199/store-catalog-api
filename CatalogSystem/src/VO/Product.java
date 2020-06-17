package VO;

public class Product extends StandardVO{
    private String name = "";
    private String description = "";
    private double price = 0;
    private int categoryId = 0;

    public void setName(String productName) throws Exception {
        if (productName.isBlank() || productName.isEmpty()){
            throw new Exception("productName deve ser diferente de nulo ou vazio.");
        }
        else{
            name = productName;
        }
    }
    public String getName(){
        return name;
    }

    public void setDescription(String productDescription) throws Exception {
        if (productDescription.isBlank() || productDescription.isEmpty()){
            throw new Exception("productDescription deve ser diferente de nulo ou vazio.");
        }
        else{
            description = productDescription;
        }
    }
    public String getDescription(){
        return description;
    }

    public void setPrice(double productPrice) throws Exception {
        if (productPrice >= 0){
            price = productPrice;
        }
        else{
            throw new Exception("productPrice não pode ser negativo.");
        }
    }
    public double getPrice(){
        return price;
    }

    public void setCategoryId(int productCategoryId) throws Exception {
        if(productCategoryId > 0){
            categoryId = productCategoryId;
        }
        else{
            throw new Exception("productCategoryId deve ser maior que 0");
        }
    }
    public int getCategoryId(){
        return categoryId;
    }
}
