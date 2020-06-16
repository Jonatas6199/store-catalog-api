package VO;

public class ProductImage extends StandardVO{
    private String imagePath = "";
    private int productId = 0;

    public void setImagePath(String productImagePath) throws Exception{
    	if (productImagePath.isBlank() || productImagePath.isEmpty()) {
    		throw new Exception("productImagePath não pode ser nulo ou vazio.");
    	}
    	else {
    		imagePath = productImagePath;
    	}
    }
    public String getImagePath(){
    	return imagePath;
    }
    
    public void setProductId(int productProductImageId) throws Exception {
    	if (productProductImageId > 0) {
    		productId = productProductImageId;
    	}
    	else {
    		throw new Exception("productProductImageId deve ser maior que 0");
    	}
    }
    public int getProductId() {
    	return productId;
    }
}